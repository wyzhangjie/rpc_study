package questions.evrydaystep;

import java.util.*;

/**
 * ClassName Leecode1765
 * Description
 * Create by jie.zhang02
 * Date 2022/1/29 11:28 上午
 */
public class Leecode1765 {
    int[][] directions = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};

    public int[][] highestPeak(int[][] isWater) {
        int[][] result = new int[isWater.length][isWater[0].length];
        for(int i=0;i<isWater.length;i++){
            Arrays.fill(result[i], -1);
        }

        Queue<int[]> array = new LinkedList<>();
        for (int i = 0; i < isWater.length; i++) {
            for (int j = 0; j < isWater[0].length; j++) {
                if (isWater[i][j] == 1) {
                    array.add(new int[]{i, j});
                    result[i][j] = 0;
                }
            }
        }

        while (!array.isEmpty()) {
            int[] element = array.poll();
            for (int[] direction : directions) {
                if (element[0] + direction[0] >= 0 && element[0] + direction[0] < isWater.length && element[1] + direction[1] >= 0
                        && element[1] + direction[1] < isWater[0].length && result[element[0] + direction[0]][element[1] + direction[1]]==-1) {
                    result[element[0] + direction[0]][element[1] + direction[1]]=result[element[0]][element[1]]+1;
                    array.offer(new int[] {element[0] + direction[0],element[1] + direction[1]});
                }
            }
        }





     /*   while (!array.isEmpty()){

                int[] element=  array.poll();
                if(element[0]-1>=0 && isWater[element[0]-1][element[1]]!=1){
                    result[element[0]-1][element[1]]=result[element[0]][element[1]]+1;
                    array.offer(new int[]{element[0]-1,element[1]});
                }
                if(element[0]+1<isWater.length && isWater[element[0]+1][element[1]]!=1){
                    result[element[0]+1][element[1]]=result[element[0]][element[1]]+1;
                    array.offer(new int[]{element[0]+1,element[1]});
                }
                if(element[1]+1<isWater[0].length && isWater[element[0]][element[1]+1]!=1){
                    result[element[0]][element[1]+1]=result[element[0]][element[1]]+1;
                    array.offer(new int[]{element[0],element[1]+1});
                }
                if(element[1]-1>=0 && isWater[element[0]][element[1]-1]!=1){
                    result[element[0]][element[1]-1]=result[element[0]][element[1]]+1;
                    array.offer(new int[]{element[0],element[1]-1});
                }



        }
*/

        return result;
    }

    public static void main(String[] args) {
        int[][] isWater = new int[][]{{0, 1}, {0, 0}};
        Leecode1765 leecode1765 = new Leecode1765();
        int[][] result = leecode1765.highestPeak(isWater);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.println(result[i][j]);
            }
        }
    }
}
