package util;


import game.*;

public class gameUtil {

    public static final int SIZE = 400;

    public static boolean isPathConstructed(Tile[][] tiles) {

        int x;
        int y;
        int leftPriorty = 0,rightPriorty = 0,upPriorty = 0,downPriorty = 0;

        int counter = 0; // We say that if we cant find a path in 100 moves we return false.
        Pipe starterTile = null;
        Pipe endTile = null;
        outerLoop:for (int i = 0; i < tiles[0].length; i++) {
            for (int j = 0; j < tiles.length; j++) {
                if (tiles[i][j] instanceof Starter) {
                    starterTile = (Pipe) tiles[i][j];
                    break outerLoop;
                }
            }
        }


        outerLoop:for (int i = 0; i < tiles[0].length; i++) {
            for (int j = 0; j < tiles.length; j++) {
                if (tiles[i][j] instanceof End) {
                    endTile = (Pipe) tiles[i][j];
                    break outerLoop;
                }
            }
        }


        x = starterTile.getxGrid(); // X or starter tile
        y = starterTile.getyGrid(); // Y of starter tile

        int xTarget = endTile.getxGrid();
        int yTarget = endTile.getyGrid();

        int xDiff = x - xTarget;
        int yDiff = y - yTarget;

        upPriorty = yDiff;
        leftPriorty = xDiff;

        downPriorty = -yDiff;
        rightPriorty = -xDiff;

        while (!(tiles[x][y] instanceof End)) {

            Tile currentTile = tiles[x][y];
            if (counter > 100) {
                System.out.println("counter");
                return false;
            }

            counter++;

            if (currentTile.isDownEdge() && downPriorty >= upPriorty) {
                if (tiles[x][y + 1].isUpEdge()) { //Current pipe is downEdged and pipe below is upEdge() we can move there.

                    y++; // Go below
                    downPriorty--;
                    upPriorty++;
                    continue;

                }
            }

            if (currentTile.isRightEdge() && rightPriorty >= leftPriorty) {
                if (tiles[x + 1][y].isLeftEdge()) {

                    x++; // Go right
                    rightPriorty--;
                    leftPriorty++;
                    continue;
                }
            }

            if (currentTile.isUpEdge() && upPriorty >= downPriorty){
                if (tiles[x][y - 1].isDownEdge()) {
                    y--; // Go up
                    upPriorty--;
                    downPriorty++;
                    continue;
                }
            }

            if (currentTile.isLeftEdge() && leftPriorty >= rightPriorty) {
                if (tiles[x - 1][y].isRightEdge()) {
                    x--; // Go left
                    leftPriorty--;
                    rightPriorty++;
                    continue;
                }
            }



        }
        return true;

    }


    public static boolean isSwappableTiles(Tile tile1, Tile tile2) {

        if (!(tile1 instanceof Free || tile2 instanceof Free)) {

            return false;
        }

        int xGrid1 = tile1.getxGrid();
        int yGrid1 = tile1.getyGrid();
        int xGrid2;
        xGrid2 = tile2.getxGrid();

        int yGrid2 = tile2.getyGrid();

        if ((Math.abs(xGrid1 - xGrid2) + Math.abs(yGrid1 - yGrid2) != 1)) {
            return false;
        }

        if (tile1 instanceof Static
                || tile2 instanceof Static
                || tile1 instanceof End
                || tile2 instanceof End
                || tile1 instanceof Starter
                || tile2 instanceof Starter) {

            return false;
        }

        return true;
    }


    public static Tile getTileFromMouse(Tile[][] tiles, double sceneX, double sceneY) {

        int xGrid = 0;
        int yGrid = 0;

        // Find which tile is clicked by the mouse location.
        if (sceneX <= SIZE / 4) {
            xGrid = 0;
        } else if (sceneX <= SIZE / 2) {
            xGrid = 1;
        } else if (sceneX <= 3 * SIZE / 4) {
            xGrid = 2;
        } else {
            xGrid = 3;
        }

        if (sceneY <= SIZE / 4) {
            yGrid = 0;
        } else if (sceneY <= SIZE / 2) {
            yGrid = 1;
        } else if (sceneY <= 3 * SIZE / 4) {
            yGrid = 2;
        } else {
            yGrid = 3;
        }

        for (int row = 0; row < tiles.length; row++) {
            for (int col = 0; col < tiles[row].length; col++) {
                Tile tile = tiles[row][col];
                if (tile.getxGrid() == xGrid && tile.getyGrid() == yGrid) {
                    return tile;
                }
            }
        }
        return null;
    }
}
