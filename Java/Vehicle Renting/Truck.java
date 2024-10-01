package com.hexaware.vehicleRS;

import com.hexaware.exceptions.InsufficientBalanceException;
import com.hexaware.exceptions.VehicleAlreadyRentedException;

public class Truck extends Vehicle {
    
    private double userBalance;
    
    public Truck(String vehicleID, double rentPrice, double userBalance) {
        super(vehicleID, rentPrice);
        this.userBalance = userBalance;
    }
    
    @Override
    public void rentVehicle() {
        try {
            if (!isRented()) {
                if (userBalance >= getRentPrice()) {
                    userBalance -= getRentPrice();
                    setRented(true);
                    System.out.println(getVehicleID() + " has been rented. Remaining balance: " + userBalance);
                } else {
                    throw new InsufficientBalanceException("Insufficient balance to rent " + getVehicleID());
                }
            } else {
                throw new VehicleAlreadyRentedException(getVehicleID() + " is already rented.");
            }
        } catch (InsufficientBalanceException | VehicleAlreadyRentedException e) {
            System.out.println(e.getMessage());
        }
    }
    
    @Override
    public void returnVehicle() {
        try {
            if (isRented()) {
                setRented(false);
                System.out.println(getVehicleID() + " has been returned.");
            } else {
                throw new VehicleAlreadyRentedException(getVehicleID() + " was not rented.");
            }
        } catch (VehicleAlreadyRentedException e) {
            System.out.println(e.getMessage());
        }
    }
}
