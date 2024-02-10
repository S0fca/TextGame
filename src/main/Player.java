package main;

public class Player {

    private Location currentLocation;
    private Backpack backpack = new Backpack();

    public boolean moveUp() {
        try {
            if (!currentLocation.getUp().getName().equals("void")) {
                currentLocation = currentLocation.getUp();
                return true;
            }
        } catch (NullPointerException ignored) {
        }
        return false;
    }

    public boolean moveDown() {
        try {
            if (!currentLocation.getDown().getName().equals("void")) {
                currentLocation = currentLocation.getDown();
                return true;
            }
        } catch (NullPointerException ignored) {
        }
        return false;
    }

    public boolean moveLeft() {
        try {
            if (!currentLocation.getLeft().getName().equals("void")) {
                currentLocation = currentLocation.getLeft();
                return true;
            }
        } catch (NullPointerException ignored) {
        }
        return false;
    }

    public boolean moveRight() {
        try {
            if (!currentLocation.getRight().getName().equals("void")) {
                currentLocation = currentLocation.getRight();
                return true;
            }
        } catch (NullPointerException ignored) {
        }
        return false;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void pickUpItem(Item item){
        backpack.add(item);
    }

    public Backpack getBackpack() {
        return backpack;
    }
}
