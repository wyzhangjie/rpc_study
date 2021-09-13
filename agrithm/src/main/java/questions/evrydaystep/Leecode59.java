package questions.evrydaystep;

import java.util.ArrayList;
import java.util.List;

public class Leecode59 {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        if(n==0){
            return null;
        }

        int top = 0;
        int button = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        int digit=1;
        while (top <= button && left <= right) {
            for (int i = left; i <= right; i++) {
                matrix[top][i]=digit++;
            }
            for (int j = top+1; j <=button; j++) {
                matrix[j][right]=digit++;
            }

            if(left<right && top<button){
                for (int z = right-1 ; z > left; z--) {
                    matrix[button][z]=digit++;
                }

                for (int x = button; x > top; x--) {
                    matrix[x][left]=digit++;

                }
            }



            top = top + 1;
            button = button - 1;
            left = left + 1;
            right = right - 1;

        }

        return matrix;
    }

    private  void print(int[][] maxtrix){
        for(int i=0;i<maxtrix.length;i++){
            for(int j=0;j<maxtrix[0].length;j++){
                System.out.println(maxtrix[i][j]);
            }
        }
    }

    public static void main(String[] args) {
        Leecode59 leecode59 = new Leecode59();
        leecode59.print(leecode59.generateMatrix(3));
    }
}
