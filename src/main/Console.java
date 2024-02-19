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
    private final HashMap<String, CommandInterface> map = new HashMap<>();

    public void initialization() {
        map.put("north", new MoveUp(player));
        map.put("south", new MoveDown(player));
        map.put("west", new MoveLeft(player));
        map.put("east", new MoveRight(player));
        map.put("commands", new Commands(map));
        map.put("explore", new Explore(player));
        map.put("leave", new Leave());
        map.put("pick up", new PickUp(player));
        map.put("backpack", new Backpack(player));
        map.put("eat herbs", new EatHerbs(player));
        map.put("use bandages", new UseBandages(player));
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
        System.out.println("Health: " + player.getHealth() + "/100");
        initialization();
        do {
            execute();
        } while (!exit);
    }
}
