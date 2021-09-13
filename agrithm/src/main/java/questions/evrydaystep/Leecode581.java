package questions.evrydaystep;

import java.util.Arrays;

/**
 * 581. 最短无序连续子数组
 * 给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 * <p>
 * 请你找出符合题意的 最短 子数组，并输出它的长度。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,6,4,8,10,9,15]
 * 输出：5
 * 解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：0
 * 示例 3：
 * <p>
 * 输入：nums = [1]
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 104
 * -105 <= nums[i] <= 105
 * <p>
 * <p>
 * 进阶：你可以设计一个时间复杂度为 O(n) 的解决方案吗？
 * <p>
 * 通过次数69,485提交次数182,220
 * 请问您在哪类招聘中遇到此题？
 * 贡献者
 * LeetCode
 * 581/2299
 * <p>
 * 智能模式
 * <p>
 * 模拟面试
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 12345
 * class Solution {
 * public int findUnsortedSubarray(int[] nums) {
 * <p>
 * }
 * }
 * 控制台
 * 贡献
 */
public class Leecode581 {
    public int findUnsortedSubarray(int[] nums) {
        int[] temp = new int[nums.length];
        temp= Arrays.copyOf(nums,nums.length);
        Arrays.sort(temp);
        int beginLeft =-1;
        int endRight=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=temp[i]){
                beginLeft=i;
                break;
            }
        }
        for(int i=nums.length-1;i>=0;i--){
            if(nums[i]!=temp[i]){
                endRight=i;
                break;
            }
        }
        if(beginLeft==-1 || endRight==-1){
            return 0;
        }
        return endRight-beginLeft+1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 6, 4, 8, 10, 9, 15};
        Leecode581 leecode581 = new Leecode581();
        System.out.println(leecode581.findUnsortedSubarray(nums));
        int[] nums1 = new int[]{8,1,3};
        System.out.println(leecode581.findUnsortedSubarray(nums1));
    }
}
