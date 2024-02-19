package main.commands;

import main.Player;

public class MoveUp implements CommandInterface {

    private final Player player;

    public MoveUp(Player player) {
        this.player = player;
    }

    @Override
    public String execute() {
        if (player.moveUp()) return player.getCurrentLocation().toString();
        return "Can't move north :(";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
