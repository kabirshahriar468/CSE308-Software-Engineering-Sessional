

import Ingredients.Candy;
import Ingredients.Cookies;
import Shakes.*;

import java.util.ArrayList;

public class ShakeBuilder{
    private boolean isLactoseFree = false;
    private Candy candy;
    private Cookies cookies;
    private int quantity = 0;
    private String shakeType;
    private ArrayList<Shake> shakes = new ArrayList<>();

    public void setLactoseFree(boolean isLactoseFree) {
        this.isLactoseFree = isLactoseFree;
    }

    public void addCandy(Candy candy) {
        this.candy = candy;
    }

    public void addCookies(Cookies cookies) {
        this.cookies = cookies;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setShakeType(String shakeType) {
        this.shakeType = shakeType;
    }

    public ArrayList<Shake> getShakes() {
        for(int i = 0; i < this.quantity; i++) {
            if(shakeType =="Coffee") {
                shakes.add(new CoffeeShake(this.isLactoseFree, this.candy, this.cookies));
            } else if(shakeType =="Zero") {
                shakes.add(new ZeroShake(this.isLactoseFree, this.candy, this.cookies));
            } else if(shakeType =="Strawberry") {
                shakes.add(new StrawberryShake(this.isLactoseFree, this.candy, this.cookies));
            } else if(shakeType =="Vanilla") {
                shakes.add(new VanillaShake(this.isLactoseFree, this.candy, this.cookies));
            } else if(shakeType == "Chocolate") {
                shakes.add(new ChocolateShake(this.isLactoseFree, this.candy, this.cookies));
            }
        }
        return shakes;
    }
}
