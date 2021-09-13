package questions.evrydaystep;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/**
 * 743. 网络延迟时间
 * 有 n 个网络节点，标记为 1 到 n。
 *
 * 给你一个列表 times，表示信号经过 有向 边的传递时间。 times[i] = (ui, vi, wi)，其中 ui 是源节点，vi 是目标节点， wi 是一个信号从源节点传递到目标节点的时间。
 *
 * 现在，从某个节点 K 发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1 。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
 * 输出：2
 * 示例 2：
 *
 * 输入：times = [[1,2,1]], n = 2, k = 1
 * 输出：1
 * 示例 3：
 *
 * 输入：times = [[1,2,1]], n = 2, k = 2
 * 输出：-1
 *
 *
 * 提示：
 *
 * 1 <= k <= n <= 100
 * 1 <= times.length <= 6000
 * times[i].length == 3
 * 1 <= ui, vi <= n
 * ui != vi
 * 0 <= wi <= 100
 * 所有 (ui, vi) 对都 互不相同（即，不含重复边）
 * */
public class Leecode743 {
    int NF = Integer.MAX_VALUE/2;
    //迪杰斯特拉算法
    public int networkDelayTime(int[][] times, int n, int k) {
        //维护邻接矩阵
        int[][] nums = new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(nums[i],NF);
        }

        for(int[] temp:times){
            nums[temp[0]-1][temp[1]-1]=temp[2];
        }

        int[] dest = new int[n];
        for(int i=0;i<n;i++){
            dest[i]=NF;
        }
        boolean[] used = new boolean[n];
        Arrays.fill(used,false);

        dest[k-1]=0;//第一个入队列的点。
        for(int a=0;a<n;a++){
            int x=-1;
            for(int y=0;y<n;y++){
                if(!used[y] &&(x==-1 || dest[x]>dest[y])){
                    x=y;
                }

            }
            used[x]=true;
            for(int z=0;z<n;z++){
                dest[z]=Math.min(dest[z],dest[x]+nums[x][z]);
            }

        }
        int ans = Arrays.stream(dest).max().getAsInt();
        return ans >= NF ? -1 : ans;





    }

    public static void main(String[] args) {
        int [][] times =new int[][] {{2,1,1},{2,3,1},{3,4,1}};
        int [][] times1 =new int[][] {{1,2,1}};
        int n = 4;
        int k = 2;
        Leecode743 leecode743 = new Leecode743();
        System.out.println(leecode743.networkDelayTime(times,n,k));
        System.out.println(leecode743.networkDelayTime(times1,2,1));
        System.out.println(leecode743.networkDelayTime(times1,2,2));

        //[[1,2,1],[2,3,2],[1,3,2]]
        //3
        //1

        int [][] times3 =new int[][] {{1,2,1},{2,3,2},{1,3,2}};
    }
}
