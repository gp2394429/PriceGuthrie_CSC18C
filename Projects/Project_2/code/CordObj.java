/**
 * CordObj.java
 *
 *
 * Author: Guthrie Price
 * Date: 6/10/2015 
 * Purpose: An abstract class for implmenting classes with data and a coordinate
 */

public abstract class CordObj<T>{

    private Coordinate cord;
    private T data;

    public CordObj(Coordinate c, T d){
        cord = c;
        data = d;
    }

    public Coordinate getCord(){
        return cord;
    }
    
    public T getData(){
        return data;
    }

    public void setCord(Coordinate c){
        cord = c;
    }

    public void setData(T d){
        data = d;
    }

    public String toString(){
        return "["+cord.toString()+","+data.toString()+"]";
    }
}
