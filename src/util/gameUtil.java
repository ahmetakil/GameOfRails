package util;

import game.*;
import javafx.scene.layout.GridPane;

public class gameUtil {

//TODO CREATE A METHOD THAT IS RESPONSIBLE FOR PATH FINDING APIS.

    public static boolean isPathConstructed(Tile[][] tiles){

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
        return false;
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
