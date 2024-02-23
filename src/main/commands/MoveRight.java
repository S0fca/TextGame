package main.commands;

import main.Player;

public class MoveRight implements CommandInterface {

    private final Player player;

    public MoveRight(Player player) {
        this.player = player;
    }

    @Override
    public String execute() {
        if (player.moveRight()) return player.getCurrentLocation().toString();
        return "Can't move east :(";
    }
}
