package questions.evrydaystep;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Leecode496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        Deque<Integer> deque = new ArrayDeque<>();
        int n=nums2.length;
        for(int i=n-1;i>=0;i--){
            //单调栈(维持，从低到顶，逐渐递减。)
            while (!deque.isEmpty() && nums2[i]>deque.peek()){
                deque.pop();
            }
            map.put(nums2[i],deque.isEmpty()?-1:deque.peek());
            deque.push(nums2[i]);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; ++i) {
            res[i] = map.get(nums1[i]);
        }
        return res;

    }

    public static void main(String[] args) {
       int[] nums1 = new int[]{4,1,2};
       int[] nums2 = new int[]{1,3,4,2};
        Leecode496 leecode496 = new Leecode496();
        int[] result =leecode496.nextGreaterElement(nums1,nums2);
        for(int a:result){
            System.out.println(a);
        }
    }
}
