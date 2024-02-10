package main;

import main.world.Location;
import main.world.World;

public class Game {

    private final World world;
    private final Player player = new Player();

    public Game() {
        world = new World();
        setPlayerLocation();
        Console console = new Console(player);
        console.start();
    }

    public void setPlayerLocation() {
        for (Location location : world.getLocations()) {
            if (location.getName().equals("Start")) {
                player.setCurrentLocation(location);
                break;
            }
        }

    }

}
