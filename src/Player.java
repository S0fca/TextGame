public class Player {

    private Location currentLocation;
    private Backpack backpack;

    public void moveUp() {
        if (currentLocation.getUp() != null) {
            if (currentLocation.getUp().getName() != "void") currentLocation = currentLocation.getUp();
        }
    }

    public void moveDown() {
        if (currentLocation.getDown() != null) {
            if (currentLocation.getDown().getName() != "void") currentLocation = currentLocation.getDown();
        }
    }

    public void moveLeft() {
        if (currentLocation.getLeft() != null) {
            if (currentLocation.getLeft().getName() != "void") currentLocation = currentLocation.getLeft();
        }
    }

    public void moveRight() {
        if (currentLocation.getRight() != null) {
            if (currentLocation.getRight().getName() != "void") currentLocation = currentLocation.getRight();
        }
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }
}
