package com.hexaware.vehicleRS;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create vehicles
        Vehicle car = new Car("AU9001", 50, 200);
        Vehicle bike = new Bike("R1T20", 20, 300);
        Vehicle truck = new Truck("EICHER-T60", 80, 250);

        // Create user
        User user = new User("John Doe");

        int choice;
        do {
            System.out.println("\nVehicle Rental System");
            System.out.println("1. Rent a Vehicle");
            System.out.println("2. Return a Vehicle");
            System.out.println("3. View Rented Vehicles");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            // menu driven
            switch (choice) {
                case 1:
                    System.out.println("Vehicles available to rent: 1. Car :: 2. Bike :: 3. Truck");
                    int vehicleChoice = sc.nextInt();
                    switch (vehicleChoice) {
                        case 1:
                            user.rentVehicle(car);
                            break;
                        case 2:
                            user.rentVehicle(bike);
                            break;
                        case 3:
                            user.rentVehicle(truck);
                            break;
                        default:
                            System.out.println("Invalid choice.");
                    }
                    break;
                case 2:
                    System.out.println("Which vehicle do you want to return: 1. Car :: 2. Bike :: 3. Truck");
                    vehicleChoice = sc.nextInt();
                    switch (vehicleChoice) {
                        case 1:
                            user.returnVehicle(car);
                            break;
                        case 2:
                            user.returnVehicle(bike);
                            break;
                        case 3:
                            user.returnVehicle(truck);
                            break;
                        default:
                            System.out.println("Invalid choice.");
                    }
                    break;
                case 3:
                    user.showRentedVehicles();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        sc.close();
    }
}

