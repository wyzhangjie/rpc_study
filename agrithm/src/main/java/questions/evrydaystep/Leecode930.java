package questions.evrydaystep;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 930. 和相同的二元子数组
 * 给你一个二元数组 nums ，和一个整数 goal ，请你统计并返回有多少个和为 goal 的 非空 子数组。
 *
 * 子数组 是数组的一段连续部分。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,0,1,0,1], goal = 2
 * 输出：4
 * 解释：
 * 如下面黑体所示，有 4 个满足题目要求的子数组：
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * 示例 2：
 *
 * 输入：nums = [0,0,0,0,0], goal = 0
 * 输出：15
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 3 * 104
 * nums[i] 不是 0 就是 1
 * 0 <= goal <= nums.length
 * 通过次数13,333提交次数27,054
 * */
public class Leecode930 {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int result =0;
        int[][] dp=new int[nums.length][nums.length];
        for(int i=0;i<nums.length;i++){
            dp[i][i]=nums[i];
            if(dp[i][i]==goal){
                result++;
            }
            for(int j=i+1;j<nums.length;j++){
                dp[i][j]=dp[i][j-1]+nums[j];
                if(dp[i][j]==goal){
                    result++;
                }
            }
        }
        return result;
    }


    public int numSubarraysWithSum2(int[] nums, int goal) {
        int result =0;
        Map<Integer,Integer> map = new HashMap<>();
        //计算前缀和
        int[] sums = new int[nums.length+1];
        sums[0]=0;
        for(int i=1;i<nums.length+1;i++){
            sums[i]=sums[i-1]+nums[i-1];
        }
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            int tempSum = sums[i+1];
            int backSum = sums[i+1]-goal;
            result+=map.getOrDefault(backSum,0);
            map.put(tempSum,map.getOrDefault(tempSum,0)+1);
        }
        return result;
    }

    public int numSubarraysWithSum3(int[] nums, int goal) {
        int result =0;
        Map<Integer,Integer> map = new HashMap<>();
        //计算前缀和
        int sums=0;

        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            sums+=nums[i];
            int tempSum = sums;
            int backSum = sums-goal;
            result+=map.getOrDefault(backSum,0);
            map.put(tempSum,map.getOrDefault(tempSum,0)+1);
        }
        return result;
    }
    public static void main(String[] args) {
       int[] nums = new int[]{1,0,1,0,1};
       int[] nums2 = new int[]{0,0,0,0,0};
       int goal = 2;
        Leecode930 leecode930 = new Leecode930();
        System.out.println(leecode930.numSubarraysWithSum(nums,goal));
        System.out.println(leecode930.numSubarraysWithSum(nums2,0));
        System.out.println(leecode930.numSubarraysWithSum3(nums,goal));
        System.out.println(leecode930.numSubarraysWithSum3(nums2,0));
    }
}
