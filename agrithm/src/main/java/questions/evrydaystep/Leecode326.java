package questions.evrydaystep;

public class Leecode326 {
    public boolean isPowerOfThree(int n) {
        int begin=0;
        int end=19;
        while (begin<=end){
            int mid = begin +(end-begin)/2;
            int total = 1;
            for(int i=0;i<mid;i++){
                total*=3;
            }
            if(total==n){
                return true;
            }else if(total>n){
                end=mid-1;
            }else {
                begin=mid+1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int a =9;
        Leecode326 leecode326 = new Leecode326();
        System.out.println(leecode326.isPowerOfThree(a));
    }
}
