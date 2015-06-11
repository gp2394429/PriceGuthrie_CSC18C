/**
 * Vertex.java
 *
 *
 * Author: Guthrie Price 
 * 6/10/2015
 * Purpose: Class that represents a vertex in a graph
 */

public class Vertex{

    int label;

    public Vertex(int label){
        this.label = label;

    }
    public boolean equal(Vertex v){
        return label == v.label;
    }
}
