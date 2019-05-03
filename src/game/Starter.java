package game;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

public class Starter extends Pipe {

    public Starter(int x, int y, boolean upEdge, boolean downEdge, boolean leftEdge, boolean rightEdge) {

        super(x, y, upEdge, downEdge, leftEdge, rightEdge);
        setFill();

    }

    @Override
    public void setFill(){
        if(isHorizontal()) {
            this.setFill(new ImagePattern(new Image("img/starterHorizontal.png")));
        }else{
            this.setFill(new ImagePattern(new Image("img/starterVertical.png")));
        }
    }

    @Override
    public boolean isHorizontal() {
        return isLeftEdge();
    }

    @Override
    public String toString(){
        return String.format("Starter pipe at %d %d ",getxGrid(),getyGrid());
    }
}
