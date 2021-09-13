package questions.evrydaystep;


import java.util.Stack;

/**
 *
 * 456. 132模式
 * 给你一个整数数组 nums ，数组中共有 n 个整数。132 模式的子序列 由三个整数 nums[i]、nums[j] 和 nums[k] 组成，并同时满足：i < j < k 和 nums[i] < nums[k] < nums[j] 。
 *
 * 如果 nums 中存在 132 模式的子序列 ，返回 true ；否则，返回 false 。
 *
 *
 *
 * 进阶：很容易想到时间复杂度为 O(n^2) 的解决方案，你可以设计一个时间复杂度为 O(n logn) 或 O(n) 的解决方案吗？
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：false
 * 解释：序列中不存在 132 模式的子序列。
 * 示例 2：
 *
 * 输入：nums = [3,1,4,2]
 * 输出：true
 * 解释：序列中有 1 个 132 模式的子序列： [1, 4, 2] 。
 * 示例 3：
 *
 * 输入：nums = [-1,3,2,0]
 * 输出：true
 * 解释：序列中有 3 个 132 模式的的子序列：[-1, 3, 2]、[-1, 3, 0] 和 [-1, 2, 0] 。
 *
 *
 * 提示：
 *
 * n == nums.length
 * 1 <= n <= 104
 * -109 <= nums[i] <= 109
 * */
public class Leecode456 {
    Stack<Integer> stack=new Stack<>();
    public boolean find132pattern(int[] nums) {
        int len =nums.length;
        if(len<3){
            return false;
        }
        int leftMin = nums[0];
        for(int i=1;i<len-1;i++){
            for(int j=i+1;j<len;j++){
                if(nums[i]>leftMin && leftMin<nums[j] && nums[i]>nums[j]){
                    return true;
                }
            }
            if(nums[i]<leftMin){
                leftMin=nums[i];
            }
        }
        return false;
    }

    //单调栈
    public boolean find132patternMethod2(int[] nums) {
        int len =nums.length;
        if(len<3){
            return false;
        }
       //第一步找到任何位置，它最左面的最小值
        int[] leftMin = new int[len];
        leftMin[0]=nums[0];
        for(int i=1;i<len;i++){
            leftMin[i]=Math.min(leftMin[i-1],nums[i-1]);
        }
        for(int j=len-1;j>0;j--){
            int rightMin=-500;
            while (!stack.empty() &&stack.peek()<nums[j]){
                rightMin=  stack.pop();
            }
            if(rightMin!=-500){
                if(leftMin[j]<rightMin && rightMin<nums[j]){
                    return true;
                }
            }
            stack.push(nums[j]);

        }
        return false;

    }

    public static void main(String[] args) {
        int[] nums = {1,3,2,4,5,6,7,8,9,10};
        Leecode456 leecode456 = new Leecode456();
        System.out.println(leecode456.find132pattern(nums));
        System.out.println(leecode456.find132patternMethod2(nums));
    }
    

}
