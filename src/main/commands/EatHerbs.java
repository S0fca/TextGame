package main.commands;

import main.Player;
import main.world.Item;

public class EatHerbs implements CommandInterface {

    Player player;

    public EatHerbs(Player player) {
        this.player = player;
    }

    @Override
    public String execute() {
        if (player.getHealth() >= 100) return "You have full health.";
        if (player.getItemNumber(new Item("Medicinal Herbs", true)) > 0) {
            player.addOrDeleteItem(new Item("Medicinal Herbs", true), -1);
            player.changeHealth(10);
        } else return "You don't have any herbs :(";
        return "Your health: " + player.getHealth() + "/100";
    }
}
