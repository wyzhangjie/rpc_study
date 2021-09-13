package questions.evrydaystep;

/**
 * 552. 学生出勤记录 II
 * 可以用字符串表示一个学生的出勤记录，其中的每个字符用来标记当天的出勤情况（缺勤、迟到、到场）。记录中只含下面三种字符：
 * 'A'：Absent，缺勤
 * 'L'：Late，迟到
 * 'P'：Present，到场
 * 如果学生能够 同时 满足下面两个条件，则可以获得出勤奖励：
 * <p>
 * 按 总出勤 计，学生缺勤（'A'）严格 少于两天。
 * 学生 不会 存在 连续 3 天或 连续 3 天以上的迟到（'L'）记录。
 * 给你一个整数 n ，表示出勤记录的长度（次数）。请你返回记录长度为 n 时，可能获得出勤奖励的记录情况 数量 。答案可能很大，所以返回对 109 + 7 取余 的结果。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：8
 * 解释：
 * 有 8 种长度为 2 的记录将被视为可奖励：
 * "PP" , "AP", "PA", "LP", "PL", "AL", "LA", "LL"
 * 只有"AA"不会被视为可奖励，因为缺勤次数为 2 次（需要少于 2 次）。
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：3
 * 示例 3：
 * <p>
 * 输入：n = 10101
 * 输出：183236316
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 105
 */
public class Leecode552 {
    final int MOD = 1000000007;

    //方法0 野蛮递归，缺陷，n数量较大，直接栈溢出。
    public int checkRecord(int n) {
        int lateNum = 0;
        int absentNum = 0;
        return dfsNoRecode(n, 0, absentNum, lateNum);
    }

    private int dfsNoRecode(int n, int i, int absentNum, int lateNum) {
        if (i >= n) {
            return 1;
        }
        int ans = 0;
        //当天已经到场了，那么就继续。
        ans = (ans + dfsNoRecode(n, i + 1, absentNum, 0)) % MOD;
        //如果当天缺席了，那么如果之前缺席次数少于1，那么可以继续递归计算，同时连续迟到的次数降为0
        if (absentNum < 1) {
            ans = (ans + dfsNoRecode(n, i + 1, absentNum + 1, 0)) % MOD;
        }
        //如果当天迟到了，那么如果当前迟到连续次数小于2，那么可以继续递归计算，
        if (lateNum < 2) {
            ans = (ans + dfsNoRecode(n, i + 1, absentNum, lateNum + 1)) % MOD;
        }
        return ans;

    }

    //方法1，带备忘录的dfs
    public int checkRecord1(int n) {
        int lateNum = 0;
        int absentNum = 0;
        int[][][] memo = new int[n][2][3];
        return dfsWithRecode(n, 0, absentNum, lateNum, memo);
    }


    private int dfsWithRecode(int n, int i, int absentNum, int lateNum, int[][][] memo) {
        if (i >= n) {
            return 1;
        }
        if (memo[i][absentNum][lateNum] != 0) {
            return memo[i][absentNum][lateNum];
        }
        int ans = 0;
        //如果当天出席了
        ans = (ans + dfsWithRecode(n, i + 1, absentNum, 0, memo)) % MOD;
        //如果当天缺席了，那么如果之前缺席次数少于1，那么可以继续递归计算，同时连续迟到的次数降为0
        if (absentNum < 1) {
            ans = (ans + dfsWithRecode(n, i + 1, absentNum + 1, 0, memo)) % MOD;
        }
        //如果当天迟到了，那么如果当前迟到连续次数小于2，那么可以继续递归计算，
        if (lateNum < 2) {
            ans = (ans + dfsWithRecode(n, i + 1, absentNum, lateNum + 1, memo)) % MOD;
        }
        memo[i][absentNum][lateNum] = ans;
        return ans;
    }

    //带备忘录的递归，转动态规划
    public int checkRecord2(int n) {
        int[][][] memo = new int[n+1][2][3];
        //第一天，不管出席，迟到还是缺席，都会给优秀记上一笔
        memo[0][0][0] = 1;

        for (int day = 1; day <= n; day++) {
            //今天我到场了
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 3; j++) {
                    memo[day][i][0] = (memo[day ][i][0] + memo[day - 1][i][j])% MOD;
                }
            }

            //今天我迟到了
            for (int i = 0; i < 2; i++) {
                for (int j = 1; j <= 2; j++) {
                    memo[day][i][j] = (memo[day][i][j] + memo[day - 1][i][j - 1]) % MOD;
                }
            }

            //今天我缺席了
                for (int j = 0; j <= 2; j++) {
                    memo[day][1][0]=(memo[day][1][0]+memo[day-1][0][j])%MOD;
                }

        }
        int ans = 0;

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                ans = (ans + memo[n ][i][j]) % MOD;
            }
        }

        return ans;
    }

    //带备忘录的递归，转动态规划
    public int checkRecord2_1(int n) {
        int[][] memo = new int[2][3];
        //第一天，不管出席，迟到还是缺席，都会给优秀记上一笔
        memo[0][0] = 1;

            //今天我到场了
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 3; j++) {
                    memo[i][0] = (memo[i][0] + memo[i][j])% MOD;
                }
            }

            //今天我迟到了
            for (int i = 0; i < 2; i++) {
                for (int j = 1; j <= 2; j++) {
                    memo[i][j] = (memo[i][j] + memo[i][j - 1]) % MOD;
                }
            }

            //今天我缺席了
            for (int j = 0; j <= 2; j++) {
                memo[1][0]=(memo[1][0]+memo[0][j])%MOD;
            }

        int ans = 0;

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                ans = (ans + memo[i][j]) % MOD;
            }
        }

        return ans;
    }



    public int checkRecord4(int n) {
        final int MOD = 1000000007;
        int[][][] dp = new int[n + 1][2][3]; // 长度，A 的数量，结尾连续 L 的数量
        dp[0][0][0] = 1;
        for (int i = 1; i <= n; i++) {
            // 以 P 结尾的数量
            for (int j = 0; j <= 1; j++) {
                for (int k = 0; k <= 2; k++) {
                    dp[i][j][0] = (dp[i][j][0] + dp[i - 1][j][k]) % MOD;
                }
            }
            // 以 A 结尾的数量
            for (int k = 0; k <= 2; k++) {
                dp[i][1][0] = (dp[i][1][0] + dp[i - 1][0][k]) % MOD;
            }
            // 以 L 结尾的数量
            for (int j = 0; j <= 1; j++) {
                for (int k = 1; k <= 2; k++) {
                    dp[i][j][k] = (dp[i][j][k] + dp[i - 1][j][k - 1]) % MOD;
                }
            }
        }
        int sum = 0;
        for (int j = 0; j <= 1; j++) {
            for (int k = 0; k <= 2; k++) {
                sum = (sum + dp[n][j][k]) % MOD;
            }
        }
        return sum;
    }




    public static void main(String[] args) {
        int n = 10101;
        Leecode552 leecode552 = new Leecode552();
        System.out.println(leecode552.checkRecord4(n));
        System.out.println(leecode552.checkRecord2_1(n));
    }
}
