package com.hexaware.vehicleRS;

import java.util.*;

import com.hexaware.exceptions.InsufficientBalanceException;
import com.hexaware.exceptions.VehicleAlreadyRentedException;
import com.hexaware.exceptions.MaxVehiclesRentedException;
import com.hexaware.exceptions.VehicleNotRentedException;

public class User {
    
    private String userName;
    private Vehicle[] rentedVehicles;
    private int vehicleCount;
    private static final int maxVehicles = 3;
    
    public User(String userName) {
        this.userName = userName;
        this.rentedVehicles = new Vehicle[maxVehicles];
        this.vehicleCount = 0;
    }
    
    // getter to obtain username
    public String getUserName() {
        return userName;
    }

    // Rent a vehicle method with exception handling
    public void rentVehicle(Vehicle vehicle) {
        try {
            if (vehicleCount >= maxVehicles) {
                throw new MaxVehiclesRentedException("You cannot rent more than " + maxVehicles + " vehicles.");
            }
            if (vehicle.isRented()) {
                throw new VehicleAlreadyRentedException(vehicle.getVehicleID() + " has already been rented.");
            }

            vehicle.rentVehicle();
            rentedVehicles[vehicleCount] = vehicle;
            vehicleCount++; // Increase count of vehicles rented
            System.out.println("You've rented vehicle: " + vehicle.getVehicleID());
            
        } catch (MaxVehiclesRentedException | VehicleAlreadyRentedException e) {
            System.out.println(e.getMessage());
        }
    }
    
    // Return a vehicle method with exception handling
    public void returnVehicle(Vehicle vehicle) {
        try {
            boolean vehicleFound = false;
            for (int i = 0; i < vehicleCount; i++) {
                if (rentedVehicles[i] == vehicle) {
                    vehicle.returnVehicle();
                    // Shift remaining vehicles in the array to fill the gap
                    for (int j = i; j < vehicleCount - 1; j++) {
                        rentedVehicles[j] = rentedVehicles[j + 1];
                    }
                    rentedVehicles[vehicleCount - 1] = null;  // Remove the last element
                    vehicleCount--;  // Decrease the count of rented vehicles
                    vehicleFound = true;
                    System.out.println(vehicle.getVehicleID() + " has been returned.");
                    break;
                }
            }

            if (!vehicleFound) {
                throw new VehicleNotRentedException("You have not rented this vehicle: " + vehicle.getVehicleID());
            }
        } catch (VehicleNotRentedException e) {
            System.out.println(e.getMessage());
        }
    }
    
    // Display rented vehicles
    public void showRentedVehicles() {
        if (vehicleCount == 0) {
            System.out.println("You have not rented any vehicles.");
        } else {
            System.out.println("Rented Vehicles:");
            for (int i = 0; i < vehicleCount; i++) {
                System.out.println(rentedVehicles[i].getVehicleID());
            }
        }
    }
}
