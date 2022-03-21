package questions.evrydaystep;/**
 * ClassName Leecode2001
 * Description
 * Create by jie.zhang02
 * Date 2022/2/9 2:42 下午
 */

import java.util.HashMap;
import java.util.Map;

/**
 * @author jie.zhang
 * @date 2022年02月09日 2:42 下午
 */
public class Leecode2006 {
    public int countKDifference(int[] nums, int k) {
        int ans=0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int num:nums){
            if(map.containsKey(k+num)){
                ans+=map.get(k+num);
            }
            if(map.containsKey(num-k)){
                ans+=map.get(num-k);
            }
            map.put(num,map.getOrDefault(num,0)+1);
        }
        return ans;
    }

    public static void main(String[] args) {
       int[] nums = new int[]{1,2,2,1};
       int k = 1;
        Leecode2006 leecode2006 = new Leecode2006();
        System.out.println(leecode2006.countKDifference(nums,k));
    }
}
