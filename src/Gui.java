import game.Tile;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import util.*;

import java.util.ArrayList;

public class Gui {


    private Scene gameScene,entryScene,finalScene;
    private Tile[][] tiles;
    private Pane rootPane;
    private Pane gamePane;
    private Pane sidePane;
    private Pane entryPane;
    private static int GAME_SIZE = gameUtil.GAME_SIZE;

    private ArrayList<Tile> swapArray;

    private double tilePrevX = 0; // X location of tile before dragging used for swapping tiles.
    private double tilePrevY = 0; // Y location of tile before dragging used for swapping tiles.

    public Gui(Tile[][] tiles) {


        this.tiles = tiles;

        entryPane = new Pane();
        entryPane.setStyle("-fx-background-color:#f84cff");

        // rootPane is our global pane that holds gamePane and sidePane
        rootPane = new Pane();
        rootPane.setStyle("-fx-background-color:#000000");

        entryScene = new Scene(entryPane,640,440);
        gameScene = new Scene(rootPane, 640, 440); // Creating gameScene with panes

        // gamePane is  playable pane that holds the grid.
        gamePane = new Pane();
        gamePane.setMaxWidth(GAME_SIZE);
        gamePane.setMaxHeight(GAME_SIZE);
        gamePane.setLayoutX(10);
        gamePane.setLayoutY(20);

        // sidePane is the information pane that holds level , number of moves and all of those.
        sidePane = new Pane();
        sidePane.setMaxWidth(GAME_SIZE / 2);
        sidePane.setMaxHeight(GAME_SIZE);

        sidePane.setLayoutX(20 + GAME_SIZE);
        sidePane.setLayoutY(20);

        rootPane.getChildren().addAll(sidePane, gamePane);


        for (int row = 0; row < tiles.length; row++) {
            for (int col = 0; col < tiles[row].length; col++) {

                Tile tile = tiles[row][col];
                tile.setLayoutX(row * 100);
                gamePane.setStyle("-fx-background-image: url(img/empty.jpeg)");
                tile.setLayoutY(col * 100);
                gamePane.getChildren().add(tile); // iterate through the matrix add all the tiles to the pane
            }
        }

        swapArray = new ArrayList<>();
    }


    public void showGui(Stage stage) {
        showGame();
        showSidePane();
        showEntryPane();
        stage.setScene(entryScene);
        stage.show();
    }

    public void showEntryPane(){
        entryPane.setMaxHeight(440);
        entryPane.setMaxWidth(640);
        Text text = new Text(entryPane.getMaxHeight()/2,entryPane.getMaxWidth()/2,"Game Of Rails");
        text.setFont(new Font(50));
        text.setTextAlignment(TextAlignment.CENTER);
        entryPane.getChildren().addAll(text);
        Button button = new Button("ok");
    }

    public void showSidePane() {

        sidePane.setStyle("-fx-background-image: url(img/empty.jpeg)");

        Text level = new Text(sidePane.getMaxWidth() / 2 - 50, sidePane.getMaxHeight() / 4 - 50, "LEVEL");
        level.setFont(new Font(30));
        level.setTextAlignment(TextAlignment.CENTER);
        level.setFill(Color.valueOf("ecff82"));

        // Current Level
        Text currentLevel = new Text(sidePane.getMaxWidth() / 2 - 25, sidePane.getMaxHeight() / 4, Main.LEVEL + "");
        currentLevel.setFont(new Font(50));
        currentLevel.setTextAlignment(TextAlignment.CENTER);
        currentLevel.setFill(Color.valueOf("ecff82"));

        // Number Of Moves
        Text numberOfMoves = new Text(sidePane.getMaxWidth() / 2 - 50, sidePane.getMaxHeight() / 4 - 50, "MOVES");
        numberOfMoves.setFont(new Font(30));
        numberOfMoves.setTextAlignment(TextAlignment.CENTER);
        numberOfMoves.setFill(Color.valueOf("ecff82"));

        // Current Number of Level
        Text currentNumberMoves = new Text(sidePane.getMaxWidth() / 2 - 25, sidePane.getMaxHeight() / 4, Main.NUMBER_OF_MOVES + "");
        currentNumberMoves.setFont(new Font(50));
        currentNumberMoves.setTextAlignment(TextAlignment.CENTER);
        currentNumberMoves.textProperty().bind(Main.NUMBER_OF_MOVES.asString());
        currentNumberMoves.setFill(Color.valueOf("ecff82"));


        // VBox declaration to use in sidePane.
        VBox vbox = new VBox();
        vbox.setPrefWidth(200);
        vbox.setPrefHeight(400);
        vbox.alignmentProperty().set(Pos.CENTER);
        vbox.getChildren().addAll(level, currentLevel, numberOfMoves, currentNumberMoves);

        sidePane.getChildren().add(vbox);

        sidePane.getChildren().addAll(currentLevel, level);
    }

    public void showGame() {

        // Iterate through all the tiles and set their event handlers.
        for (int row = 0; row < tiles.length; row++) {
            for (int col = 0; col < tiles[row].length; col++) {

                Tile tile = tiles[col][row];

                tile.setOnMousePressed(e -> {
                    tilePrevX = tile.getLayoutX();
                    tilePrevY = tile.getLayoutY();
                    if (gameUtil.isSwappableTile(tile)) {
                     /* Removing then putting the tile back on top to give it top priority
                    otherwise it will go below other tiles.  */
                        gamePane.getChildren().remove(tile);
                        gamePane.getChildren().add(tile);

                        swapArray.clear();
                        swapArray.add(tile);
                    }
                });

                // While dragging constantly update the tiles x-y values according to mouse.
                tile.setOnMouseDragged(e -> {
                    if (gameUtil.isSwappableTile(tile)) {
                        tile.setLayoutX(e.getSceneX() - tile.getWidth() / 2 - 10);
                        tile.setLayoutY(e.getSceneY() - tile.getHeight() / 2 - 10);

                    }

                });
                /*
                 When released first check if there is a proper tile at mouse locations then
                 swap the tiles and check if the pathConstructed if it is play the animation
                 and continue to the next level.
                 */
                tile.setOnMouseReleased(e -> {
                            if (e.getSceneX() > 10 && e.getSceneX() < 420 && e.getSceneY() > 10 && e.getSceneY() < 420) {

                                if (gameUtil.isSwappableTile(tile)) {
                                    Tile swap2 = gameUtil.getTileFromMouse(tiles, e.getSceneX(), e.getSceneY());

                                    if (swap2 == null || !gameUtil.isSwappableTiles(swapArray.get(0), swap2)) {

                                        tile.setLayoutX(tilePrevX);
                                        tile.setLayoutY(tilePrevY);
                                        return;
                                    }

                                    swapArray.add(swap2);
                                    swapTiles(swapArray.get(0), swapArray.get(1));

                                    if (gameUtil.isPathConstructed(tiles)) {

                                        Animation.playAnimation(gamePane, gameUtil.getPaths());

                                        if (Main.LEVEL == Main.MAX_LEVEL) {
                                            System.out.println("CONGRATS YOU WIN !");
                                        } else {
                                            Tile[][] nextLevel = fileUtil.createGrid(++Main.LEVEL);
                                            Gui nextGui = new Gui(nextLevel);
                                            Animation.getPathTransition().setOnFinished(event -> {
                                                nextGui.showGui(Main.getStage());
                                                Main.NUMBER_OF_MOVES.set(0);
                                            });
                                        }
                                    }
                                }
                            } else {
                                tile.setLayoutX(tilePrevX);
                                tile.setLayoutY(tilePrevY);
                            }
                        }

                );
            }
        }
    }

    private void swapTiles(Tile tile1, Tile tile2) {

        /*
         * These Grid assignments are for our tiles[][] grid positions
         * layout positions are for replacing them in the pane
         *
         * */
        int xGrid1 = tile1.getxGrid();
        int yGrid1 = tile1.getyGrid();

        int xGrid2 = tile2.getxGrid();
        int yGrid2 = tile2.getyGrid();

        if (xGrid1 == xGrid2 && yGrid1 == yGrid2) {
            tile2.setLayoutX(tilePrevX);
            tile2.setLayoutY(tilePrevY);
            return;
        }

        Main.NUMBER_OF_MOVES.setValue(Main.NUMBER_OF_MOVES.add(1).getValue());

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
