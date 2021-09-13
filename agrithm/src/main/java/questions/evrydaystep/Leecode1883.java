package questions.evrydaystep;

import java.util.Arrays;

public class Leecode1883 {

    public int maxIceCream(int[] costs, int coins) {
        int[][] dp = new int[costs.length + 1][coins + 1];
        for (int i = 0; i <= costs.length; i++) {
            dp[i][0] = 0;
        }
        for (int j = 1; j <= costs.length; j++) {
            for (int i = 1; i <= coins; i++) {
                dp[j][i] = dp[j - 1][i];
                if (costs[j - 1] <= i) {
                    dp[j][i] = Math.max(dp[j - 1][i], dp[j - 1][i - costs[j - 1]] + 1);
                }
            }
        }
        return dp[costs.length][coins];
    }

    public int maxIceCreamSimple(int[] costs, int coins) {
        int sum=0;
        Arrays.sort(costs);
        for(int cost:costs){
            if(coins-cost>=0){
                coins-=cost;
                sum++;
            }
        }
        return sum;
    }

    //降维度
    public int maxIceCream1(int[] costs, int coins) {
        int[] dp = new int[coins + 1];
        dp[0] = 0;
        for (int j = 1; j <= costs.length; j++) {
            for (int i = 1; i <= coins; i++) {
                dp[i] = dp[i - 1];
                if (costs[j - 1] <= i) {
                    dp[i] = Math.max(dp[i], dp[i - costs[j - 1]] + 1);
                }
            }
        }
        return dp[coins];
    }

    public static void main(String[] args) {
        int[] costs = new int[]{1, 6, 3, 1, 2, 5};
        int coins = 20;
        Leecode1883 leecode1883 = new Leecode1883();
        System.out.println(leecode1883.maxIceCreamSimple(costs, coins));
        System.out.println(leecode1883.maxIceCream1(costs, coins));
    }


}
