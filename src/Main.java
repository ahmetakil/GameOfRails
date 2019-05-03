import game.Tile;
import javafx.application.Application;
import javafx.stage.Stage;
import util.fileUtil;


public class Main extends Application {

    public static int LEVEL = 3;

    public static void main(String[] args) {

        launch(args);

    }

    @Override
    public void start(Stage primaryStage) {

        Tile[][] grid = fileUtil.createGrid(LEVEL);

        Gui gui = new Gui(grid);
        primaryStage.setResizable(false);
        gui.showGrid(primaryStage);

    }
}

/**
 extra things
    - Play music at the background which is can be closed by user.
    - Key generator for let the user continue to game.
    - Themes can be added from user.
    - Congratulaitons at the end.


 */