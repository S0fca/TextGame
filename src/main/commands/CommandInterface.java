package main.commands;

public interface CommandInterface {

    String execute();

    default boolean exit() {
        return false;
    }

}
