package com.hexaware.vehicleRS;

public class Truck extends Vehicle{
	
	private double userBalance;
	
	public Truck(String vehicleID, double rentPrice, double userBalance) {
		super(vehicleID, rentPrice);
		this.userBalance = userBalance;
	}
	
	@Override
	public void rentVehicle() {
		
		if(!isRented()) {
			if(userBalance > getRentPrice()) {
				userBalance -= getRentPrice();
				setRented(true);
				System.out.println(getVehicleID() + " has been rented. Remaining balance: " + userBalance);
			}else {
				System.out.println("Insufficient balance to rent " + getVehicleID());
			}
		}else {
			System.out.println(getVehicleID() + "is already rented.");
		}
		
	}
	
	@Override
	public void returnVehicle() {
		
		if(!isRented()) {
			setRented(false);
			System.out.println(getVehicleID() + "has been returned");
		}else {
			System.out.println(getVehicleID() + "was not rented out");
		}
		
	}

}