package questions.evrydaystep;/**
 * ClassName Leecode322
 * Description
 * Create by jie.zhang02
 * Date 2022/3/1 5:46 下午
 */

/**
 * @author jie.zhang
 * @date 2022年03月01日 5:46 下午
 */
public class Leecode322 {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[amount+1][coins.length];
        for(int i=0;i<dp.length;i++){
            dp[i][0]=0;

        }
        for(int i=0;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                dp[i][j]=amount+1;
            }
        }

        for(int i=1;i<=amount;i++){
            for(int j=0;j<coins.length;j++){
                if(coins[j]<=i){
                    dp[i][j]=Math.min(dp[i-coins[j]][j]+1,dp[i][j]);
                }

            }
        }
        return dp[amount][coins.length-1];
    }

    public static void main(String[] args) {
      int[]  coins = {1, 2, 5};
      int amount = 11;
        Leecode322 leecode322 = new Leecode322();
        System.out.println(leecode322.coinChange(coins,amount));
    }
}
