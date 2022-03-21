package questions.evrydaystep.highEfficiency;/**
 * ClassName Leecode56
 * Description
 * Create by jie.zhang02
 * Date 2022/3/1 2:55 下午
 */

/**
 * @author jie.zhang
 * @date 2022年03月01日 2:55 下午
 */
public class Leecode56 {
    public int maxSubArray(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int ans=0;
        int result=Integer.MIN_VALUE;

        for(int a:nums){
            if(ans<=0){
                ans=a;
            }else {
                ans+=a;
            }
            result =Math.max(result,ans);
        }
        return result;
    }

    public static void main(String[] args) {
        Leecode56 leecode56 = new Leecode56();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(leecode56.maxSubArray(nums));
    }
}
