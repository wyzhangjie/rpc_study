package questions.evrydaystep;

import java.util.*;

public class Leecode373 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new LinkedList<>();
        //用优先级队列来求解
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(Comparator.comparingInt(a -> (nums1[a[0]] + nums2[a[1]])));
       for(int i=0;i<Math.min(nums1.length,k);i++){

           queue.offer(new int[]{i,0});
       }
       while (k-->0 && !queue.isEmpty()){
           int[] temp =queue.poll();
           result.add(Arrays.asList(nums1[temp[0]],nums2[temp[1]]));
           if(++temp[1]<nums2.length){
               queue.offer(temp);
           }

       }
       return result;

    }
    public static void main(String[] args) {
        //[1,2]
        //[3]
        //3
    int[]    nums1 = {1,2}, nums2 = {3};
    int k = 3;
        Leecode373 leecode373 = new Leecode373();
        System.out.println(leecode373.kSmallestPairs(nums1,nums2,k));
    }
}
