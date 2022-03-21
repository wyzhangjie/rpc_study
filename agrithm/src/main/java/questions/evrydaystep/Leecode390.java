package questions.evrydaystep;

public class Leecode390 {
    public int lastRemaining(int n) {
        int left=1;
        boolean l2r=true;
        int step =1;
        while (n>1){
            if(n%2==1 || l2r){
                left+=step;
            }
            n=n/2;
            step*=2;
            l2r=false;
        }
        return left;
    }
}
