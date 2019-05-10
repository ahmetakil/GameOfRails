package gameOfRails.gui;

import gameOfRails.Main;
import gameOfRails.game.Tile;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.io.File;

public class EntryGui {

    private Scene entryScene;
    private Pane entryPane;


    public EntryGui(Tile[][] tiles){


        entryPane = new Pane();
        entryPane.setStyle("-fx-background-color:#f84cff");

        entryScene = new Scene(entryPane,640,440);
        entryPane.setMaxHeight(440);
        entryPane.setMaxWidth(640);

        Image backScreen = new Image(new File("img/train.gif").toURI().toString());
        ImageView imageView = new ImageView(backScreen);
        imageView.setFitHeight(440);
        imageView.setFitWidth(640);
        entryPane.getChildren().addAll(imageView);

        BorderPane borderPane = new BorderPane();

        Image gameName = new Image(new File("img/gameName.png").toURI().toString());
        ImageView gameNameImage = new ImageView(gameName);
        gameNameImage.setX(entryPane.getMaxWidth()/2- 301);
        gameNameImage.setY(entryPane.getMaxHeight()/2 -33);
        gameNameImage.setFitWidth(602);
        gameNameImage.setFitHeight(66);
        entryPane.getChildren().addAll(gameNameImage);

        Button button = new Button("PLAY");

        // Creating borderPane to put our text and button on login screen
        borderPane.setMinSize(640, 440);
        borderPane.setBottom(button);

        //Using static borderPane methods to adjust the settings.
        BorderPane.setAlignment(button, Pos.CENTER);
        BorderPane.setMargin(button, new Insets(5,5,50,5));


        Label nameTextField = new Label("Name:");
        nameTextField.setTextFill(Color.web("ecff82"));
        TextField textField = new TextField ();
        HBox nameArea = new HBox();
        nameArea.setSpacing(10);
        nameArea.getChildren().addAll(nameTextField,textField);
        nameArea.setLayoutX(entryPane.getMaxHeight()/2);
        nameArea.setLayoutY(entryPane.getMaxWidth()/2);

        entryPane.getChildren().addAll(borderPane,nameArea);
        button.setOnMousePressed(e->{
            Gui gui = new Gui(tiles);
            gui.showGui(Main.getStage());
    });

        Main.getStage().setScene(entryScene);
        Main.getStage().show();


    }

}
