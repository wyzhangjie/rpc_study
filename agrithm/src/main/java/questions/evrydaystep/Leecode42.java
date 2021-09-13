package questions.evrydaystep;
/**
 * 剑指 Offer 42. 连续子数组的最大和
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 *
 * 要求时间复杂度为O(n)。
 *
 *
 *
 * 示例1:
 *
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 *
 * 提示：
 *
 * 1 <= arr.length <= 10^5
 * -100 <= arr[i] <= 100
 *
 * */
public class Leecode42 {
    public int maxSubArray(int[] nums) {

        int left=0;
        int right=0;
        int max=nums[0];
        while (left<right&&right< nums.length-1){
            while (max<max+nums[right] ){

                right++;
            }
            while (max-nums[left]<max+nums[right]){
                left++;
            }

        }
        return 0;

    }


    public int maxSubArray1(int[] nums) {

       int pre=0;
       int max=nums[0];
       for(int num:nums){
           pre = Math.max(pre+num,num);
           max=Math.max(pre,max);
       }
       return max;
    }

    public static void main(String[] args) {
      int[]  nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        Leecode42 leecode42 = new Leecode42();
        System.out.println(leecode42.maxSubArray1(nums));
    }

}
