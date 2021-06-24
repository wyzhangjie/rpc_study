package questions;

import java.util.HashMap;
import java.util.Map;

/**
 * 1269. 停在原地的方案数
 * 有一个长度为 arrLen 的数组，开始有一个指针在索引 0 处。
 * <p>
 * 每一步操作中，你可以将指针向左或向右移动 1 步，或者停在原地（指针不能被移动到数组范围外）。
 * <p>
 * 给你两个整数 steps 和 arrLen ，请你计算并返回：在恰好执行 steps 次操作以后，指针仍然指向索引 0 处的方案数。
 * <p>
 * 由于答案可能会很大，请返回方案数 模 10^9 + 7 后的结果。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：steps = 3, arrLen = 2
 * 输出：4
 * 解释：3 步后，总共有 4 种不同的方法可以停在索引 0 处。
 * 向右，向左，不动
 * 不动，向右，向左
 * 向右，不动，向左
 * 不动，不动，不动
 * 示例  2：
 * <p>
 * 输入：steps = 2, arrLen = 4
 * 输出：2
 * 解释：2 步后，总共有 2 种不同的方法可以停在索引 0 处。
 * 向右，向左
 * 不动，不动
 * 示例 3：
 * <p>
 * 输入：steps = 4, arrLen = 2
 * 输出：8
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= steps <= 500
 * 1 <= arrLen <= 10^6
 */

public class Leecode1269 {
    private final int a = 1000000007;

    public int numWays(int steps, int arrLen) {
        Map<String, Integer> map = new HashMap<>();
        return dfsNew(steps, arrLen, 0, map);
        //   return dfs(steps,arrLen,0);
    }

    private int dfs(int steps, int arrLen, int index) {
        if (steps == 0) {
            return index == 0 ? 1 : 0;
        }

        int result = 0;
        if (index > 0) {
            result += dfs(steps - 1, arrLen, index - 1) % a;
        }

        if (index < arrLen - 1) {
            result += dfs(steps - 1, arrLen, index + 1) % a;
        }
        result += dfs(steps - 1, arrLen, index) % a;
        return (int) (result % a);

    }
/**
 * 添加备注
 *
 * 执行用时：
 * 343 ms
 * , 在所有 Java 提交中击败了
 * 5.26%
 * 的用户
 * 内存消耗：
 * 57.5 MB
 * , 在所有 Java 提交中击败了
 * 5.26%
 * 的用户
 *
 * */
    private int dfsNew(int steps, int arrLen, int index, Map<String, Integer> map) {
        //走完全程了，发现走到了原点，记录一次结果
        if (steps == 0) {
            return index == 0 ? 1 : 0;
        }
        String key = steps + "*" + index;
        if (map.containsKey(key)) {
            return map.get(key);
        }

        long result = 0;
        if (index > 0) {
            result += dfsNew(steps - 1, arrLen, index - 1, map) % a;
        }

        if (index < arrLen - 1) {
            result += dfsNew(steps - 1, arrLen, index + 1, map) % a;
        }
        result += dfsNew(steps - 1, arrLen, index, map) % a;
        result = result % a;
        map.put(key, (int)result);
        return (int)result;
    }


    public static void main(String[] args) {
        Leecode1269 leecode1269 = new Leecode1269();
        System.out.println(leecode1269.numWays(27, 7));
    }
}
