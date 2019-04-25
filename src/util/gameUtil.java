package util;

import game.*;
import javafx.scene.layout.GridPane;

public class gameUtil {

//TODO CREATE A METHOD THAT IS RESPONSIBLE FOR PATH FINDING APIS.

    public static boolean isPathConstructed(Tile[][] tiles) throws Exception{
        int x = 0;
        int y = 0;
        Pipe tile = null; //Creating null object
        for(int i = 0; i<tiles[0].length;i++){ //Checking all x axis
            for(int j = 0;j<tiles.length;j++){ //Checking all y axis
                if(tiles[i][j] instanceof Starter){ //Checks is it starter or not for initial point
                    tile = (Pipe) tiles[i][j]; //putting it into null object
                    x = i;
                    y= j;
                }
            }
        }
        try {
            while (!(tiles[x][y] instanceof End)){  //For checking all tiles in the path
                if(tiles[x][y].isDownEdge()){       //Thanks to abstract method in tile.java we can use that
                    if(!tiles[x][++y].isUpEdge()){  //We search for upper edge in lower tile if not returns false
                        return false;
                    }
                    tiles[x][y].setUpEdge(false);   //Closing the gate
                }
                if(tiles[x][y].isUpEdge()){
                    if(!tiles[x][--y].isDownEdge()){
                        return false;
                    }
                    tiles[x][y].setDownEdge(false);
                }
                if(tiles[x][y].isLeftEdge()){
                    if(!tiles[--x][y].isRightEdge()){
                        return false;
                    }
                    tiles[x][y].setRightEdge(false);
                }
                if(tiles[x][y].isRightEdge()){
                    if(!tiles[++x][y].isLeftEdge()){
                        return false;
                    }
                    tiles[x][y].setLeftEdge(false);
                }
            }

        }catch (Exception e){ //For any exception returns false
            return false;
        }


        /**
            -locate starting tile check its open direction
                If:
                    DOWN IS OPEN:
                        The the tile below should be open on UP.
                            THEN
                                Check that tiles directions.
                        ELSE: # down is not open
                            THEN RIGHT IS OPEN
                                CHECK THE TILE ON THE RUGHT DOES IT HAVE A OPEN LEFT.

         */
        return true;
    }

    public static boolean isSwappableTiles(Tile tile1, Tile tile2) {
        System.out.println("xxxx");
        if(!(tile1 instanceof Free || tile2 instanceof Free)){

            return false;
        }
        System.out.println("yyy");
        System.out.println(tile1);
        System.out.println(tile2);
        if(tile1 instanceof Static
                || tile2 instanceof Static
                || tile1 instanceof End
                || tile2 instanceof End
                || tile1 instanceof Starter
                || tile2 instanceof Starter){

            return false;
        }

        return true;
    }
}
