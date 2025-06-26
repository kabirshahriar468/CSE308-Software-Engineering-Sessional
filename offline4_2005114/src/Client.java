import java.io.IOException;
import java.util.List;
import java.util.Scanner;



public class Client {
    public static void main(String[] args) throws IOException {
        SocketWrapper server = new SocketWrapper("127.0.0.1",  3000);
        Scanner sc = new Scanner(System.in);
        new Thread(() -> {
            try {

                while (true) {

                    Object data = server.read();
                    if(data instanceof String){
                        System.out.println((String) data);
                    }else{
                        List<String> list=(List<String>)data;
                        for (String stockname:list) {
                            System.out.println(stockname);
                        }
                    }
                    int doubled= (int) data;
                    //System.out.println("server sent: + doubled);
                }
            } catch (IOException e) {
                System.out.println("Server disconnected"); }
            catch(ClassNotFoundException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    server.closeConnection();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
        while (true) {
            server.write(sc.nextLine());

        }
    }
}