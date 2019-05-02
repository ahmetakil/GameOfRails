import game.Tile;
import javafx.application.Application;
import javafx.stage.Stage;
import util.fileUtil;


public class Main extends Application {


    public static void main(String[] args) {

        launch(args);

    }

    @Override
    public void start(Stage primaryStage) {

        Tile[][] grid = fileUtil.createGrid(1);

        Gui gui = new Gui(grid);
        primaryStage.setResizable(false);
        gui.showGrid(primaryStage);

    }
}
/**
TODO:
   +Swapping tiles
   +Path Logic Check
   - Animation
   + Images
   + Check if replacing dirt with water
 actually make sense or not.


 extra things
    - Play music at the background which is can be closed by user.
    - Key generator for let the user continue to game.
    - Themes can be added from user.
    - Program can only resize while it protects it shape.
    - Congratulaitons at the end.


 */