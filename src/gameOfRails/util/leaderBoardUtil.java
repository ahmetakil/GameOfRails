package gameOfRails.util;

import gameOfRails.gui.EntryGui;
import gameOfRails.gui.GameGui;

import java.io.*;
import java.util.Scanner;

public class leaderBoardUtil {
    static File leaderBoard = new File("leaderBoard.dat");
    static FileWriter fileWriter;
    static BufferedWriter bufferedWriter;



    public static void addToLeaderBoards() throws Exception{
        Writer output = new BufferedWriter(new FileWriter(leaderBoard,true));
        output.write("player " + EntryGui.NAME + "\n");
        output.write("\ttotalmoves " + GameGui.TOTAL_MOVES + "\n");
        output.write("\ttotalseconds " +GameGui.TOTAL_SECONDS + "\n");
        output.close();
    }


    public static String[]  sortTleaderBoard(String players[],String sortedBy){
        players = new String[10];


        return players;
    }

}

