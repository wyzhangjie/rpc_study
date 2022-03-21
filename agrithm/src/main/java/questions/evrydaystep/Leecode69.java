package questions.evrydaystep;/**
 * ClassName Leecode69
 * Description
 * Create by jie.zhang02
 * Date 2022/2/28 8:49 下午
 */

/**
 * @author jie.zhang
 * @date 2022年02月28日 8:49 下午
 */
public class Leecode69 {
    public int mySqrt(int x) {
        int left=0;
        int right=x;
        int ans=-1;
        while (left<=right){
            int mid= left+(right-left)/2;
            if(((long)mid*mid)<=x){
               ans= mid;
               left=mid+1;
            }else {
                right=mid-1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int x=2147395599;
        Leecode69 leecode69 = new Leecode69();
        System.out.println(leecode69.mySqrt(x));
    }
}
