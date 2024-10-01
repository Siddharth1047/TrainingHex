package com.hexaware.vehicleRS;

import java.util.*;

// abstract class vehicle
public abstract class Vehicle {
	
	private String vehicleID;
	private double rentPrice;
	private boolean isRented;
	
	public Vehicle(String vehicleID, double rentPrice) {
		this.vehicleID = vehicleID;
		this.rentPrice = rentPrice;
		this.isRented = false;
	}

	// getter setters
	public String getVehicleID() {
		return vehicleID;
	}

	public void setVehicleID(String vehicleID) {
		this.vehicleID = vehicleID;
	}

	public double getRentPrice() {
		return rentPrice;
	}

	public void setRentPrice(double rentPrice) {
		this.rentPrice = rentPrice;
	}
    
    public boolean isRented() {
		return isRented;
	}

	public void setRented(boolean isRented) {
		this.isRented = isRented;
	}

	// abstract methods for concrete classes
	public abstract void rentVehicle();
    public abstract void returnVehicle();
	
}
