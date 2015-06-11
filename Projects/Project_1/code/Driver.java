/**
 * Driver.java
 *
 *
 * Author: Guthrie Price 
 * 5/18/2015
 * Purpose: Driver program for the game collection
 */

import java.util.Scanner;

public class Driver{

    public static void main(String args[]){

        char[] symbols = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    	MemoryPuzzle m = new MemoryPuzzle(symbols);
        m.run();
    }
}
