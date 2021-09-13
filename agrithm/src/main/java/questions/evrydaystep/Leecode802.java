package questions.evrydaystep;

import java.util.*;

public class Leecode802 {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        //题意是说如果某个节点走了所有的路径后走回到了自己，那么他就不安全
        //如果走完所有路径之后不会走到自己，那么他就安全。
        //说道有无环儿，拓扑排序能够简单的做到这一点
        //1、维护所有节点的入度
        //2、找到那些入度位0的节点，这些点肯定是安全的，也就是无环
        //3、根据性质，安全节点连接的节点是安全的，剩下就去将其他连接在入度为0的节点入度-1，减完后如果入度为0那这个节点也是安全的放置
        //到队列当中
        //为啥非得反着维护关系，因为我们要获取每一个节点的入度，如果按照题目给的节点关系，我们维护节点出度关系，就很难计算每个节点的入度。所以维护每个节点的
        int n = graph.length;
        List<Integer> result = new LinkedList<Integer>();
        Deque<Integer> d = new ArrayDeque<>();
        List<List<Integer>> list = new LinkedList<>();
        int[] inDeg = new int[n];
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int temp : graph[i]) {
                //表示i是这个temp的一个出度从temp->i,所以这个题到这里其实是把关系给反转了，变成数组指向各个位置的节点了。
                list.get(temp).add(i);
            }

            inDeg[i] = graph[i].length;
        }


        for (int i = 0; i < n; i++) {
            if (inDeg[i] == 0) {
                d.add(i);
            }
        }
        while (!d.isEmpty()) {
            int dd = d.pop();
            for (int ll : list.get(dd)) {
                inDeg[ll]--;
                if (inDeg[ll] == 0) {
                    d.push(ll);
                }
            }
        }
        for(int i=0;i< inDeg.length;i++){
            if (inDeg[i] == 0) {
                result.add(i);
            }
        }



        return result;

    }


    public List<Integer> eventualSafeNodes1(int[][] graph) {
        //题意是说如果某个节点走了所有的路径后走回到了自己，那么他就不安全
        //如果走完所有路径之后不会走到自己，那么他就安全。
        //说道有无环儿，拓扑排序能够简单的做到这一点
        //1、维护所有节点的入度
        //2、找到那些入度位0的节点，这些点肯定是安全的，也就是无环
        //3、根据性质，安全节点连接的节点是安全的，剩下就去将其他连接在入度为0的节点入度-1，减完后如果入度为0那这个节点也是安全的放置
        //到队列当中
        int n = graph.length;
        List<Integer> result = new LinkedList<Integer>();
        Deque<Integer> d = new ArrayDeque<>();
        List<List<Integer>> list = new LinkedList<>();
        int[] inDeg = new int[n];
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int temp : graph[i]) {
                //表示i是这个temp的一个入节点
                //从i->temp节点
                list.get(i).add(temp);
            }


        }
        for (int i = 0; i < n; i++) {
            inDeg[i] = list.get(i).size();
        }

        for (int i = 0; i < n; i++) {
            if (inDeg[i] == 0) {
                d.add(i);
            }
        }
        while (!d.isEmpty()) {
            int dd = d.pop();
            for (int ll : list.get(dd)) {
                inDeg[ll]--;
                if (inDeg[ll] == 0) {
                    d.push(inDeg[ll]);
                }
            }
        }
        for(int i=0;i< inDeg.length;i++){
            if (inDeg[i] == 0) {
                result.add(i);
            }
        }



        return result;

    }

    public static void main(String[] args) {
        //graph = [[1,2],[2,3],[5],[0],[5],[],[]]
        int[][] graph = new int[][]{
                {1,2},{2,3},{5},{0},{5},{},{}
        };
        int[][] graph1 = new int[][]{
                {1,2,3,4},{1,2},{3,4},{0,4},{}
        };
        int[][] graph2= new int[][]{
                {},{0,2,3,4},{3},{4},{}
        };
        Leecode802 leecode802 = new Leecode802();
     /*   System.out.println(leecode802.eventualSafeNodes(graph));
        System.out.println(leecode802.eventualSafeNodes(graph1));*/
        System.out.println(leecode802.eventualSafeNodes(graph2));
    }
}
