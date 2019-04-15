package game;

import javafx.scene.image.Image;

public abstract class Tile {
        private byte x; // Location of the tile at x-axis in the grid pane
        private byte y; // Location of the tile at y-axis in the grid pane
        private Image image; // Image of the tile which was brought from minecraft rail system.
        private boolean movable; //A boolean variable that keeps is tile static or not.

    public Tile(byte x, byte y,boolean movable) { //Construction of the object
        this.x = x;
        this.y = y;
        this.movable = movable;
    }

    public byte getX() { //Getter Setter methods.
        return x;
    }

    public void setX(byte x) {
        this.x = x;
    }

    public byte getY() {
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
