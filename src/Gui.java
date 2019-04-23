import game.Tile;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Gui {

    private Tile[][] tiles;
    private GridPane pane;
    private static final int SIZE = 430;
    private Scene scene;


    public Gui(Tile[][] tiles) { // Constructor of GUI

        this.tiles = tiles; // Get the files from argument which gives the input read from file
        pane = new GridPane();
        for (int row = 0; row < tiles.length; row++) {
            for (int col = 0; col < tiles[row].length; col++) {

                pane.add(tiles[row][col],col ,row ); // iterate through the matrix add all the tiles to the pane
            }

        }


    }


    public void showGrid(Stage stage){


        pane.setPadding(new Insets(3,3,3,3));
        pane.setHgap(3);
        pane.setVgap(3);

        scene = new Scene(pane, SIZE, SIZE); // Creating scene with pane


        for(int row=0;row<tiles.length;row++){
            for(int col=0;col<tiles[row].length;col++){

                Tile tile = tiles[row][col];

                tile.setOnMouseClicked(e -> { // Event handler

                    Tile t = (Tile) e.getPickResult().getIntersectedNode();
                    System.out.println(t.getxGrid()+" , " + t.getyGrid()+" ,"+t.getClass().getName());

                });

                // Bind the tiles to the screen to make the page responsive
                tile.widthProperty().bind(scene.widthProperty().divide(4).subtract(7));
                tile.heightProperty().bind(scene.heightProperty().divide(4).subtract(7));

            }
        }

        stage.setScene(scene);
        stage.show();

    }



    public Scene getScene(){
        return scene;
    }
}
