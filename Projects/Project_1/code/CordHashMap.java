/**
 * CordHashMap.java
 *
 *
 * Author: Guthrie Price
 * Date: 5/18/2015 
 * Purpose: A mapping of coordinates to an array index
 */

import java.util.Vector;

public abstract class CordHashMap{

    private int dimSize; //Size of one dimension of the space
    private CordObj[] space; //The space of coordinate objects
    
    public CordHashMap(int size){
        dimSize = size;
        space = new CordObj[Utility.pow(size,2)];
    }

    //Returns the coordinate space
    public CordObj[] getSpace(){
        return space;
    }

    //Returns the dimension size
    public int getSize(){
        return dimSize;
    }

    //Fills the coordinate space with coordinate objects
    public void fillSpace(Vector<CordObj> objs){
        //TODO fix error for objects with coordinates outside the space size
        for(CordObj obj : objs){
            add(obj);
        }
    }

    //Sets a specific coordinate to a coordinate object
    public void add(CordObj obj){
        getSpace()[hash(obj.getCord())] = obj;
    }

    //Returns the coordinate object at a coordinate
    public CordObj get(Coordinate c){
        return getSpace()[hash(c)];
    }
    
    //Maps a 2D coordinate to the coordinate space
    public int hash(Coordinate c){
        return ((c.getX()-1)+((c.getY()-1)*dimSize));
    }

    public String toString(){
        String result = "";
        for(int i=0;i<Utility.pow(dimSize,2);i++){
            result = result+space[i].toString()+" ";
        }
        return result;
    }
}
    
    
