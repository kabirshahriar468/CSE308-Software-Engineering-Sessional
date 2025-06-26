package Decorators;
import Passengers.Passenger;

public abstract class PassengerDecorator implements Passenger{
    protected Passenger passenger;

    public PassengerDecorator(Passenger passenger){
        this.passenger=passenger;
    }

}
