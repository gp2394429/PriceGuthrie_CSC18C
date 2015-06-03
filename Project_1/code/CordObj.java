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
