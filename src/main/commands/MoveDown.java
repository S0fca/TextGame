package main.commands;
import main.Player;

public class MoveDown implements Command {

    Player player;

    public MoveDown(Player player) {
        this.player = player;
    }

    @Override
    public String execute() {
        player.moveDown();
        return player.getCurrentLocation().toString();
    }

    @Override
    public boolean exit() {
        return false;
    }

}
