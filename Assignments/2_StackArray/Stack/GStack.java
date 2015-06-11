/**
 * GStack.java
 *
 *
 * Author: Guthrie Price
 * 3/7/2015 - Data Structures (CSC-18C 42030)
 * Implementation of a generic stack
 */


public class GStack<T> {
	
	private int arrSize;
	private T stackArr[];
	private int top;
	
    public GStack(int initArrSze) {
    	arrSize = initArrSze; //Initial array size
    	stackArr = (T[])(new Object[initArrSze]);
    	top = -1;
    }
    //Pushes an element to the top of the stack
    public void push(T elem){
    	//Increase array size if adding an element to a full stack
    	if(top>=arrSize-1){
    		resizeArray();
    	}
       	stackArr[++top] = elem;
    }
    //Pops an element from the top of the stack
    //NOTE: No internal checks for popping from an empty stack
    //Will throw an ArrayIndexOutOfBounds exception
    public T pop(){
    	return stackArr[top--];
    }
    //Looks at the top element without removing it from the stack
    //NOTE: No internal checks for peeking from an empty stack
    //Will throw an ArrayIndexOutOfBounds exception
    public T peek(){
    	return stackArr[top];
    }
    //Tests to see if the stack is empty or not
    public boolean empty(){
    	return (top == -1);
    }
    //Returns the current size of the stack
    public int size(){
    	return top+1;
    }
    //Doubles the current array size used for the stack
    private void resizeArray(){
    	T tempArr[] = (T[])(new Object[arrSize*2]);
    	for(int i = 0;i<arrSize;i++){
    		tempArr[i] = stackArr[i];
    	}
    	arrSize*=2;
    	stackArr = tempArr;
    }
    //Main function used for testing the stack
    public static void main(String args[]){
    	GStack s = new GStack(10);
    	String s1 = new String("HELLO");
    	String s2 = new String("WORLD");
    	System.out.println("Empty stack?: "+s.empty());
    	System.out.println("Pushing "+s1);
    	s.push(s1);
    	System.out.println("Empty stack?: "+s.empty());
    	System.out.println("Peeking "+s.peek());
    	System.out.println("Pushing "+s2);
    	s.push(s2);
    	System.out.printf("Current size: %d\n", s.size());
    	//System.out.println(s);
    	for(int i=0;i<2;i++){
    		System.out.println("Popping "+s.pop());
    	}
    	System.out.println("Empty stack?: "+s.empty());
    	System.out.printf("Current size: %d\n", s.size());
    }
}
