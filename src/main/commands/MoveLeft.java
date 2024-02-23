package main.commands;

import main.Player;

public class MoveLeft implements CommandInterface {

    private final Player player;

    public MoveLeft(Player player) {
        this.player = player;
    }

    @Override
    public String execute() {
        if (player.moveLeft()) return player.getCurrentLocation().toString();
        return "Can't move west :(";
    }
}
