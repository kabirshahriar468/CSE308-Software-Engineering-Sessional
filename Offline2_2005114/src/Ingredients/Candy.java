package Ingredients;

import Ingredients.Ingredients;

public class Candy implements Ingredients {
    private static final int price = 50;

    @Override
    public String getName() {
        return "Candy";
    }

    @Override
    public int getExtraPrice() {
        return price;
    }

    public static int getPrice() {
        return price;
    }
}
