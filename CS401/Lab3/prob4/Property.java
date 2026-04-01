package lesson3.labs.prob4;

public abstract class Property {
    private Address address;

    public Property (Address add) {
        address = add;
    }
    public Address getAddress() {
        return address;
    }

    abstract double computeRent();
}
