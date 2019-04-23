package game;

import javafx.scene.paint.Color;

public class EmptyTile extends Tile {

    public EmptyTile(int x, int y) {
        super(x, y, true);
        this.setStroke(Color.YELLOW);
    }

    @Override
    public void setFill() {
        this.setFill(Color.BROWN);
    }
}
