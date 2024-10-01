package com.hexaware.exceptions;

// Custom exception: InsufficientBalanceException
public class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

// Custom exception: VehicleAlreadyRentedException
public class VehicleAlreadyRentedException extends Exception {
    public VehicleAlreadyRentedException(String message) {
        super(message);
    }
}
