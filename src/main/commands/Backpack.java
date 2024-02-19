package main.commands;

import main.Player;

public class Backpack implements CommandInterface {

    Player player;

    public Backpack(Player player) {
        this.player = player;
    }

    @Override
    public String execute() {
        return player.getBackpack();
    }

    @Override
    public boolean exit() {
        return false;
    }
}
