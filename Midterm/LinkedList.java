/**
 * LinkedList.java
 *
 *
 * Author: Guthrie Price 
 * 3/16/2015 - Data Structures (CSC-18C 42030)
 * Implementation of a linked list.
 */


public class LinkedList{
	
	public Node head;
	public int length;
	
    public LinkedList() {
    	head = new Node(null);
    	length = 0;
    }
    
    public void append(Integer data){
    	Node temp = new Node(data);
    	Node current = head;
    	
    	while(current.getNext() != null){
    		current = current.getNext();
    	}
    	current.setNext(temp);
    	length++;
    }
    
    public Integer pop(){
        Node result = head.getNext();
        if(result != null){
            head.setNext(result.getNext());
        }
        length--;
        return result.getData();
    }

    public void insert(Integer data, int index){
    	if(index >= length){
    		append(data);
    	}
    	else if (index < 0){
    		index = 0;
    	}
    	else{
    		Node temp = new Node(data);
    		Node current = head;
    		for(int i=0;i<index;i++){
    			current = current.getNext();
    		}
    		temp.setNext(current.getNext());
    		current.setNext(temp);
    		length++;
    	}
    }
    
    public boolean remove(int index){
    	if(index >= length || index < 0){
    		return false;
    	}
    	Node current = head;
    	for(int i=0;i<index;i++){
    		current = current.getNext();
    	}
    	current.setNext(current.getNext().getNext());
    	length--;
    	return true;
    }
    
    public Integer get(int index){
    	if (index < 0){
    		index = 0;
    	}
    	Node current = head;
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
    	Node current = head.getNext();
    	while(current != null){
    		result = result + current.getData().toString() + " ";
    		current = current.getNext();
    	}
    	return result;
    }
    
    public class Node{
    	
    	private Integer data;
    	private Node next;
    	
    	public Node(Integer data){
    		this.data = data;
    		next = null;
    	}
    	
    	public Integer getData(){
    		return data;
    	}
    	
    	public Node getNext(){
    		return next;
    	}
    	public void setData(Integer data){
    		this.data = data;
    	}
    	public void setNext(Node next){
    		this.next = next;
    	}
    }
}
