package questions.evrydaystep;

import java.util.HashMap;
import java.util.Map;

/**
 * 992. K 个不同整数的子数组
 * 给定一个正整数数组 A，如果 A 的某个子数组中不同整数的个数恰好为 K，则称 A 的这个连续、不一定独立的子数组为好子数组。
 * <p>
 * （例如，[1,2,3,1,2] 中有 3 个不同的整数：1，2，以及 3。）
 * <p>
 * 返回 A 中好子数组的数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = [1,2,1,2,3], K = 2
 * 输出：7
 * 解释：恰好由 2 个不同整数组成的子数组：[1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2].
 * 示例 2：
 * <p>
 * 输入：A = [1,2,1,3,4], K = 3
 * 输出：3
 * 解释：恰好由 3 个不同整数组成的子数组：[1,2,1,3], [2,1,3], [1,3,4].
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 20000
 * 1 <= A[i] <= A.length
 * 1 <= K <= A.length
 * 通过次数8,991提交次数24,5
 */
public class Leecode992 {
    public int subarraysWithKDistinct(int[] A, int K) {
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        map.put(A[0], 1);
        int len = A.length;
        int result = 0;
        while ( true) {
            if(right>len-1 ){
             if(map.size()==K){
                 if(map.size()==K){
                     print(map);
                     result++;
                 }
             }else {
                 break;
             }

            }
           if(map.size()<=K){
               if(map.size()==K){
                   print(map);
                   result++;
               }
               right++;
               if(right<len){
                   if(map.get(A[right]) != null) {
                       int old = map.get(A[right]);
                       map.put(A[right], ++old);

                   } else {
                       map.put(A[right], 1);
                   }
               }

           }else {
            left++;
            right=left;
               map.clear();
               map.put(A[left], 1);
           }


        }
        return result;
    }

    private void print(Map<Integer, Integer> map) {
        map.forEach((a,b)->{
            System.out.print(a+"-->"+b);
        });
        System.out.println();
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 1, 2, 3};
        Leecode992 leecode992 = new Leecode992();
        System.out.println(leecode992.subarraysWithKDistinct(a, 2));
    }
}
