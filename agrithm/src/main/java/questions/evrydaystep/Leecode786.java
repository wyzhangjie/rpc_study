package questions.evrydaystep;

import java.util.PriorityQueue;
import java.util.Queue;

public class Leecode786 {

    public int[] kthSmallestPrimeFraction1(int[] arr, int k) {
        int n = arr.length;
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->Double.compare(b[0]*1.0/b[1],a[0]*1.0/a[1]));
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double t = arr[i] * 1.0 / arr[j];
                if (q.size() < k || q.peek()[0] * 1.0 / q.peek()[1] > t) {
                    if (q.size() == k) q.poll();
                    q.add(new int[]{arr[i], arr[j]});
                }
            }
        }
        return q.poll();
    }


    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        //保持一个最大顶堆，最上面是这k个数字最大的。
        Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[0]*o2[1]>o1[1]*o2[0]?-1: 1);

        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                //1、找到比大顶堆的顶数据小的数据就放入到顶堆当中
                //2，1成立的情况下，如果某数字的分数小于大顶堆的顶堆数据，那么就把顶堆弹出去，放置进来小的分数的数据。
                //3、到最后，这个大顶堆就是这个k数据里面最大的分数，但是确实整个数组当中最小的k个分数的集合。
                if(queue.size()<k){
                    queue.add(new int[]{arr[i],arr[j]});
                }else {
                    if(  queue.peek()[0]*arr[j]>queue.peek()[1]*arr[i]){
                        if(queue.size()==k) {
                            queue.poll();
                        }
                        queue.add(new int[]{arr[i],arr[j]});

                    }
                }






            }
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,5};
        Leecode786 leecode786 = new Leecode786();
        int[] result = leecode786.kthSmallestPrimeFraction(arr,3);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }
}
