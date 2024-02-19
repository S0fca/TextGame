package main.world;

public class Item {

    private final String name;
    private final boolean pickUp;

    public Item(String name, boolean pickUp) {
        this.name = name;
        this.pickUp = pickUp;
    }

    @Override
    public String toString() {
        return name;
    }

    public boolean isPickUp() {
        return pickUp;
    }
}
