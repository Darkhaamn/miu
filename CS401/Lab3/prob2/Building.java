package lesson3.labs.prob2;

import java.util.ArrayList;
import java.util.List;

public class Building {
    private double maintenanceCost;
    private List<Apartment> apartments;

    public Building(double maintenanceCost) {
        this.maintenanceCost = maintenanceCost;
        apartments = new ArrayList<>();
    }

    public void addApartment(Apartment newApartment) {
        apartments.add(newApartment);
    }

    public List<Apartment> getApartments() {
        return apartments;
    }

    public double calcProfits() {
        // which is the sum of all the apartment rents minus the building maintenance costs.
        double profit = 0;
        for (Apartment apt: apartments) {
            profit += apt.getRent();
        }
        profit -= maintenanceCost;
        return profit;
    }
}
