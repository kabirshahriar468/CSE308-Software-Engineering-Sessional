package Shakes;

import Ingredients.*;

import java.util.ArrayList;

public class ZeroShake implements Shake {
    private int basePrice = 240;
    private ArrayList<Ingredients> ingredients = new ArrayList<>();

    public ZeroShake(boolean isLactoseFree, Candy candy, Cookies cookies) {
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
        
        ingredients.add(new Sugar(true));
        
        ingredients.add(new Jello(true));
    }

    @Override
    public String getName() {
        return "Zero Shake";
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
