package questions.evrydaystep.dp;/**
 * ClassName Leecode1137
 * Description
 * Create by jie.zhang02
 * Date 2022/3/21 3:52 下午
 */

/**
 * @author jie.zhang
 * @date 2022年03月21日 3:52 下午
 */
public class Leecode1137 {
    public int tribonacci(int n) {
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

        int i=2;
        while (i++<n){
            dp[i]= dp[i-1]+dp[i-2]+dp[i-3];
        }

        return dp[n];

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
        int dp0 = 0;
        int dp1=1;
        int dp2=1;
        for(int i=3;i<=n;i++){
            dp0=dp0+dp1+dp2;
            int temp =dp0;
            dp0=dp1;
            dp1=dp2;
            dp2=temp;
        }


        return dp2;

    }

}
