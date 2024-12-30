package oop;

import java.util.ArrayList;
import java.util.List;

public class RentalAgency {
    private final List<Vehicle> vehicleFleet;

    public RentalAgency() {
        vehicleFleet = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        vehicleFleet.add(vehicle);
    }

    public Vehicle findAvailableVehicle(String model) {
        for (Vehicle vehicle : vehicleFleet) {
            if (vehicle.getModel().equalsIgnoreCase(model) && vehicle.isAvailableForRental()) {
                return vehicle;
            }
        }
        return null;
    }

    public void processRental(Customer customer, String model, int days) {
        Vehicle vehicle = findAvailableVehicle(model);
        if (vehicle != null) {
            vehicle.setAvailable(false);
            RentalTransaction transaction = new RentalTransaction(customer, vehicle, days);
            customer.addRentalTransaction(transaction);
            System.out.println("Rental processed for " + customer.getName() + " for " + days + " days.");
        } else {
            System.out.println("Vehicle is not available for rental.");
        }
    }

    public void returnVehicle(RentalTransaction transaction) {
        Vehicle vehicle = transaction.getVehicle();
        vehicle.setAvailable(true);
        System.out.println(vehicle.getModel() + " has been returned and is now available for rental.");
    }

    public void markAsAvailable(String model) {
        for (Vehicle vehicle : vehicleFleet) {
            if (vehicle.getModel().equalsIgnoreCase(model)) {
                vehicle.setAvailable(true);
                System.out.println(model + " is now available for rental.");
                return;
            }
        }
        System.out.println(model + " not found in the fleet.");
    }
}
