package main.commands;

import main.Player;
import main.world.Item;

public class UseBandages implements CommandInterface {

    private final Player player;

    public UseBandages(Player player) {
        this.player = player;
    }

    @Override
    public String execute() {
        if (player.getHealth() >= 100) return "You have full health.";
        if (player.getItemNumber(new Item("Bandages", true)) > 0) {
            player.addOrDeleteItem(new Item("Bandages", true), -1);
            player.changeHealth(25);
        } else return "You don't have any bandages :(";
        return "Your health: " + player.getHealth() + "/100";
    }
}
