package COMP1020_TermProject;

import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.IOException;


public class Leaderboard {
    public String name;
    private int score = 0;
    private int time;
    static LinkedList<String> leaderboard = new LinkedList<>();
    Leaderboard(int score){
        this.score = score;
        BufferedReader br = null;
        try{
            br = new BufferedReader(new FileReader("leaderboard.txt"));
            Scanner sc = new Scanner(br);
            time = Integer.parseInt(sc.nextLine());
            while (sc.hasNextLine())
                leaderboard.add(sc.nextLine());
            addName(time, this.score);
        }
        catch(Exception e){
            System.out.print(e);
        }
    }
    public static void addName(int time, int score){
        if (leaderboard.size() > 10){
            leaderboard.pollFirst();
        }
        String st = "Attempt " + time;
        System.out.println(String.valueOf(time).length());
        for (int i = 0; i < 20 - String.valueOf(time).length(); i++){
            st += " ";
        }
        st += score;
        leaderboard.add(st);
        if (time > 1000){
            time = -1;
        }
        try{
            PrintWriter out = new PrintWriter("leaderboard.txt"); 

            time += 1;
            out.println(String.valueOf(time));   

            for (int i = 0; i < leaderboard.size(); i++){
                out.println(leaderboard.get(i));
            }

            out.close(); 
        }
        catch(Exception e){
            System.out.print(e);
        }
    }
}