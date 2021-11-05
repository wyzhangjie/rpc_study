package questions.evrydaystep;

public class Leecode673 {
    public int findNumberOfLIS(int[] nums) {

        int[] dp = new int[nums.length];
       // int[] lens= new int[nums.length];
        int[] num = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            dp[i]=1;
          //  lens[i]=1;
            num[i]=1;
        }
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){

                   if(dp[i]<=dp[j]+1){
                       dp[i]=Math.max(dp[i],dp[j]+1);
                       if(dp[i]>(dp[j]+1)){

                           num[i]=num[j];
                       }else if(dp[i]==(dp[j]+1)){
                           num[i]+=num[j];
                       }
                   }

                }
            }
        }
        int max=-1;
        int len=0;
        for(int i=0;i<num.length;i++){
            if(dp[i]>max){
                len=num[i];
                max=dp[i];
            }else if(dp[i]==max){
                len+=num[i];
            }
        }
        return len;

    }

    public static void main(String[] args) {
        //[1,2,4,3,5,4,7,2]
        //[1,2,3,1,2,3,1,2,3]
        int[] nums = new int[]{2,2,2,2,2};
        Leecode673 leecode673 = new Leecode673();
        System.out.println(leecode673.findNumberOfLIS(nums));

    }
}
