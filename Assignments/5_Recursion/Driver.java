import java.util.Random;

public class Driver{

    public static final int NUMS = 5;

    public static void main(String args[]){

        //Summing problem
        System.out.println("Summing Problem");
        Random g = new Random();
        int[] array = new int[NUMS];
        int num;

        System.out.print("Numbers to sum: ");
        for(int i=0;i<NUMS;i++){
            num = g.nextInt(10);
            System.out.print(num+" ");
            array[i]=num;
        }
        System.out.println();
        System.out.println(Recursion.sum(array,0,array.length));
        System.out.println();

        //Savings problem
        System.out.println("Savings Problem");
        float pv = (g.nextInt(900000)+100000.0f)/100;
        float i = (g.nextInt(70)+1.0f)/100;
        int n = (g.nextInt(20)+1);

        System.out.println("Initial value: "+pv);
        System.out.println("Interest/year: "+i);
        System.out.println("Number of years: "+n);
        System.out.print("Total savings: ");
        System.out.println(Recursion.savings(pv,i,n));
    }
}
