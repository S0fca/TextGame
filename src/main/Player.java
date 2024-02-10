package main;

import main.world.Entity;
import main.world.Item;
import main.world.Location;

public class Player {

    private Location currentLocation;
    private int numberOfKeys = 0;
    private int health = 100;
    private boolean firstTimeInEnd = true;
    private Backpack backpack = new Backpack();

//region movement

    public boolean moveUp() {
        try {
            if (!currentLocation.getUp().getName().equals("void")) {
                currentLocation = currentLocation.getUp();
                checkState();
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
                checkState();
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
                checkState();
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
                checkState();
                return true;
            }
        } catch (NullPointerException ignored) {
        }
        return false;
    }

//endregion

    public void checkState() {
        checkEntities();
        checkEnd();
    }

    public void checkEntities() {
        Entity entity = currentLocation.getEntity();
        if (!(entity == null)) {
            if (entity.isFriendly()) {
                System.out.println("Friend yippee");
                System.out.println("");
            } else {
                System.out.println("Entity moment xd");
                health -= entity.getDamage();
                System.out.println(health);
                if (health <= 0) {
                    System.out.println("You've been killed. \nGame over");
                    System.exit(0);
                }
            }
            currentLocation.setEntity(null);
        }
    }

    public void checkEnd() {
        String text = "";
        String endText = "The keys fit perfectly and the portal activates.\nYou decide to wald inside and find yourself back home.\nGame end :)";
        if (currentLocation.getName().equals("End")) {
            if (firstTimeInEnd) {
                firstTimeInEnd = false;
                switch (numberOfKeys) {
                    case 0 ->
                            text += "You decide that it would be smart to try to find the keys and try to activate the portal.";
                    case 1 ->
                            text += "You remember the key, that you've found and decide to try whether it fits. \nYou put it inside and it works, but you don't have the second one so you take with you. \n\"I should try to find the second one\" you decide.";
                    case 2 ->{
                        text += "You remember the two keys you've found and realize, that they should fit so you try it out." + endText;
                        System.exit(0);
                    }
                }
                System.out.println("As you're walking, you spot something in the distance."
                        + "\nYou continue walking closer and you discover what appears to be a portal."
                        + "\nAs you inspect the portal you think to yourself, \"Could it be a portal back home?\""
                        + "\nTaking a closer look, you notice two key holes\n"
                        + text);
            } else if (numberOfKeys == 2) {
                System.out.println("You've gotten to the portal again and this time with both keys. You put them both in the keyholes.\n" + endText);
                System.exit(0);
            }
        }
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    public void pickUpItem(Item item) {
        backpack.add(item);
        if (item.toString().contains("key")) numberOfKeys++;
    }

    public void dealDamage(int damage) {
        health -= damage;
    }

//region getters

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public int getHealth() {
        return health;
    }

    public Backpack getBackpack() {
        return backpack;
    }

    public boolean getFirstTimeInEnd() {
        return firstTimeInEnd;
    }

//endregion

}
