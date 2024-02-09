package main.commands;

public class Leave implements Command {
    @Override
    public String execute() {
        return "Game over";
    }

    @Override
    public boolean exit() {
        return true;
    }
}
