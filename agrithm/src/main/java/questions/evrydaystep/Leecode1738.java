package questions.evrydaystep;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.function.IntFunction;

/**
 * 1738. 找出第 K 大的异或坐标值
 * 给你一个二维矩阵 matrix 和一个整数 k ，矩阵大小为 m x n 由非负整数组成。
 *
 * 矩阵中坐标 (a, b) 的 值 可由对所有满足 0 <= i <= a < m 且 0 <= j <= b < n 的元素 matrix[i][j]（下标从 0 开始计数）执行异或运算得到。
 *
 * 请你找出 matrix 的所有坐标中第 k 大的值（k 的值从 1 开始计数）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：matrix = [[5,2],[1,6]], k = 1
 * 输出：7
 * 解释：坐标 (0,1) 的值是 5 XOR 2 = 7 ，为最大的值。
 * 示例 2：
 *
 * 输入：matrix = [[5,2],[1,6]], k = 2
 * 输出：5
 * 解释：坐标 (0,0) 的值是 5 = 5 ，为第 2 大的值。
 * 示例 3：
 *
 * 输入：matrix = [[5,2],[1,6]], k = 3
 * 输出：4
 * 解释：坐标 (1,0) 的值是 5 XOR 1 = 4 ，为第 3 大的值。
 * 示例 4：
 *
 * 输入：matrix = [[5,2],[1,6]], k = 4
 * 输出：0
 * 解释：坐标 (1,1) 的值是 5 XOR 2 XOR 1 XOR 6 = 0 ，为第 4 大的值。
 *
 *
 * 提示：
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 1000
 * 0 <= matrix[i][j] <= 106
 * 1 <= k <= m * n
 * 通过次数9,769提交次
 * */
public class Leecode1738 {
    public int kthLargestValue(int[][] matrix, int k) {
        List<Integer> priorityQueue = new LinkedList();

        int[][] prePriority = new int[matrix.length+1][matrix[0].length+1];
        for(int i=1;i<=matrix.length;i++){
            for(int j=1;j<=matrix[0].length;j++){
                prePriority[i][j]=prePriority[i-1][j-1]^prePriority[i-1][j]^prePriority[i][j-1]^matrix[i-1][j-1];
                priorityQueue.add(prePriority[i][j]);
            }
        }
       Integer[] result = priorityQueue.stream().sorted(Comparator.reverseOrder()).toArray(Integer[]::new);
        return result[k-1];
    }


    public int kthLargestValue1(int[][] matrix, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue();

        int[][] prePriority = new int[matrix.length+1][matrix[0].length+1];
        for(int i=1;i<=matrix.length;i++){
            for(int j=1;j<=matrix[0].length;j++){
                prePriority[i][j]=prePriority[i-1][j-1]^prePriority[i-1][j]^prePriority[i][j-1]^matrix[i-1][j-1];
                if(priorityQueue.size()<k){
                    priorityQueue.add(prePriority[i][j]);
                }
                else {
                    if(prePriority[i][j]>priorityQueue.peek()){
                        priorityQueue.poll();
                        priorityQueue.add(prePriority[i][j]);
                    }
                }
            }
        }
        return priorityQueue.peek();
    }

    public static void main(String[] args) {
        //[[3,10,9,5,5,7],[0,1,7,3,8,1],[9,3,0,6,1,6],[10,2,9,10,10,7]]
        //18
        int[][] matrix = new int[][]{{3,10,9,5,5,7},{0,1,7,3,8,1},{9,3,0,6,1,6},{10,2,9,10,10,7}};
        Leecode1738 leecode1738 = new Leecode1738();
        System.out.println(leecode1738.kthLargestValue(matrix,18));
    }
}
