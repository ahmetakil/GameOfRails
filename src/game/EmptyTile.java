package game;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

public class EmptyTile extends Tile {

    public EmptyTile(int x, int y) {
        super(x, y, true);
    }

    @Override
    public boolean isUpEdge() {
        return false;
    }

    @Override
    public boolean isLeftEdge() {
        return false;
    }

    @Override
    public boolean isRightEdge() {
        return false;
    }

    @Override
    public boolean isDownEdge() {
        return false;
    }

    @Override
    public void setUpEdge(boolean upEdge) {

    }

    @Override
    public void setLeftEdge(boolean leftEdge) {

    }

    @Override
    public void setRightEdge(boolean rightEdge) {

    }

    @Override
    public void setDownEdge(boolean downEdge) {

    }

    @Override
    public void setFill() {
        this.setFill(new ImagePattern(new Image("img/empty.jpeg")));
    }

    @Override
    public String toString(){
        return String.format("EmptyTile at %d %d ",getxGrid(),getyGrid());
    }

}
