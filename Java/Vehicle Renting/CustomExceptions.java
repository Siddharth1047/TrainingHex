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

// Custom exception: MaxVehiclesRentedException
class MaxVehiclesRentedException extends Exception {
    public MaxVehiclesRentedException(String message) {
        super(message);
    }
}

// Custom exception: VehicleNotRentedException
class VehicleNotRentedException extends Exception {
    public VehicleNotRentedException(String message) {
        super(message);
    }
}
