package oop;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String customerId;
    private String name;
    private List<RentalTransaction> rentalHistory;

    public Customer(String customerId, String name) {
        this.customerId = customerId;
        this.name = name;
        this.rentalHistory = new ArrayList<>();
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public List<RentalTransaction> getRentalHistory() {
        return rentalHistory;
    }

    public void addRentalTransaction(RentalTransaction transaction) {
        rentalHistory.add(transaction);
    }

    public double getTotalRentalCost() {
        double totalCost = 0;
        for (RentalTransaction transaction : rentalHistory) {
            totalCost += transaction.getTotalCost();
        }
        return totalCost;
    }

    public List<RentalTransaction> getActiveRentals() {
        List<RentalTransaction> activeRentals = new ArrayList<>();
        for (RentalTransaction transaction : rentalHistory) {
            if (!transaction.isReturned()) {
                activeRentals.add(transaction);
            }
        }
        return activeRentals;
    }
}
