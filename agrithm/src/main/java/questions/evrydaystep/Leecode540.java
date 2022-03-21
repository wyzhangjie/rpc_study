package questions.evrydaystep;/**
 * ClassName Leecode540
 * Description
 * Create by jie.zhang02
 * Date 2022/2/14 10:45 上午
 */

/**
 * @author jie.zhang
 * @date 2022年02月14日 10:45 上午
 */
public class Leecode540 {
    public int singleNonDuplicate(int[] nums) {
        int left=0;
        int right =nums.length;
        while (left<right){
            int mid = left+(right-left)/2;
            if(mid%2==0 && (mid+1)<nums.length && nums[mid]==nums[mid+1]){
                left=mid+1;
                continue;
            }
            if(mid%2==1 && (mid-1)>=0 && nums[mid]==nums[mid-1]){
                left=mid+1;
                continue;
            }
            if(mid%2==0 &&(mid-1)>=0 && nums[mid]==nums[mid-1]){
                right=mid-1;
                continue;
            }
            if(mid%2==1 &&(mid+1)<nums.length && nums[mid]==nums[mid+1]){
                right=mid-1;
                continue;
            }else {
                return nums[mid];
            }


        }
        return nums[left];
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,3,3,4,4,8,8};
        Leecode540 leecode540 = new Leecode540();
        System.out.println(leecode540.singleNonDuplicate(nums));
    }
}
