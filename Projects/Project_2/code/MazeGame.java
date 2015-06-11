/**
 * MazeGame.java
 *
 *
 * Author: Guthrie Price 
 * 6/10/2015
 * Purpose: A game that uses a graph to represent a maze
 */

import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Iterator;

public class MazeGame{

    private Graph maze; //The maze
    private Vertex current; //The room the player is in
    private Scanner input;
    private Vertex[] rooms;
    private int[][] paths;
    private int goal;
    private int userChoice;
    private ArrayList<Integer> currentPaths;
    private final int EMPTY = -1;

    public MazeGame(int minPath, int deadRooms, Scanner s){
        input = s;
        goal = minPath-1;
        maze = MazeGenerator.generateMaze(minPath, deadRooms);
        rooms = maze.getVers();
        paths = maze.getEdges();
        current = rooms[0];
    }
    public void run(){
        System.out.println("Welcome to Dr. Lehr's Labyrinth.");
        System.out.println("You are trying to find Dr.Lehr's office in order to deliver your final.");
        System.out.println("However, the building layout is strange... I hope you get there in time.");
        System.out.println("Good luck!\n");
        while(!gameOver(current)){
            //Output information about the current room
            currentPaths = output(current);
            //Get the users choice on the path
            userChoice = Utility.getNumber("\nChoose a path",1,currentPaths.size(),input);
            System.out.println("\nGoing down hallway labeled \"Corridor "+paths[maze.verInGraph(current)][(int)maze.verInGraph(rooms[currentPaths.get(userChoice-1)])]+"\"\n");
            //Set the current room to what the user chose
            current = rooms[currentPaths.get(userChoice-1)];
        }
        System.out.println("Congratulations! You found Dr. Lehr's office!");
        System.out.println("Unfortunately, he isn't in right now, please come again later.\n");
    }
    public boolean gameOver(Vertex current){
        if(current.equal(rooms[goal]))
            return true;
        return false;
    }
    public ArrayList<Integer> output(Vertex curRoom){
        int numPaths = 0;
        int curPaths[] = paths[maze.verInGraph(curRoom)];
        int validPaths[] = new int[curPaths.length];
        ArrayList<Integer> choices;
        System.out.println("Which hall do you choose to go down?\n");
        for(int i=0;i<curPaths.length;i++){
            if(curPaths[i] != EMPTY){
                validPaths[numPaths] = i;
                numPaths++;
            }
        }
        choices = new ArrayList<Integer>(numPaths);
        for(int i=0;i<numPaths;i++)
            choices.add(validPaths[i]);
        Collections.shuffle(choices);
        Iterator choiceIter = choices.iterator();
        for(int i=0;i<numPaths;i++){
            if(numPaths == 1)
                System.out.println("You hit a dead end, better go back...");
            System.out.println((i+1)+". Go down hallway labeled \"Corridor "+paths[maze.verInGraph(curRoom)][maze.verInGraph(rooms[(int)choiceIter.next()])]+"\"");
        }
        return choices;
    }
}
