package questions.evrydaystep;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leecode851 {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int[] indegree = new int[quiet.length];
        List<Integer>[] graph = new List[quiet.length];
        //构建拓扑表
        for(int i=0;i<quiet.length;i++){
            graph[i] = new ArrayList<>();
        }
        for (int[] richSmall : richer) {
            graph[richSmall[0]].add(richSmall[1]);
            indegree[richSmall[1]]++;
        }
        //先初始化自己为自己的结果
        int[] answer = new int[quiet.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = i;
        }
        //拓扑排序
        Queue<Integer> queue = new LinkedList<>();
        //第一步骤，把入度为0的，也就是边沿的节点入队列
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        //第二步骤：
       //2.1 首先把入度为0的加入队列
        //2.2 然后取出一个，把它相连的数据根据题意更新，并且将这些数据的入度减去1，如果此时它的入度变为0，那么进入queue，如果不为0，继续下面的操作。

        while (!queue.isEmpty()) {
            int p = queue.poll();
            for (int q : graph[p]) {


                if (quiet[answer[p]] < quiet[answer[q]]) {
                    answer[q] = answer[p];
                }
                if ((--indegree[q]) == 0) {
                    queue.offer(q);
                }
            }

        }
        return answer;

    }


    public int[] loudAndRich1(int[][] richer, int[] quiet) {
        // 拓扑排序：取入度为0的先入队，减少它下游节点的入度，如果为0了也入队，直到队列中没有元素为止

        int n = quiet.length;

        // 先整理入度表和邻接表
        int[] inDegree = new int[n];

        List<Integer>[] g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }

        for (int[] r : richer) {
            inDegree[r[1]]++;
            g[r[0]].add(r[1]);
        }

        // 初始化ans各位为自己
        // 题目说的是：在所有拥有的钱肯定不少于 person x 的人中，person y 是最安静的人
        // 注意这里的不少于，说明可以是自己
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = i;
        }

        // 拓扑排序开始
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int p = queue.poll();
            // q是p的下游，也就是p比q有钱
            for (int q : g[p]) {
                // 如果p的安静值比q小，更新p的安静值对应的那个人
                // 注意这里p的安静值，并不是原始的quiet数组中的quiet[p]
                // 而是已经更新后的安静值，所以，应该取quiet[ans[p]]
                // 这里没有改变原来数组的内容，而是通过ans[p]间接引用的，细细品一下
                // 想像一下上图中的3的安静值被更新成了5的1
                if (quiet[ans[p]] < quiet[ans[q]]) {
                    ans[q] = ans[p];
                }

                if (--inDegree[q] == 0) {
                    queue.offer(q);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] richer = {{1, 0}, {2, 1}, {3, 1}, {3, 7}, {4, 3}, {5, 3}, {6, 3}};
        int[] quiet = {3, 2, 5, 4, 6, 1, 7, 0};
        Leecode851 leecode851 = new Leecode851();
        int[] answer = leecode851.loudAndRich(richer, quiet);
        for (int t : answer) {
            System.out.println(t);
        }
    }
}
