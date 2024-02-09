package main.commands;

import main.Player;

public class MoveLeft implements Command {

    private final Player player;

    public MoveLeft(Player player) {
        this.player = player;
    }

    @Override
    public String execute() {
        if (player.moveLeft()) return player.getCurrentLocation().toString();
        return "Can't move left :(";
    }

    @Override
    public boolean exit() {
        return false;
    }

}
