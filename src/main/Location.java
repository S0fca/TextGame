package main;

import java.util.ArrayList;

public class Location {

    private String name;
    private Location up;
    private Location down;
    private Location left;
    private Location right;
    private ArrayList<Item> items = new ArrayList<>();

    public Location(char name) {
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(char name) {
        switch (name) {
            case '0' -> this.name = "void";
            case '1' -> this.name = "Start";
            case '2' -> this.name = "Forest";
            case '3' -> this.name = "Meadow";
            case '4' -> this.name = "Hills";
            case '5' -> this.name = "Mountains";
            case '6' -> this.name = "House";
            case '7' -> this.name = "Desert";
            case '8' -> this.name = "End";
        }
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

    @Override
    public String toString() {
        return "Name: " + name + " "
                + "Up: " + ((up != null) ? up.name : "void") + " "
                + "Down: " + ((down != null) ? down.name : "void") + " "
                + "Left: " + ((left != null) ? left.name : "void") + " "
                + "Right: " + ((right != null) ? right.name : "void") + " ";
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
}
