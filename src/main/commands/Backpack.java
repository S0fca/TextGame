package main.commands;

import main.Player;

public class Backpack implements Command {

    Player player;

    public Backpack(Player player) {
        this.player = player;
    }

    @Override
    public String execute() {
        if (player.getBackpack().length() == 0) {
            return "Your backpack is empty :(";
        }
        return player.getBackpack();
    }

    @Override
    public boolean exit() {
        return false;
    }
}
