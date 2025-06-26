import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private List<String> Notification;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(String name){
        this.name=name;
        Notification = new ArrayList<>();
    }
    public void setNotification(String s){
        Notification.add(s);
    }

    public List<String> getNotification() {
        return Notification;
    }
    public void clearNotification(){
        Notification.clear();
    }
}
