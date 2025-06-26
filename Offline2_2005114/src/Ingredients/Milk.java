package Ingredients;

public class Milk implements Ingredients{
    private static final int LFprice = 60;
    private String name;
    private int price;

    public Milk(boolean isLactoseFree){
        if(isLactoseFree){
            this.name = "Almond Milk";
            this.price = LFprice;
        }
        else{
            this.name = "Regular Milk";
            this.price = 0;
        }
    }

    @Override
    public String getName() {
        return this.name;
    }

    public static int getLFPrice() {
        return LFprice;
    }

    @Override
    public int getExtraPrice() {
        return this.price;
    }

}
