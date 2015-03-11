/**
 * BubbleSort.java
 *
 *
 * Author: Guthrie Price
 * 3/7/2015 - Data Structures (CSC-18C 42030)
 * Time analysis for implementations of bubble sort,
 * mark sort, and binary search.
 */

import java.util.Random;

public class TimeAnalysis{
	
	//Global variables
	static float TIME; //Time taken to execute method
	static int BASE = 10000; //Base number of elements in the test array
	
	//Fill an array with 2 digit numbers
	public static int[] fillArray(int n){
		int[] array = new int[n];
		Random rand = new Random();
		for(int i=0;i<array.length;i++){
			array[i]=rand.nextInt(n);
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
   
    	do{
    		swaped = false;
    		
    		for(int i=0;i<len;i++){
    			if(a[i]>a[i+1]){
    				temp=a[i];
    				a[i]=a[i+1];
    				a[i+1]=temp;
    				swaped=true;
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
        for(int cap=0;cap<nm1;cap++){
            
            //Loop on every element below the cap
            for(int lst=cap+1;lst<n;lst++){
                if(a[cap]>a[lst]){
                    temp=a[cap];
                    a[cap]=a[lst];
                    a[lst]=temp;
                }
            }
        }
        return a;
    }
    
    //Binary search implementation
    public static boolean binarySearch(int[] data, int key){
 		int low = 0;
       	int high = data.length - 1;

    	while(high >= low) {
      		int middle = (low + high) / 2; 
          	if(data[middle] == key) {
            	return true;
          	}
          	if(data[middle] < key) {
               	low = middle + 1;
          	}
          	if(data[middle] > key) {
              	high = middle - 1;
          	}
     	}
     	return false;
	}	
	
	//Raise an integer to the power of a positive integer
	public static int pow(int b, int n){
		int result = b;
		if(n==0){
			return 1;
		}
		for(int i = n;i>1;i--){
			result*=b;
		}
		return result;
	}
	
  	public static void main(String args[]){
  		long iTime;
  		long fTime;
  		int trialNum = 4;
  		int methodNum = 3;
  		int array[];
  		int size; //size of the array
  		Random rand = new Random(System.currentTimeMillis());
  		//printArray(array,10);
  		//System.out.println();
  		for (int i=1;i<=methodNum;i++){
  			size = BASE*pow(2,i);
  			System.out.printf("Current size being used for trials: %d\n",size);
	  		for(int j=0;j<trialNum;j++){
	  			array = fillArray(size);
		  		iTime = System.currentTimeMillis();
		  		bubbleSort(array);
		  		fTime = System.currentTimeMillis();
		  		TIME = ((float)(fTime-iTime))/1000; //Convert to seconds
				System.out.printf("Time for trial %d for Bubble Sort: %f seconds\n",j+1,TIME);
		  		array = fillArray(size);
		  		iTime = System.currentTimeMillis();
		  		mrkSrt(array);
		  		fTime = System.currentTimeMillis();
		  		TIME = ((float)(fTime-iTime))/1000; //Convert to seconds
				System.out.printf("Time for trial %d for Mark Sort: %f seconds\n",j+1,TIME);
		  		iTime = System.currentTimeMillis();
		  		binarySearch(array, rand.nextInt(size));
		  		fTime = System.currentTimeMillis();
		  		TIME = ((float)(fTime-iTime))/1000; //Convert to seconds
				System.out.printf("Time for trial %d for Binary Search: %f seconds\n",j+1,TIME);
	  		}
  		}
  	}
}