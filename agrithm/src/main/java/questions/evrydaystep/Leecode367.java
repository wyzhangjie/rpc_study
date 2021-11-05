package questions.evrydaystep;

//


public class Leecode367 {
    public boolean isPerfectSquare(int num) {
        //二分法求解
        Long left=0L;
        Long right=(long)num;
        while (left<=right){
            Long mid= left+(right-left)/2;
            if(mid*mid==num){
                return true;
            }else if(mid*mid>num){
                right=mid-1;
            }else {
                left=mid+1;
            }


        }
        return false;
    }

    public static void main(String[] args) {
        int num=2147483647;
        Leecode367 leecode367 = new Leecode367();
        System.out.println(leecode367.isPerfectSquare(num));
    }
}
