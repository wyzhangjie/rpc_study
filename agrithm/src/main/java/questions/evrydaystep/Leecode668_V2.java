package questions.evrydaystep;/**
 * ClassName Leecode668_V2
 * Description
 * Create by jie.zhang02
 * Date 2022/2/17 4:00 下午
 */

/**
 * @author jie.zhang
 * @date 2022年02月17日 4:00 下午
 */
public class Leecode668_V2 {
    int[][] moves = {{-1, -2}, {-2, -1},{-2, 1}, {-1, 2},{1, -2}, {2, -1},{2, 1}, {1, 2}};

    public double knightProbability(int n, int k, int row, int column) {
        double[][][] dp = new double[k+1][n][n];
        for(int step=0;step<=k;step++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(step==0){
                        dp[step][i][j]=1;
                    }else {
                        for(int[] move:moves){
                            int x= i+move[0];
                            int y=j+move[1];
                            if (x >= 0 && x < n && y >= 0 && y < n) {
                                dp[step][i][j] += dp[step - 1][x][y] / 8;
                            }
                        }
                    }
                }
            }
        }
        return dp[k][row][column];
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
        Leecode668_V2 leecode668 = new Leecode668_V2();
        System.out.println(
                leecode668.knightProbability(n,k,row,column)
        );
    }
}
