package questions.evrydaystep;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 *
 * 219. 存在重复元素 II
 * 给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，满足 nums[i] == nums[j] 且 abs(i - j) <= k 。如果存在，返回 true ；否则，返回 false 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3,1], k = 3
 * 输出：true
 * 示例 2：
 *
 * 输入：nums = [1,0,1,1], k = 1
 * 输出：true
 * 示例 3：
 *
 * 输入：nums = [1,2,3,1,2,3], k = 2
 * 输出：false
 *
 *
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * 0 <= k <= 105
 * */
public class Leecode219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int len = nums.length;
        if(len<=0){
            return false;
        }
        int i=0;
        int j=1;
        while (i<len){
            j=i+1;
            while (j<len && j-i<=k){
                if(nums[j]==nums[i]){
                    return true;
                }else {
                    j++;
                }
            }
            i++;
        }
        return false;

    }

    public boolean containsNearbyDuplicate1(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        int len = nums.length;

        for(int i=0;i<len;i++){
            if(set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);
            if(set.size()>k){
                set.remove(nums[i-k]);
            }
        }
        return false;


    }



    public static void main(String[] args) {
        //[1,2,3,4,5,6,7,8,9,9]
        //3
        int[] nums = {1,2,3,4,5,6,7,8,9,9};
        int k = 3;
        Leecode219 leecode219 = new Leecode219();
        System.out.println(leecode219.containsNearbyDuplicate1(nums,k));
    }
}
