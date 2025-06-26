package Decorators;

import Passengers.Passenger;

public class ImposterDecorator extends PassengerDecorator {
    public ImposterDecorator(Passenger passenger) {
        super(passenger);
    }

    @Override
    public void login() {
        passenger.login();
        DecorateLoginMsg();
    }

    @Override
    public void repair() {
        DecorateRepairMsg();
        passenger.repair();
    }

    @Override
    public void work() {
        DecorateWorkMsg();
        passenger.work();
    }

    @Override
    public void logout() {
        passenger.logout();
        DecorateLogoutMsg();
    }
    private void DecorateLoginMsg(){
        System.out.println(" We won’t tell anyone;you are an imposter.");
    }
    private void DecorateRepairMsg(){
        System.out.println("Repairing the spaceship.");
    }
    private void DecorateWorkMsg(){
        System.out.println("Doing research.");
    }
    private void DecorateLogoutMsg(){
        System.out.println("See you again Comrade Imposter.");
    }
}
