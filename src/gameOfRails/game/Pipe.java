package gameOfRails.game;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

import java.io.File;

public class Pipe extends Tile {

    private boolean upEdge;
    private boolean downEdge;
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

        if (isHorizontal() && isMovable()) {
            this.setFill(new ImagePattern(new Image(new File("img/pipeHorizontal.jpeg").toURI().toString())));
        } else if (isHorizontal() && !isMovable()) {
            this.setFill(new ImagePattern(new Image(new File("img/staticHorizontal.jpeg").toURI().toString())));
        } else if (!isHorizontal() && isMovable()) {
            this.setFill(new ImagePattern(new Image(new File("img/pipeVertical.jpeg").toURI().toString())));
        } else if (!isHorizontal() && !isMovable()) {
            this.setFill(new ImagePattern(new Image(new File("img/staticVertical.jpeg").toURI().toString())));
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

    public boolean isHorizontal() {
        return (this.leftEdge && this.rightEdge);
    }

    @Override
    public String toString() {
        return String.format("Pipe at %d %d ", getxGrid(), getyGrid());
    }

}
