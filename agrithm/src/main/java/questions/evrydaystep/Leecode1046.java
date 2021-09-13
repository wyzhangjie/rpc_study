package questions.evrydaystep;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 有一堆石头，每块石头的重量都是正整数。

 每一回合，从中选出两块 最重的 石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：

 如果 x == y，那么两块石头都会被完全粉碎；
 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。

  

 示例：

 输入：[2,7,4,1,8,1]
 输出：1
 解释：
 先选出 7 和 8，得到 1，所以数组转换为 [2,4,1,1,1]，
 再选出 2 和 4，得到 2，所以数组转换为 [2,1,1,1]，
 接着是 2 和 1，得到 1，所以数组转换为 [1,1,1]，
 最后选出 1 和 1，得到 0，最终数组转换为 [1]，这就是最后剩下那块石头的重量。
  

 提示：

 1 <= stones.length <= 30
 1 <= stones[i] <= 1000

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/last-stone-weight
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class Leecode1046 {

    public int minPatches(Integer[] stones) {
        //从大到小排序
        MyCompare mc = new MyCompare();

        Arrays.sort(stones,mc);


        if(stones.length<2){
            return stones[0];
        }
        //每次取两个互相抵消
        while(stones[0]!=-1 &&stones[1]!=-1 ){
            Integer large = stones[0];
            Integer small = stones[1];
            Integer result = large - small;
            if(result>0){
                stones[0]=-1;
                stones[1]=result;
            }else {
                stones[0]=-1;
                stones[1]=-1;

            }
            Arrays.sort(stones,mc);

        }

        return stones[0]==-1?0:stones[0];
    }
    //外部比较器
    class MyCompare implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            // TODO Auto-generated method stub
            return o1 > o2 ? -1 : (o1 == o2 ? 0 : 1);
        }
    }

    public static void main(String[] args) {
        Leecode1046 leecode330 = new Leecode1046();
        Integer[] a = new Integer[]{2,7,4,1,8,1};
        System.out.println(leecode330.minPatches(a));
    }
}
