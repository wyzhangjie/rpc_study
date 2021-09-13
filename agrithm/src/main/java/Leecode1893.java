import java.util.*;

/**
 *
 *1893. 检查是否区域内所有整数都被覆盖
 * 给你一个二维整数数组 ranges 和两个整数 left 和 right 。每个 ranges[i] = [starti, endi] 表示一个从 starti 到 endi 的 闭区间 。
 *
 * 如果闭区间 [left, right] 内每个整数都被 ranges 中 至少一个 区间覆盖，那么请你返回 true ，否则返回 false 。
 *
 * 已知区间 ranges[i] = [starti, endi] ，如果整数 x 满足 starti <= x <= endi ，那么我们称整数x 被覆盖了。
 *
 *
 *
 * 示例 1：
 *
 * 输入：ranges = [[1,2],[3,4],[5,6]], left = 2, right = 5
 * 输出：true
 * 解释：2 到 5 的每个整数都被覆盖了：
 * - 2 被第一个区间覆盖。
 * - 3 和 4 被第二个区间覆盖。
 * - 5 被第三个区间覆盖。
 * 示例 2：
 *
 * 输入：ranges = [[1,10],[10,20]], left = 21, right = 21
 * 输出：false
 * 解释：21 没有被任何一个区间覆盖。
 *
 *
 * 提示：
 *
 * 1 <= ranges.length <= 50
 * 1 <= starti <= endi <= 50
 * 1 <= left <= right <= 50
 * */
public class Leecode1893 {
    public boolean isCovered(int[][] ranges, int left, int right) {
        //排序
        Arrays.sort(ranges, (o1, o2) -> {
            if (o1[0]==o2[0]) return o1[1]-o2[1];
            return o1[0]-o2[0];
        });
        //放入map
        Stack<Integer> stack = new Stack<>();
        stack.push(ranges[0][0]);
        stack.push(ranges[0][1]);
        for(int i=1;i<ranges.length;i++) {
            if (stack.peek() >= ranges[i][0] - 1 && stack.peek() <= ranges[i][1] - 1) {
                stack.pop();
                stack.push(ranges[i][1]);
            }
            if (stack.peek() < ranges[i][0]-1) {
                stack.push(ranges[i][0]);
                stack.push(ranges[i][1]);
            }
        }

            while (!stack.isEmpty()){
             int stackRight = stack.peek();
             if(stackRight>=right){
                 stack.pop();
                 int stackLeft = stack.peek();
                 if(stackLeft<=left){
                     return true;
                 }else {
                     stack.pop();
                 }
             }else {
                 return false;
             }
            }

return false;


        //判断覆盖情况
    }

    public static void main(String[] args) {
        int[][]  ranges =new int[][] {{1,10},{10,20}};
        int left = 21;
        int right = 21;
        Leecode1893 leecode1893 = new Leecode1893();
        System.out.println(leecode1893.isCovered(ranges,left,right));
    }
}
