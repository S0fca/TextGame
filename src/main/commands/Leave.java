package main.commands;

public class Leave implements CommandInterface {
    @Override
    public String execute() {
        return "Game over";
    }

    @Override
    public boolean exit() {
        return true;
    }
}
