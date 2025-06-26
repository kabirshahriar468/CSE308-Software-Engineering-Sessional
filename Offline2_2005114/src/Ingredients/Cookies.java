package Ingredients;

public class Cookies implements Ingredients{
    private static final int price = 40;

    @Override
    public String getName() {
        return "Cookies";
    }

    public static int getPrice() {
        return price;
    }

    @Override
    public int getExtraPrice() {
        return price;
    }
}
