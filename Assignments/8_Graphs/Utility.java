public class Utility{
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
