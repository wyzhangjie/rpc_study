package questions.evrydaystep;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Leecode502 {
    private int max = 0;


    public int findMaximizedCapital1(int k, int w, int[] profits, int[] capital) {
        int[][] a = new int[profits.length][2];
        for(int i=0;i<profits.length;i++){
            a[i][0]=capital[i];
            a[i][1]=profits[i];
        }
        Arrays.sort(a, Comparator.comparingInt(p -> p[0]));
        int start=0;

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((m,n)->n-m);

        for(int count=0;count<k;count++){
            while (start<profits.length && w>=a[start][0]){
                priorityQueue.add(a[start][1]);
                start++;
            }
            if(!priorityQueue.isEmpty()){
                w+=priorityQueue.poll();
            }else {
                break;
            }
        }
        return w;


    }


    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        boolean[] flag = new boolean[profits.length];
        deepFind(k, w, profits, capital, flag, 0);
        return max;

    }





    private void deepFind(int k, int w, int[] profits, int[] capital, boolean[] flag, int index) {
        if (w > max) {
            max = w;

        }
        if (k <= 0|| index>=capital.length) {
            return;
        }
        if(w<capital[index]){
            return;
        }

        if (!flag[index]) {

                flag[index] = true;
                deepFind(k - 1, w + profits[index] , profits, capital, flag, index + 1);


        }
        flag[index] = false;
        deepFind(k + 1, w - profits[index] , profits, capital, flag, index + 1);


    }

    public static void main(String[] args) {
        int k = 2, w = 0;
        int[] profits = new int[]{1, 2, 3};
        int[] capital = new int[]{0, 1, 1};
        Leecode502 leecode502 = new Leecode502();
        System.out.println(leecode502.findMaximizedCapital(k, w, profits, capital));

        System.out.println(leecode502.findMaximizedCapital1(k, w, profits, capital));
    }
}
