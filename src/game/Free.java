package game;

import javafx.scene.paint.Color;

public class Free extends EmptyTile {


    public Free(int x, int y) {
        super(x, y);
    }

    @Override
    public void setFill() {
        this.setFill(Color.GRAY);
    }
}
