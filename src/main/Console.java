package main;

import main.commands.*;

import java.util.HashMap;
import java.util.Scanner;

public class Console {

    Player player;

    public Console(Player player) {
        this.player = player;
    }

    private boolean exit = false;
    private final HashMap<String, Command> map = new HashMap<>();

    public void initialization() {
        map.put("up", new MoveUp(player));
        map.put("down", new MoveDown(player));
        map.put("left", new MoveLeft(player));
        map.put("right", new MoveRight(player));
        map.put("commands", new Commands(map));
        map.put("explore", new Explore(player));
        map.put("leave", new Leave());
        map.put("pick up", new PickUp(player));
    }

    private void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print(">> ");
        String command = scanner.nextLine();
        command = command.trim().toLowerCase();
        if (map.containsKey(command)) {
            System.out.println(map.get(command).execute());
            exit = map.get(command).exit();
        } else System.out.println("Unknown command");
    }

    public void start() {
        initialization();
        do {
            execute();
        } while (!exit);
    }


}
