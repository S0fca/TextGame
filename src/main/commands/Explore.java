package main.commands;

import main.Player;
import main.world.Item;

public class Explore implements CommandInterface {

    private final Player player;
    private int key = 0;


    public Explore(Player player) {
        this.player = player;
    }

    @Override
    public String execute() {
        String items = "";
        String text = "";
        for (Item item : player.getCurrentLocation().getItems()) {
            items += item.toString() + '\n';
            if (item.toString().contains("key")) key += 1;
        }
        if (items.contains("key")) {
            player.addOrDeleteItem(player.getCurrentLocation().getKey(), 1);
            player.getCurrentLocation().getItems().remove(player.getCurrentLocation().getKey());
        } else if (key == 2) key = 0;
        if (items.length() > 0) {
            text += "You've looked around and managed to find these items: \n" + items.strip();
            if (key == 1 && items.contains("key")) {
                if (player.getFirstTimeInEnd())
                    text += "\nYou've found a key, you look at it and decide to keep it. \nMight come in handy you think to yourself.";
                else text += "\nOh you've found one of the keys, looks like it should fit";
            } else if (key == 2 && items.contains("key")) {
                if (player.getFirstTimeInEnd())
                    text += "\nYou've found another key that's interesting. \nYou also decide to take it with you.";
                else text += "\nOh cool you've managed to find the second key!";
            }
        } else {
            text += "You've looked around but didn't find anything.";
        }
        return text;
    }

    @Override
    public boolean exit() {
        return false;
    }
}
