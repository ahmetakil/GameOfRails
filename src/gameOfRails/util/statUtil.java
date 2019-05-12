package gameOfRails.util;

import gameOfRails.Main;
import gameOfRails.gui.GameGui;

public class statUtil {
    static int[] times = new int[Main.MAX_LEVEL];
    static int[] moves = new int[Main.MAX_LEVEL];

    public static void addToStats(){
        times[Main.LEVEL -1] = (int) timeUtil.currentSeconds();
        moves[Main.LEVEL -1] = Main.NUMBER_OF_MOVES.getValue();
    }

    public static String stats(){
        String string = "Level 1:\t Time is:" + hourFormatConverter(times[0]) + " Number of Moves: " + moves[0] +
                "\nLevel 2:\t Time is:" + hourFormatConverter(times[1]) + " Number of Moves: " + moves[1] +
                "\nLevel 3:\t Time is:" + hourFormatConverter(times[2]) + " Number of Moves: " + moves[2] +
                "\nLevel 4:\t Time is:" + hourFormatConverter(times[3]) + " Number of Moves: " + moves[3] +
                "\nLevel 5:\t Time is:" + hourFormatConverter(times[4]) + " Number of Moves: " + moves[4] +
                "\nIn Total:\t Time is:" + hourFormatConverter(GameGui.TOTAL_SECONDS) + " Number of Moves: " + GameGui.TOTAL_MOVES;
        return string;
    }
    private static int arrraySum(int[] arrray){
        return 0;
    }

    public static String hourFormatConverter (int input){

        long seconds = input;
        long minutes = seconds/60;
        return String.format("%02d:%02d",minutes,seconds%60);
    }
}

