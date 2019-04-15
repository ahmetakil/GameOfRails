package game;

public class Static extends Pipe {

    public Static(byte x, byte y, boolean upEdge, boolean downEdge, boolean leftEdge, boolean rightEdge) {

        super(x, y, false, upEdge, downEdge, leftEdge, rightEdge);
    }

    public Static(byte x, byte y, byte position1, byte position2) {

        super(x, y, false, false, false, false, false);
        setPosition(position1, position2);
    }
}
