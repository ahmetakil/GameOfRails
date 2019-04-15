package game;

public class Static extends Pipe {

    public Static(int x, int y, boolean upEdge, boolean downEdge, boolean leftEdge, boolean rightEdge) {

        super(x, y, false, upEdge, downEdge, leftEdge, rightEdge);
    }

    public Static(int x, int y, int position1, int position2) {

        super(x, y, false, false, false, false, false);
        setPosition(position1, position2);
    }
}
