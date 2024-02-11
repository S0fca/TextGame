package main;

import main.world.Entity;
import main.world.Item;
import main.world.Location;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Player {

    private Location currentLocation;
    private int numberOfKeys = 0;
    private int health = 100;
    private boolean firstTimeInEnd = true;

    private final HashMap<Item, Integer> backpack = new HashMap<>();

    public void checkState() {
        checkEntities();
        checkEnd();
    }


//region entity

    public void checkEntities() {
        Entity entity = currentLocation.getEntity();
        if (!(entity == null)) {
            if (entity.isFriendly()) {
                boolean answer;
                System.out.println("You've been walking for a bit and came across a creature. \nLuckily the creature seems friendly and asks you whether you'd like to buy some Medicinal Herbs"
                        + "\nin exchange for coins. The herbs can heal you by 10. \nSo would you? \nHere's your backpack: \n" + getBackpack());
                answer = getAnswer();
                if (answer) {
                    if (getItemNumber(new Item("Coin", true)) < 1) {
                        System.out.println("You've got no coins. So you tell the creature and it leaves.");
                    } else {
                        System.out.println("How many would you like to trade?");
                        int number = getNumber(getItemNumber(new Item("Coin", true)));

                        addOrDeleteItem(new Item("Coin", true), -number);
                        addOrDeleteItem(new Item("Medicinal Herbs", true), number);
                        System.out.println("Here's your backpack: \n" + getBackpack());
                    }
                } else {
                    System.out.println("\"That's alright, see you later,\" the creature says. ");
                }
            } else {
                System.out.println("Entity moment xd");
                changeHealth(-entity.getDamage());
                System.out.println(health);
                if (health <= 0) {
                    System.out.println("You've been killed. \nGame over");
                    System.exit(0);
                }
                currentLocation.setEntity(null);
            }
        }
    }

    private int getNumber(int max) {
        Scanner scanner = new Scanner(System.in);
        int number = -1;
        while (true) {
            try {
                if (number >= 0 && number <= max) {
                    break;
                } else {
                    System.out.println("Number has to be at least 0 and has to be smaller than " + (max + 1));
                    number = scanner.nextInt();
                }
            } catch (InputMismatchException e) {
                scanner.next();
                System.out.println("Has to be a number.");
                number = getNumber(max);
            }
        }
        return number;
    }

    private boolean getAnswer() {
        System.out.print("Write yes or no: ");
        String answer;
        Scanner scanner = new Scanner(System.in);
        answer = scanner.nextLine();
        if (answer.equalsIgnoreCase("Yes")) return true;
        else if (answer.equalsIgnoreCase("no")) return false;
        else return getAnswer();
    }

//endregion

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
                    case 2 -> {
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

    public void addOrDeleteItem(Item item, int number) {
        if (item.toString().contains("key")) numberOfKeys++;
        boolean itemFound = false;
        for (Item i : backpack.keySet()) {
            if (i.toString().equals(item.toString())) {
                backpack.replace(i, backpack.get(i) + number);
                itemFound = true;
            }
        }
        if (!itemFound && number > 0) {
            backpack.put(item, number);
        }
    }

    public void changeHealth(int number) {
        health += number;
    }


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

//region getters

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public int getHealth() {
        return health;
    }

    public String getBackpack() {
        String text = "";
        for (Item item : backpack.keySet()) {
            text += item.toString() + " " + backpack.get(item) + '\n';
        }
        return text.strip();
    }

    public int getItemNumber(Item item) {
        int number = 0;
        for (Item i : backpack.keySet()) {
            if (i.toString().equals(item.toString())) {
                number = backpack.get(i);
                break;
            }
        }
        return number;
    }

    public boolean getFirstTimeInEnd() {
        return firstTimeInEnd;
    }

//endregion

}
