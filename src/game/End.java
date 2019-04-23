package game;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;

public class End extends Pipe {



    public End(int x, int y, boolean upEdge, boolean downEdge, boolean leftEdge, boolean rightEdge) {

        super(x, y, false, upEdge, downEdge, leftEdge, rightEdge);
        /*
        We need to call setFill() here again because the constructor takes place before we assign up,down,right,left values
        because of that it it doesn't work the first time (same as static).
         */
        setFill();
    }

    public End(int x, int y, byte position) {

        super(x, y, false, false, false, false, false);
        setPosition(position, (byte) -1);
    }

    @Override
    public void setFill() {
        if(this.isLeftEdge()) {
            this.setFill(new ImagePattern(new Image("img/endHorizontal.jpeg")));
        }else{
            this.setFill(new ImagePattern(new Image("img/endVertical.jpeg")));
        }
    }
}
