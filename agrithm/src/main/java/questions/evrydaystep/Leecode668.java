package questions.evrydaystep;


/**
 * ClassName Leecode668
 * Description
 * Create by jie.zhang02
 * Date 2022/2/17 10:06 上午
 */

/**
 * @author jie.zhang
 * @date 2022年02月17日 10:06 上午
 * 在一个 n x n 的国际象棋棋盘上，一个骑士从单元格 (row, column) 开始，并尝试进行 k 次移动。行和列是 从 0 开始 的，所以左上单元格是 (0,0) ，右下单元格是 (n - 1, n - 1) 。
 *
 * 象棋骑士有8种可能的走法，如下图所示。每次移动在基本方向上是两个单元格，然后在正交方向上是一个单元格。
 *1 <= n <= 25
 * 0 <= k <= 100
 * 0 <= row, column <= n
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/knight-probability-in-chessboard
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leecode668 {

    int[][] moves = {{-1, -2}, {-2, -1},{-2, 1}, {-1, 2},{1, -2}, {2, -1},{2, 1}, {1, 2}};
    double rangeIn=0;
    double rangeOut=0;



    public double knightProbability(int n, int k, int row, int column) {

        subKnight(n,k,row,column,k);
        return rangeIn/Math.pow(8,k);

    }

    /**
     * @param n 整个正方格的个数
     * @param k
     * @param row
     * @param column

     */
    private void subKnight(int n, int k, int row, int column ,int sum) {

        if(k<0){
            return;
        }
        if(k==0){
            if(row>=0 && row<n && column>=0 && column<n){
                rangeIn++;
            }
        }

        for(int i=0;i<moves.length;i++){
            if(row+moves[i][0]>=0 && row+moves[i][0]<n && column+moves[i][1]>=0 && column+moves[i][1]<n){

                subKnight(n,k-1,row+moves[i][0],column+moves[i][1],sum);

            }


        }
    }


    public static void main(String[] args) {
        int n = 8;
        int k = 30;
        int row = 6;
        int column = 4;
        //8
        //30
        //6
        //4
        Leecode668 leecode668 = new Leecode668();
        System.out.println(
                leecode668.knightProbability(n,k,row,column)
        );
    }
}
