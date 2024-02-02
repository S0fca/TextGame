package main.commands;
import main.Player;

public class MoveRight implements Command {

    Player player;

    public MoveRight(Player player) {
        this.player = player;
    }

    @Override
    public String execute() {
        player.moveRight();
        return player.getCurrentLocation().toString();
    }

    @Override
    public boolean exit() {
        return false;
    }

}
