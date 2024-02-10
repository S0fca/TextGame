package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class World {

    private final ArrayList<Location> locations = new ArrayList<>();

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
        }
        Random r = new Random();
        String[] keys = {"Red key", "Blue key"};
        int num1 = -1;
        for (int i = 0; i < 2; i++) {
            int num = r.nextInt(locations.size());
            if (!locations.get(num).getName().equals("Start") && !locations.get(num).getName().equals("End") && !locations.get(num).getName().equals("void") && num1 != num) {
                if (num1 == -1) num1 = num;
                locations.get(num).addKeyItem(new Item(keys[i], true));
                System.out.println(locations.get(num));
            } else i--;
        }
        if (start == 1 && end == 1) {
            System.out.println("World successfully loaded");
            System.out.println("You can now move around and explore :)\nWrite \"commands\" to see everything you can do!\n");
            System.out.println("""
                    You've just woken up thinking you're at home, in your bed, just like every other day.
                    However, as your eyes open, you find yourself lying somewhere outside, somewhere unknown.
                    As you look around everything looks normal, yet not quite right - there's something off about this place.
                    The place looks nice and you're feeling pretty calm, not realizing the situation you're in just yet.
                    As you wake up, you start walking around and exploring, after a while you begin to realize you're
                    somewhere outside, alone with no sight of home and no idea what's going on or where you are.
                    You begin to panic a little but eventually calm down considering panic is not gonna help anything.
                    You're now deciding what to do, you could explore a bit more or try to walk somewhere.""");
        } else {
            System.out.println("World loaded unsuccessfully :(");
            System.exit(0);
        }
    }

    public ArrayList<Location> getLocations() {
        return locations;
    }
}
