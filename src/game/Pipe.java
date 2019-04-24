package game;

import javafx.scene.image.Image;
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
        setFill();
    }

    @Override
    public void setFill() {

        if(isHorizontal()) {
            this.setFill(new ImagePattern(new Image("img/pipeHorizontal.jpeg")));
        }else{
            this.setFill(new ImagePattern(new Image("img/pipeVertical.jpeg")));
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
