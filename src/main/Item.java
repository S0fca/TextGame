package main;

public class Item {

    private final String name;
    private boolean pickUp;

    public Item(String name, boolean pickUp) {
        this.name = name;
        this.pickUp = pickUp;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public boolean isPickUp() {
        return pickUp;
    }
}
