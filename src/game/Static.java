package game;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

public class Static extends Pipe {

    public Static(int x, int y, boolean upEdge, boolean downEdge, boolean leftEdge, boolean rightEdge) {

        super(x, y, false, upEdge, downEdge, leftEdge, rightEdge);
        setFill();
    }


    @Override
    public void setFill(){
        if(isHorizontal()) {
            this.setFill(new ImagePattern(new Image("img/staticHorizontal.jpeg")));
        }else{
            this.setFill(new ImagePattern(new Image("img/staticVertical.jpeg")));
        }
    }

    @Override
    public String toString(){
        return String.format("Static pipe at %d %d ",getxGrid(),getyGrid());
    }
}
