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
        String string = "";
        for (int i = 0;i<Main.MAX_LEVEL;i++){
            string += (String.format("Level %d  -> Time: %s Number of Moves: %d \n",i+1,hourFormatConverter(times[i]),moves[i]));
        }
        string += String.format("In Total -> Time: %s Number of Moves: %d",hourFormatConverter(GameGui.TOTAL_SECONDS),GameGui.TOTAL_MOVES);
        return string;
    }
    private static int arrraySum(int[] arrray){
        int sum = 0;
        for (int i = 0;i<arrray.length;i++){
            sum+= arrray[i];
        }
        return sum;
    }

    public static String hourFormatConverter (int input){

        long seconds = input;
        long minutes = seconds/60;
        return String.format("%02d:%02d",minutes,seconds%60);
    }
}

