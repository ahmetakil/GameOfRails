package game;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

public class CurvedStatic extends Curved {

    public CurvedStatic(int x, int y, int position1, int position2) {
        super(x, y, position1, position2);
        setPosition(position1, position2);
        setFill();
    }

    @Override
    public void setFill(){
        if(isUpEdge() && isRightEdge()) {
            this.setFill(new ImagePattern(new Image("img/URcurvedStatic.png")));
        }else if(isUpEdge() && isLeftEdge()){
            this.setFill(new ImagePattern(new Image("img/ULcurvedStatic.png")));
        }else if(isDownEdge() && isLeftEdge()){
            this.setFill(new ImagePattern(new Image("img/DLcurvedStatic.png")));
        }else if(isDownEdge() && isRightEdge()){
            this.setFill(new ImagePattern(new Image("img/DRcurvedStatic.png")));
        }
    }
}
