package main;

public class Game {

    private World world;
    private Player player = new Player();

    public Game() {
        world = new World();
        setPlayerLocation();
        Console console = new Console(player);
        console.start();
    }

    public void setPlayerLocation() {
        for (Location l : world.getLocations()) {
            if (l.getName().equals("Start")) {
                player.setCurrentLocation(l);
                break;
            }
        }

    }

}
