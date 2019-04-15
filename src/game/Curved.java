package game;

public class Curved extends Pipe{
    public Curved(byte x, byte y, boolean upEdge, boolean downEdge, boolean leftEdge, boolean rightEdge) {
        super(x, y,true,upEdge, downEdge, leftEdge, rightEdge);
    }

    public Curved(byte x,byte y,byte position1,byte position2){

        super(x,y,false,false,false,false,false);
        setPosition(position1,position2);

        if((isDownEdge() && isUpEdge()) || (isLeftEdge() && isRightEdge()))  {
            System.out.println("curved dedik düz oldu");
        }
    }


}
