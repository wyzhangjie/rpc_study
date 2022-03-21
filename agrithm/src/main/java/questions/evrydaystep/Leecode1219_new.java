package questions.evrydaystep;/**
 * ClassName Leecode1219_new
 * Description
 * Create by jie.zhang02
 * Date 2022/2/7 7:39 上午
 */

/**
 * @author jie.zhang
 * @date 2022年02月07日 7:39 上午
 */
public class Leecode1219_new {
        static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int[][] grid;
        int m, n;
        int ans = 0;

        public int getMaximumGold(int[][] grid) {
            this.grid = grid;
            this.m = grid.length;
            this.n = grid[0].length;
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (grid[i][j] != 0) {
                        dfs(i, j, 0);
                    }
                }
            }
            return ans;
        }

        public void dfs(int x, int y, int gold) {
            gold += grid[x][y];
            ans = Math.max(ans, gold);

            int rec = grid[x][y];
            grid[x][y] = 0;

            for (int d = 0; d < 4; ++d) {
                int nx = x + dirs[d][0];
                int ny = y + dirs[d][1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] > 0) {
                    dfs(nx, ny, gold);
                }
            }

            grid[x][y] = rec;
        }

    public static void main(String[] args) {
        int[][]  grid = {{0,6,0},{5,8,7},{0,9,0}};
        Leecode1219_new leecode1219 = new Leecode1219_new();
        System.out.println(leecode1219.getMaximumGold(grid));
    }

}


