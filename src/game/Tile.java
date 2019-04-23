package game;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public abstract class Tile extends Rectangle {
    private int xGrid; // Location of the tile at x-axis in the grid pane
    private int yGrid; // Location of the tile at y-axis in the grid pane
    private Image image;
    private boolean movable; //A boolean variable that keeps is tile static or not


    public Tile(int x, int y, boolean movable) { //Construction of the object
        super(130,130);
        this.xGrid = x;
        this.yGrid = y;
        this.movable = movable;
        setFill();
    }


    public void setFill(){
        this.setFill(Color.BLACK);
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public boolean isMoveable() {
        return movable;
    }


    public int getxGrid() {
        return xGrid;
    }

    public int getyGrid() {
        return yGrid;
    }
}