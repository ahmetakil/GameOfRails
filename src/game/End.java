package game;

public class End extends Pipe {

    public End(byte x, byte y, boolean upEdge, boolean downEdge, boolean leftEdge, boolean rightEdge) {
        super(x, y,false,upEdge, downEdge, leftEdge, rightEdge);
    }

    public End(byte x,byte y,byte position){
        super(x,y,false,false,false,false,false);
        setPosition(position,(byte)-1);
    }
}
