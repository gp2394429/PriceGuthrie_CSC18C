public class Utility{

    public static int pow(int b, int a){
        if(a==1) return b;
        if(a%2==1) return pow(b*b,a-1);
        else{
            int x = pow(b,a/2);
            return x*x;
        }
    }
}
