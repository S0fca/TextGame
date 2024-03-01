package main.commands;

import main.Player;

public class Health implements CommandInterface {

    private final Player player;

    public Health(Player player) {
        this.player = player;
    }

    @Override
    public String execute() {
        return "Your health: " + player.getHealth() +"/100";
    }
}
