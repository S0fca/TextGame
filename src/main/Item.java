package main;

public class Item {

    private final String name;
    private boolean pickUp;
    private boolean key;

    public Item(String name, boolean pickUp, boolean key) {
        this.name = name;
        this.pickUp = pickUp;
        this.key = key;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }
}
