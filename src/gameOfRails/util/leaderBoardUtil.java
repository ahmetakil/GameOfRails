package gameOfRails.util;

import gameOfRails.gui.EntryGui;
import gameOfRails.gui.GameGui;

import java.io.*;

public class leaderBoardUtil {
        static PrintWriter printWriter;


    public static void addToLeaderBoards() throws IOException{

        File leaderBoard = new File("leaderBoard.dat");
        FileWriter fileWriter = new FileWriter(leaderBoard);
        printWriter = new PrintWriter(fileWriter);

        printWriter.println("player " + EntryGui.NAME);
        printWriter.println("\ttotalmoves " + GameGui.TOTAL_MOVES);
        printWriter.println("\ttotalseconds " +GameGui.TOTAL_SECONDS);
        printWriter.close();

    }
}

