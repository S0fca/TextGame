package main.commands;

import main.Item;
import main.Player;

public class Explore implements Command {

    private final Player player;

    public Explore(Player player) {
        this.player = player;
    }

    @Override
    public String execute() {
        String items = "";
        boolean key = false;
        for (Item item : player.getCurrentLocation().getItems()) {
            items += item.toString() + '\n';
            if (item.getName().contains("key")) key = true;

        }
        return "You've looked around and managed to find these items: \n" + items.strip() + ((key) ? "\n -You've found a key!" : "");
    }

    @Override
    public boolean exit() {
        return false;
    }
}
