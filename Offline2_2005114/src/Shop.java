import java.util.Scanner;
import Ingredients.Cookies;
import Ingredients.Candy;

import Ingredients.Milk;
import java.util.ArrayList;
import Shakes.Shake;

public class Shop {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("Your order?\n\"o\" to order\n\t\"q\" to quit");
            String s = scan.nextLine();
            if (s.equals("o")) {
                System.out.println("Give Order...");
            } else if (s.equals("q")) {
                System.out.println("Quiting...");
                System.exit(0);
            }
            BuildOrder makeOrder = new BuildOrder();
            while (true) {
                String typeOfShake = null, choice;
                int ordercount = 0;
                boolean isAddCandy = false, isLactoseFree = false, isAddCookies = false;
                ShakeBuilder builder = new ShakeBuilder();
                if (!makeOrder.getOrders().isEmpty())
                    System.out.println("Add more Shakes...");
                System.out.println("\t1. Chocolate Shake");
                System.out.println("\t2. Coffee Shake");
                System.out.println("\t3. Strawberry Shake");
                System.out.println("\t4. Vanilla Shake");
                System.out.println("\t5. Zero Shake");
                System.out.println("\t\"e\" to close order");

                System.out.print("Enter your choice: ");

                choice = scan.nextLine();
                if (choice.equals("1")) {
                    typeOfShake = "Chocolate";
                } else if (choice.equals("2")) {
                    typeOfShake = "Coffee";
                } else if (choice.equals("3")) {
                    typeOfShake = "Strawberry";
                } else if (choice.equals("4")) {
                    typeOfShake = "Vanilla";
                } else if (choice.equals("5")) {
                    typeOfShake = "Zero";
                } else if (choice.equals("e")) {
                    if (makeOrder.getOrders().isEmpty()) {
                        System.out.println("No order placed!");
                        continue;
                    }
                    makeOrder.printOrder();
                    break;
                } else {
                    System.out.println("Invalid input!");
                    continue;
                }

                System.out.print("Enter quantity: ");
                choice = scan.nextLine();
                try {
                    ordercount = Integer.parseInt(choice);
                    if (ordercount <= 0) {
                        System.out.println("Invalid input!");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input!");
                }

                System.out.print("Add cookies [Extra: " + Cookies.getPrice() + "]? (y/n): ");
                choice = scan.nextLine();
                if (choice.equals("y")) {
                    isAddCookies = true;

                } else {
                    isAddCookies = false;

                }
                System.out.print("Is lactose free [Extra: " + Milk.getLFPrice() + "]? (y/n): ");
                choice = scan.nextLine();
                if (choice.equals("y")) {
                    isLactoseFree = true;
                } else {
                    isLactoseFree = false;

                }

                System.out.print("Add candy [Extra: " + Candy.getPrice() + "]? (y/n): ");
                choice = scan.nextLine();
                if (choice.equals("y")) {
                    isAddCandy = true;

                } else {
                    isAddCandy = false;
                }

                if (typeOfShake == "Chocolate") {
                    makeOrder.buildChocolateShake(builder, ordercount, isLactoseFree, isAddCandy, isAddCookies);
                } else if (typeOfShake == "Strawberry") {
                    makeOrder.buildStrawberryShake(builder, ordercount, isLactoseFree, isAddCandy, isAddCookies);
                } else if (typeOfShake == "Zero") {
                    makeOrder.buildZeroShake(builder, ordercount, isLactoseFree, isAddCandy, isAddCookies);
                } else if (typeOfShake == "Vanilla") {
                    makeOrder.buildVanillaShake(builder, ordercount, isLactoseFree, isAddCandy, isAddCookies);
                } else if (typeOfShake == "Coffee") {
                    makeOrder.buildCoffeeShake(builder, ordercount, isLactoseFree, isAddCandy, isAddCookies);
                }
                ArrayList<Shake> shakes = builder.getShakes();
                makeOrder.addOrder(shakes);
            }
            BuildOrder.reset();
        }
    }
}