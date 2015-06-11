/**
 * MazeGenerator.java
 *
 *
 * Author: Guthrie Price 
 * 6/10/2015
 * Purpose: Method for generating a graph that represents a maze
 */

import java.util.Random;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Iterator;

public class MazeGenerator{

    public static Graph generateMaze(int minPath, int deadEnd){
        int maxRooms = minPath+minPath*deadEnd; //Maximum number of rooms in the maze
        Graph maze = new Graph(maxRooms); //Graph for representing the maze
        ArrayList<Integer> weights = new ArrayList<Integer>(maxRooms*2); //Random weights assigned to each path
        Random generator = new Random();
        int totalRooms = 0; //Total rooms added counter
        //Fill the weights list
        for(int i=0;i<maxRooms*2;i++)
            weights.add(i+1);
        Iterator weightIter = weights.iterator(); //Iterator for getting weights
        Collections.shuffle(weights, new Random(System.nanoTime())); //Shuffle the weights into random order
        Vertex[] rooms = new Vertex[deadEnd]; //Used for making dead end submaze
        //Fill the maze with the minimum rooms needed to complete the maze
        for(int i=0;i<minPath;i++){
            Vertex v = new Vertex(totalRooms);
            maze.addVertex(v);
            totalRooms++;
        }
        //Connect the rooms in a single path from beginning to end
        //For each vertex on the path, generate a new set of verticies
        //And create a deadend submaze
        Vertex vers[] = maze.getVers();
        for(int i=0;i<minPath-1;i++){
            //Link the current room to the next room on the correct path
            maze.addEdge(vers[i],vers[i+1],(int)weightIter.next());
            //Generate the rooms for the deadend submaze
            for(int j=0;j<deadEnd;j++){
                Vertex v = new Vertex(totalRooms); 
                maze.addVertex(v);
                rooms[j] = v;
                totalRooms++;
            }
            //Add a connection from the correct path to the deadend submaze
            maze.addEdge(vers[i],rooms[0],1);
            //Connect the rooms randomly in the deadend submaze
            for(int j=0;j<deadEnd*2;j++){
                Vertex room1 = rooms[generator.nextInt(deadEnd)];
                Vertex room2 = rooms[generator.nextInt(deadEnd)];
                if(!(room1.equal(room2)))
                    maze.addEdge(room1,room2,(int)weightIter.next());
            }
        }
        return maze;
    }
}
