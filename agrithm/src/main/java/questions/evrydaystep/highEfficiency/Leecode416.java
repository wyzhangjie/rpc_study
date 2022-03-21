package questions.evrydaystep.highEfficiency;/**
 * ClassName Leecode416
 * Description
 * Create by jie.zhang02
 * Date 2022/3/1 4:12 下午
 */

import java.util.Arrays;

/**
 * @author jie.zhang
 * @date 2022年03月01日 4:12 下午
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 100
 */
public class Leecode416 {
    public boolean canPartition(int[] nums) {
    int sum=0;
    int maxEtem  =0;
    for(int a:nums){
        sum+=a;
        maxEtem=Math.max(maxEtem,a);
    }
    int target=sum/2;
    if(sum%2!=0){
        return false;
    }
    if(maxEtem>target){
        return false;
    }

    boolean[] dp = new boolean[target+1];
    dp[0]=true;
    for(int num:nums){
        for(int i=target;i>=1;i--){
            if(i>=num){
                dp[i]|=dp[i-num];
            }
        }
    }
    return dp[target];

    }


    public static void main(String[] args) {
        int[] num ={1,2,5};
        Leecode416 leecode416 = new Leecode416();
        System.out.println(leecode416.canPartition(num));

    }
}
