package questions.evrydaystep;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 * <p>
 * <p>
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *  
 * <p>
 * 提示：
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leecode54 {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if(matrix==null || matrix.length==0 || matrix[0].length==0){
            return result;
        }

        int top = 0;
        int button = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        while (top <= button && left <= right) {
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            for (int j = top+1; j <=button; j++) {
                result.add(matrix[j][right]);
            }

            if(left<right && top<button){
                for (int z = right-1 ; z > left; z--) {
                    result.add(matrix[button][z]);
                }

                for (int x = button; x > top; x--) {
                    result.add(matrix[x][left]);

                }
            }



            top = top + 1;
            button = button - 1;
            left = left + 1;
            right = right - 1;

        }

        return result;
    }

    public void print(List<Integer> list) {
        Iterator<Integer> itor = list.iterator();
        while (itor.hasNext()) {
            System.out.println(itor.next());
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Leecode54 leecode54 = new Leecode54();
        leecode54.print(leecode54.spiralOrder(matrix));
    }
}
