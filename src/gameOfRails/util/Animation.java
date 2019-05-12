package gameOfRails.util;

import gameOfRails.game.Starter;
import javafx.animation.PathTransition;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.PathElement;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.io.File;
import java.util.ArrayList;

public class Animation {

    private static PathTransition pathTransition;
    private static ArrayList<PathElement> paths;

    public static void playAnimation(Pane pane, ArrayList<PathElement> paths) {

        Animation.paths = paths;
        Rectangle rect = new Rectangle(80, 80);
        rect.setFill(new ImagePattern(new Image(new File("img/cart.png").toURI().toString())));

        double starterX = 0; // Grid x-y position of starterTile
        double starterY = 0;

        /*Find the starter tile from pane to
        find the animation start location.
         */
        for(Node node:pane.getChildren()) {

            if (node instanceof Starter) {
                starterX = node.getLayoutX();
                starterY = node.getLayoutY();

            }
        }
        rect.setStroke(Color.BLACK);

        paths.add(0, new MoveTo(starterX+gameUtil.offset, starterY+gameUtil.offset));
        pane.getChildren().add(rect);

        pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.seconds(2));
        pathTransition.setCycleCount(1);

        pathTransition.setNode(rect);

        pathTransition.setPath(new Path(paths));

        pathTransition.play();

    }


    public static PathTransition getPathTransition() {
        return pathTransition;
    }

    public static ArrayList<PathElement> getPaths() {
        return paths;
    }
}