package Shakes;

import Ingredients.Ingredients;

import java.util.ArrayList;

public interface Shake {
    public String getName();

    public int getBasePrice();

    public int getPrice();

    public ArrayList<Ingredients> getIngredients();
}
