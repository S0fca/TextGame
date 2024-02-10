package main.world;

public class Entity {

    private String name;
    private boolean friendly;
    private int damage;

    public Entity(String name, boolean friendly, int damage) {
        this.name = name;
        this.friendly = friendly;
        this.damage = 0;
    }

    public boolean isFriendly() {
        return friendly;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "name='" + name + '\'' +
                ", friendly=" + friendly +
                '}';
    }

    public int getDamage() {
        return damage;
    }
}
