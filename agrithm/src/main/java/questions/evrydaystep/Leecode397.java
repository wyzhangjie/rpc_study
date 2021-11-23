package questions.evrydaystep;

import java.util.HashMap;
import java.util.Map;

public class Leecode397 {
    public int integerReplacement(int n) {
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        int[] dp = new int[3];

        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 2;

        for (int i = 4; i <= n + 1; i++) {
            //偶数
            if (i % 2 == 0) {
                if ((i / 2) % 2 != 0) {
                    dp[i / 2] = Math.min(dp[i / 2 + 1], dp[i / 2 - 1]) + 1;
                }
                dp[i] = dp[i / 2] + 1;

            }
        }


        if (n % 2 != 0) {
            dp[n] = Math.min(dp[n - 1], dp[n + 1]) + 1;
        }
        return dp[n];
    }


    public int integerReplacement1(int n) {
        Map<Long,Integer> mem = new HashMap<>();
        return dfs(n,mem);
    }

    private int dfs(long n,Map<Long,Integer> mem) {
        if (n == 1) {
            return 0;
        }
        if(mem.containsKey(n)){
            return mem.get(n);
        }
        int ans=0;

        if (n % 2 == 0) {
            ans= dfs(n / 2,mem) + 1;
        }else {
            ans= Math.min(dfs(n  + 1,mem), dfs(n  - 1,mem)) + 1;
        }

        mem.put(n,ans);
        return ans;

    }

    public static void main(String[] args) {
        int n = 8;
        Leecode397 leecode397 = new Leecode397();
        System.out.println(leecode397.integerReplacement1(8));
    }
}
