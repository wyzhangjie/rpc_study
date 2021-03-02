package questions.evrydaystep;

public class Leecode1004 {

    public int longestOnes(int[] nums, int K) {
        int max=0;

        int left=0;
        int right=0;
        int len =nums.length;
        int change =0;
        while(right<len){
           if(nums[right]==0){
               change++;
               if(change<=K){
                   right++;
               }else {
                   while (nums[left]!=0){
                       left++;
                   }
                   change--;
                   left++;
                   right++;
               }
               max =Math.max(max,right-left);
           }else {
               right++;
               max =Math.max(max,right-left);
           }
        }
        return max;
    }

    public static void main(String[] args) {
        //A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
        int[] nums = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        Leecode1004 leecode1004 = new Leecode1004();
        System.out.println(leecode1004.longestOnes(nums,3));
    }
}
