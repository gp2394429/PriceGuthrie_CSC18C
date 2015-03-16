/**
 * StackDriver.java
 *
 *
 * Author: Guthrie Price
 * 3/16/2015 - Data Structures (CSC-18C 42030)
 * Testing/Driver for stack implemenation
 */


public class StackDriver {
    public static void main(String[] args){
    	Stack s = new Stack();
    	System.out.println(s.empty());
    	for(int i=0;i<10;i++){
    		s.push(new Integer(i*10));
    	}
    	System.out.println(s);
    	for(int i=0;i<4;i++){
    		System.out.println(s.pop());
    	}
    	System.out.println(s.size());
    	System.out.println(s.empty());
    	System.out.println(s);
    	for(int i=0;i<6;i++){
    		System.out.println(s.pop());
    	}
    	System.out.println(s.size());
    	System.out.println(s.empty());
    	System.out.println(s);
    }
    
    
}