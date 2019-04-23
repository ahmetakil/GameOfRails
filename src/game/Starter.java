package game;

import javafx.scene.paint.Color;

public class Starter extends Pipe {

    public Starter(int x, int y, boolean upEdge, boolean downEdge, boolean leftEdge, boolean rightEdge) {

        super(x, y, false, upEdge, downEdge, leftEdge, rightEdge);

    }

    @Override
    public void setFill() {
        this.setFill(Color.GREEN);
    }
}
