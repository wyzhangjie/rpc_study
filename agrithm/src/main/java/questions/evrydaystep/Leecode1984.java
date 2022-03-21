package questions.evrydaystep;/**
 * ClassName Leecode1984
 * Description
 * Create by jie.zhang02
 * Date 2022/2/11 10:43 上午
 */

import java.util.Arrays;

/**
 * @author jie.zhang
 * @date 2022年02月11日 10:43 上午
 */
public class Leecode1984 {
    public int minimumDifference(int[] nums, int k) {
        int result=Integer.MAX_VALUE;
        Arrays.sort(nums);
        int left = 0;
        while (left + k-1 < nums.length) {

        result=Math.min(result,nums[left+k-1]-nums[left]);
        left++;
        }
        return result;
    }

    public static void main(String[] args) {
      int[]  nums = new int[]{9,4,1,7};
     int k = 2;
        Leecode1984 leecode1984 = new Leecode1984();
        System.out.println(leecode1984.minimumDifference(nums,k));
    }
}
