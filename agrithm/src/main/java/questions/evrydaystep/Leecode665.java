package questions.evrydaystep;
/**
 * 给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
 *
 * 我们是这样定义一个非递减数列的： 对于数组中所有的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [4,2,3]
 * 输出: true
 * 解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
 * 示例 2:
 *
 * 输入: nums = [4,2,1]
 * 输出: false
 * 解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
 *  
 *
 * 说明：
 *
 * 1 <= n <= 10 ^ 4
 * - 10 ^ 5 <= nums[i] <= 10 ^ 5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/non-decreasing-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class Leecode665 {
    public boolean checkPossibility(int[] nums) {
       int len =nums.length;
       int change =0;
      for(int i=1;i<len-1;i++){
          if(nums[i]>nums[i-1] && nums[i]>nums[i+1]){
              if(i-1==0){
                  nums[i]=nums[i-1];
                  change++;

              }else {
                  nums[i+1]=nums[i];
                  change++;
              }

          }
          if(nums[i]<nums[i-1] && nums[i]<nums[i+1]){
              if(nums[i+1]>=nums[i-1]){
                  nums[i]=nums[i-1];
                  change++;
              }else if(nums[i+1]>=nums[i]){
                  nums[i-1]=nums[i]-1;
                  change++;
              }else  {
                  return false;
              }
          }
          if(nums[i]>nums[i-1] && nums[i]<nums[i+1]){
            continue;
          }
          if(nums[i]<nums[i-1] && nums[i]>=nums[i+1]){
              return false;
          }
          if(change>1) break;
      }

      return change<=1?true:false;
    }
    public boolean checkPossibilityForVersion1(int[] nums) {
        //如果发现了一个不符合递增的时候，妖魔调整前面的变小，妖魔调整后面的变成大 ，然后判断是否符合结果
        int len = nums.length;
        int changeNum=0;
        for(int i=0;i<len-1;i++){
            int before = nums[i];
            int after = nums[i+1];
            if(before>after){
                changeNum++;
                nums[i] = after;
               boolean tep= isInOrder(nums);
               if(tep){
                   return true;
               }
                nums[i]=before;
                nums[i+1]=before;
                return isInOrder(nums);
            }
            if(changeNum>1) break;
        }

        return changeNum<=1?true:false;
    }

    private boolean isInOrder(int[] nums) {
        for(int i=1;i<nums.length;i++){
            if(nums[i]-nums[i-1]<0)return false;
        }
        return true;
    }

    public static void main(String[] args) {
      //  int[] num = new int[]{3,4,2,3};
    //    int[] num = new int[]{4,2,3};
   //     int[] num = new int[]{-1,4,2,3};
    //    int[] num = new int[]{2,3,3,2,2};
        int[] num = new int[]{5,7,1,8};
        Leecode665 leecode665 = new Leecode665();
        System.out.println(leecode665.checkPossibility(num));
    }
}
