package questions.evrydaystep;
/**
 * 给你一个 m x n 的矩阵 matrix 。如果这个矩阵是托普利茨矩阵，返回 true ；否则，返回 false 。
 *
 * 如果矩阵上每一条由左上到右下的对角线上的元素都相同，那么这个矩阵是 托普利茨矩阵 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/toeplitz-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class Leecode776 {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int heng = matrix.length;
        int lie =matrix[0].length;
        //先计算横向
        int j=lie-1;
        int i=heng-1;
        while (j>=1){
            int step=1;
            while (j-step>=0 && i-step>=0){
                if(matrix[i-step][j-step]!=matrix[heng-1][j]){
                    return false;
                }
                step++;
            }
            j--;
        }
        //计算纵向
        i=heng-2;
        j=lie-1;
        while (i>=1){
            int step=1;
            while (j-step>=0 && i-step>=0){
                if(matrix[i-step][j-step]!=matrix[i][j]){
                    return false;
                }
                step++;
            }
            i--;
        }
        return true;
    }

    public static void main(String[] args) {
      /*  int[][] matrix={{1,2,3,4},{5,1,2,3},{9,5,1,2}};*/
        int[][] matrix={{1,2},{2,2}};
        /*
        [[44,35,39],[15,44,35],[17,15,44],[80,17,15],[43,80,0],[77,43,80]]
        * */
        int[][] ma={{44,35,39},{15,44,35},{17,15,44},{80,17,15},{43,80,0},{77,43,80}};
        Leecode776 leecode776 = new Leecode776();
        System.out.println(leecode776.isToeplitzMatrix(ma));
    }
}
