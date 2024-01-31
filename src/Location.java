public class Location {

    private String name;
    private Location up;
    private boolean goUp;
    private Location down;
    private Location left;
    private Location right;

    public Location(char name) {
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(char name) {
        switch (name) {
            case '0' -> this.name = null;
            case '1' -> this.name = "1";
            case '2' -> this.name = "2";
            case '3' -> this.name = "3";
            case '4' -> this.name = "4";
            case '5' -> this.name = "5";
        }
    }

    public void setUp(Location up) {
        this.up = up;
    }

    public void setDown(Location down) {
        this.down = down;
    }

    public void setLeft(Location left) {
        this.left = left;
    }

    public void setRight(Location right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return  "\nName: " + name + " "
                + "Up: " + ((up != null) ? up.name : "void") + " "
                + "Down: " + ((down != null) ? down.name : "void") + " "
                + "Left: " + ((left != null) ? left.name : "void") + " "
                + "Right: " + ((right != null) ? right.name : "void") + " ";
    }

    public void setGoUp(boolean goUp) {
        this.goUp = goUp;
    }
}
