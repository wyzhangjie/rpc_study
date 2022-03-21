package questions.evrydaystep;/**
 * ClassName Leecode2039
 * Description
 * Create by jie.zhang02
 * Date 2022/3/21 12:17 下午
 */

import java.util.*;

/**
 * @author jie.zhang
 * @date 2022年03月21日 12:17 下午
 */
public class Leecode2039 {
    public int networkBecomesIdle(int[][] edges, int[] patience) {
        //一共有多少条边
        int len = patience.length;

        List<Integer>[] list = new List[len];
        for (int i = 0; i < len; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            list[edges[i][0]].add(edges[i][1]);
            list[edges[i][1]].add(edges[i][0]);
        }

        int d = 1;
        int[] distances = new int[len];

        Deque<Integer> queue = new LinkedList();
        queue.offer(0);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int node = queue.pollFirst();
                for (int next : list[node]) {
                    if (distances[next] == 0&& next!=0) {
                        queue.offerLast(next);
                        distances[next] = d;
                    }
                }
                d++;
            }
        }
        int[] times = new int[len];
        for (int i = 1; i < len; i++) {
            int p = patience[i];
            int dist = distances[i];
            // 假设p=2,d=2，一条消息发送出去到回来需要4秒，等于2的两倍，会发送两条消息
            // 假设p=3,d=2，一条消息发送出去到回来需要4秒，大于3，会发送两条消息
            // 假设p=4,d=2，一条消息发送出去到回来需要4秒，等于4，只会发送一条消息
            // 每条消息耗费的时长为 2*d，所以，总的时间为最后一条消息发送的时间 + 来回的时间
            times[i] = ((2 * dist - 1) / p )* p + 2 * dist;
        }

        int max = 0;
        for (int time : times) {
            max = Math.max(max, time);
        }
        // 题目要求的是返回第几秒空闲，也就是最后一条消息到达从服务器的时间加一
        return max + 1;
    }

    public static void main(String[] args) {
       int[][] edges = {{0,1},{1,2}};
       int[] patience = {0,2,1};
        Leecode2039 leecode2039 = new Leecode2039();
        System.out.println(leecode2039.networkBecomesIdle(edges,patience));
    }
}
