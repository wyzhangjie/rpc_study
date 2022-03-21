package questions.evrydaystep;

import java.util.Arrays;

/**
 * 913. 猫和老鼠
 * 两位玩家分别扮演猫和老鼠，在一张 无向 图上进行游戏，两人轮流行动。
 * <p>
 * 图的形式是：graph[a] 是一个列表，由满足 ab 是图中的一条边的所有节点 b 组成。
 * <p>
 * 老鼠从节点 1 开始，第一个出发；猫从节点 2 开始，第二个出发。在节点 0 处有一个洞。
 * <p>
 * 在每个玩家的行动中，他们 必须 沿着图中与所在当前位置连通的一条边移动。例如，如果老鼠在节点 1 ，那么它必须移动到 graph[1] 中的任一节点。
 * <p>
 * 此外，猫无法移动到洞中（节点 0）。
 * <p>
 * 然后，游戏在出现以下三种情形之一时结束：
 * <p>
 * 如果猫和老鼠出现在同一个节点，猫获胜。
 * 如果老鼠到达洞中，老鼠获胜。
 * 如果某一位置重复出现（即，玩家的位置和移动顺序都与上一次行动相同），游戏平局。
 * 给你一张图 graph ，并假设两位玩家都都以最佳状态参与游戏：
 * <p>
 * 如果老鼠获胜，则返回 1；
 * 如果猫获胜，则返回 2；
 * 如果平局，则返回 0 。
 */
public class Leecode913 {
    int MOUSE_WIN = 1;
    int CAT_WIN = 2;
    int even = 0;

    public int catMouseGame(int[][] graph) {
        int n = graph.length;
        int[][][] memo = new int[n][n][2 * n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++)
            Arrays.fill(memo[i][j], -1);
        }
        return deep(1, 2, 0, graph, memo);
    }

    private int deep(int mouse_position, int cat_position, int step, int[][] graph, int[][][] memo) {
        if (step >= 2 * graph.length) {
            return even;
        }
        if (memo[mouse_position][cat_position][step] != -1) {
            return memo[mouse_position][cat_position][step];
        }
        if (mouse_position == cat_position) {
            return memo[mouse_position][cat_position][step] = CAT_WIN;
        }
        if (mouse_position == 0) {
            return memo[mouse_position][cat_position][step] = MOUSE_WIN;
        }
        //1\这时候是老鼠可以行动了
        if (step % 2 == 0) {
            int ans = CAT_WIN;
            for (int i = 0; i < graph[mouse_position].length; i++) {

                int nextAns = deep(graph[mouse_position][i], cat_position, step + 1, graph, memo);
                if (nextAns == MOUSE_WIN) {
                    return memo[mouse_position][cat_position][step] = MOUSE_WIN;
                }
                // 有平局，先记录为平局，后面如果有老鼠可以赢的场景，通过上述语句可以返回
                if (nextAns == even) {
                    ans = even;
                }

            }
            return memo[mouse_position][cat_position][step] = ans;

        } else {
            //现在是老猫行动了
            int ans = MOUSE_WIN;
            for (int i = 0; i < graph[cat_position].length; i++) {

                if (graph[cat_position][i] != 0) {
                    int nextAns = deep(mouse_position, graph[cat_position][i], step + 1, graph, memo);
                    if (nextAns == CAT_WIN) {
                        return memo[mouse_position][cat_position][step] = CAT_WIN;
                    }
                    // 有平局，先记录为平局，后面如果有老鼠可以赢的场景，通过上述语句可以返回
                    if (nextAns == even) {
                        ans = even;
                    }
                }


            }
            return memo[mouse_position][cat_position][step] = ans;
        }


    }


    /**
     * 平局
     */
    private static final int DRAW = 0;

    public int catMouseGame1(int[][] graph) {
        int n = graph.length;
        int[][][] memo = new int[n][n][2 * n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }
        return dfs1(graph, n, memo, 2, 1, 0);
    }

    private int dfs1(int[][] graph, int n, int[][][] memo, int catPos, int mousePos, int turns) {
        // 超过节点数两倍，可以确定为平局
        if (turns >= 2 * n) {
            return 0;
        }

        // 缓存中有，直接返回
        if (memo[catPos][mousePos][turns] != -1) {
            return memo[catPos][mousePos][turns];
        }

        // 老鼠赢
        if (mousePos == 0) {
            return memo[catPos][mousePos][turns] = MOUSE_WIN;
        }

        // 猫赢
        if (catPos == mousePos) {
            return memo[catPos][mousePos][turns] = CAT_WIN;
        }

        // turns 为偶数是轮到老鼠走，为奇数是轮到猫走
        if (turns % 2 == 0) {
            // 老鼠最坏情况是猫赢
            int ans = CAT_WIN;
            // 尝试走到下一个节点
            for (int nextPos : graph[mousePos]) {
                int nextAns = dfs1(graph, n, memo, catPos, nextPos, turns + 1);
                // 如果老鼠可以赢，直接返回
                if (nextAns == MOUSE_WIN) {
                    return memo[catPos][mousePos][turns] = MOUSE_WIN;
                }
                // 有平局，先记录为平局，后面如果有老鼠可以赢的场景，通过上述语句可以返回
                if (nextAns == DRAW) {
                    ans = DRAW;
                }
            }
            // 返回老鼠走的结果
            return memo[catPos][mousePos][turns] = ans;
        } else {
            // 猫最坏情况是老鼠赢
            int ans = MOUSE_WIN;
            for (int nextPos : graph[catPos]) {
                // 注意猫不能走到0号节点
                if (nextPos != 0) {
                    // 尝试进入下一个节点
                    int nextAns = dfs1(graph, n, memo, nextPos, mousePos, turns + 1);
                    // 如果猫可以赢，直接返回
                    if (nextAns == CAT_WIN) {
                        return memo[catPos][mousePos][turns] = CAT_WIN;
                    }
                    // 有平局，先记录为平局，后面如果有猫可以赢的场景，通过上述语句可以返回
                    if (nextAns == DRAW) {
                        ans = DRAW;
                    }
                }
            }
            // 返回猫走的结果
            return memo[catPos][mousePos][turns] = ans;
        }
    }


    public static void main(String[] args) {
        //   int[][]  graph = {{2,5},{3},{0,4,5},{1,4,5},{2,3},{0,2,3}};
        //   int[][] graph = {{1,3},{0},{3},{0,2}};
        int[][] graph = {{3, 4}, {3, 5}, {3, 6}, {0, 1, 2}, {0, 5, 6}, {1, 4}, {2, 4}};
        Leecode913 leecode913 = new Leecode913();
        System.out.println(leecode913.catMouseGame(graph));
    }
}
