package gameOfRails.util;

import gameOfRails.Main;
import gameOfRails.gui.GameGui;

/*
    This class is for collecting stats for levels and prints them in FinalGui to inform about his/her performance.
 */

public class statUtil {
    //Creating arrays in the amount of level for avoid the out of bounds exception for extra levels.
    private static int[] times = new int[Main.MAX_LEVEL];
    private static int[] moves = new int[Main.MAX_LEVEL];

    //This methods is calling after every level. This methods adds the value of time and moves to array.
    public static void addToStats(){
        times[Main.LEVEL -1] = (int) timeUtil.currentSeconds();
        moves[Main.LEVEL -1] = Main.NUMBER_OF_MOVES.getValue();
    }

    //This method is returns the stats in a aesthetic form to print in FinalGui.
    public static String stats(){
        String string = "";
        for (int i = 0;i<Main.MAX_LEVEL;i++){
            string += (String.format("Level %d  -> Time: %s Number of Moves: %d \n",i+1,hourFormatConverter(times[i]),moves[i]));
        }
        string += String.format("In Total -> Time: %s Number of Moves: %d",hourFormatConverter(GameGui.TOTAL_SECONDS),GameGui.TOTAL_MOVES);
        return string;
    }

    //This methods converts the seconds into MM:SS hour format.
    private static String hourFormatConverter(int seconds){
        long minutes = seconds/60;
        return String.format("%02d:%02d",minutes,seconds%60);
    }
}

