import game.Tile;
import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.stage.Stage;
import util.fileUtil;

public class Main extends Application {

    public static IntegerProperty NUMBER_OF_MOVES = new SimpleIntegerProperty(0);
    public static int LEVEL = 1;
    private static Stage primaryStage;

    public static void main(String[] args) {

        launch(args);

    }

    @Override
    public void start(Stage primaryStage) {

        this.primaryStage = primaryStage;

        Tile[][] grid = fileUtil.createGrid(LEVEL);

        Gui gui = new Gui(grid);
        primaryStage.setResizable(false);
        gui.showGui(primaryStage);

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