package main.world;

import java.util.ArrayList;
import java.util.Random;

public class Location {

    private String name;
    private Location up, down, left, right;
    private final ArrayList<Item> items = new ArrayList<>();
    private Entity entity;
    private boolean explored = false;

    public Location(char name) {
        setName(name);
        addItems();
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }

    private void addItems() {
        Random r = new Random();
        int numberOfItems = r.nextInt(5);
        Item[] items = new Item[]{new Item("Compass", true), new Item("Bandages", true),
                new Item("Knife", true), new Item("Medicinal Herbs", true),
                new Item("Rock", false), new Item("Paper", true),
                new Item("Book", true), new Item("Chest", false),
                new Item("Coin", true), new Item("Coin", true), new Item("Coin", true)};
        for (int i = 0; i < numberOfItems; i++) {
            this.items.add(items[r.nextInt(items.length)]);
        }
    }

    public void addKeyItem(Item key) {
        items.add(key);
    }

    public Item getKey() {
        for (Item item : items) {
            if (item.toString().contains("key")) {
                return item;
            }
        }
        return null;
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
        return "You've walked into a place, it looks like (a): " + name + "\nYou look around and you see\n"
                + "North: " + ((up != null) ? up.name : "void") + '\n'
                + "South: " + ((down != null) ? down.name : "void") + '\n'
                + "West: " + ((left != null) ? left.name : "void") + '\n'
                + "East: " + ((right != null) ? right.name : "void");
    }

    public void pickUpItems() {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).isPickUp()) items.remove(items.get(i));
        }
    }

    public Entity getEntity() {
        return entity;
    }

//region setters

    public void setExplored(boolean explored) {
        this.explored = explored;
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
//endregion

//region getters


    public boolean isExplored() {
        return explored;
    }

    public ArrayList<Item> getItems() {
        return items;
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
//endregion

}
