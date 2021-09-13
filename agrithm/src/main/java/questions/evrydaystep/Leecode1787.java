package questions.evrydaystep;

/**
 *
 *
 *
 *
 *
 *
 *
 * 没思路，未完成！！！！！！！！！！！！！
 *
 *
 *
 *
 * 1787. 使所有区间的异或结果为零
 * 给你一个整数数组 nums​​​ 和一个整数 k​​​​​ 。区间 [left, right]（left <= right）的 异或结果 是对下标位于 left 和 right（包括 left 和 right ）之间所有元素进行 XOR 运算的结果：nums[left] XOR nums[left+1] XOR ... XOR nums[right] 。
 * <p>
 * 返回数组中 要更改的最小元素数 ，以使所有长度为 k 的区间异或结果等于零。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,0,3,0], k = 1
 * 输出：3
 * 解释：将数组 [1,2,0,3,0] 修改为 [0,0,0,0,0]
 * 示例 2：
 * <p>
 * 输入：nums = [3,4,5,2,1,7,3,4,7], k = 3
 * 输出：3
 * 解释：将数组 [3,4,5,2,1,7,3,4,7] 修改为 [3,4,7,3,4,7,3,4,7]
 * 示例 3：
 * <p>
 * 输入：nums = [1,2,4,1,2,5,1,2,6], k = 3
 * 输出：3
 * 解释：将数组[1,2,4,1,2,5,1,2,6] 修改为 [1,2,3,1,2,3,1,2,3]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= nums.length <= 2000
 * ​​​​​​0 <= nums[i] < 210
 * 通过次数3,734提交次数6,246
 */
public class Leecode1787 {
    int result = Integer.MAX_VALUE;

    public int minChanges(int[] nums, int k) {
        int len = nums.length;
        int group = len / k;
        minChange(nums, group, 0, 0, k, -1);
        return result;
    }

    /**
     * sum:所有满足条件的情况下一共修改了多少次
     */
    private void minChange(int[] nums, int group, int subGroup, int sum, int k, int delever) {


        if(subGroup==group){
            result = Math.min(result, sum);
            return;
        }
        for (int i = subGroup * k + 0; i < subGroup * k + k; i++) {
            int getOne = 0;
            for (int j = subGroup * k + 0; j < subGroup * k + k; j++) {
                if (i != j) {
                    getOne ^= nums[j];
                }
            }
            if (delever != -1) {
                if (delever == getOne) {
                    minChange(nums, group, subGroup + 1, sum++, k, delever);
                } else {
                    minChange(nums, group, subGroup + 1, sum, k, getOne);
                }
            } else {
                minChange(nums, group, subGroup + 1, sum+1, k, getOne);
            }
        }

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,0,3,0};
        Leecode1787 leecode1787 = new Leecode1787();
        System.out.println(leecode1787.minChanges(nums,1));
    }
}
