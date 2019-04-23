package game;

import javafx.scene.paint.Color;

public class End extends Pipe {



    public End(int x, int y, boolean upEdge, boolean downEdge, boolean leftEdge, boolean rightEdge) {

        super(x, y, false, upEdge, downEdge, leftEdge, rightEdge);
    }

    public End(int x, int y, byte position) {

        super(x, y, false, false, false, false, false);
        setPosition(position, (byte) -1);
    }

    @Override
    public void setFill() {
        this.setFill(Color.RED);
    }
}
