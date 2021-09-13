package questions.evrydaystep;

import java.util.*;

/**
 * 787. K 站中转内最便宜的航班
 * 有 n 个城市通过一些航班连接。给你一个数组 flights ，其中 flights[i] = [fromi, toi, pricei] ，表示该航班都从城市 fromi 开始，以价格 pricei 抵达 toi。
 *
 * 现在给定所有的城市和航班，以及出发城市 src 和目的地 dst，你的任务是找到出一条最多经过 k 站中转的路线，使得从 src 到 dst 的 价格最便宜 ，并返回该价格。 如果不存在这样的路线，则输出 -1。
 *
 *
 *
 * 示例 1：
 *
 * 输入:
 * n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
 * src = 0, dst = 2, k = 1
 * 输出: 200
 * 解释:
 * 城市航班图如下
 *
 *
 * 从城市 0 到城市 2 在 1 站中转以内的最便宜价格是 200，如图中红色所示。
 * 示例 2：
 *
 * 输入:
 * n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
 * src = 0, dst = 2, k = 0
 * 输出: 500
 * 解释:
 * 城市航班图如下
 *
 *
 * 从城市 0 到城市 2 在 0 站中转以内的最便宜价格是 500，如图中蓝色所示。
 *
 * */
public class Leecode787 {
    //dfs
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        //第一步：组织结构
        List<int[]>[] edge = new List[n];
        Queue<int[]> queue = new LinkedList<>();
        int[] prices= new int[n];
        //初始化
        for(int i=0;i<n;i++){
            edge[i]=new ArrayList<>();
            prices[i]=Integer.MAX_VALUE;
        }
        for(int[] flight:flights){
            edge[flight[0]].add(new int[]{flight[1],flight[2]});
        }
        prices[src]=0;
        queue.add(new int[]{src,0,prices[src]});

        while (!queue.isEmpty()){
            int[] poll = queue.poll();
            if(poll[1]>k)break;
            for(int[] next:edge[poll[0]]){
                //到这里，poll[2]表示金额是到了poll[0]这个位置的金额
                if(prices[next[0]]>poll[2]+next[1]){
                    //到了这里说这个接下来要到达的点，距离小于 poll[0]进入选择队列之后的最小距离，那么则将其更新进入队列。
                    prices[next[0]]=poll[2]+next[1];
                    queue.add(new int[]{next[0], poll[1] + 1, prices[next[0]]});
                }
            }
        }
        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }
    //dp
    public int findCheapestPriceV2(int n, int[][] flights, int src, int dst, int k) {
        return 0;

    }

    public int findCheapestPrice1(int n, int[][] flights, int src, int dst, int k) {
        final int INF = 10000 * 101 + 1;
        int[] f = new int[n];
        Arrays.fill(f, INF);
        f[src] = 0;
        int ans = INF;
        for (int t = 1; t <= k + 1; ++t) {
            int[] g = new int[n];
            Arrays.fill(g, INF);
            for (int[] flight : flights) {
                int j = flight[0], i = flight[1], cost = flight[2];
                g[i] = Math.min(g[i], f[j] + cost);
            }
            f = g;
            ans = Math.min(ans, f[dst]);
        }
        return ans == INF ? -1 : ans;
    }

}
