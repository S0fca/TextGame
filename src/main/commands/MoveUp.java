package main.commands;

import main.Player;

public class MoveUp implements Command {

    private final Player player;

    public MoveUp(Player player) {
        this.player = player;
    }

    @Override
    public String execute() {
        if (player.moveUp()) return player.getCurrentLocation().toString();
        return "Can't move up :(";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
