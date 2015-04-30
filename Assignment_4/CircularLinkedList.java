/**
 * CircularLinkedList.java
 *
 *
 * Author: Guthrie Price 
 * 4/1/2015 - Data Structures (CSC-18C 42030)
 * Implementation of a circularly linked list.
 */


public class CircularLinkedList<T>{
	
	private Node<T> current;
	private int length;
	
    public CircularLinkedList() {
    	current = new Node<T>(null);
    	length = 0;
    }

    public CircularLinkedList(T data){
	current = new Node<T>(data);
	length = 1;
    }
    
    public void push(T data){
    	Node<T> temp = new Node(data);
    	if (length <= 0){
	    current.setData(data);
    	}
    	else{
	   temp.setPrev(current.getPrev());
	   temp.setNext(current);
	   current.setPrev(temp);
	   current = temp;
    	}
    	length++;
    }
    
    public T pop(){
    	Node<T> result = current;
    	result.getNext().setPrev(result.getPrev());
    	result.getPrev().setNext(result.getNext());
    	length--;
    	return result.getData();
    }
    
    public int size(){
    	return length;
    }
    
    public String toString(){
    	String result="";
	Node<T> cur = current;
    	for(int i = 0;i<length;i++){
    	    result = result + cur.getData().toString() + " ";
    	    cur = cur.getNext();
    	}
	result = result + "\n";
    	return result;
    }
    
    private class Node<T>{
    	
    	private T data;
    	private Node<T> next;
    	private Node<T> prev;
    	
    	public Node(T data){
    		this.data = data;
    		next = this;
    		prev = this;
    	}
    	
    	public T getData(){
    		return data;
    	}
    	
    	public Node getNext(){
    		return next;
    	}
    	public Node getPrev(){
    		return prev;
    	}
    	public void setData(T data){
    		this.data = data;
    	}
    	public void setNext(Node<T> next){
    		this.next = next;
    	}
    	public void setPrev(Node<T> prev){
    		this.prev = prev;
    	}
    }
}
