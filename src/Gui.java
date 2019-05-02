import game.Tile;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import util.gameUtil;

import java.util.ArrayList;

public class Gui {

    private Tile[][] tiles;
    private Pane pane;
    static int SIZE = gameUtil.SIZE;
    private Scene scene;
    private ArrayList<Tile> swapArray;
    double tilePrevX = 0; // X location of tile before dragging.
    double tilePrevY = 0; // Y location of tile before dragging

    public Gui(Tile[][] tiles) {

        this.tiles = tiles;
        pane = new Pane();
        for (int row = 0; row < tiles.length; row++) {
            for (int col = 0; col < tiles[row].length; col++) {

                Tile tile = tiles[row][col];
                tile.setLayoutX(row * 100);
                pane.setStyle("-fx-background-image: url(\"img/empty.jpeg\"); ");
                tile.setLayoutY(col * 100);
                pane.getChildren().add(tile); // iterate through the matrix add all the tiles to the pane

            }
        }
        swapArray = new ArrayList<>();
    }


    public void showGrid(Stage stage) {

        scene = new Scene(pane, SIZE, SIZE); // Creating scene with pane
        scene.setFill(Color.rgb(135, 135, 140));
        //pane.setStyle("-fx-background-image: url(\"img/emptyFree.jpeg\");");

        for (int row = 0; row < tiles.length; row++) {
            for (int col = 0; col < tiles[row].length; col++) {


                Tile tile = tiles[col][row];

                tile.setOnMousePressed(e -> {

                     /* Removing then putting the tile back on top to give it top priority
                    otherwise it will go below other tiles.  */
                    pane.getChildren().remove(tile);
                    pane.getChildren().add(tile);
                    tilePrevX = tile.getLayoutX();
                    tilePrevY = tile.getLayoutY();
                    swapArray.clear();
                    swapArray.add(tile);

                });


                tile.setOnMouseDragged(e -> {
                    tile.setLayoutX(e.getSceneX() - tile.getWidth() / 2);
                    tile.setLayoutY(e.getSceneY() - tile.getHeight() / 2);

                });

                tile.setOnMouseReleased(e -> {
                    Tile swap2 = gameUtil.getTileFromMouse(tiles, e.getSceneX(), e.getSceneY());

                    if (!gameUtil.isSwappableTiles(swapArray.get(0), swap2)) {

                        tile.setLayoutX(tilePrevX);
                        tile.setLayoutY(tilePrevY);
                        return;
                    }
                    swapArray.add(swap2);
                    swapTiles(swapArray.get(0), swapArray.get(1));
                    if (gameUtil.isPathConstructed(tiles)) {
                        System.out.println("gg");
                    }

                });

            }
        }

        stage.setScene(scene);
        stage.show();

    }

    private boolean swapTiles(Tile tile1, Tile tile2) {

        /**These Grid assignments are for out arbitrary grid positions
         * layout positions are for replacing them in the pane
         * */
        int xGrid1 = tile1.getxGrid();
        int yGrid1 = tile1.getyGrid();

        int xGrid2 = tile2.getxGrid();
        int yGrid2 = tile2.getyGrid();


        double xLayout2 = tile2.getLayoutX();
        double yLayout2 = tile2.getLayoutY();

        pane.getChildren().remove(tile1);
        pane.getChildren().remove(tile2);

        // SCENE POSITION ASSIGNMENT
        tile1.setLayoutX(xLayout2);
        tile1.setLayoutY(yLayout2);

        tile2.setLayoutX(tilePrevX);
        tile2.setLayoutY(tilePrevY);

        pane.getChildren().add(tile1);
        pane.getChildren().add(tile2);

        // GRID POSITION ASSIGNMENT
        tile1.setxGrid(xGrid2);
        tile1.setyGrid(yGrid2);

        tile2.setxGrid(xGrid1);
        tile2.setyGrid(yGrid1);


        tiles[xGrid1][yGrid1] = tile2;
        tiles[xGrid2][yGrid2] = tile1;

        swapArray.clear();
        return true;
    }

}
