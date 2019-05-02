package game;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

public class Free extends EmptyTile {


    public Free(int x, int y) {
        super(x, y);
    }

    @Override
    public void setFill() {
        this.setFill(new ImagePattern(new Image("img/emptyFree.jpeg")));
    }

    @Override
    public String toString(){
        return String.format("Free  at %d %d ",getxGrid(),getyGrid());
    }
}
