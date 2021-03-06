/**
 * Edge.java
 *
 *
 * Author: Guthrie Price 
 * 6/10/2015
 * Purpose: Class representing an undirected edge for the Graph class
 */

public class Edge{

        public Vertex v1; //The first vertex in the edge
        public Vertex v2; //The second vertex in the edge
        public int weight; //The edge's weight

        //Constructor
        public Edge(Vertex start, Vertex end, int w){
            v1 = start;
            v2 = end;
            weight = w;
        }
        //Determines if this edge is greater than another
        public boolean greater(Edge e){
            return weight > e.weight;
        }
    }
