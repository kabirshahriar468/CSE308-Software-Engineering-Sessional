package Ingredients;

public class Coffee implements Ingredients{
    @Override
    public String getName() {
        return "Coffee";
    }

    @Override
    public int getExtraPrice() {
        return 0;
    }
}
