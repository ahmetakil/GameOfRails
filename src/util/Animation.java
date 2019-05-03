package util;

import javafx.animation.PathTransition;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.PathElement;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.util.ArrayList;

public class Animation {

    private static PathTransition pathTransition;

    public static void playAnimation(Pane pane, ArrayList<PathElement> paths) {


        Rectangle rect = new Rectangle(80, 80);
        rect.setFill(new ImagePattern(new Image("img/cart.jpeg")));
        rect.setLayoutX(10);
        rect.setLayoutY(10);
        rect.setStroke(Color.BLACK);

        paths.add(0, new MoveTo(gameUtil.offset, gameUtil.offset));
        pane.getChildren().add(rect);

        pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.seconds(1));
        pathTransition.setCycleCount(1);

        pathTransition.setNode(rect);

        pathTransition.setPath(new Path(paths));
        pathTransition.play();

    }


    public static PathTransition getPathTransition() {
        return pathTransition;
    }
}