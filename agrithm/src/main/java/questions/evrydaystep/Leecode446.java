package questions.evrydaystep;

import java.util.HashMap;
import java.util.Map;

/**
 * 446. 等差数列划分 II - 子序列
 * 给你一个整数数组 nums ，返回 nums 中所有 等差子序列 的数目。
 * <p>
 * 如果一个序列中 至少有三个元素 ，并且任意两个相邻元素之差相同，则称该序列为等差序列。
 * <p>
 * 例如，[1, 3, 5, 7, 9]、[7, 7, 7, 7] 和 [3, -1, -5, -9] 都是等差序列。
 * 再例如，[1, 1, 2, 5, 7] 不是等差序列。
 * 数组中的子序列是从数组中删除一些元素（也可能不删除）得到的一个序列。
 * <p>
 * 例如，[2,5,10] 是 [1,2,1,2,4,1,5,10] 的一个子序列。
 * 题目数据保证答案是一个 32-bit 整数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,4,6,8,10]
 * 输出：7
 * 解释：所有的等差子序列为：
 * [2,4,6]
 * [4,6,8]
 * [6,8,10]
 * [2,4,6,8]
 * [4,6,8,10]
 * [2,4,6,8,10]
 * [2,6,10]
 * 示例 2：
 * <p>
 * 输入：nums = [7,7,7,7,7]
 * 输出：16
 * 解释：数组中的任意子序列都是等差子序列。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1  <= nums.length <= 1000
 * -231 <= nums[i] <= 231 - 1
 */
public class Leecode446 {
    public int numberOfArithmeticSlices(int[] nums) {
        int ans = 0;
        Map<Long, Integer>[] maps = new Map[nums.length];
        for(int i=0;i<nums.length;i++){
            maps[i]= new HashMap<Long, Integer>();

        }
        //i是最后的位置，从i开始往前找 差值相同的位置j
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<i;j++){
                long d = 1L * nums[i] - nums[j];
                int cnt = maps[j].getOrDefault(d,0);
                ans += cnt;
                maps[i].put(d,maps[i].getOrDefault(d, 0) + cnt + 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,4,6,8,10};
        Leecode446 leecode446 = new Leecode446();
        System.out.println(leecode446.numberOfArithmeticSlices(nums));
    }
}
