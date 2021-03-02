package questions.evrydaystep;

public class Leecode303 {
    private int[] nums;

    public Leecode303(int[] nums) {
        this.nums= nums;
    }

    public int sumRange(int i, int j) {
        int[] subSum= getAllSubNums(nums);
        if(i==0){
            return subSum[j];
        }else {
            return subSum[j]-subSum[i-1];
        }

    }

    private int[] getAllSubNums(int[] nums) {
        int[] subSum= new int[nums.length];
        int len = nums.length;
        subSum[0]=nums[0];
        for(int i=1;i<len;i++){
            subSum[i]=nums[i]+subSum[i-1];
        }
        return subSum;
    }

    public static void main(String[] args) {
        //["NumArray","sumRange","sumRange","sumRange"]
        //[[[-2,0,3,-5,2,-1]],[0,2],[2,5],[0,5]]
        int[] nums ={-2, 0, 3, -5, 2, -1};
        Leecode303 leecode303 = new Leecode303(nums);
        System.out.println(leecode303.sumRange(0,5));
    }
}
