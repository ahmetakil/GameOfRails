package gameOfRails.gui;

import gameOfRails.Main;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.io.File;

public class FinalGui {

    private Scene finalScene;
    private Pane finalPane;

    public FinalGui(){


        finalPane = new Pane();
        finalPane.setStyle("-fx-background-color:#f84cff");

        finalScene = new Scene(finalPane,640,440);
        finalPane.setMaxHeight(440);
        finalPane.setMaxWidth(640);

        Image backScreen = new Image(new File("img/train.gif").toURI().toString());
        ImageView imageView = new ImageView(backScreen);
        imageView.setFitHeight(440);
        imageView.setFitWidth(640);
        finalPane.getChildren().addAll(imageView);

        BorderPane borderPane = new BorderPane();

        Image gameName = new Image(new File("img/gameName.png").toURI().toString());
        ImageView gameNameImage = new ImageView(gameName);
        gameNameImage.setX(finalPane.getMaxWidth()/2- 301);
        gameNameImage.setY(finalPane.getMaxHeight()/2 -33);
        gameNameImage.setFitWidth(602);
        gameNameImage.setFitHeight(66);
        finalPane.getChildren().addAll(gameNameImage);

        Button button = new Button("CONGRATULATIONS "+EntryGui.NAME);

        // Creating borderPane to put our text and button on login screen
        borderPane.setMinSize(640, 440);
        borderPane.setBottom(button);

        //Using static borderPane methods to adjust the settings.
        BorderPane.setAlignment(button, Pos.CENTER);
        BorderPane.setMargin(button, new Insets(5,5,50,5));

        finalPane.getChildren().addAll(borderPane);

        Main.getStage().setScene(finalScene);
        Main.getStage().show();


    }

}