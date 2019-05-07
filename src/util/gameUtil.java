package util;


import game.*;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.PathElement;

import java.util.ArrayList;

public class gameUtil {

    public static final int SIZE = 400;
    private static ArrayList<PathElement> paths = new ArrayList<>();
    public static final int offset = 40;

    public static ArrayList<PathElement> getPaths() {
        return paths;
    }

    /**
     * This method both checks if the pathConstructed
     * then if it is constructed it also creates
     * the path objects that will later be used
     * in path Animation.
     */

    //TODO Optimized it or rewrite it. HAVE TO BE BETTER THAN CANS'.
    public static boolean isPathConstructed(Tile[][] tiles) {


        int leftPriority, rightPriority, upPriority = 0, downPriority = 0;
        LastAction lastAction = null;

        Pipe starterTile = null;
        Pipe endTile = null;

        outerLoop:
        for (int i = 0; i < tiles[0].length; i++) {
            for (int j = 0; j < tiles.length; j++) {
                if (tiles[i][j] instanceof Starter) {
                    starterTile = (Pipe) tiles[i][j];
                    break outerLoop;
                }
            }
        }

        outerLoop:
        for (int i = 0; i < tiles[0].length; i++) {
            for (int j = 0; j < tiles.length; j++) {
                if (tiles[i][j] instanceof End) {
                    endTile = (Pipe) tiles[i][j];
                    break outerLoop;
                }
            }
        }

        int x = starterTile.getxGrid(); // X or starter tile
        int y = starterTile.getyGrid(); // Y of starter tile

        int xTarget = endTile.getxGrid();
        int yTarget = endTile.getyGrid();

        int xDiff = x - xTarget;
        int yDiff = y - yTarget;

        upPriority = yDiff;
        leftPriority = xDiff;

        downPriority = -yDiff;
        rightPriority = -xDiff;

        while (!(tiles[x][y] instanceof End)) {

            Tile currentTile = tiles[x][y];

            if (currentTile.isDownEdge() && downPriority >= upPriority && lastAction != LastAction.UP) {
                if (tiles[x][y + 1].isUpEdge()) { //Current pipe is downEdged and pipe below is upEdge() we can move there.

                    y++; // Go below
                    downPriority--;
                    upPriority++;
                    lastAction = LastAction.DOWN;
                    paths.add(new LineTo((x * 100) + offset, (y * 100) + offset));

                    continue;

                }else{
                    paths.clear();
                    return false;
                }
            }

            if (currentTile.isRightEdge() && rightPriority >= leftPriority && lastAction != LastAction.LEFT) {
                if (tiles[x + 1][y].isLeftEdge()) {

                    x++; // Go right
                    rightPriority--;
                    leftPriority++;
                    lastAction = LastAction.RIGHT;
                    paths.add(new LineTo((x * 100) + offset, (y * 100) + offset));
                    continue;
                }else{
                    paths.clear();
                    return false;
                }
            }

            if (currentTile.isUpEdge() && upPriority >= downPriority && lastAction != LastAction.DOWN) {
                if (tiles[x][y - 1].isDownEdge()) {
                    y--; // Go up
                    upPriority--;
                    downPriority++;
                    lastAction = LastAction.UP;
                    paths.add(new LineTo((x * 100) + offset, (y * 100) + offset));
                    continue;
                }else{
                    paths.clear();
                    return false;
                }
            }

            if (currentTile.isLeftEdge() && leftPriority >= rightPriority && lastAction != LastAction.RIGHT ) {
                if (tiles[x - 1][y].isRightEdge()) {
                    x--; // Go left
                    leftPriority--;
                    rightPriority++;
                    lastAction = LastAction.LEFT;
                    paths.add(new LineTo((x * 100) + offset, (y * 100) + offset));
                }else{
                    paths.clear();
                    return false;
                }
            }
        }
        return true;

    }

    //TODO Check from PDF that these logical expressions are true. AND ADD COMMAND
    //TODO Sort these statements to most common to less common.(Performance thing)
    public static boolean isSwappableTiles(Tile tile1, Tile tile2) {

        //If they are both free tiles we can't change them. It is unnecessary.
        if (!(tile1 instanceof Free || tile2 instanceof Free)) {
            return false;
        }
        //This if statement checks that tiles are vertical or horizontal. If their x axis and y axises differences' sum is 1
        //That means they are horizontal or vertical that means they are swappable
        if ((Math.abs(tile1.getxGrid() - tile2.getxGrid()) + Math.abs(tile1.getyGrid() - tile2.getyGrid()) != 1)) {
            return false;
        }
        //This checks both of them movable or not. If one of them is not returns false.
        return ((tile1.isMovable() && tile2.isMovable()));

        //Abandoned because of clean code things.
//        if (tile1 instanceof Static
//                || tile2 instanceof Static
//                || tile1 instanceof End
//                || tile2 instanceof End
//                || tile1 instanceof Starter
//                || tile2 instanceof Starter
//                || tile1 instanceof CurvedStatic
//                || tile2 instanceof CurvedStatic) {
//
//            return false;
//        }
    }



   //TODO Add command
    public static Tile getTileFromMouse(Tile[][] tiles, double sceneX, double sceneY) {

        int xGrid = (int)((sceneX-1) / (SIZE/4));
        int yGrid = (int)((sceneY-1) / (SIZE/4));

        //If cause a problem, try catch will be added
        return tiles[xGrid][yGrid];

        //Because of performance leaks if else is abandoned
//        // Find which tile is clicked by the mouse location.
//        if (sceneX <= SIZE / 4) {
//            xGrid = 0;
//        } else if (sceneX <= SIZE / 2) {
//            xGrid = 1;
//        } else if (sceneX <= 3 * SIZE / 4) {
//            xGrid = 2;
//        } else {
//            xGrid = 3;
//        }
//
//        if (sceneY <= SIZE / 4) {
//            yGrid = 0;
//        } else if (sceneY <= SIZE / 2) {
//            yGrid = 1;
//        } else if (sceneY <= 3 * SIZE / 4) {
//            yGrid = 2;
//        } else {
//            yGrid = 3;
//        }

        //Because of performance leaks this for loops has been deleted temporarily (Can be turned in any unexpected situation)

//        for (int row = 0; row < tiles.length; row++) {
//            for (int col = 0; col < tiles[row].length; col++) {
//                Tile tile = tiles[row][col];
//                if (tile.getxGrid() == xGrid && tile.getyGrid() == yGrid) {
//                    return tile;
//                }
//            }
//        }
    }
}

