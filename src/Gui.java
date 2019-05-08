import game.Tile;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import util.*;

import java.util.ArrayList;

public class Gui {


    private Scene scene;
    private Tile[][] tiles;
    private Pane rootPane;
    private Pane gamePane;
    private Pane sidePane;
    private static int GAME_SIZE = gameUtil.GAME_SIZE;

    private ArrayList<Tile> swapArray;

    double tilePrevX = 0; // X location of tile before dragging.
    double tilePrevY = 0; // Y location of tile before dragging

    public Gui(Tile[][] tiles) {

        this.tiles = tiles;

        rootPane = new Pane();
        rootPane.setStyle("-fx-background-color:red");

        scene = new Scene(rootPane, 640, 440); // Creating scene with panes

        gamePane = new Pane();
        gamePane.setMaxWidth(GAME_SIZE);
        gamePane.setMaxHeight(GAME_SIZE);

        gamePane.setLayoutX(20);
        gamePane.setLayoutY(20);

        sidePane = new Pane();
        sidePane.setMaxWidth(GAME_SIZE/2);
        sidePane.setMaxHeight(GAME_SIZE);

        sidePane.setLayoutX(20 + GAME_SIZE + 20);
        sidePane.setLayoutY(20);

        rootPane.getChildren().addAll(gamePane,sidePane);


        for (int row = 0; row < tiles.length; row++) {
            for (int col = 0; col < tiles[row].length; col++) {

                Tile tile = tiles[row][col];
                tile.setLayoutX(row * 100);
                gamePane.setStyle("-fx-background-image: url(\"img/empty.jpeg\"); ");
                tile.setLayoutY(col * 100);
                gamePane.getChildren().add(tile); // iterate through the matrix add all the tiles to the pane

            }
        }

        swapArray = new ArrayList<>();
    }


    public void showGui(Stage stage) {

        showGame();
        stage.setScene(scene);
        stage.show();


    }

    public void showGame() {

        for (int row = 0; row < tiles.length; row++) {
            for (int col = 0; col < tiles[row].length; col++) {

                Tile tile = tiles[col][row];

                tile.setOnMousePressed(e -> {
                    if (gameUtil.isSwappableTile(tile)) {
                     /* Removing then putting the tile back on top to give it top priority
                    otherwise it will go below other tiles.  */
                        gamePane.getChildren().remove(tile);
                        gamePane.getChildren().add(tile);
                        tilePrevX = tile.getLayoutX();
                        tilePrevY = tile.getLayoutY();
                        swapArray.clear();
                        swapArray.add(tile);
                    }
                    else {
                        //Error music can come
                        System.out.println("Unmovable Tile");
                    }
                });

                tile.setOnMouseDragged(e -> {
                    if (gameUtil.isSwappableTile(tile)) {
                        tile.setLayoutX(e.getSceneX() - tile.getWidth() / 2 - 10);
                        tile.setLayoutY(e.getSceneY() - tile.getHeight() / 2 - 10);

                    }
                });

                tile.setOnMouseReleased(e -> {

                            if (gameUtil.isSwappableTile(tile)) {
                                Tile swap2 = gameUtil.getTileFromMouse(tiles, e.getSceneX(), e.getSceneY());

                                if (!gameUtil.isSwappableTiles(swapArray.get(0), swap2)) {

                                    tile.setLayoutX(tilePrevX);
                                    tile.setLayoutY(tilePrevY);
                                    return;
                                }

                                swapArray.add(swap2);
                                swapTiles(swapArray.get(0), swapArray.get(1));
                                if (gameUtil.isPathConstructed(tiles)) {

                                    Animation.playAnimation(gamePane, gameUtil.getPaths());
                                    if (Main.LEVEL == 5) {
                                        System.out.println("CONGRATS YOU WIN !");
                                    } else {
                                        Tile[][] nextLevel = fileUtil.createGrid(++Main.LEVEL);
                                        Gui nextGui = new Gui(nextLevel);
                                        Animation.getPathTransition().setOnFinished(event -> {
                                            nextGui.showGui(Main.getStage());
                                        });
                                    }
                                }
                            }
                        }

                );
            }
        }
    }

    private void swapTiles(Tile tile1, Tile tile2) {

        /**These Grid assignments are for out arbitrary grid positions
         * layout positions are for replacing them in the pane
         * */
        int xGrid1 = tile1.getxGrid();
        int yGrid1 = tile1.getyGrid();

        int xGrid2 = tile2.getxGrid();
        int yGrid2 = tile2.getyGrid();


        double xLayout2 = tile2.getLayoutX();
        double yLayout2 = tile2.getLayoutY();

        gamePane.getChildren().remove(tile1);
        gamePane.getChildren().remove(tile2);

        // SCENE POSITION ASSIGNMENT
        tile1.setLayoutX(xLayout2);
        tile1.setLayoutY(yLayout2);

        tile2.setLayoutX(tilePrevX);
        tile2.setLayoutY(tilePrevY);

        gamePane.getChildren().add(tile1);
        gamePane.getChildren().add(tile2);

        // GRID POSITION ASSIGNMENT
        tile1.setxGrid(xGrid2);
        tile1.setyGrid(yGrid2);

        tile2.setxGrid(xGrid1);
        tile2.setyGrid(yGrid1);


        tiles[xGrid1][yGrid1] = tile2;
        tiles[xGrid2][yGrid2] = tile1;

        swapArray.clear();
    }

}
