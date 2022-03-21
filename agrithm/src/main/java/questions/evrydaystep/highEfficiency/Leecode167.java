package questions.evrydaystep.highEfficiency;/**
 * ClassName Leecode167
 * Description
 * Create by jie.zhang02
 * Date 2022/2/25 2:27 下午
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jie.zhang
 * @date 2022年02月25日 2:27 下午
 */
public class Leecode167 {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
      for(int i=0;i<nums.length;i++) {
          if (map.containsKey(target - nums[i])) {
              int a=i + 1;
              int b=map.get(target - nums[i]) + 1;
              result = new int[]{ a, b} ;
              return result;
          }else {
              map.put(nums[i],i);
          }
      }
        return  result;

    }
    public static void main(String[] args) {
        int[]  nums = new int[] {2,7,11,15};
        int target = 9;
        Leecode167 leecode1 = new Leecode167();
        int[] result =leecode1.twoSum(nums,target);
        for(int a:result){
            System.out.println(a);
        }
    }


}
