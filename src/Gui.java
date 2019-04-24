import game.Tile;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import util.gameUtil;

import java.util.ArrayList;

public class Gui {

    private Tile[][] tiles;
    private GridPane pane;
    private static final int SIZE = 400;
    private Scene scene;
    private ArrayList<Tile> swapArray;

    public Gui(Tile[][] tiles) { // Constructor of GUI

        this.tiles = tiles; // Get the files from argument which gives the input read from file
        pane = new GridPane();
        for (int row = 0; row < tiles.length; row++) {
            for (int col = 0; col < tiles[row].length; col++) {

                pane.add(tiles[row][col], col, row); // iterate through the matrix add all the tiles to the pane
            }
        }
        swapArray = new ArrayList<>();
    }


    public void showGrid(Stage stage) {

       pane.setAlignment(Pos.CENTER);

        scene = new Scene(pane, SIZE, SIZE); // Creating scene with pane
        scene.setFill(Color.rgb(135,135 ,140 ));
        for (int row = 0; row < tiles.length; row++) {
            for (int col = 0; col < tiles[row].length; col++) {

                Tile tile = tiles[row][col];

                // Bind the tiles to the screen to make the page responsive
                tile.widthProperty().bind(scene.widthProperty().divide(4).subtract(7));
                tile.heightProperty().bind(scene.heightProperty().divide(4).subtract(7));

                // PRESS EVENT
                tile.setOnMousePressed(e->{
                    swapArray.clear();
                    Tile swap1 = (Tile) e.getPickResult().getIntersectedNode();
                    System.out.println(swap1.getxGrid()+" , "+swap1.getyGrid());
                    swapArray.add(swap1);

                });

                // RELEASE EVENT
                tile.setOnMouseReleased(e->{
                    if(!(e.getPickResult().getIntersectedNode() instanceof Tile)){
                        return;
                    }
                    Tile swap2 = (Tile) e.getPickResult().getIntersectedNode();
                    if(!swapArray.contains(swap2)){
                        swapArray.add(swap2);
                        swapTiles(swapArray.get(0),swapArray.get(1));


                    }
                });
            }
        }

        stage.setScene(scene);
        stage.show();

    }

    private boolean swapTiles(Tile tile1, Tile tile2) {


        int xGrid1 = tile1.getxGrid();
        int yGrid1 = tile1.getyGrid();

        int xGrid2 = tile2.getxGrid();
        int yGrid2 = tile2.getyGrid();

        if((Math.abs(xGrid1-xGrid2) + Math.abs(yGrid1-yGrid2) != 1) || !gameUtil.isSwappableTiles(tile1,tile2)){
            return false;
        }

        pane.getChildren().remove(tile1);
        pane.getChildren().remove(tile2);

        pane.add(tile1,xGrid2,yGrid2);
        pane.add(tile2,xGrid1,yGrid1);

        tiles[xGrid1][yGrid1] = tile2;
        tiles[xGrid2][yGrid2] = tile1;
        tile1.setxGrid(xGrid2);
        tile2.setxGrid(xGrid1);

        tile1.setyGrid(yGrid2);
        tile2.setyGrid(yGrid1);
        swapArray.clear();
        return true;
    }

}
