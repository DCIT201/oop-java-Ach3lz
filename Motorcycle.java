package oop;

public class Motorcycle extends Vehicle {
    private static final double BASE_RENTAL_RATE = 30.0;

    public Motorcycle(String vehicleId, String model) {
        super(vehicleId, model, BASE_RENTAL_RATE);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getBaseRentalRate() * days;
    }

    @Override
    public boolean isAvailableForRental() {
        return isAvailable();
    }
}
