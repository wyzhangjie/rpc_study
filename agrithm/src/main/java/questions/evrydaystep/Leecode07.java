package questions.evrydaystep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * LCP 07. 传递信息
 * 小朋友 A 在和 ta 的小伙伴们玩传信息游戏，游戏规则如下：
 * <p>
 * 有 n 名玩家，所有玩家编号分别为 0 ～ n-1，其中小朋友 A 的编号为 0
 * 每个玩家都有固定的若干个可传信息的其他玩家（也可能没有）。传信息的关系是单向的（比如 A 可以向 B 传信息，但 B 不能向 A 传信息）。
 * 每轮信息必须需要传递给另一个人，且信息可重复经过同一个人
 * 给定总玩家数 n，以及按 [玩家编号,对应可传递玩家编号] 关系组成的二维数组 relation。返回信息从小 A (编号 0 ) 经过 k 轮传递到编号为 n-1 的小伙伴处的方案数；若不能到达，返回 0。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 5, relation = [[0,2],[2,1],[3,4],[2,3],[1,4],[2,0],[0,4]], k = 3
 * <p>
 * 输出：3
 * <p>
 * 解释：信息从小 A 编号 0 处开始，经 3 轮传递，到达编号 4。共有 3 种方案，分别是 0->2->0->4， 0->2->1->4， 0->2->3->4。
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 3, relation = [[0,2],[2,1]], k = 2
 * <p>
 * 输出：0
 * <p>
 * 解释：信息不能从小 A 处经过 2 轮传递到编号 2
 * <p>
 * 限制：
 * <p>
 * 2 <= n <= 10
 * 1 <= k <= 5
 * 1 <= relation.length <= 90, 且 relation[i].length == 2
 * 0 <= relation[i][0],relation[i][1] < n 且 relation[i][0] != relation[i][1]
 * 通过次数13,823提交次数19,543
 */
public class Leecode07 {
    public int numWays(int n, int[][] relation, int k) {
        int destination = n - 1;
        int begin = 0;
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] edge : relation) {
            int pos = edge[0];
            int value = edge[1];
            list.get(pos).add(value);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < relation.length; i++) {
            if (relation[i][0] == 0) {
                queue.add(relation[i][1]);
            }
        }
        int i = 1;
        while (!queue.isEmpty() && i < k) {
            i++;
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                int index = queue.poll();
                List<Integer> list1 = list.get(index);
                for (Integer index1 : list1) {
                    queue.add(index1);
                }
            }
        }
        int ways = 0;
        if (i == k) {
            while (!queue.isEmpty()) {
                if (queue.poll() == destination) {
                    ways++;
                }
            }
        }
        return ways;
    }
    //深度优先搜索

    private int sum=0;
    public int deep(int n, int[][] relation, int k){

        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] edge : relation) {
            int pos = edge[0];
            int value = edge[1];
            list.get(pos).add(value);
        }
        deepSub(list,0,k,0,n);
        return sum;
    }

    private void deepSub(List<List<Integer>> list, int i,int k,int nextIndex,int n) {
        if(i==k){
            if(nextIndex==(n-1) ){
                sum++;
            }
        }else {
            List<Integer> nextIndexs= list.get(nextIndex);
            for(Integer index:nextIndexs){
              deepSub(list,i+1,k,index,n);
            }
        }

    }

    public static void main(String[] args) {
        //输入：n = 5, relation = [[0,2],[2,1],[3,4],[2,3],[1,4],[2,0],[0,4]], k = 3
        //
        //输出：3
        int[][] relation = new int[][]{{0, 2}, {2, 1}, {3, 4}, {2, 3}, {1, 4}, {2, 0}, {0, 4}};
        Leecode07 leecode07 = new Leecode07();
        System.out.println(leecode07.numWays(5, relation, 3));
        System.out.println(leecode07.deep(5, relation, 3));
        test2();
    }

    public static void test1(){
        /**
         * 3
         * [[0,2],[2,1]]
         * 2
         * */

        int[][] nums = new int[][]{{0,2},{2,1}};
        Leecode07 leecode07 = new Leecode07();
        System.out.println(leecode07.numWays(3, nums, 2));

    }

    public static void test2(){
        //3
        //[[0,2],[0,1],[1,2],[2,1],[2,0],[1,0]]
        //1
        int[][] nums = new int[][]{{0,2},{0,1},{1,2},{2,1},{2,0},{1,0}};
        Leecode07 leecode07 = new Leecode07();
        System.out.println(leecode07.numWays(3, nums, 1));

    }
}
