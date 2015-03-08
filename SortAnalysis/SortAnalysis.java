/**
 * @(#)BubbleSort.java
 *
 *
 * @author 
 * @version 1.00 2015/3/1
 */

import java.util.Random;

public class SortAnalysis{
	
	//Global variables
	static int opart = 0; //Arithmetirc operations
	static int oplog = 0; //Logical operations
	static int opeq = 0; //Equality operations
	static int SIZE = 400; //Size of array
	
	//Fill an array with 2 digit numbers
	public static int[] fillArray(int n){
		int[] array = new int[n];
		Random rand = new Random();
		int max = 99; int min = 10;
		for(int i=0;i<array.length;i++){
			array[i]=rand.nextInt(max-min+1)+min;
		}
		return array;
	}
	
	//Print an array
	public static void printArray(int[] a,int perLine){
		for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
            if(i%perLine==(perLine-1))System.out.println();
		}
	}
	
	//Find the max for an array
    public static int max(int a[]){
        int amax=a[0];
        for(int i=1;i<a.length;i++){
            if(amax<a[i])amax=a[i];
        }
        return amax;
    }
    
    //Find the min for an array
    public static int min(int a[]){
        int amin=a[0];
        for(int i=1;i<a.length;i++){
            if(amin>a[i])amin=a[i];
        }
        return amin;
    }
    
    //Bubble Sort implementation
    public static int[] bubbleSort(int[] a){
    	int len = a.length-1;
    	boolean swaped;
    	int temp;
    	
    	opeq++;
    	do{
    		swaped = false;
    		
    		opeq+=2;
    		for(int i=0;i<len;i++){
    			oplog+=2;opart+=2;
    			if(a[i]>a[i+1]){
    				temp=a[i];
    				a[i]=a[i+1];
    				a[i+1]=temp;
    				swaped=true;
    				opeq+=4;
    			}
    		}
    	}while(swaped);
    	return a;
    }
    
    //Simplest Sort -> MarkSort
    public static int []mrkSrt(int a[]){
        //Declare and use
        int temp;int nm1=a.length-1;int n=a.length;
        //Loop for each cap of lst
        opeq++;
        for(int cap=0;cap<nm1;cap++){
            oplog++;opart++;
            //Loop on every element below the cap
            opeq++;opart++;
            for(int lst=cap+1;lst<n;lst++){
                oplog+=2;opart++;
                if(a[cap]>a[lst]){
                    temp=a[cap];
                    a[cap]=a[lst];
                    a[lst]=temp;
                    opeq+=3;
                }
            }
        }
        return a;
    }
    
    //Binary search implementation
    public static boolean binarySearch(int[] data, int key){
 		int low = 0;
       	int high = SIZE - 1;
 		opeq+=2;opart++;

    	while(high >= low) {
			oplog++;
      		int middle = (low + high) / 2;
			opeq++;opart+=2;oplog++;   
          	if(data[middle] == key) {
            	return true;
          	}
			oplog++;
          	if(data[middle] < key) {
               	low = middle + 1;
				opart++;opeq++;
          	}
			oplog++;
          	if(data[middle] > key) {
				opeq++;opart++;
              	high = middle - 1;
          	}
     	}
     	return false;
	}	
	
	public static void resetOps(){
		opart=0;
		oplog=0;
		opeq=0;
	}
	
	public static void printOps(){
		System.out.printf("N = %d\n",SIZE);
  		System.out.printf("OPEQ = %d\n",opeq);
  		System.out.printf("OPART = %d\n",opart);
  		System.out.printf("OPLOG = %d\n",oplog);
  		System.out.printf("TOTAL = %d\n",(opeq+opart+oplog));
	}
	
  	public static void main(String args[]){
  		Random rand = new Random(System.currentTimeMillis());
  		int[] array = fillArray(SIZE+1);
  		//printArray(array,10);
  		//System.out.println();
  		System.out.println("\nBubble Sort");
  		bubbleSort(array);
  		printOps();
  		resetOps();
  		array = fillArray(SIZE+1);
  		System.out.println("\nMark Sort");
  		mrkSrt(array);
  		printOps();
  		resetOps();
  		System.out.println("\nBinary Search");
  		binarySearch(array, rand.nextInt(SIZE+1));
  		printOps();
  	}
}