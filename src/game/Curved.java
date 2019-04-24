package game;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

public class Curved extends Pipe {

    public Curved(int x, int y, int position1, int position2) {

        super(x, y, false, false, false, false, false);
        setPosition(position1, position2);
        setFill();
    }

    // Converts input text from file to 4 variable boolean logic.
    public void setPosition(int position1, int position2) {

        if(position1 == 0){
            setUpEdge(true);
        }else if(position1 == 1){
            setDownEdge(true);
        }else{
            System.out.println("Something went wrong... at Curved setPosition");

        }


        if(position2 == 0){

            setLeftEdge(true);
        }else if(position2 == 1){
            setRightEdge(true);
        }else{
            System.out.println("Something went wrong... at Curved setPosition 2");

        }

    }

    @Override
    public void setFill(){
        if(isUpEdge() && isRightEdge()) {
            this.setFill(new ImagePattern(new Image("img/URCurved.png")));
        }else if(isUpEdge() && isLeftEdge()){
            this.setFill(new ImagePattern(new Image("img/ULCurved.png")));
        }else if(isDownEdge() && isLeftEdge()){
            this.setFill(new ImagePattern(new Image("img/DLCurved.png")));
        }else if(isDownEdge() && isRightEdge()){
            this.setFill(new ImagePattern(new Image("img/DRCurved.png")));
        }
    }

}
