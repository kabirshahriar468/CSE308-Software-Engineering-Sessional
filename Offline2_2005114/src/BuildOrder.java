import Ingredients.Candy;
import Ingredients.Cookies;
import Ingredients.Ingredients;
import Shakes.Shake;
import java.util.ArrayList;

public class BuildOrder {
    private ArrayList<ArrayList<Shake>> allOrders = new ArrayList<>();
    private static boolean Run = false;


    public BuildOrder() {
        if (Run) {
            throw new RuntimeException("Builder is already active");
        }
        Run = true;
    }

    public static void reset() {
        Run = false;
    }


    public ArrayList<ArrayList<Shake>> getOrders() {
        return allOrders;
    }

    public void buildChocolateShake(ShakeBuilder builder, int quantity, boolean isLactoseFree, boolean isAddCandy, boolean isAddCookies) {
        builder.setQuantity(quantity);
        builder.setLactoseFree(isLactoseFree);
        if (isAddCandy) {
            builder.addCandy(new Candy());
        }
        if (isAddCookies) {
            builder.addCookies(new Cookies());
        }
        builder.setShakeType("Chocolate");
    }



    public void buildZeroShake(ShakeBuilder builder, int quantity, boolean isLactoseFree, boolean isAddCandy, boolean isAddCookies) {
        builder.setQuantity(quantity);
        builder.setLactoseFree(isLactoseFree);
        if (isAddCandy) {
            builder.addCandy(new Candy());
        }
        if (isAddCookies) {
            builder.addCookies(new Cookies());
        }
        builder.setShakeType("Zero");
    }
    public void addOrder(ArrayList<Shake> order) {
        System.out.println("Order added"+order.size());
        allOrders.add(order);
    }
    public void buildVanillaShake(ShakeBuilder builder, int quantity, boolean isLactoseFree, boolean isAddCandy, boolean isAddCookies) {
        builder.setQuantity(quantity);
        builder.setLactoseFree(isLactoseFree);
        if (isAddCandy) {
            builder.addCandy(new Candy());
        }
        if (isAddCookies) {
            builder.addCookies(new Cookies());
        }
        builder.setShakeType("Vanilla");
    }

    public void buildStrawberryShake(ShakeBuilder builder, int quantity, boolean isLactoseFree, boolean isAddCandy, boolean isAddCookies) {
        builder.setQuantity(quantity);
        builder.setLactoseFree(isLactoseFree);
        if (isAddCandy) {
            builder.addCandy(new Candy());
        }
        if (isAddCookies) {
            builder.addCookies(new Cookies());
        }
        builder.setShakeType("Strawberry");
    }
    public void buildCoffeeShake(ShakeBuilder builder, int quantity, boolean isLactoseFree, boolean isAddCandy, boolean isAddCookies) {
        builder.setLactoseFree(isLactoseFree);
        builder.setQuantity(quantity);


        if (isAddCandy) {
            builder.addCandy(new Candy());
        }
        if (isAddCookies) {
            builder.addCookies(new Cookies());
        }
        builder.setShakeType("Coffee");
    }



    public void printOrder() {
        int count = 0, total = 0;
        System.out.println("Order Summary...");
        for(ArrayList<Shake> item: allOrders) {
            System.out.println("Item " + ++count + ": " + item.get(0).getName() + " [Base Price: " + item.get(0).getBasePrice() + "]");
            System.out.println("Quantity: " + item.size());
            System.out.println("Ingredients: ");
            for(Ingredients ing: item.get(0).getIngredients()) {
                System.out.println("\t"+ing.getName() + (ing.getExtraPrice()>0?(" [ExtraPrice: " + ing.getExtraPrice() + "]"):""));
            }
            total += item.get(0).getPrice() * item.size();
            System.out.println("Price: " + item.get(0).getPrice() * item.size());
        }
        System.out.println("Total Price: " + total);
    }
}
