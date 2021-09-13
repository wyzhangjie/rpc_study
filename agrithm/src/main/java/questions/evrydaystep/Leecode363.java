package questions.evrydaystep;

/**
 * 363. 矩形区域不超过 K 的最大数值和
 * 给你一个 m x n 的矩阵 matrix 和一个整数 k ，找出并返回矩阵内部矩形区域的不超过 k 的最大数值和。
 * <p>
 * 题目数据保证总会存在一个数值和不超过 k 的矩形区域。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：matrix = [[1,0,1],[0,-2,3]], k = 2
 * 输出：2
 * 解释：蓝色边框圈出来的矩形区域 [[0, 1], [-2, 3]] 的数值和是 2，且 2 是不超过 k 的最大数字（k = 2）。
 * 示例 2：
 * <p>
 * 输入：matrix = [[2,2,-1]], k = 3
 * 输出：3
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -100 <= matrix[i][j] <= 100
 * -105 <= k <= 105
 * <p>
 * <p>
 * 进阶：如果行数远大于列数，该如何设计解决方案？
 * <p>
 * 通过次数12,882提交次数29,189
 */
public class Leecode363 {
    /*public int maxSumSubmatrix(int[][] matrix, int k) {

        int result = Integer.MIN_VALUE;
        int width = 1;
        int m = matrix.length;
        int n = matrix[0].length;
        int maxWidth = matrix.length > matrix[0].length ? matrix.length : matrix[0].length;

        if (matrix.length > matrix[0].length) {
            for (; width <= maxWidth; width++) {
                for (int i = 0; i <= m - width; i++) {
                    for (int j = 0; j <= n ; j++) {
                        int temp = 0;
                        boolean enter=false;
                        for (int heng = i; heng < m && heng < i + width; heng++) {
                            for (int lie = j; lie < n && lie < j + width; lie++) {
                                temp += matrix[heng][lie];
                                enter=true;
                            }
                        }
                        if (enter &&temp <= k && temp > result) {
                            result = temp;
                        }
                    }


                }
            }
        } else {
            for (; width <= maxWidth; width++) {
                for (int j = 0; j <= n - width; j++) {
                    for (int i = 0; i <= m ; i++) {

                        int temp = 0;
                        boolean enter=false;
                        for (int lie = j; lie < n && lie < j + width; lie++) {
                            for(int ceng=1;ceng<=width;ceng++){
                                for (int heng = i; heng < m && heng < i + width; heng++) {
                                    temp += matrix[heng][lie];
                                    enter=true;
                                }
                                if (enter && temp <= k && temp > result) {
                                    result = temp;
                                }
                            }

                        }

                    }


                }
            }
        }


        return result;

    }

*/



    public int maxSumSubmatrix(int[][] matrix, int k){
        int n=matrix[0].length;
        int m= matrix.length;
        int max = Integer.MIN_VALUE;
        for(int num=0;num<n;num++){
            int[] rowSum = new int[m];
            for(int j=num;j<n;j++){
                for(int i=0;i<m;i++){
                rowSum[i]+=matrix[i][j];
                }
                max = Math.max(max,dpMax(rowSum,k));
            }
        }
        return max;

    }

    private int dpMax(int[] rowSum, int k) {
        int max = Integer.MIN_VALUE;
        for(int i=0;i<rowSum.length;i++){
            int sum=0;

            for(int j=i;j<rowSum.length;j++){
                sum+=rowSum[j];
                if(sum>max && sum<=k) max=sum;
            }
        }
        return max;
    }


    public static void main(String[] args) {
        //1,0,1],[0,-2,3]
        int[][] intervals = {{5,-4,-3,4},{-3,-4,4,5},{5,1,5,-4}};
        Leecode363 leecode363 = new Leecode363();
        System.out.println(leecode363.maxSumSubmatrix(intervals, 3));
    }

}
