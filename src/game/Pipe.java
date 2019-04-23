package game;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;

public class Pipe extends Tile {
    private boolean upEdge;     //Declaring 4 variables for the edges is the in/out or just a wall.
    private boolean downEdge;   // 1 means the edge has the pipe input output. 0 means not.
    private boolean leftEdge;
    private boolean rightEdge;

    public Pipe(int x, int y, boolean movable, boolean upEdge, boolean downEdge, boolean leftEdge, boolean rightEdge) {

        super(x, y, movable);
        this.upEdge = upEdge;
        this.downEdge = downEdge;
        this.leftEdge = leftEdge;
        this.rightEdge = rightEdge;
    }

    @Override
    public void setFill() {
        if(isHorizontal()) {
            this.setFill(new ImagePattern(new Image("img/pipeHorizontal.jpeg")));
        }else{
            this.setFill(new ImagePattern(new Image("img/pipeVertical.jpeg")));
        }
    }

    //This method sets edges due to given position (0 is up, 1 is left, 2 is down, 3 is right)
    public void setPosition(int position1, int position2) {

        //Error checking. If the positions are the same it will throw an exception.
        if (position1 == position2) {
            System.out.println("pos1 and pos2 is are same");
            return; // If they are same it returns nothing for exit the method.
        }

        //Sets first position checking the position value
        if (position1 == 0) {
            setUpEdge(true);
        } else if (position1 == 1) {
            setLeftEdge(true);
        } else if (position1 == 2) {
            setDownEdge(true);
        } else if (position1 == 3) {
            setRightEdge(true);
        }
        //Sets second position checking the position value
        if (position2 == 0) {
            setUpEdge(true);
        } else if (position2 == 1) {
            setLeftEdge(true);
        } else if (position2 == 2) {
            setDownEdge(true);
        } else if (position2 == 3) {
            setRightEdge(true);
        }
    }

    public boolean isUpEdge() {
        return upEdge;
    }

    public void setUpEdge(boolean upEdge) {
        this.upEdge = upEdge;
    }

    public boolean isDownEdge() {
        return downEdge;
    }

    public void setDownEdge(boolean downEdge) {
        this.downEdge = downEdge;
    }

    public boolean isLeftEdge() {
        return leftEdge;
    }

    public void setLeftEdge(boolean leftEdge) {
        this.leftEdge = leftEdge;
    }

    public boolean isRightEdge() {
        return rightEdge;
    }

    public void setRightEdge(boolean rightEdge) {
        this.rightEdge = rightEdge;
    }

    public boolean isHorizontal(){
        return (this.leftEdge && this.rightEdge);
    }
}
