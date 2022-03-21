package questions;

import java.util.Arrays;

public class Leecode1005 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        int sum=0;
        Arrays.sort(nums);

            for(int i=0;i<nums.length;i++){
               if(k>0){
                   if(nums[i]<0){
                       sum+=-nums[i];
                   }else {
                       k=k%2;
                       if(k>0){
                           if(i-1>=0 && nums[i-1]<0 && -nums[i-1]<nums[i]){
                               sum+=2*nums[i-1]+nums[i];
                           }else {
                               sum-=nums[i];
                           }

                       }else {
                           sum+=nums[i];
                       }

                   }
                   k--;
               }else {
                   sum+=nums[i];
               }

            }
            int i = nums.length-1;
        while (k>0){
            sum+=2*nums[i];
            i--;
            k--;
        }
        return sum;
    }

    public static void main(String[] args) {
        //[-4,-2,-3]
        //4
        int[] nums = new int[] {-4,-2,-3};
        int k = 4;
        Leecode1005 leecode1005 = new Leecode1005();
        System.out.println(leecode1005.largestSumAfterKNegations(nums,k));
    }
}
