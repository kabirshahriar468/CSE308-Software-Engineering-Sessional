import Decorators.ImposterDecorator;
import Passengers.CrewMate;
import Passengers.Imposter;
import Passengers.Passenger;

import java.util.Scanner;

public class Problem1_Main {
    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);
        String []cmd=scan.nextLine().split(" ");
        while(!cmd[0].equalsIgnoreCase("exit")) {
            if (cmd[0].equalsIgnoreCase("login")) {
                if (cmd[1].contains("crew")) {
                    Passenger passenger = new CrewMate();
                    passenger.login();
                    String command = scan.nextLine();
                    while (!command.equalsIgnoreCase("logout")) {
                        if (command.equalsIgnoreCase("repair")) {
                            passenger.repair();
                        } else if (command.equalsIgnoreCase("work")) {
                            passenger.work();
                        } else {
                            System.out.println("Wrong Command!");
                        }
                        command = scan.nextLine();
                    }
                    passenger.logout();

                } else if (cmd[1].contains("imp")) {
                    Passenger passenger = new ImposterDecorator(new Imposter());
                    passenger.login();
                    String command = scan.nextLine();
                    while (!command.equalsIgnoreCase("logout")) {
                        if (command.equalsIgnoreCase("repair")) {
                            passenger.repair();
                        } else if (command.equalsIgnoreCase("work")) {
                            passenger.work();
                        } else {
                            System.out.println("Wrong Command!");
                        }
                        command = scan.nextLine();
                    }
                    passenger.logout();
                }
            } else {
                System.out.println("Invalid command.");
            }
            cmd=scan.nextLine().split(" ");
        }
    }
}
