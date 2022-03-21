package questions.evrydaystep.weekcompetation;/**
 * ClassName Leecode2183
 * Description
 * Create by jie.zhang02
 * Date 2022/2/25 11:10 上午
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author jie.zhang
 * @date 2022年02月25日 11:10 上午
 */
public class Leecode2183 {
    public long countPairs(int[] nums, int k) {
        int len =nums.length;
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]%k==0){
                list.add(len-i-1);
            }

        }
        int sum=0;
        for(Integer a:list){
            sum+=a;
        }
        return sum;
    }

    public static void main(String[] args) {
      int[]  nums = new int[]{1,2,3,4,5};
      int k = 2;
        Leecode2183 leecode2183 = new Leecode2183();
        System.out.println(leecode2183.countPairs(nums,k));
    }
}
