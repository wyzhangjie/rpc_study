package questions.evrydaystep;/**
 * ClassName Leecode668_New
 * Description
 * Create by jie.zhang02
 * Date 2022/2/17 3:41 下午
 */

/**
 * @author jie.zhang
 * @date 2022年02月17日 3:41 下午
 */
public class Leecode668_New {
    int[][] moves = {{-1, -2}, {-2, -1},{-2, 1}, {-1, 2},{1, -2}, {2, -1},{2, 1}, {1, 2}};

    public double knightProbability(int n, int k, int row, int column) {
        double[][][] memo = new double[n][n][k+1];
        return dfs(k,row,column,n,memo);
    }

    /**
     * @param k 需要走的步骤
     * @param row 这个正方形的格栅板
     * @param column
     * @param n
     * @return
     */
    private double dfs(int k, int row, int column, int n,double[][][] memo) {
        if(row<0||row>=n || column<0 || column>=n){
            return 0;
        }
        if(k==0){
            return 1;
        }

        if(memo[row][column][k]!=0){
            return memo[row][column][k];
        }
        double ans=0;
        for(int i=0;i<moves.length;i++){
            ans+=dfs(k-1,row+moves[i][0],column+moves[i][1],n,memo)/8;
        }
        memo[row][column][k]=ans;
        return ans;

    }

    public static void main(String[] args) {
        int n = 3;
        int k = 2;
        int row = 0;
        int column = 0;
        //8
        //30
        //6
        //4
        Leecode668_New leecode668 = new Leecode668_New();
        System.out.println(
                leecode668.knightProbability(n,k,row,column)
        );
    }
}
