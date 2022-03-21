package questions.evrydaystep;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Leecode1705 {
    public int eatenApples(int[] apples, int[] days) {
        int answer = 0;
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < apples.length; i++) {
            while (!queue.isEmpty() && queue.peek()[0] <= i) {
                queue.poll();
            }

            int dieDay = i + days[i];
            int count = apples[i];
            if (count > 0) {
                queue.offer(new int[]{dieDay, count});
            }

            if (!queue.isEmpty()) {
                int[] arr = queue.peek();
                arr[1]--;
                if (arr[1] == 0) {
                    queue.poll();
                }
                answer++;
            }

        }
        int base = apples.length;
        while (!queue.isEmpty()) {
            while (!queue.isEmpty() && queue.peek()[0] <= base) {
                queue.poll();
            }
            if(queue.isEmpty()){
                return answer;
            }

            int[] arr = queue.poll();

            int last = Math.min(arr[0]-base,arr[1]);
            answer+=last;
            base+=last;
        }
        return answer;


    }

    public static void main(String[] args) {

        int[] apples = new int[]{2,1,10};
        int[] days = {2,10,1};
        Leecode1705 leecode1705 = new Leecode1705();
        System.out.println(leecode1705.eatenApples(apples, days));
    }
}
