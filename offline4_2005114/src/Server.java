import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Server {

    Map<String, List<String>> listeners = new HashMap<>();
    List<Stock> stocks=new ArrayList<>();
    List<User> userList=new ArrayList<>();

    HashMap<String,SocketWrapper> clientMap=new HashMap<>();
    public Server(){
        for(int i=1;i<7;i++){
            Stock s=new Stock("P"+Integer.toString(i),i+4,30.00+(i%4)*10.00);
            stocks.add(s);
            listeners.put(s.getName(),new ArrayList<>());
        }
    }

    public  void subscribe(String s, String user) {
        List<String> users = listeners.get(s);

        if(users!=null)users.add(user);
    }
    public  void unsubscribe(String s, String user) {
        List<String> users = listeners.get(s);
        if(users!=null)users.remove(user);
    }
    public void addStock(String name,int cnt,double price){
        Stock s=new Stock(name,cnt,price);
        stocks.add(s);
        listeners.put(name,new ArrayList<>());
    }

    public  void notify(String stockName, String msg) throws IOException {
        List<String> users = listeners.get(stockName);
        for (String listener : users) {
            SocketWrapper clientUpdate=clientMap.get(listener);
            if(clientUpdate!=null){
                clientUpdate.write(msg);
            }else{
                for(User user:userList){
                    user.setNotification(msg);
                }
            }
        }
    }
    public void increasePrice(String stockName,double inc) throws IOException {
        for (Stock s: stocks) {
            if(stockName.equals(s.getName())){
                s.setPrice(s.getPrice()+inc);
                String msg=s.getName()+" price increased by "+String.valueOf(inc);
                notify(s.getName(),msg);
            }
        }
    }
    public void decreasePrice(String stockName,double inc) throws IOException {
        for (Stock s:stocks) {
            if(stockName.equals(s.getName())){
                s.setPrice(s.getPrice()-inc);
                String msg=s.getName()+" price decreased by "+String.valueOf(inc);
                notify(s.getName(),msg);
            }
        }
    }
    public void changeCount(String stockName,int inc) throws IOException {
        for (Stock s:stocks) {
            if(stockName.equals(s.getName())){
                s.setCount(s.getCount()+inc);
                String msg=s.getName()+" count increased by "+String.valueOf(inc);
                notify(s.getName(),msg);
            }
        }
    }
    public void giveNotification(String clientName, SocketWrapper client) throws IOException {
        clientMap.put(clientName,client);
        int ck=0;
        for (User user:userList) {
            if(user.getName().equals(clientName)){
                ck=1;
                if(user.getNotification().size()!=0){
                    client.write(user.getNotification());
                    user.clearNotification();
                }
            }
        }
        if(ck==0){
            User u=new User(clientName);
            userList.add(u);
        }
    }
    public List<String> viewStocks(String userName){
        List<String> subscribedStocks=new ArrayList<>();
        for(Map.Entry<String,List<String>> entry : listeners.entrySet()){
            for(String user: entry.getValue()){
                if(user.equals(userName)){
                    subscribedStocks.add(entry.getKey());
                }
            }
        }
        return subscribedStocks;
    }
    public void adminClient(SocketWrapper client) throws IOException, ClassNotFoundException {
        while (true){
            Object data=client.read();
            String cmds=(String)data;
            String []cmd=cmds.split(" ");
            if(cmd[0].equals("I")){
                increasePrice(cmd[1],Double.valueOf(cmd[2]));
            } else if (cmd[0].equals("D")) {
                decreasePrice(cmd[1],Double.valueOf(cmd[2]));
            } else if (cmd[0].equals("C")) {
                changeCount(cmd[1],Integer.valueOf(cmd[2]));
            }
        }
    }
    public void userClient(SocketWrapper client,String userName) throws IOException, ClassNotFoundException {
        giveNotification(userName,client);

        while (true){
            Object data=client.read();
            String cmds=(String)data;
            String []cmd=cmds.split(" ");
            if(cmd[0].equals("S")){
                subscribe(cmd[1],userName);
            } else if (cmd[0].equals("U")) {
                unsubscribe(cmd[1],userName);
            } else if (cmd[0].equals("V")) {
                List<String> subscribedStocks=viewStocks(userName);
                client.write(subscribedStocks);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        ServerSocket server=new ServerSocket(3000);
        Server server1=new Server();


        while(true){
            Socket clientSocket=server.accept();
            SocketWrapper client=new SocketWrapper(clientSocket);
            new Thread(()->{
                try {
                    String tmp = (String) client.read();
                    String []tokens=tmp.split(" ");

                    if(tokens[0].equals("admin")){
                        server1.adminClient(client);
                    } else if (tokens[0].equals("user")) {
                        server1.userClient(client,tokens[1]);
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }finally {
                    try {
                        client.closeConnection();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }).start();
        }
    }
}