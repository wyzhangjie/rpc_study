package questions.evrydaystep;

import java.util.*;

public class Leecode1584 {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        //初始化并查集
        DisjointSetUnion dsu = new DisjointSetUnion(n);
        List<Edge> edges = new ArrayList<Edge>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                //将所有可以连通的边计算出来边的长度
                edges.add(new Edge(dist(points, i, j), i, j));
            }
        }
        //按照边的长度从小到大排序
        Collections.sort(edges, (edge1, edge2) -> edge1.len - edge2.len);
        //针对每一个较小的边，将两个点合并
        int ret = 0, num = 1;
        for (Edge edge : edges) {
            int len = edge.len, x = edge.x, y = edge.y;
            if (dsu.unionSet(x, y)) {
                ret += len;

                num++;
                //当合并的点个数等于n-1的时候说明全部连通了，所以结束
                if (num == n) {
                    break;
                }
            }
        }
        return ret;
    }

    public int dist(int[][] points, int x, int y) {
        return Math.abs(points[x][0] - points[y][0]) + Math.abs(points[x][1] - points[y][1]);
    }

    class DisjointSetUnion {
        int[] f;
        int[] rank;
        int n;

        public DisjointSetUnion(int n) {
            this.n = n;
            this.rank = new int[n];
            Arrays.fill(this.rank, 1);
            this.f = new int[n];
            for (int i = 0; i < n; i++) {
                this.f[i] = i;
            }
        }

        public int find(int x) {
            return f[x] == x ? x : (f[x] = find(f[x]));
        }

        public boolean unionSet(int x, int y) {
            int fx = find(x), fy = find(y);
            if (fx == fy) {
                return false;
            }
            if (rank[fx] < rank[fy]) {
                int temp = fx;
                fx = fy;
                fy = temp;
            }
            rank[fx] += rank[fy];
            //把短的放置到长的上面
            f[fy] = fx;
            return true;
        }
    }

    class Edge {
        int len, x, y;

        public Edge(int len, int x, int y) {
            this.len = len;
            this.x = x;
            this.y = y;
        }
    }
}
