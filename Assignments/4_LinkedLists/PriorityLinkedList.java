/**
 * PriorityLinkedList.java
 *
 *
 * Author: Guthrie Price 
 * 3/23/2015 - Data Structures (CSC-18C 42030)
 * Implementation of a priority queue using a linked list.
 */


public class PriorityLinkedList<T>{
	
	private Node<T> head;
	private int length;
	
    public PriorityLinkedList() {
    	head = new Node<T>(null);
    	length = 0;
    }
    
    public void append(T data){
    	Node<T> temp = new Node(data);
    	Node<T> current = head;
    	
    	while(current.getNext() != null){
    		current = current.getNext();
    	}
    	current.setNext(temp);
    	temp.setPrev(current);
    	length++;
    }
    
    public void prepend(T data){
    	Node<T> temp = new Node(data);
    	if (length <= 0){
    		head.setNext(temp);
    		temp.setPrev(head);
    	}
    	else{

    	head.getNext().setPrev(temp);
    	temp.setNext(head.getNext());
    	head.setNext(temp);
    	}
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
    		temp.setPrev(current);
    		current.getNext().setPrev(temp);
    		current.setNext(temp);
    		length++;
    	}
    }
    
    public T pop(){
    	Node<T> result = head.getNext();
    	result.getNext().setPrev(head);
    	head.setNext(result.getNext());
    	length--;
    	return result.getData();
    }
    
    public boolean remove(int index){
    	if(index >= length || index < 0){
    		return false;
    	}
    	Node<T> current = head;
    	for(int i=0;i<index;i++){
    		current = current.getNext();
    	}
    	current.getNext().getNext().setPrev(current);
    	current.setNext(current.getNext().getNext());
    	length--;
    	return true;
    }
    
    //Moves accessed node to front of the linked list
    public T get(int index){
    	if (index < 0){
    		index = 0;
    	}
	if (index > length){
	    index = length-1;
	}
    	Node<T> current = head.getNext();
    	for(int i=0;i<index;i++){
    		current = current.getNext();
    	}
	if(head.getNext() != current){
	    current.getPrev().setNext(current.getNext());
	    if(current.getNext() != null){
		current.getNext().setPrev(current.getPrev());
	    }
	    current.setPrev(head);
	    current.setNext(head.getNext());
	    head.setNext(current);
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
