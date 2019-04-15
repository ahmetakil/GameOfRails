package game;

public class Pipe extends Tile {
    private boolean upEdge;     //Declaring 4 variables for the edges is the in/out or just a wall.
    private boolean downEdge;   // 1 means the edge has the pipe input output. 0 means not.
    private boolean leftEdge;
    private boolean rightEdge;

    public Pipe(byte x, byte y, boolean movable, boolean upEdge, boolean downEdge, boolean leftEdge, boolean rightEdge) {
        super(x, y, movable);
        this.upEdge = upEdge;
        this.downEdge = downEdge;
        this.leftEdge = leftEdge;
        this.rightEdge = rightEdge;
    }

    public void setPosition(byte position1, byte position2) {
        if (position1 == position2) {
            System.out.println("pos1 and pos2 is are same");
            return;
        }
        if (position1 == 0) {
            setUpEdge(true);
        } else if (position1 == 1) {
            setLeftEdge(true);
        } else if (position1 == 2) {
            setDownEdge(true);
        } else if (position1 == 3) {
            setRightEdge(true);
        }
        if (position2 == 0) {
            setUpEdge(true);
        } else if (position2 == 1) {
            setLeftEdge(true);
        } else if (position2 == 2) {
            setDownEdge(true);
        } else if (position2 == 3) {
            setRightEdge(true);
        }
    }

    public boolean isUpEdge() {
        return upEdge;
    }

    public void setUpEdge(boolean upEdge) {
        this.upEdge = upEdge;
    }

    public boolean isDownEdge() {
        return downEdge;
    }

    public void setDownEdge(boolean downEdge) {
        this.downEdge = downEdge;
    }

    public boolean isLeftEdge() {
        return leftEdge;
    }

    public void setLeftEdge(boolean leftEdge) {
        this.leftEdge = leftEdge;
    }

    public boolean isRightEdge() {
        return rightEdge;
    }

    public void setRightEdge(boolean rightEdge) {
        this.rightEdge = rightEdge;
    }
}
