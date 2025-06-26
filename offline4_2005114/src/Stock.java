import java.io.Serializable;

public class Stock implements Serializable {
    private String name;
    private int count;
    private double price;
    public Stock(String name, int cnt, double price){
        this.name=name;
        this.count=cnt;
        this.price=price;
    }
    public Stock(){
        name="";
        count=0;
        price= 0.00;
    }
    public double getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public void setALL(String name,int cnt,double price){
        this.name=name;
        this.count=cnt;
        this.price=price;
    }

}
