package questions.evrydaystep;

import java.util.HashMap;
import java.util.Map;

/**
 * 一只青蛙想要过河。 假定河流被等分为若干个单元格，并且在每一个单元格内都有可能放有一块石子（也有可能没有）。 青蛙可以跳上石子，但是不可以跳入水中。
 * <p>
 * 给你石子的位置列表 stones（用单元格序号 升序 表示）， 请判定青蛙能否成功过河（即能否在最后一步跳至最后一块石子上）。
 * <p>
 * 开始时， 青蛙默认已站在第一块石子上，并可以假定它第一步只能跳跃一个单位（即只能从单元格 1 跳至单元格 2 ）。
 * <p>
 * 如果青蛙上一步跳跃了 k 个单位，那么它接下来的跳跃距离只能选择为 k - 1、k 或 k + 1 个单位。 另请注意，青蛙只能向前方（终点的方向）跳跃。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：stones = [0,1,3,5,6,8,12,17]
 * 输出：true
 * 解释：青蛙可以成功过河，按照如下方案跳跃：跳 1 个单位到第 2 块石子, 然后跳 2 个单位到第 3 块石子, 接着 跳 2 个单位到第 4 块石子, 然后跳 3 个单位到第 6 块石子, 跳 4 个单位到第 7 块石子, 最后，跳 5 个单位到第 8 个石子（即最后一块石子）。
 * 示例 2：
 * <p>
 * 输入：stones = [0,1,2,3,4,8,9,11]
 * 输出：false
 * 解释：这是因为第 5 和第 6 个石子之间的间距太大，没有可选的方案供青蛙跳跃过去。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/frog-jump
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leecode403 {
    //某个位置有第几个石子
    Map<Integer, Integer> map = new HashMap<>();

    Map<String, Boolean> cache = new HashMap<>();


    public boolean canCross(int[] stones) {

        for (int i = 0; i < stones.length; i++) {
            map.put(stones[i], i);
        }
        if (!map.containsKey(1)) {
            return false;
        }
        if (!map.containsKey(0)) {
            return false;
        }
        return canCrossRecurse(stones, stones.length, 1, 1);
    }

    /**
     * pos当前是第几个石子
     */
    private Boolean canCrossRecurse(int[] stones, int length, int pos, int preStep) {
        if (length - 1 == pos) {
            return true;
        }
        for (int i = -1; i <= 1; i++) {
            if (preStep + i > 0) {
                int next = stones[pos] + preStep + i;
                if (map.containsKey(next)) {
                    boolean cur = canCrossRecurse(stones, length, map.get(next), preStep + i);
                    if (cur) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean canCrossV2(int[] stones) {
        for (int i = 0; i < stones.length; i++) {
            map.put(stones[i], i);
        }
        if (!map.containsKey(1)) {
            return false;
        }
        if (!map.containsKey(0)) {
            return false;
        }
        return dfsV2(stones, stones.length, 1, 1);
    }

    /**
     * pos当前是第几个石子
     */
    private Boolean dfsV2(int[] stones, int length, int pos, int preStep) {
        String key = pos + "_" + preStep;
        if (length - 1 == pos) {
            return true;
        }
        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        for (int i = -1; i <= 1; i++) {
            if (preStep + i > 0) {
                int next = stones[pos] + preStep + i;
                if (map.containsKey(next)) {
                    boolean cur = dfsV2(stones, length, map.get(next), preStep + i);
                    cache.put(key, cur);
                    if (cur) {

                        return true;
                    }
                }
            }
        }
        cache.put(key, false);
        return false;
    }


    public boolean canCrossV3(int[] ss) {
        int n = ss.length;
        for (int i = 0; i < n; i++) {
            map.put(ss[i], i);
        }
        // check first step
        if (!map.containsKey(1)) return false;
        return dfs(ss, ss.length, 1, 1);
    }

    boolean dfs(int[] ss, int n, int u, int k) {
        String key = u + "_" + k;
        // if (cache[u][k] != 0) return cache[u][k] == 1;
        if (cache.containsKey(key)) return cache.get(key);
        if (u == n - 1) return true;
        for (int i = -1; i <= 1; i++) {
            if (k + i == 0) continue;
            int next = ss[u] + k + i;
            if (map.containsKey(next)) {
                boolean cur = dfs(ss, n, map.get(next), k + i);
                // cache[u][k] = cur ? 1 : -1;
                cache.put(key, cur);
                if (cur) return true;
            }
        }
        // cache[u][k] = -1;
        cache.put(key, false);
        return false;
    }


    public boolean canCrossV4(int[] stones) {
        int len = stones.length;
        if (stones[1] != 1) {
            return false;
        }
        //语义：位置i 步长是j的时候有没有可以到达的路径，有就有true,没有返回false
        Boolean[][] dp = new Boolean[len][len];
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                dp[i][j]=false;
            }
        }
        dp[0][0] = true;
        for (int i = 1; i < len; i++) {
            for (int j = i-1; j >=0; j--) {
                int curLen = stones[i] - stones[j];
                if(curLen>j+1){
                    break;
                }
                dp[i][curLen] = dp[j][curLen - 1] || dp[j][curLen] || dp[j][curLen + 1];
                if(i==len-1 && dp[i][curLen]){
                    return true;
                }
            }

        }

        return false;
    }

    public static void main(String[] args) {
        int[] stones = new int[]{0,1,2,3,4,8,9,11};
        Leecode403 leecode403 = new Leecode403();
        System.out.println(leecode403.canCrossV4(stones));
    }


}
