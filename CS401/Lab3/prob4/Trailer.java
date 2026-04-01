package lesson3.labs.prob4;

public class Trailer extends Property {
    private Address trailerParkAddress;

    public Trailer(Address add, Address trailerParkAddress) {
        if (add == null) {
            throw new NullPointerException("Address cannot be null");
        }
        super(add);
        this.trailerParkAddress = trailerParkAddress;
    }

    @Override
    double computeRent() {
        return 500;
    }
}
