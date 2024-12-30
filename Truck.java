package oop;

public class Truck extends Vehicle implements Rentable {
    private static final double BASE_RENTAL_RATE = 80.0;
    @SuppressWarnings("FieldMayBeFinal")
    private RentalAgency rentalAgency;

    public Truck(String vehicleId, String model, RentalAgency rentalAgency) {
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
        // Logic to rent the truck to the customer
        rentalAgency.processRental(customer, getModel(), days);
    }

    @Override
    public void returnVehicle() {
        // Logic to return the truck (interact with RentalAgency to mark it as available)
        rentalAgency.markAsAvailable(getModel());
        System.out.println(getModel() + " has been returned.");
    }
}