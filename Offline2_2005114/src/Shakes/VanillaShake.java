package Shakes;

import Ingredients.*;

import java.util.ArrayList;

public class VanillaShake implements Shake {
    private int basePrice = 190;
    private ArrayList<Ingredients> ingredients = new ArrayList<>();

    public VanillaShake(boolean isLactoseFree, Candy candy, Cookies cookies) {
        if (isLactoseFree) {
            ingredients.add(new Milk(true));
        } else {
            ingredients.add(new Milk(false));
        }

        if (candy != null) {
            ingredients.add(candy);
        }

        if (cookies != null) {
            ingredients.add(cookies);
        }

        ingredients.add(new Flavor("VANILLA"));

        ingredients.add(new Sugar(false));

        ingredients.add(new Jello(false));
    }

    @Override
    public String getName() {
        return "Vanilla Shake";
    }

    @Override
    public int getBasePrice() {
        return basePrice;
    }

    @Override
    public ArrayList<Ingredients> getIngredients() {
        return ingredients;
    }

    @Override
    public int getPrice() {
        int price = this.basePrice;
        for (Ingredients ingredient : ingredients) {
            price += ingredient.getExtraPrice();
        }
        return price;
    }
}
