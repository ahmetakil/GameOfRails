package gameOfRails.gui;

import gameOfRails.Main;
import gameOfRails.util.Animation;
import gameOfRails.util.audioUtil;
import gameOfRails.util.fileUtil;
import gameOfRails.util.statUtil;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.io.File;



class FinalGui {


    FinalGui() {


        audioUtil.stopAll();

        Pane finalPane = new Pane();
        finalPane.setStyle("-fx-background-color:#f84cff");

        Scene finalScene = new Scene(finalPane, 640, 440);
        finalPane.setMaxHeight(440);
        finalPane.setMaxWidth(640);

        //Creating and setting backscreen image
        Image backScreen = new Image(new File("img/outro.gif").toURI().toString());
        ImageView imageView = new ImageView(backScreen);
        imageView.setFitHeight(440);
        imageView.setFitWidth(640);
        audioUtil.playEntry();
        finalPane.getChildren().addAll(imageView);

        //Creating and setting stats
        Text stats = new Text(statUtil.stats());
        stats.setFill(Color.web("ecff82"));
        stats.setX(140);
        stats.setY(finalPane.getMaxHeight() / 2 - 40);
        stats.setFont(Font.font("Helvetica", FontWeight.BOLD, 15));


        Image gameName = new Image(new File("img/congratulations.png").toURI().toString());
        ImageView gameNameImage = new ImageView(gameName);
        gameNameImage.setX(finalPane.getMaxWidth() / 2 - 301);
        gameNameImage.setY(finalPane.getMaxHeight() / 2 - 153);
        gameNameImage.setFitWidth(602);
        gameNameImage.setFitHeight(53);
        finalPane.getChildren().addAll(gameNameImage);


        Button restartButton = new Button("PLAY AGAIN");
        Button exitButton = new Button("EXIT THE GAME ");

        restartButton.setPrefHeight(25);
        restartButton.setPrefWidth(160);

        exitButton.setPrefHeight(25);
        exitButton.setPrefWidth(160);

        HBox hbox = new HBox(restartButton, exitButton);
        hbox.setSpacing(5);
        hbox.setLayoutX(finalPane.getMaxWidth() / 2 - 180);
        hbox.setLayoutY(finalPane.getMaxHeight() - 40);


        restartButton.setOnMousePressed(e -> {
            Main.LEVEL = 1;
            Main.NUMBER_OF_MOVES.setValue(0);
            Animation.getPaths().clear();
            audioUtil.stopAll();
            new EntryGui(fileUtil.createGrid(1));
        });

        exitButton.setOnMousePressed(e -> {
            audioUtil.stopAll();
            Main.getStage().close();
        });

        finalPane.getChildren().addAll(stats, hbox);

        Main.getStage().setScene(finalScene);
        Main.getStage().show();


    }

}
