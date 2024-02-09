package main;

import java.util.ArrayList;
import java.util.Random;

public class Location {

    private String name;
    private Location up;
    private Location down;
    private Location left;
    private Location right;
    private final ArrayList<Item> items = new ArrayList<>();
    private final ArrayList<Entity> entities = new ArrayList<>();

    public Location(char name) {
        setName(name);
        addItems();
        addEntities();
    }

    private void addEntities() {
    }

    private void addItems() {
        Random r = new Random();
        int numberOfItems = r.nextInt(5) + 1;
        ArrayList<Item> itemsList = setItems();
        for (int i = 0; i < numberOfItems; i++) {
            items.add(itemsList.get(r.nextInt(itemsList.size())));
        }
    }

    private ArrayList<Item> setItems() {
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item("Compass", true, false));
        items.add(new Item("Bandages", true, false));
        items.add(new Item("Knife", true, false));
        items.add(new Item("Medicinal Herbs", true, false));
        items.add(new Item("Coins", true, false));
        items.add(new Item("Flint and steal", true, false));
        items.add(new Item("Paper", true, false));
        items.add(new Item("Book", true, false));
        items.add(new Item("Spyglass", true, false));
        items.add(new Item("Chest", false, false));
        items.add(new Item("Rock", false, false));

        return items;
    }

    public void addKeyItem(Item key) {
        items.add(key);
    }

    public void setName(char name) {
        switch (name) {
            case '0' -> this.name = "void";
            case '1' -> this.name = "Start";
            case '2' -> this.name = "Forest";
            case '3' -> this.name = "Meadow";
            case '4' -> this.name = "Hills";
            case '5' -> this.name = "Mountains";
            case '6' -> this.name = "Village";
            case '7' -> this.name = "Desert";
            case '8' -> this.name = "End";
        }
    }

    @Override
    public String toString() {
        return "Name: " + name + " "
                + "Up: " + ((up != null) ? up.name : "void") + " "
                + "Down: " + ((down != null) ? down.name : "void") + " "
                + "Left: " + ((left != null) ? left.name : "void") + " "
                + "Right: " + ((right != null) ? right.name : "void") + " ";
    }

    public String getName() {
        return name;
    }

    public Location getUp() {
        return up;
    }

    public Location getDown() {
        return down;
    }

    public Location getLeft() {
        return left;
    }

    public Location getRight() {
        return right;
    }

    public void setUp(Location up) {
        this.up = up;
    }

    public void setDown(Location down) {
        this.down = down;
    }

    public void setLeft(Location left) {
        this.left = left;
    }

    public void setRight(Location right) {
        this.right = right;
    }

    public ArrayList<Item> getItems() {
        return items;
    }
}
