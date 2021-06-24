package questions.evrydaystep;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [0,1]
 * 输出: 2
 * 说明: [0, 1] 是具有相同数量0和1的最长连续子数组。
 * 示例 2:
 *
 * 输入: nums = [0,1,0]
 * 输出: 2
 * 说明: [0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数组。
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * nums[i] 不是 0 就是 1
 * 通过次数20,493提交次数40,346
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contiguous-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class Leecode525 {
    public int findMaxLength(int[] nums) {
        int maxLen=0;
        for(int i=0;i<nums.length;i++){
            int zeroNum=0;
            int oneNum=0;
            for(int j=i;j<nums.length;j++){
                if(nums[j]==0){
                    zeroNum++;
                }else {
                    oneNum++;
                }
                if(zeroNum==oneNum){
                    maxLen =Math.max(maxLen,j-i+1);
                }
            }
        }
        return maxLen;


    }
    public int findMaxLength1(int[] nums) {
        int maxLen = 0;
        Map<Integer,Integer> map = new HashMap<>();
        int preSum=0;
        map.put(0,-1);

        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                preSum--;
            }else {
                preSum++;
            }
            if(map.get(preSum)!=null){
                maxLen = Math.max(maxLen,i-map.get(preSum));
            }else {
                map.put(preSum,i);
            }
        }
        return maxLen;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,1};
        Leecode525 leecode525 = new Leecode525();
        System.out.println(leecode525.findMaxLength1(nums));
    }
}
