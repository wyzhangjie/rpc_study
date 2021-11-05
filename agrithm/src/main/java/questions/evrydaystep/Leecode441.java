package questions.evrydaystep;
/**
 * 你总共有 n 枚硬币，并计划将它们按阶梯状排列。对于一个由 k 行组成的阶梯，其第 i 行必须正好有 i 枚硬币。阶梯的最后一行 可能 是不完整的。
 *
 * 给你一个数字 n ，计算并返回可形成 完整阶梯行 的总行数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/arranging-coins
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class Leecode441 {
    public int arrangeCoins(int n) {
        long left=1;
        long right=n;
        while (left<=right){
            long mid =(long) left+(right-left)/2;
            long total = mid*(mid+1)/2;
            if(total==n){
                return  (int)mid;
            }

            if(mid*(mid+1)/2>n){
                right=mid-1;
            }else {
                left=mid+1;
            }

        }
        return (int) right;


    }

    public static void main(String[] args) {
        int n=5;
        Leecode441 leecode441 = new Leecode441();
        System.out.println(leecode441.arrangeCoins(n));
    }
}
