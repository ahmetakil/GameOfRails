package gameOfRails.game;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

import java.io.File;

public class Free extends EmptyTile {


    public Free(int x, int y) {
        super(x, y,false);
    }

    @Override
    public void setFill() {
        this.setFill(new ImagePattern(new Image(new File("img/emptyFree.jpeg").toURI().toString())));
    }

    @Override
    public String toString(){
        return String.format("Free  at %d %d ",getxGrid(),getyGrid());
    }
}
