package questions.evrydaystep.highEfficiency;/**
 * ClassName Leecode1
 * Description
 * Create by jie.zhang02
 * Date 2022/2/25 2:07 下午
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jie.zhang
 * @date 2022年02月25日 2:07 下午
 */
public class Leecode1 {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i=0;i<nums.length;i++) {
            List<Integer> list = map.getOrDefault(nums[i], new ArrayList<>());
            list.add(i);
            map.putIfAbsent(nums[i], list);
        }

        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()){
            if(map.containsKey(target-entry.getKey())){
                List<Integer> result1=map.get(entry.getKey());
               List<Integer> result2=map.get(target-entry.getKey());

               for(Integer a:result1){
                   for(Integer b:result2){
                       if(!a.equals(b)){
                           result=new int[]{a,b};
                           break;
                       }
                   }
               }
            }

        }
        return  result;

    }

    public static void main(String[] args) {
      int[]  nums = new int[] {2,7,11,15};
      int target = 9;
        Leecode1 leecode1 = new Leecode1();
        int[] result =leecode1.twoSum(nums,target);
        for(int a:result){
            System.out.println(a);
        }
    }
}
