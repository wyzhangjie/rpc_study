package questions.evrydaystep;

public class Leecode154 {
    public int findMin(int[] nums) {
        int begin =0;
        int end =nums.length-1;

        if(nums.length==1){
            return nums[0];
        }
        while (begin<end){
            int mid= begin +(end-begin)/2;
            if(nums[mid]==nums[end]){
               end--;

            }else if(nums[mid]<nums[end]){
                end=mid;
            }else {
                begin=mid+1;
            }
        }

        return nums[begin];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,3};
        Leecode154 leecode154 = new Leecode154();
        System.out.println(leecode154.findMin(nums));
        nums = new int[]{3,3,1,3};
        System.out.println(leecode154.findMin(nums));
        nums = new int[]{10,1,10,10,10};
        System.out.println(leecode154.findMin(nums));
        nums = new int[]{10,10,10,10,1};
        System.out.println(leecode154.findMin(nums));
    }
}
