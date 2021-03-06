/**
 * Driver.java
 *
 *
 * Author: Guthrie Price
 * 4/1/2015 - Data Structures (CSC-18C 42030)
 * Driver for testing linked list implementations
 */


public class Driver {

    public static void main(String args[]){
    	DoubleLinkedList dblLL = new DoubleLinkedList();
	CircularLinkedList cirLL = new CircularLinkedList();
    	PriorityLinkedList priLL = new PriorityLinkedList();

    	for(int i=1;i<10;i++){
    		dblLL.prepend(i);
		cirLL.push(i);
    	}

	priLL.prepend(3);
	priLL.prepend(4);
	priLL.get(1);
	System.out.print(priLL);
	priLL.get(1);

    	System.out.print(dblLL);
	System.out.print(cirLL);
	System.out.print(priLL);
    }
}
