package questions.evrydaystep;/**
 * ClassName Leecode1219
 * Description
 * Create by jie.zhang02
 * Date 2022/2/5 7:22 下午
 */

/**
 * @author jie.zhang
 * @date 2022年02月05日 7:22 下午
 */
public class Leecode1219 {
    private int[][] direct = {{1,0},{0,1},{-1,0},{0,-1}};

    private int[][] grid;
    int result=0;
    public int getMaximumGold(int[][] grid) {
        this.grid=grid;

       for(int i=0;i<grid.length;i++){
           for(int j=0;j<grid[0].length;j++){
               if(grid[i][j]!=0){
                   dfs(i,j,0);
               }
           }
       }

        return result;
    }

    private void dfs( int x, int y, int gold) {
        gold+=grid[x][y];
        result=Math.max(result,gold);
        int temp = grid[x][y];
        grid[x][y]=0;
        for(int i=0;i<direct.length;i++){
            int x1 =x+direct[i][0];
            int y1=y+direct[i][1];
            if(x1>=0 && x1<grid.length && y1>=0 && y1<grid[0].length && grid[x1][y1]>0){
                dfs(x1,y1,gold);
            }

        }
        grid[x][y]=temp;
    }

    public static void main(String[] args) {
      int[][]  grid = {{0,6,0},{5,8,7},{0,9,0}};
        Leecode1219 leecode1219 = new Leecode1219();
        System.out.println(leecode1219.getMaximumGold(grid));
    }

}
