package questions.evrydaystep;/**
 * ClassName Leecode1380
 * Description
 * Create by jie.zhang02
 * Date 2022/2/15 9:38 下午
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author jie.zhang
 * @date 2022年02月15日 9:38 下午
 */
public class Leecode1380 {
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int[] hengs = new int[matrix.length];
        int[] lie = new int[matrix[0].length];
        for (int i = 0; i < hengs.length; i++) {
            hengs[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                hengs[i] = Math.min(matrix[i][j], hengs[i]);
            }
        }

        for (int j = 0; j < matrix[0].length; j++) {
            for (int i = 0; i < matrix.length; i++) {

                if (lie[j] < matrix[i][j]) {
                    lie[j] = matrix[i][j];
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == hengs[i] && matrix[i][j] == lie[j]) {
                    list.add(matrix[i][j]);
                }
            }


        }
        return list;
    }

    public static void main(String[] args) {
        int[][] matrix = {{3,7,8},{9,11,13},{15,16,17}};
        Leecode1380 leecode1380 = new Leecode1380();
        System.out.println(leecode1380.luckyNumbers(matrix));
    }
}
