/**
 * Driver.java
 *
 *
 * Author: Guthrie Price 
 * 6/10/2015
 * Purpose: Driver program for the game collection
 */

import java.util.Scanner;
import java.util.InputMismatchException;

public class Driver{


    public static void main(String args[]){
        int userChoice; //User choice for the main menu
        boolean running = true; //Testing to see if the game is running
        char[] symbols = "abcdefghijklmnopqrstuvwxyz".toCharArray(); //Symbols used in the memory game
        Scanner input = new Scanner(System.in); //Used for getting input from the user
        int minPath = 4; //The minimum number of rooms
        int deadEnds = 8; //The number of rooms per dead end sub maze
        
        //Enter main loop
        while(running){
            //Print the main menu
            mainMenu();
            //Get the user's choice
            userChoice = Utility.getNumber("\nChoose your game",1,4,input);
            //Decide what to do based on the users choice
            switch(userChoice){
                case 1:
                    //Run the memory game
    	            MemoryPuzzle m = new MemoryPuzzle(symbols,input);
                    System.out.println();
                    m.run();
                    break;
                case 2:
                    //Run the guessing game
                    GuessingGame g = new GuessingGame(input);
                    System.out.println();
                    g.run();
                    break;
                case 3:
                    //Run the maze game
                    MazeGame z = new MazeGame(minPath,deadEnds,input);
                    System.out.println();
                    z.run();
                    break;
                case 4:
                    //Exit the game
                    System.out.println("Exiting...");
                    running = false;
                    break;
                default:
                    //Something unforseen as occured, exit with an error
                    System.out.println("Something strange happened");
                    System.exit(-1);
            }
        }
    }

    //Main menu function
    private static void mainMenu(){
        System.out.println("Main Menu\n-------------");
        System.out.println("1. Memory Game");
        System.out.println("2. Masochistic Guessing Game");
        System.out.println("3. Dr. Lehr's Labyrinth");
        System.out.println("4. Exit");
    }
}
