package questions.evrydaystep;

import java.util.*;

/**
 * 给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 *
 * 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 *
 * 说明:
 * 不允许旋转信封。
 *
 * 示例:
 *
 * 输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * 输出: 3
 * 解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/russian-doll-envelopes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class Leecode354 {
    public int maxEnvelopes(int[][] envelopes) {
       sort(envelopes);
        int len = envelopes.length;
        int max=1;
        int[] result = new int[len];
        Arrays.fill(result,1);
        for(int i=1;i<len;i++){
            for(int j=0;j<i;j++){
                if(envelopes[i][1]>envelopes[j][1]){
                    result[i]=Math.max(result[i],result[j]+1);
                }
            }
            max=Math.max(max,result[i]);
        }
        return max;

    }

    private void sort(int[][] envelopes) {
        Arrays.sort(envelopes, (o1, o2) -> {
            if(o1[0]==o2[0]){
               return o2[1]-o1[1];
            }
            return o1[0]-o2[0];
        });
    }

    private TreeMap<Integer,Integer> transMap(int[][] envelopes) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int i=0;i<envelopes.length;i++){
            map.put(envelopes[i][0],envelopes[i][1]);
        }
        return map;
    }



    public static void main(String[] args) {
        int[][] a = {{1,3},{3,5},{6,7},{6,8},{8,4},{9,5}};
        Leecode354 leecode354 = new Leecode354();
        System.out.println(leecode354.maxEnvelopes(a));
    }
}
