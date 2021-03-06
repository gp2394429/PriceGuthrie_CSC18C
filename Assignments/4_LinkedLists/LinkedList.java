/**
 * LinkedList.java
 *
 *
 * Author: Guthrie Price 
 * 3/23/2015 - Data Structures (CSC-18C 42030)
 * Implementation of a singly linked list with a head and a tail.
 */


public class LinkedList<T>{

	private Node<T> head;
	private Node<T> tail;
	private int length;
	
    public LinkedList() {
    	head = new Node<T>(null);
    	tail = new Node<T>(null);
    	head.setNext(tail);
    	tail.setPrev(head);
    	length = 0;
    }
    
    public void prepend(T data){
    	Node<T> temp = new Node(data);
    	next = head.getNext();
    	temp.setNext(next);
    	temp.setPrev(head);
    	next.setPrev(temp);
    	head.setNext(temp);
    	length++;
    }
    
    public void append(T data){
    	Node<T> temp = new Node(data);
		prev = tail.getPrev();
		temp.setNext(tail);
		temp.setPrev(prev);
		prev.setNext(temp);
		tail.setPrev(temp);
    	length++;
    }
    
    public void insert(T data, int index){
    	if(index >= length){
    		append(data);
    	}
    	else if (index < 0){
    		prepend(data);
    	}
    	else{
    		Node<T> temp = new Node(data);
    		Node<T> current = head;
    		for(int i=0;i<index;i++){
    			current = current.getNext();
    		}
    		temp.setNext(current.getNext());
    		temp.setPrev(current.getPrev());
    		current.getNext().setPrev(temp);
    		current.setNext(temp);
    		length++;
    	}
    }
    
    public boolean remove(int index){
    	if(index >= length || index < 0){
    		return false;
    	}
    	Node<T> current = head;
    	for(int i=0;i<index;i++){
    		current = current.getNext();
    	}
    	current.setNext(current.getNext().getNext());
    	length--;
    	return true;
    }
    
    public T get(int index){
    	if (index < 0){
    		index = 0;
    	}
    	Node<T> current = head;
    	for(int i=0;i<index+1;i++){
    		if(current.getNext() == null){
    			return current.getData();
    		}
    		current = current.getNext();
    	}
    	return current.getData();
    }
    public int size(){
    	return length;
    }
    
    public String toString(){
    	String result="";
    	Node<T> current = head.getNext();
    	while(current != null){
    		result = result + current.getData().toString() + " ";
    		current = current.getNext();
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
    		next = null;
    		prev = null;
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
