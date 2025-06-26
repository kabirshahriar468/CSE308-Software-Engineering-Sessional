package Shakes;

import Ingredients.*;

import java.util.ArrayList;

public class CoffeeShake implements Shake {
    private static final int basePrice = 250;
    private ArrayList<Ingredients> ingredients = new ArrayList<>();

    public CoffeeShake(boolean isLactoseFree, Candy candy, Cookies cookies) {
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

        ingredients.add(new Coffee());

        ingredients.add(new Sugar(false));

        ingredients.add(new Jello(false));
    }

    @Override
    public String getName() {
        return "Coffee Shake";
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
