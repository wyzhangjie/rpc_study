package questions.evrydaystep;

/**
 * 518. 零钱兑换 II
 * 给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: amount = 5, coins = [1, 2, 5]
 * 输出: 4
 * 解释: 有四种方式可以凑成总金额:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * 示例 2:
 * <p>
 * 输入: amount = 3, coins = [2]
 * 输出: 0
 * 解释: 只用面额2的硬币不能凑成总金额3。
 * 示例 3:
 * <p>
 * 输入: amount = 10, coins = [10]
 * 输出: 1
 */
public class Leecode518 {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int i = 0; i <= coins.length; i++) {
            dp[i][0] = 1;
        }


        for (int i = 1; i <= coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                int coin = coins[i - 1];
                dp[i] [j]= dp[i - 1][j];
                if (j - coin >= 0) {
                    dp[i][j] +=  dp[i][j - coin];
                }

            }
        }
        return dp[coins.length][amount];
    }
    public int change1(int amount, int[] coins) {
      int[] dp = new int[amount+1];
      dp[0]=1;
      for(int i=0;i<coins.length;i++){
          for(int j=coins[i];j<=amount;j++){
              dp[j]+=dp[j-coins[i]];
          }
      }
      return dp[amount];
    }
    public static void main(String[] args) {
        int amount = 5;
        int[] coins = new int[]{1, 2, 5};
        Leecode518 leecode518 = new Leecode518();
        System.out.println(leecode518.change(amount, coins));
        System.out.println(leecode518.change1(amount, coins));

    }
}
