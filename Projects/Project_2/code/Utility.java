/**
 * Utility.java
 *
 *
 * Author: Guthrie Price 
 * 6/10/2015
 * Purpose: Utility class full of generic methods
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class Utility{

    public static int pow(int b, int a){
        if(a==1) return b;
        if(a%2==1) return pow(b*b,a-1);
        else{
            int x = pow(b,a/2);
            return x*x;
        }
    }
    //Gets a number from the user within the lower and upper bounds
    public static int getNumber(String prompt, int lowBnd, int upBnd, Scanner input){
        int choice=0;
        do{
            try{
                System.out.print(prompt+"("+lowBnd+"-"+upBnd+"): ");
                choice = input.nextInt();
            }
            catch(InputMismatchException e){
                choice=lowBnd-1;
                input.next();
            }
            finally{
                if(choice>upBnd || choice<lowBnd){
                    System.out.println("Oops, invalid choice, try again.");
                }
            }
        }while(choice>upBnd || choice<lowBnd);

        return choice;
    }
    //Waits for a user to press enter
    public static void waitForInput(Scanner input){
        System.out.print("Press enter to continue ");
        input.nextLine();
    }

    public static void mrkSrt(Edge a[]){
        //Declare and use
        Edge temp;int nm1=a.length-1;int n=a.length;
        //Loop for each cap of lst
        for(int cap=0;cap<nm1;cap++){
            //Loop on every element below the cap
            for(int lst=cap+1;lst<n;lst++){
                if(a[cap].greater(a[lst])){
                    temp=a[cap];
                    a[cap]=a[lst];
                    a[lst]=temp;
                }
            }
        }
    }
}
