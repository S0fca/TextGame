package main.commands;

import main.Player;
import main.world.Item;

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
