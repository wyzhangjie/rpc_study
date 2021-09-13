package questions.evrydaystep;

public class Leccode576 {
    private int[][] directions = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    int MOD = (int) 1e9 + 7;
    int dataM;
    int dataN;
    int[][][] cache;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] data = new int[m][n][maxMove + 1];
        dataM = m;
        dataN = n;


        for (int j = 0; j < m; j++) {
            for (int z = 0; z < n; z++) {
                for (int i = 0; i <= maxMove; i++) {
                    data[j][z][i] = -1;
                }
            }

            cache = data;

        }
        return dfs(startRow, startColumn, maxMove);
    }

    private int dfs(int startRow, int startColumn, int maxMove) {
        if (startRow < 0 || startRow >= dataM || startColumn < 0 || startColumn >= dataN) {
            return 1;
        }
        if (maxMove == 0) return 0;
        if (cache[startRow][startColumn][maxMove] != -1) {
            return cache[startRow][startColumn][maxMove];
        }
        int ans = 0;
        for (int[] direct : directions) {
            int nx = startRow + direct[0];
            int ny = startColumn + direct[1];
            ans += dfs(nx, ny, maxMove - 1);
            ans %= MOD;
        }
        cache[startRow][startColumn][maxMove] = ans;
        return ans;
    }

    public static void main(String[] args) {
        /**
         * 1
         * 3
         * 3
         * 0
         * 1
         * */
       int m = 1, n = 3, maxMove = 3, startRow = 0, startColumn = 1;
        Leccode576 leccode576 = new Leccode576();
        System.out.println(leccode576.findPaths(m,n,maxMove,startRow,startColumn));
    }



}
