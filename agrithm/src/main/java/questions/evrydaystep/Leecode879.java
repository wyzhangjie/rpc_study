package questions.evrydaystep;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * 879. 盈利计划
 * 集团里有 n 名员工，他们可以完成各种各样的工作创造利润。
 * <p>
 * 第 i 种工作会产生 profit[i] 的利润，它要求 group[i] 名成员共同参与。如果成员参与了其中一项工作，就不能参与另一项工作。
 * <p>
 * 工作的任何至少产生 minProfit 利润的子集称为 盈利计划 。并且工作的成员总数最多为 n 。
 * <p>
 * 有多少种计划可以选择？因为答案很大，所以 返回结果模 10^9 + 7 的值。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 5, minProfit = 3, group = [2,2], profit = [2,3]
 * 输出：2
 * 解释：至少产生 3 的利润，该集团可以完成工作 0 和工作 1 ，或仅完成工作 1 。
 * 总的来说，有两种计划。
 * 示例 2：
 * <p>
 * 输入：n = 10, minProfit = 5, group = [2,3,5], profit = [6,7,8]
 * 输出：7
 * 解释：至少产生 5 的利润，只要完成其中一种工作就行，所以该集团可以完成任何工作。
 * 有 7 种可能的计划：(0)，(1)，(2)，(0,1)，(0,2)，(1,2)，以及 (0,1,2) 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 100
 * 0 <= minProfit <= 100
 * 1 <= group.length <= 100
 * 1 <= group[i] <= 100
 * profit.length == group.length
 * 0 <= profit[i] <= 100
 * 通过次数6,208提交次数12,765
 */
public class Leecode879 {

    int result = 0;
    int minProfit1;
    int[] group1;
    int[] profit1;
    HashMap<String, Boolean> map = new HashMap<>();

    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        minProfit1 = minProfit;
        group1 = group;
        profit1 = profit;
        TreeSet<Integer> posContain = new TreeSet<Integer>();

        subPro(n, 0, 0, map, posContain);
        return result;
    }

    private void subPro(int n, int curProfit, int i, Map<String, Boolean> map, TreeSet<Integer> posContain) {
        if (i == profit1.length || n<0 ) {
            if (n >= 0 && curProfit >= minProfit1) {
                if (posContain.size() >= 1 && map.get(posContain.toString()) == null) {
                    map.put(posContain.toString(), true);
                    result = result % (10 ^ 9 + 7) + 1;
                }
            }
            return ;
        }

        for(int j=i;j<group1.length;j++){
            //参与
            posContain.add(j);
            subPro(n - group1[j], curProfit + profit1[j], i + 1, map, posContain);

            //不参与
            posContain.remove(j);
            subPro(n + group1[j], curProfit - profit1[j], i + 1, map, posContain);

        }


    }


    public int profitableSchemes2(int n, int minProfit, int[] group, int[] profit) {
      int[][][] dp = new int[group.length+1][n+1][minProfit+1];
      dp[0][0][0]=1;
      for(int i=1;i<=group.length;i++){
          int preGroup=group[i-1];
          int preProfit=profit[i-1];
          for(int z=0;z<=n;z++){
              for(int j=0;j<=minProfit;j++){
                  if(z<preGroup){
                      dp[i][z][j]=dp[i-1][z][j];
                  }else {
                      dp[i][z][j]=(dp[i-1][z][j]+ dp[i-1][z-preGroup][Math.max(0,j-preProfit)])%((int)1e9 + 7);
                  }
              }
          }
      }
      int sum=0;
      for(int j=0;j<=n;j++){
          sum=(sum+dp[group.length][j][minProfit])%((int)1e9 + 7);
      }
      return sum;

    }


    public int profitableSchemes3(int n, int minProfit, int[] group, int[] profit) {
        int len = group.length, MOD = (int)1e9 + 7;
        int[][][] dp = new int[len + 1][n + 1][minProfit + 1];
        dp[0][0][0] = 1;
        for (int i = 1; i <= len; i++) {
            int members = group[i - 1], earn = profit[i - 1];
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k <= minProfit; k++) {
                    if (j < members) {
                        dp[i][j][k] = dp[i - 1][j][k];
                    } else {
                        dp[i][j][k] = (dp[i - 1][j][k] + dp[i - 1][j - members][Math.max(0, k - earn)]) % MOD;
                    }
                }
            }
        }
        int sum = 0;
        for (int j = 0; j <= n; j++) {
            sum = (sum + dp[len][j][minProfit]) % MOD;
        }
        return sum;
    }


    public static void main(String[] args) {
        /**
         *1
         * 1
         * [2,2,2,2,2]
         * [1,2,1,1,0]
         * */
        int[] group = new int[]{2,2};
        int[] profit = new int[]{2,3};
        Leecode879 leecode879 = new Leecode879();

        System.out.println(leecode879.profitableSchemes(5, 3, group, profit));
        System.out.println(leecode879.profitableSchemes2(5, 3, group, profit));


    }
}
