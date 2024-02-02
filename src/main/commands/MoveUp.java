package main.commands;
import main.Player;

public class MoveUp implements Command {

    Player player;

    public MoveUp(Player player) {
        this.player = player;
    }

    @Override
    public String execute() {
        player.moveUp();
        return player.getCurrentLocation().toString();
    }

    @Override
    public boolean exit() {
        return false;
    }
}
