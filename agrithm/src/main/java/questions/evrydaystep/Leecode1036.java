package questions.evrydaystep;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 1036. 逃离大迷宫
 * 在一个 106 x 106 的网格中，每个网格上方格的坐标为 (x, y) 。
 * <p>
 * 现在从源方格 source = [sx, sy] 开始出发，意图赶往目标方格 target = [tx, ty] 。数组 blocked 是封锁的方格列表，其中每个 blocked[i] = [xi, yi] 表示坐标为 (xi, yi) 的方格是禁止通行的。
 * <p>
 * 每次移动，都可以走到网格中在四个方向上相邻的方格，只要该方格 不 在给出的封锁列表 blocked 上。同时，不允许走出网格。
 * <p>
 * 只有在可以通过一系列的移动从源方格 source 到达目标方格 target 时才返回 true。否则，返回 false。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：blocked = [[0,1],[1,0]], source = [0,0], target = [0,2]
 * 输出：false
 * 解释：
 * 从源方格无法到达目标方格，因为我们无法在网格中移动。
 * 无法向北或者向东移动是因为方格禁止通行。
 * 无法向南或者向西移动是因为不能走出网格。
 * 示例 2：
 * <p>
 * 输入：blocked = [], source = [0,0], target = [999999,999999]
 * 输出：true
 * 解释：
 * 因为没有方格被封锁，所以一定可以到达目标方格。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= blocked.length <= 200
 * blocked[i].length == 2
 * 0 <= xi, yi < 106
 * source.length == target.length == 2
 * 0 <= sx, sy, tx, ty < 106
 * source != target
 * 题目数据保证 source 和 target 不在封锁列表内
 */
public class Leecode1036 {
    static final int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        int len = blocked.length;
        int circle = len * (len - 1) / 2;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < len; i++) {
            set.add(convert(blocked[i][0], blocked[i][1]));
        }
        String sourceResult = deep(set, source, target, circle);
        String targetResult = deep(set, target,source, circle);
        return "Pass".equalsIgnoreCase(sourceResult) && "pass".equalsIgnoreCase(targetResult);

    }

    private String deep(Set<Integer> blocked, int[] source, int[] target, int max) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(source);
        Set<Integer> visited = new HashSet<>();
        visited.add(convert(source[0], source[1]));
        while (!queue.isEmpty()) {
            int[] top = queue.poll();
            for(int[] direct:directions){
                int x= top[0]+direct[0];
                int y= top[1]+direct[1];
                int flat = convert(x,y);
                if(x>=0 && x<1000000 && y >=0 && y<1000000 &&  !blocked.contains(flat) && !visited.contains(flat)){
                    if(convert(target[0],target[1])==flat){
                        return "PASS";
                    }
                    visited.add(flat);
                    if(visited.size()>max){
                        return "PASS";
                    }
                    queue.offer(new int[] {x, y});

                }


            }

        }
        return "NOPASS";

    }

    int convert(int x, int y) {
        return x * 1000001 + y;
    }

    public static void main(String[] args) {
       int[][] blocked = {};
       int[] source = {0,0};
       int[] target = {999999,999999};
        Leecode1036 leecode1036 = new Leecode1036();
        System.out.println(
                leecode1036.isEscapePossible(blocked,source,target)
        );
    }
}
