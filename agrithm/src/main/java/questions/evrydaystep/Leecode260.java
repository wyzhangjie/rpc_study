package questions.evrydaystep;

public class Leecode260 {
    public int[] singleNumber(int[] nums) {
        int sum = 0;
        for(int num:nums){
            sum^=num;
        }
        int temp1=0;
        for(int i=31;i>=0;i--){
            if(((sum>>i)&1)==1){
                temp1=i;
                break;
            }
        }
        int[] ans= new int[2];
        for(int num:nums){
            if(((num>>temp1)&1)==1){
                ans[0]^=num;
            }else {
                ans[1]^=num;
            }
        }
        return ans;

    }

    public static void main(String[] args) {
     int[]  nums = new int[]{1,2,1,3,2,5};
        Leecode260 leecode260 = new Leecode260();
        System.out.println(leecode260.singleNumber(nums));
    }
}
