package main.world;

public record Entity(boolean friendly, int damage) {

    @Override
    public String toString() {
        return "Entity{" +
                "friendly=" + friendly +
                ", damage=" + damage +
                '}';
    }
}
