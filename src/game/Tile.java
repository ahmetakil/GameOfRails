package game;

import javafx.scene.image.Image;

public abstract class Tile {
    private int x; // Location of the tile at x-axis in the grid pane
    private int y; // Location of the tile at y-axis in the grid pane
    private Image image;
    private boolean movable; //A boolean variable that keeps is tile static or not.

    public Tile(int x, int y, boolean movable) { //Construction of the object
        this.x = x;
        this.y = y;
        this.movable = movable;
    }

    public int getX() { //Getter Setter methods.
        return x;
    }

    public void setX(byte x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(byte y) {
        this.y = y;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public boolean isMoveable() {
        return movable;
    }

}