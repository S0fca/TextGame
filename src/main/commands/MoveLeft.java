package main.commands;
import main.Player;

public class MoveLeft implements Command {

    Player player;

    public MoveLeft(Player player) {
        this.player = player;
    }

    @Override
    public String execute() {
        player.moveLeft();
        return player.getCurrentLocation().toString();
    }

    @Override
    public boolean exit() {
        return false;
    }

}
