package lesson3.labs.prob4;

public class House extends Property {
    private double lotSize;

    public House(Address add, double lotSize) {
        if (add == null) {
            throw new NullPointerException("Address cannot be null");
        }
        super(add);
        this.lotSize = lotSize;
    }


    @Override
    double computeRent() {
        return 0.1 * lotSize;
    }
}
