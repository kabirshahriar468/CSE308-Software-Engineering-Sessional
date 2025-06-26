package Passengers;

public class Imposter implements Passenger{
    @Override
    public void login() {
        System.out.println("Welcome Crewmate! ");
    }

    @Override
    public void repair() {
        System.out.println("Damaging the spaceship.");
    }

    @Override
    public void work() {
        System.out.println("Trying to kill a crewmate.\n" +
                "Successfully killed a crewmate.");
    }

    @Override
    public void logout() {
        System.out.println("Bye Bye crewmate.");
    }
}
