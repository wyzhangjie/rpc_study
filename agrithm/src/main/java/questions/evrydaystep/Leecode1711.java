package questions.evrydaystep;

import java.util.HashMap;
import java.util.Map;

/**
 * 大餐 是指 恰好包含两道不同餐品 的一餐，其美味程度之和等于 2 的幂。
 *
 * 你可以搭配 任意 两道餐品做一顿大餐。
 *
 * 给你一个整数数组 deliciousness ，其中 deliciousness[i] 是第 i​​​​​​​​​​​​​​ 道餐品的美味程度，返回你可以用数组中的餐品做出的不同 大餐 的数量。结果需要对 109 + 7 取余。
 *
 * 注意，只要餐品下标不同，就可以认为是不同的餐品，即便它们的美味程度相同。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：deliciousness = [1,3,5,7,9]
 * 输出：4
 * 解释：大餐的美味程度组合为 (1,3) 、(1,7) 、(3,5) 和 (7,9) 。
 * 它们各自的美味程度之和分别为 4 、8 、8 和 16 ，都是 2 的幂。
 * 示例 2：
 *
 * 输入：deliciousness = [1,1,1,3,3,3,7]
 * 输出：15
 * 解释：大餐的美味程度组合为 3 种 (1,1) ，9 种 (1,3) ，和 3 种 (1,7) 。
 *  
 *
 * 提示：
 *
 * 1 <= deliciousness.length <= 105
 * 0 <= deliciousness[i] <= 220
 * 通过次数15,572提交次数46,418
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-good-meals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class Leecode1711 {

    public int countPairs(int[] deliciousness) {
        //109 + 7
        int inform =  1000000007;
        int result=0;
        int count=0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int dic:deliciousness){
         count=0;
         while (count<22){
             int left= (1<<count)-dic;
             int subResult = map.getOrDefault(left,0);
             result+=subResult;
             if(result>inform){
                 result-=inform;
             }
             count++;
         }
         map.put(dic,map.getOrDefault(dic,0)+1);

        }
        return result;
    }

    public static void main(String[] args) {


        int[]  deliciousness = new int[]{1048576,1048576};
        Leecode1711 leecode1711 = new Leecode1711();
        System.out.println(
                leecode1711.countPairs(deliciousness)
        );
    }
}
