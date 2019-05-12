package gameOfRails.gui;

import gameOfRails.Main;
import gameOfRails.util.audioUtil;
import gameOfRails.util.statUtil;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.io.File;

public class FinalGui {

    private Scene finalScene;
    private Pane finalPane;

    public FinalGui(){
        audioUtil.stop();

        finalPane = new Pane();
        finalPane.setStyle("-fx-background-color:#f84cff");

        finalScene = new Scene(finalPane,640,440);
        finalPane.setMaxHeight(440);
        finalPane.setMaxWidth(640);

        Image backScreen = new Image(new File("img/outro.gif").toURI().toString());
        ImageView imageView = new ImageView(backScreen);
        imageView.setFitHeight(440);
        imageView.setFitWidth(640);
        audioUtil.playInLoop(audioUtil.getEntryMusic());
        finalPane.getChildren().addAll(imageView);

        BorderPane borderPane = new BorderPane();

        Text stats = new Text(statUtil.stats());
        stats.setFill(Color.web("ecff82"));
        System.out.println(statUtil.stats());




        Image gameName = new Image(new File("img/congratulations.png").toURI().toString());
        ImageView gameNameImage = new ImageView(gameName);
        gameNameImage.setX(finalPane.getMaxWidth()/2- 301);
        gameNameImage.setY(finalPane.getMaxHeight()/2 -33);
        gameNameImage.setFitWidth(602);
        gameNameImage.setFitHeight(53);
        finalPane.getChildren().addAll(gameNameImage);


        Button restartButton = new Button("PLAY AGAIN");
        Button exitButton = new Button("EXIT THE GAME " + EntryGui.NAME);

        // Creating borderPane to put our text and button on login screen
        borderPane.setMinSize(640, 440);
        borderPane.setBottom(exitButton);
        borderPane.setCenter(restartButton);

        restartButton.setOnMousePressed(e ->{
            Main.LEVEL = 1;
            audioUtil.stop();
            Main.getStage().setScene(GameGui.getGameScene());
        });

        exitButton.setOnMousePressed(e->{
            audioUtil.stop();
            Main.getStage().close();
        });

            //Using static borderPane methods to adjust the settings.
        BorderPane.setAlignment(exitButton, Pos.CENTER);
        BorderPane.setMargin(exitButton, new Insets(5,5,50,5));

        finalPane.getChildren().addAll(borderPane);
        finalPane.getChildren().addAll(stats);
        Main.getStage().setScene(finalScene);
        Main.getStage().show();


    }

}
