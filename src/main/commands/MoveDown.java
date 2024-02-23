package main.commands;

import main.Player;

public class MoveDown implements CommandInterface {

    private final Player player;

    public MoveDown(Player player) {
        this.player = player;
    }

    @Override
    public String execute() {
        if (player.moveDown()) return player.getCurrentLocation().toString();
        return "Can't move south :(";
    }
}
