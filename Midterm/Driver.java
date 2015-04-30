import java.util.Random;
import java.util.Scanner;

public class Driver{

    private static float EPSILON = 1.0e-6f; //Used for problem 9

    //Helper functions
    public static void printMenu(){
        System.out.println("1. Problem 1");
        System.out.println("2. Problem 2");
        System.out.println("3. Problem 3");
        System.out.println("4. Problem 4");
        System.out.println("5. Problem 5");
        System.out.println("6. Problem 6");
        System.out.println("7. Problem 7");
        System.out.println("8. Problem 8");
        System.out.println("9. Problem 9");
        System.out.println("10. Exit");
    }

    public static int getChoice(String prompt){
        Scanner input = new Scanner(System.in);
        System.out.print(prompt);
        return(input.nextInt());
    }

    public static float getFloat(String prompt){
        Scanner input = new Scanner(System.in);
        System.out.print(prompt);
        return(input.nextFloat());
    }

    //Problem 1
    public static Vector top(Vector x, int p){
    	Vector result = new Vector();
    	x.sort();
    	for(int i=0;i<p;i++){
    		result.set(i,x.get(i));
    	}
    	return result;
    }

    public static void problem1(){
        int size;
        int p; //Number of elements to take from the top of the vector;
        Vector x = new Vector();
        Random generator = new Random();
        size = getChoice("Enter the number of elements in the vector: ");
        p = getChoice("Enter the number of top elements to get from the vector: ");
        //Fill array with random 2 digit numbers
        for(int i=0;i<size;i++)
            x.set(i,generator.nextInt(90)+10);
        System.out.println(x);
        System.out.println(top(x,p));
    }
    //Problem 2
    public static Vector mode(Vector x){
        StatClass m = new StatClass(x);
        return m.getMode();
    }

    public static void problem2(){
        int size;
        int m;
        Vector x = new Vector();
        size = getChoice("Enter the number of elements in the vector: ");
        m = getChoice("Enter the mod: ");
        for(int i=0;i<size;i++)
            x.set(i,i%m);
        System.out.println(x);
        System.out.println(mode(x));
    }

    //Problem 3
    public static StatClass stats(Vector x){
        return new StatClass(x);
    }

    public static void problem3(){
        int size;
        int m;
        Vector x = new Vector();
        size = getChoice("Enter the number of elements in the vector: ");
        m = getChoice("Enter the mod: ");
        for(int i=0;i<size;i++)
            x.set(i,i%m);
        System.out.println(x);
        System.out.println(stats(x));
    }

    //Problem 4
    public static LinkedList top(SortedLinkedList x, int p){
        LinkedList result = new LinkedList();
        for(int i=0;i<p;i++){
            result.append(x.pop());
        }
        return result;
    }

    public static void problem4(){
        int size;
        int p; //Number of elements to take from the top of the list;
        SortedLinkedList x = new SortedLinkedList();
        Random generator = new Random();
        size = getChoice("Enter the number of elements in the list: ");
        p = getChoice("Enter the number of top elements to get from the list: ");
        //Fill linked list with random 2 digit numbers
        for(int i=0;i<size;i++)
            x.push(generator.nextInt(90)+10);
        System.out.println(x);
        System.out.println(top(x,p));
    }

    //Problem 5
    public static Vector mode(LinkedList x){
    	StatClass m = new StatClass(x);
    	return m.getMode();
    }

    public static void problem5(){
        int size;
        int m;
        LinkedList x = new LinkedList();
        size = getChoice("Enter the number of elements in the list: ");
        m = getChoice("Enter the mod: ");
        for(int i=0;i<size;i++)
            x.append(i%m);
        System.out.println(x);
        System.out.println(mode(x));
    }

    //Problem 6
    public static StatClass stats(LinkedList x){
	return new StatClass(x);
    }

    public static void problem6(){
        int size;
        int m;
        LinkedList x = new LinkedList();
        size = getChoice("Enter the number of elements in the list: ");
        m = getChoice("Enter the mod: ");
        for(int i=0;i<size;i++)
            x.append(i%m);
        System.out.println(x);
        System.out.println(stats(x));
    }

    //Problem 7
    public static void problem7(){
        int size;
        int n; //Number of elements randomly chosen that demonstrate the priorty list
        int elem; //The random element to search for
        boolean found; //True if the element is found, false otherwise
        Random generator = new Random();
        PriorityList x = new PriorityList();
        size = getChoice("Enter the number of elements in the list: ");
        n = getChoice("Number of elements randomly chosen: ");

        for(int i=0;i<size;i++)
            x.append(generator.nextInt(90)+10);
        for(int i=0;i<n;i++){
            System.out.println("The list so far\n");
            System.out.println(x);
            elem = generator.nextInt(90)+10;
            found = x.exists(elem);
            System.out.println("Trying to find " + elem);
            System.out.print("The element was ");
            if(!found)
                System.out.print("not ");
            System.out.println("found\n");
        }
    }

    //Problem 8
    public static float powR(float x, int y){
    	float a;
    	if(y<=0){
    		return 1.0f;
    	}
    	
    	if(y%2 == 0){
    		a = powR(x,y/2);
    		return a*a;
    	}
    	
    	a = powR(x,(y-1));
    	return x*a;
    }

    public static void problem8(){
        float base = getFloat("Enter the base: ");
        int exponent = getChoice("Enter the exponent: ");
        System.out.println(powR(base,exponent));
    }

    //Problem 9
    public static float h(float x){
    	if(Math.abs(x) < EPSILON){
    	    return (x+(x*x*x)/6);
    	}
    	float a = h(x/3);
    	float b = g(x/3);
        return -(a*a*a)+3*b*b*a;
    }
    
    public static float g(float x){
        if(Math.abs(x) < EPSILON){
            return (1+x*x/2);
        }
        float a = h(x/3);
        float b = g(x/3);
        return b*b*b-(3*a*a*b);
    }
    
    public static void problem9(){
        float x = -(1.0f);
        float delx = 0.1f;
        for(int i=0;i<=20;i++){
            System.out.println("x = " + x);
            System.out.println("h(x) = " + h(x));
            System.out.println("g(x) = " + g(x));
            x+=delx;
        }
    }


    public static void main(String args[]){
        Random generator = new Random();
        int choice;
        boolean running = true;

        while(running){
            printMenu();
            choice = getChoice("Enter an integer: ");
            switch(choice){
                case 1: 
                    problem1();
                    break;
                case 2: 
                    problem2();
                    break;
                case 3: 
                    problem3();
                    break;
                case 4: 
                    problem4();
                    break;
                case 5: 
                    problem5();
                    break;
                case 6: 
                    problem6();
                    break;
                case 7: 
                    problem7();
                    break;
                case 8: 
                    problem8();
                    break;
                case 9: 
                    problem9();
                    break;
                case 10: 
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice, try again");
            }
        }
    }
}


