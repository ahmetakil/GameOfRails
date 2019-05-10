package gameOfRails;

import gameOfRails.game.Tile;
import gameOfRails.gui.EntryGui;
import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import gameOfRails.util.fileUtil;

import java.io.File;

public class Main extends Application {

    public static IntegerProperty NUMBER_OF_MOVES = new SimpleIntegerProperty(0);
    public static final int MAX_LEVEL = fileUtil.getMaxLevel();
    public static int LEVEL = 6;
    private static Stage primaryStage;

    public static void main(String[] args) {

       launch(args);


    }

    @Override
    public void start(Stage primaryStage) {

        this.primaryStage = primaryStage;

        Tile[][] grid = fileUtil.createGrid(LEVEL);

        EntryGui entry  = new EntryGui(grid);
        primaryStage.setResizable(false);

    }


    public static Stage getStage(){
        return primaryStage;
    }
}

/*
 TODO:
    - Play music at the background which is can be closed by user.
    - Key generator for let the user continue to game.
    - Themes can be added from user.
    - Better background image
    - Congratulations at the end.
 */