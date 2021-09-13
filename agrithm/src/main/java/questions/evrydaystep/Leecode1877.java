package questions.evrydaystep;

import java.util.Arrays;

public class Leecode1877 {
    public int minPairSum(int[] nums) {
        int max = Integer.MIN_VALUE;
        Arrays.sort(nums);
        for(int i=0,j=nums.length-1;i<j;i++,j--){
            int sum = nums[i]+nums[j];
            max=Math.max(max,sum);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,5,2,3};
        Leecode1877 leecode1877 = new Leecode1877();
        System.out.println(leecode1877.minPairSum(nums));
    }
}
