package questions.evrydaystep;

public class Leecode1480 {
    public int[] runningSum(int[] nums) {
        int[] result = new int[nums.length];
        result[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            result[i]=result[i-1]+nums[i];
        }
        print(result);
        return  result;
    }

    //原地求和
    public int[] runningSum1(int[] nums) {
        for(int i=1;i<nums.length;i++){
            nums[i]=nums[i-1]+nums[i];
        }
        print(nums);
        return  nums;
    }

    private void print(int[] result) {
        for(int a:result){
            System.out.print(a);
        }
        System.out.println("");
    }

    public static void main(String[] args) {
       int[] nums = new int[]{1,2,3,4};
        Leecode1480 leecode1480 = new Leecode1480();
        System.out.println(leecode1480.runningSum1(nums));
    }
}
