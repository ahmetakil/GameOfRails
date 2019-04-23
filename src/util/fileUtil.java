package util;

import game.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class fileUtil {


    /*
    So readText() method basically reads the text and gives us a 1 dimensional
    array list we want to convert that to a 2D 4x4 grid
     */
    public static Tile[][] createGrid(int level){

        int pos = 0;
        Tile[][] grid = new Tile[4][4];
        ArrayList<Tile> tiles = readText(level);


        for(int row=0;row<4;row++){
            for(int col=0;col<4;col++){

                grid[row][col] = tiles.get(pos);
                pos++;

            }
        }

        return grid;

    }


    public static ArrayList<Tile> readText(int level) { // Reading text with level parameter

        ArrayList<Tile> tiles = new ArrayList<>();

        try {

            File file = new File("level" + level + ".txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNext()) {

                String line = scanner.nextLine(); // id,type,property
                if(line.trim().equalsIgnoreCase("")){
                    continue;
                }
                String[] lineContents = line.split(","); // [id, type , property]
                int position = Integer.parseInt(lineContents[0]);
                int[] coordinates = calculateCoordinatesfromPos(position);
                String type = lineContents[1];
                String direction = lineContents[2];


                switch (type) {

                    case "Starter":
                        if (direction.equalsIgnoreCase("Vertical")) {


                            tiles.add(new Starter(coordinates[0], coordinates[1], false, true, false, false));
                        } else {

                            tiles.add(new Starter(coordinates[0], coordinates[1], false, false, true, false));
                        }

                        break;



                    case "End":
                        if (direction.equalsIgnoreCase("Vertical")) {


                            tiles.add(new End(coordinates[0], coordinates[1], false, true, false, false));
                        } else {

                            tiles.add(new End(coordinates[0], coordinates[1], false, false, true, false));
                        }

                        break;


                    case "Empty":

                        if(direction.equalsIgnoreCase("Free")){

                            tiles.add(new Free(coordinates[0],coordinates[1]));

                        }else{

                            tiles.add(new EmptyTile(coordinates[0],coordinates[1]));
                        }
                        break;

                    case "PipeStatic":

                        if(direction.equalsIgnoreCase("Horizontal")){

                            tiles.add(new Static(coordinates[0],coordinates[1],1,3));

                        }else{

                            tiles.add(new Static(coordinates[0],coordinates[1],0,2));
                        }

                        break;

                    case "Pipe":


                        if(direction.equalsIgnoreCase("Vertical")){

                            tiles.add(new Pipe(coordinates[0],coordinates[1],true,true,true,false,false));

                        }else if(direction.equalsIgnoreCase("Horizontal")){

                            tiles.add(new Pipe(coordinates[0],coordinates[1],true,false,false,true,true));
                        }else{

                            int first = Integer.parseInt(direction.charAt(0)+"");
                            int second = Integer.parseInt(direction.charAt(1)+"");

                            tiles.add(new Curved(coordinates[0],coordinates[1] ,first ,second ));
                        }
                        break;


                }


            }


        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return tiles;
    }


    // Calculate x and y values from position (Ex : 5 > x: 1 y:1)
    public static int[] calculateCoordinatesfromPos(int position) {

        int x = (position - 1) % 4;
        int y = (position - 1) / 4;
        int[] array = {x, y};
        return array;

    }
}
