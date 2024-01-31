package Commands;

import java.util.HashMap;
import java.util.Scanner;

public class Console {

    private boolean exit = false;
    private final HashMap<String, Command> map = new HashMap<>();

    public void initialization() {
        map.put("up", new MoveUp());
    }

    private void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print(">> ");
        String command = scanner.nextLine();
        command = command.trim().toLowerCase();
        if (map.containsKey(command)) {
            System.out.println(">> " + map.get(command).execute());
            exit = map.get(command).exit();
        } else {
            System.out.println(">> Unknown command");
        }
    }

    public void start() {
        initialization();
        do {
            execute();
        } while (!exit);
    }


}
