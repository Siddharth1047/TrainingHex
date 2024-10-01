package com.hexaware.vehicleRS;
import java.util.*;

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

	public void rentVehicle(Vehicle vehicle) {
		if (vehicleCount < maxVehicles) { // check for vehicle count of already rented vehicles
			if (!vehicle.isRented()) {
				vehicle.rentVehicle();
				rentedVehicles[vehicleCount] = vehicle;
				vehicleCount++; // increase count of vehicles rented
				System.out.println("You've rented vehicle: " + vehicle.getVehicleID());
			}else {
				System.out.println(vehicle.getVehicleID() + " has already rented.");
			}
		}else {
			System.out.println("You cannot rent more than " + maxVehicles + " vehicles.");
		}
	}
	
	public void returnVehicle(Vehicle vehicle) {
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
                break;
            }
        }
        if (!vehicleFound) {
            System.out.println("You have not rented this vehicle.");
        }
    }
	
	// display vehicles rented
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
