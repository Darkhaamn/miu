package lesson3.labs.prob2;

import java.util.ArrayList;
import java.util.List;

public class LandlordInfo {
    List<Building> buildings;

    public LandlordInfo() {
        buildings = new ArrayList<>();
    }

    public void addBuilding (Building newBuilding) {
        buildings.add(newBuilding);
    }

    public double calcProfits() {
        // which is the sum of all the apartment rents minus the building maintenance costs.
        double profit = 0;

        for (Building bld: buildings) {
            profit += bld.calcProfits();
        }
        return profit;
    }
}
