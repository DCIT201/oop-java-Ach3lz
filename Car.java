package oop;

public class Car extends Vehicle implements Rentable {
    private static final double BASE_RENTAL_RATE = 50.0;
    private RentalAgency rentalAgency;

    public Car(String vehicleId, String model, RentalAgency rentalAgency) {
        super(vehicleId, model, BASE_RENTAL_RATE);
        this.rentalAgency = rentalAgency;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getBaseRentalRate() * days;
    }

    @Override
    public boolean isAvailableForRental() {
        return isAvailable();
    }

    @Override
    public void rent(Customer customer, int days) {
        // Logic to rent the car to the customer
        rentalAgency.processRental(customer, getModel(), days);
    }

    @Override
    public void returnVehicle() {
        // Logic to return the car (interact with RentalAgency to mark it as available)
        rentalAgency.markAsAvailable(getModel());
        System.out.println(getModel() + " has been returned.");
    }
}
