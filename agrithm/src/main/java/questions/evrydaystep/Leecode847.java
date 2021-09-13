package questions.evrydaystep;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 *847. 访问所有节点的最短路径
 * 存在一个由 n 个节点组成的无向连通图，图中的节点按从 0 到 n - 1 编号。
 *
 * 给你一个数组 graph 表示这个图。其中，graph[i] 是一个列表，由所有与节点 i 直接相连的节点组成。
 *
 * 返回能够访问所有节点的最短路径的长度。你可以在任一节点开始和停止，也可以多次重访节点，并且可以重用边。
 * 提示：
 *
 * n == graph.length
 * 1 <= n <= 12
 * 0 <= graph[i].length < n
 * graph[i] 不包含 i
 * 如果 graph[a] 包含 b ，那么 graph[b] 也包含 a
 * 输入的图总是连通图
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-path-visiting-all-nodes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class Leecode847 {
    public int shortestPathLength(int[][] graph) {
        int len = graph.length;
        Queue<Integer[]> queue = new LinkedList<>();
        boolean[][] hasSeen = new boolean[len][1<<len];
        //初始化
        for(int i=0;i<len;i++){
            queue.offer(new Integer[]{i,1<<i,0});
            hasSeen[i][1<<i]=true;
        }

        int ans=0;
        while (!queue.isEmpty()){
            Integer[] temp = queue.poll();
            int start =temp[0];
            int mask = temp[1];
            int step  =temp[2];
            if(mask==(1<<len)-1){
                ans=step;
                break;
            }
            for(int v:graph[start]){
                int maskDest = mask | 1<<v;
                if(!hasSeen[v][maskDest]){
                    queue.offer(new Integer[]{v,maskDest,step+1});
                    hasSeen[v][maskDest]=true;
                }
            }
        }

        return ans;

    }

    public void floidMethod(int[][] graph){
        //第一步骤 根据弗洛伊德算法获取每两个点之间的最短距离
        int n = graph.length;
        int[][] floid = new int[n][n];
        //首先给每一个位置填充最大值
        for(int i=0;i<n;i++){
            Arrays.fill(floid[i],n+1);
        }
        for(int i=0;i<n;i++){
            for(int v:graph[i]){
                floid[i][v]=1;
            }
        }
        for(int x=0;x<n;x++){
            for(int y=0;y<n;y++){
                for(int z=0;z<n;z++){
                    if(floid[y][z]>floid[y][x]+floid[x][z]){
                        floid[y][z]=floid[y][x]+floid[x][z];
                    }
                }
            }
        }
    }


        public int shortestPathLength1(int[][] graph) {
            int n = graph.length;
            Queue<int[]> queue = new LinkedList<int[]>();
            boolean[][] seen = new boolean[n][1 << n];
            for (int i = 0; i < n; ++i) {
                queue.offer(new int[]{i, 1 << i, 0});
                seen[i][1 << i] = true;
            }

            int ans = 0;
            while (!queue.isEmpty()) {
                int[] tuple = queue.poll();
                int u = tuple[0], mask = tuple[1], dist = tuple[2];
                if (mask == (1 << n) - 1) {
                    ans = dist;
                    break;
                }
                // 搜索相邻的节点
                for (int v : graph[u]) {
                    // 将 mask 的第 v 位置为 1
                    int maskV = mask | (1 << v);
                    if (!seen[v][maskV]) {
                        queue.offer(new int[]{v, maskV, dist + 1});
                        seen[v][maskV] = true;
                    }
                }
            }
            return ans;
        }


    public static void main(String[] args) {
        int[][] graph = {{1,2,3},{0},{0},{0}};
        int[][] graph1= {{1},{0,2,4},{1,3,4},{2},{1,2}};
        Leecode847 leecode847 = new Leecode847();
        System.out.println(leecode847.shortestPathLength(graph1));
        System.out.println(leecode847.shortestPathLength1(graph1));
    }
}
