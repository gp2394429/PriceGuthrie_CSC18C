/**
 * Coordinate.java
 *
 *
 * Author: Guthrie Price 
 * Date: 5/18/2015
 * Purpose: A representation of a coordinate in a 2-dimensional space
 */

public class Coordinate{

    private int x; //x-coordinate
    private int y; //y-coordiante

    public Coordinate(Integer xVal, Integer yVal){
        x = xVal;
        y = yVal;
    }

    //Sets the x-coordinate
    public void setX(Integer xVal){
        x = xVal;
    }

    //Sets the y-coordinate
    public void setY(Integer yVal){
        y = yVal;
    }

    //Gets the x-coordinate
    public Integer getX(){
        return x;
    }

    //Gets the y-coordinate
    public Integer getY(){
        return y;
    }

    //Determines if one coordinate is equal to another
    public boolean isEqual(Coordinate c){
        return (x == c.getX() && y == c.getY());
    } 

    public String toString(){
        return "("+getX()+","+getY()+")";
    }
}
