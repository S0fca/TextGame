package main.commands;

import main.Player;
import main.world.Item;

public class PickUp implements CommandInterface {

    Player player;

    public PickUp(Player player) {
        this.player = player;
    }

    @Override
    public String execute() {
        if (!player.getCurrentLocation().isExplored()) return "You didn't explore yet.";
        for (Item item : player.getCurrentLocation().getItems()) {
            if (item.isPickUp()) player.addOrDeleteItem(item, 1);
        }
        player.getCurrentLocation().pickUpItems();
        return "You've picked up all the items. \nYour backpack: \n" + player.getBackpack();
    }
}
