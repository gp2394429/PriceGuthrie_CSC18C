/**
 * Stack.java
 *
 *
 * Author: Guthrie Price
 * 3/16/2015 - Data Structures (CSC-18C 42030)
 * Implementation of a stack using a linked list.
 */


public class Stack<T>{
	
	public LinkedList<T> container;

    public Stack() {
    	container = new LinkedList<T>();
    }
    
    public void push(T data){
    	container.insert(data,0);
    }
    
    public T pop(){
    	T value = container.get(0);
    	container.remove(0);
    	return value;
    }
    
    public T peek(){
    	return container.get(0);
    }
    
    public boolean empty(){
    	return (container.size() == 0);
    }
    
    public int size(){
    	return container.size();
    }
    
    public String toString(){
    	return container.toString();
    }
}