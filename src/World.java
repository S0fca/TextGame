import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class World {

    private Player player = new Player();
    private ArrayList<Location> locations = new ArrayList<>();
    Console console = new Console(player);

    public World() {
        loadFile();
    }

    public void loadFile() {
        ArrayList<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("world.txt"))) {
            String s;
            while ((s = br.readLine()) != null) {
                lines.add(s);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Something wrong with the file");
        }
        setWorld(lines);
    }

    public void setWorld(ArrayList<String> lines) {
        int start = 0;
        int end = 0;
        for (int i = 0; i < lines.size(); i += 2) {
            String line = lines.get(i);
            for (int j = 0; j < line.length(); j += 4) {
                if (line.charAt(j) == '1') start++;
                if (line.charAt(j) == '5') end++;
                locations.add(new Location(line.charAt(j)));
            }
        }
        int height = lines.size() - lines.size() / 2;
        int width = locations.size() / height;
        for (int i = 0; i < locations.size(); i++) {
            Location l = locations.get(i);
            if (l.getName() == null) {
                l.setName('0');
                continue;
            }
            if (i != 0 && (i % width) != 0) l.setLeft(locations.get(i - 1));
            if (i != locations.size() && ((i + 1) % 4) != 0) l.setRight(locations.get(i + 1));
            if (i < locations.size() - width) l.setDown(locations.get(i + width));
            if (i >= width) l.setUp(locations.get(i - width));
            if (l.getName().equals("Start")) player.setCurrentLocation(l);
        }
        if (start == 1 && end == 1) {
            System.out.println("World successfully loaded");
            console.start();
        } else {
            System.out.println("World loaded unsuccessfully :(");
        }
    }
}
