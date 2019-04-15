package game;

public class Curved extends Pipe {

    public Curved(int x, int y, boolean upEdge, boolean downEdge, boolean leftEdge, boolean rightEdge) {
        super(x, y, true, upEdge, downEdge, leftEdge, rightEdge);
    }

    public Curved(int x, int y, int position1, int position2) {

        super(x, y, false, false, false, false, false);
        setPosition(position1, position2);

        if ((isDownEdge() && isUpEdge()) || (isLeftEdge() && isRightEdge())) {
            System.out.println("curved dedik düz oldu");
        }
    }


}
