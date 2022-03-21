package questions.evrydaystep;

import java.util.HashMap;
import java.util.Map;

public class Leecode807 {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int result =0 ;
        Map<Integer, Integer> hang = new HashMap<>();
        Map<Integer, Integer> lie = new HashMap<>();
        for (int i = 0; i < grid.length; i++) {
            int temp = 0;
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] > temp) {
                    temp = grid[i][j];
                }
            }
            hang.put(i, temp);
        }

        for (int j = 0; j < grid[0].length; j++) {
            int temp = 0;
            for (int i = 0; i < grid.length; i++) {
                if (grid[i][j] > temp) {
                    temp = grid[i][j];
                }
            }
            lie.put(j, temp);
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int a = hang.get(i);
                int b= lie.get(j);
                int max = Math.min(a,b);
                if(grid[i][j]<max){
                    result+=(max-grid[i][j]);
                }
            }
        }
        return  result;

    }

    public static void main(String[] args) {
        int[][] grid = {{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}};
        Leecode807 leecode807 = new Leecode807();
        System.out.println(leecode807.maxIncreaseKeepingSkyline(grid));
    }
}
