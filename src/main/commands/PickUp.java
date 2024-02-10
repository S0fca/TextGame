package main.commands;

import main.Item;
import main.Player;

public class PickUp implements Command {

    Player player;

    public PickUp(Player player) {
        this.player = player;
    }

    @Override
    public String execute() {
        for (Item item : player.getCurrentLocation().getItems()) {
            if (item.isPickUp()) player.pickUpItem(item);
        }
        player.getCurrentLocation().pickUpItems();
        return "You've picked up all the items.";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
