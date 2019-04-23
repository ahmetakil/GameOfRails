package game;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;

public class EmptyTile extends Tile {

    public EmptyTile(int x, int y) {
        super(x, y, true);
        this.setStroke(Color.YELLOW);
    }

    @Override
    public void setFill() {
        this.setFill(new ImagePattern(new Image("img/empty.jpeg")));
    }
}
