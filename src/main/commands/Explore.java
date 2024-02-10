package main.commands;

import main.Item;
import main.Player;

public class Explore implements Command {

    private final Player player;
    private int key = 0;


    public Explore(Player player) {
        this.player = player;
    }

    @Override
    public String execute() {
        String items = "";
        for (Item item : player.getCurrentLocation().getItems()) {
            items += item.toString() + '\n';
            if (item.getName().contains("key")) key += 1;
        }
        if (items.contains("key")) {
            player.pickUpItem(player.getCurrentLocation().getKey());
            player.getCurrentLocation().getItems().remove(player.getCurrentLocation().getKey());
        } else if (key == 2) key = 0;
        return "You've looked around and managed to find these items: \n"
                + items.strip()
                + ((key > 0) ? ((key == 1) ? "\nYou've found a key, you look at it and decide to keep it. \nMight come in handy you think to your self." : "") + ((key == 2) ? "\nYou've found another key that's interesting. \nYou also decide to take it with you." : "") : "");
    }

    @Override
    public boolean exit() {
        return false;
    }
}
