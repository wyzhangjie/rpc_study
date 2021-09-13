package questions.evrydaystep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 815. 公交路线
 * 给你一个数组 routes ，表示一系列公交线路，其中每个 routes[i] 表示一条公交线路，第 i 辆公交车将会在上面循环行驶。
 *
 * 例如，路线 routes[0] = [1, 5, 7] 表示第 0 辆公交车会一直按序列 1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1 -> ... 这样的车站路线行驶。
 * 现在从 source 车站出发（初始时不在公交车上），要前往 target 车站。 期间仅可乘坐公交车。
 *
 * 求出 最少乘坐的公交车数量 。如果不可能到达终点车站，返回 -1 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：routes = [[1,2,7],[3,6,7]], source = 1, target = 6
 * 输出：2
 * 解释：最优策略是先乘坐第一辆公交车到达车站 7 , 然后换乘第二辆公交车到车站 6 。
 * 示例 2：
 *
 * 输入：routes = [[7,12],[4,5,15],[6],[15,19],[9,12,13]], source = 15, target = 12
 * 输出：-1
 *
 *
 * 提示：
 *
 * 1 <= routes.length <= 500.
 * 1 <= routes[i].length <= 105
 * routes[i] 中的所有值 互不相同
 * sum(routes[i].length) <= 105
 * 0 <= routes[i][j] < 106
 * 0 <= source, target < 106
 * 通过次数13,564提交次数35,719
 * */
public class Leecode815 {

    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source==target){
            return 0;
        }
        //记录每一个节点所在的路线下标
        Map<Integer,Set<Integer>> transNodes = new HashMap<>();
        //记录为了到达重点所要中途经过的节点
        Queue<Integer> queue = new LinkedList<>();
        //记录距离
        Map<Integer,Integer> distance = new HashMap<>();
        for(int i=0;i<routes.length;i++){
            for(int node:routes[i]){
                if(source==node){
                    queue.add(i);
                    distance.put(i,1);
                }
                Set<Integer> set =transNodes.getOrDefault(node,new HashSet<>());
                set.add(i);
                transNodes.put(node,set);
            }
        }

        while (!queue.isEmpty()){
            int pos = queue.poll();
            int step = distance.get(pos);

            for(int station:routes[pos]){
                if(station==target){
                    return step;
                }
                //该站点能够路过的线路放入queue,向他们下面进发是需要temp+1步骤的
                Set<Integer> temp = transNodes.get(station);
                if(temp==null) continue;
                for(int nr:temp){
                    if(!distance.containsKey(nr)){
                        distance.put(nr,step+1);
                        queue.add(nr);
                    }
                }

            }
        }
        return -1;
    }

    public static void main(String[] args) {
       int[][] routes = new int[][]{{1,2,7},{3,6,7}};
        Leecode815 leecode815 = new Leecode815();
        System.out.println(leecode815.numBusesToDestination(routes,1,6));
    }
}
