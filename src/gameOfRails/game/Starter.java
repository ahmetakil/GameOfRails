package gameOfRails.game;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

import java.io.File;

public class Starter extends Pipe {

    public Starter(int x, int y, boolean upEdge, boolean downEdge, boolean leftEdge, boolean rightEdge) {

        super(x, y,false,upEdge, downEdge, leftEdge, rightEdge);
        setFill();

    }

    @Override
    public void setFill(){
        if(isHorizontal()) {
            this.setFill(new ImagePattern(new Image(new File("img/starterHorizontal.png").toURI().toString())));
        }else{
            this.setFill(new ImagePattern(new Image(new File("img/starterVertical.png").toURI().toString())));
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
