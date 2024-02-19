package main.world;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class World {

    private final ArrayList<Location> locations = new ArrayList<>();
    private final Random r = new Random();


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
                if (line.charAt(j) == '8') end++;
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
        }
        addKeys();
        addEntities();
        checkWorld(start, end);
    }

    private void checkWorld(int start, int end) {
        if (start == 1 && end == 1) {
            System.out.println("""
                    World successfully loaded\s
                    Write "commands" to see everything you can do.
                    ---------------------------------------------------
                    """);
            System.out.println("""
                    You've just woken up thinking you're at home, in your bed, just like every other day.
                    However, as your eyes open, you find yourself lying somewhere outside, somewhere unknown.
                    As you look around everything looks normal, yet not quite right - there's something off about this place.
                    The place looks nice and you're feeling pretty calm, not realizing the situation you're in just yet.
                    As you wake up, you start walking around and exploring, after a while the reality sets in:
                    you're somewhere outside, alone with no sight of home and no idea what's going on or where you are.
                    You begin to panic a little but eventually calm down considering panic is not gonna help anything.
                    Do you continue exploring or choose a direction to walk, hoping to unravel the mystery
                    of your surroundings? The decision is yours to make.""");
        } else {
            System.out.println("World loaded unsuccessfully :(");
            System.exit(0);
        }
    }

    private void addKeys() {
        String[] keys = {"Red key", "Blue key"};
        int num1 = -1;
        for (int i = 0; i < keys.length; i++) {
            int num = r.nextInt(locations.size());
            if (!locations.get(num).getName().equals("Start") && !locations.get(num).getName().equals("End") && !locations.get(num).getName().equals("void") && num1 != num) {
                if (num1 == -1) num1 = num;
                locations.get(num).addKeyItem(new Item(keys[i], true));
                System.out.println(locations.get(num));
            } else i--;
        }
    }

    private void addEntities() {
        Entity[] entities = {new Entity(true, 0), new Entity(false, 50), new Entity(false, 10)};
        for (int i = 0; i < entities.length; i++) {
            int num = r.nextInt(locations.size());
            if (!locations.get(num).getName().equals("Start") && !locations.get(num).getName().equals("End") && !locations.get(num).getName().equals("void") && locations.get(num).getEntity() == null) {
                locations.get(num).setEntity(entities[i]);
                System.out.println(locations.get(num));
            } else i--;
        }
        System.out.println();
    }

    public ArrayList<Location> getLocations() {
        return locations;
    }
}