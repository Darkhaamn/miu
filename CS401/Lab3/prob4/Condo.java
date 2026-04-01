package lesson3.labs.prob4;

public class Condo extends Property {
    private int numFloors;

    public Condo(Address address, int numFloors) {
        if (address == null) {
            throw new NullPointerException("Address cannot be null");
        }
        super(address);
        this.numFloors = numFloors;
    }

    @Override
    double computeRent() {
        return 400 * numFloors;
    }
}
