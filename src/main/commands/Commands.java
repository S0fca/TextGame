package main.commands;

import java.util.HashMap;

public class Commands implements Command {

    private final HashMap<String, Command> map;

    public Commands(HashMap<String, Command> map) {
        this.map = map;
    }

    @Override
    public String execute() {
        String commands = "";
        for (String command : map.keySet()) commands += command + '\n';
        return commands.strip();
    }

    @Override
    public boolean exit() {
        return false;
    }
}
