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

        Tile[][] grid = fileUtil.createGrid(2);

        Gui gui = new Gui(grid);
        gui.showGrid(primaryStage);


    }
}