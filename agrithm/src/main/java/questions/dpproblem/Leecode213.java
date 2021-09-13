package questions.dpproblem;

public class Leecode213 {
    public int rob(int[] nums) {
        //带循环的
        int max=0;
        if(nums.length==1){
            return nums[0];
        }
        if(nums.length==2){
            return  Math.max(nums[0],nums[1]);
        }
        int[] dp = new int[nums.length-1];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        //情况1：当取第一个位置的时候，那么最后一个屋子不能算了
        for(int i=2;i<nums.length-1;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
      max = Math.max(max,dp[nums.length-2]);
        //情况2：当不取第一个位置的时候，那么最后一个屋子可以算也可以不算。
        dp = new int[nums.length];
        dp[0]=0;
        dp[1]=nums[1];

        for(int i=2;i<nums.length;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        max= Math.max(max,dp[nums.length-1]);
        return max;

    }




    public int rob1(int[] nums) {
        //带循环的
        int max=0;
        if(nums.length==1){
            return nums[0];
        }
        if(nums.length==2){
            return  Math.max(nums[0],nums[1]);
        }
        int[] dp = new int[3];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        //情况1：当取第一个位置的时候，那么最后一个屋子不能算了
        for(int i=2;i<nums.length-1;i++){
            dp[2]=Math.max(dp[1],dp[0]+nums[i]);
            dp[0]=dp[1];
            dp[1]=dp[2];
        }
        max = Math.max(max,dp[1]);
        //情况2：当不取第一个位置的时候，那么最后一个屋子可以算也可以不算。
        dp[0]=0;
        dp[1]=nums[1];
        dp[2]=0;

        for(int i=2;i<nums.length;i++){
            dp[2]=Math.max(dp[1],dp[0]+nums[i]);
            dp[0]=dp[1];
            dp[1]=dp[2];
        }
        max= Math.max(max,dp[2]);
        return max;

    }
    public static void main(String[] args) {
        int[] nums = new int[]{4,1,2};
        Leecode213 leecode213 = new Leecode213();
        System.out.println(leecode213.rob(nums));
        System.out.println(leecode213.rob1(nums));
    }
}
