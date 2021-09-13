package questions.evrydaystep;

/**
 * 1137. 第 N 个泰波那契数
 * 泰波那契序列 Tn 定义如下：
 *
 * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 *
 * 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 4
 * 输出：4
 * 解释：
 * T_3 = 0 + 1 + 1 = 2
 * T_4 = 1 + 1 + 2 = 4
 * 示例 2：
 *
 * 输入：n = 25
 * 输出：1389537
 * */

public class Leecode1137 {

    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if(n==2){
            return 1;
        }
       return tribonacci(n-1)+tribonacci(n-2)+tribonacci(n-3);

    }

    public int tribonacci1(int n) {
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        if(n==2){
            return 1;
        }
       int[] dp = new int[n+1];
       dp[0]=0;
       dp[1]=1;
       dp[2]=1;
       if(n<=2){
           return dp[n];
       }
       int i=2;
       while (i++<n){
           dp[i]= dp[i-1]+dp[i-2]+dp[i-3];
       }

       return dp[n];

    }

    public static void main(String[] args) {
        Leecode1137 leecode1137 = new Leecode1137();
        System.out.println(
                leecode1137.tribonacci(3)
        );
        System.out.println(
                leecode1137.tribonacci1(3)
        );
    }
}
