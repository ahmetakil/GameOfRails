import game.EmptyTile;
import game.Tile;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Random;

public class Gui {


    private Tile[][] tiles;
    private GridPane pane;
    private final int SIZE = 430;
    private Scene scene;


    public Gui(Tile[][] tiles) {

        this.tiles = tiles;
        pane = new GridPane();
        for (int row = 0; row < tiles.length; row++) {
            for (int col = 0; col < tiles[row].length; col++) {


                pane.add(tiles[row][col], row, col);


            }


        }


    }


    public void showGrid(){

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(5,5,5,5));
        gridPane.setHgap(5);
        gridPane.setVgap(5);

        Random random = new Random();
        scene = new Scene(gridPane, SIZE, SIZE);

        for(int row=0;row<tiles.length;row++){
            for(int col=0;col<tiles[row].length;col++){

                EmptyTile tile = new EmptyTile(row,col);

                tile.setStroke(Color.BLACK);
               tile.setFill(Color.rgb(random.nextInt(255),random.nextInt(255) ,random.nextInt(255) ));

                gridPane.add(tile,row,col ); // CHECKED THIS IS CORRECT.
                tile.setOnMouseClicked(e -> {

                    EmptyTile node = (EmptyTile) e.getPickResult().getIntersectedNode();
                    System.out.println(node.getxGrid()+" , " + node.getyGrid());

                });
                tile.widthProperty().bind(scene.widthProperty().divide(4).subtract(7));
                tile.heightProperty().bind(scene.heightProperty().divide(4).subtract(7));

            }
        }

    }



    public Scene getScene(){
        return scene;
    }
}
