package game;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;


public abstract class Tile extends Rectangle {
    private int xGrid; // Location of the tile at x-axis in the grid pane
    private int yGrid; // Location of the tile at y-axis in the grid pane
    private Image image;
    private boolean movable; //A boolean variable that keeps is tile static or not


    public Tile(int x, int y, boolean movable) { //Construction of the object
        this.xGrid = x;
        this.yGrid = y;
        this.movable = movable;
        this.image = new Image("img/empty.jpeg");
        setFill();
        setStroke(Color.WHITE);

    }


    public void setFill(){
        this.setFill(new ImagePattern(this.image));
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

    public void setxGrid(int xGrid){
        this.xGrid = xGrid;
    }

    public void setyGrid(int yGrid){
        this.yGrid = yGrid;
    }

}