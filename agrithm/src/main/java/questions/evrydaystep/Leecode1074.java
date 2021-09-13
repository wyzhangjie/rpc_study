package questions.evrydaystep;

import java.util.HashMap;
import java.util.Map;

/**
 * 1074. 元素和为目标值的子矩阵数量
 * 给出矩阵 matrix 和目标值 target，返回元素总和等于目标值的非空子矩阵的数量。
 *
 * 子矩阵 x1, y1, x2, y2 是满足 x1 <= x <= x2 且 y1 <= y <= y2 的所有单元 matrix[x][y] 的集合。
 *
 * 如果 (x1, y1, x2, y2) 和 (x1', y1', x2', y2') 两个子矩阵中部分坐标不同（如：x1 != x1'），那么这两个子矩阵也不同。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：matrix = [[0,1,0],[1,1,1],[0,1,0]], target = 0
 * 输出：4
 * 解释：四个只含 0 的 1x1 子矩阵。
 * 示例 2：
 *
 * 输入：matrix = [[1,-1],[-1,1]], target = 0
 * 输出：5
 * 解释：两个 1x2 子矩阵，加上两个 2x1 子矩阵，再加上一个 2x2 子矩阵。
 * 示例 3：
 *
 * 输入：matrix = [[904]], target = 0
 * 输出：0
 *
 *
 * 提示：
 *
 * 1 <= matrix.length <= 100
 * 1 <= matrix[0].length <= 100
 * -1000 <= matrix[i] <= 1000
 * -10^8 <= target <= 10^8
 * 通过次数16,875提交次数25,188
 * */
public class Leecode1074 {
    public int numSubmatrixSumTarget2(int[][] matrix, int target) {
        int ans = 0;
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; ++i) { // 枚举上边界
            int[] sum = new int[n];
            for (int j = i; j < m; ++j) { // 枚举下边界
                for (int c = 0; c < n; ++c) {
                    sum[c] += matrix[j][c]; // 更新每列的元素和
                }
                ans += subarraySum(sum, target);
            }
        }
        return ans;
    }

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0, pre = 0;
        for (int x : nums) {
            pre += x;
            if (map.containsKey(pre - k)) {
                count += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return count;
    }


    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int result=0;
        int[][] maxSub = new int[matrix.length+1][matrix[0].length+1];
        for(int i=0;i<matrix.length;i++){
            maxSub[i][0]=0;
        }
        for(int i=0;i<maxSub[0].length;i++){
            maxSub[0][1]=0;
        }
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix.length;j++){
                maxSub[i+1][j+1] = maxSub[i][j+1] + maxSub[i+1][j] +matrix[i][j]-maxSub[i][j];
                if(maxSub[i+1][j+1]==target){
                    result++;
                }
            }
        }

        return result;


    }

    public static void main(String[] args) {
     int[][]   matrix = {{0,1,0},{1,1,1},{0,1,0}};
        Leecode1074 leecode1074 = new Leecode1074();
        System.out.println(leecode1074.numSubmatrixSumTarget(matrix,0));
    }
}
