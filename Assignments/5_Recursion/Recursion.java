public class Recursion{

    //Sum two numbers m and n recursively
    public static int sum(int[] a,int beg,int end){
        if(end-beg<=1)return a[beg];
        int half = (beg+end)/2;
        int m=sum(a,beg,half);
        int n=sum(a,half,end);
        return m+n;
    }
    
    //Savings function
    public static float savings(float pv,float i,int n){
        if(n==0) return pv;
        return savings(pv*(i+1),i,n-1);
    }
}

