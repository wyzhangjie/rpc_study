package questions.evrydaystep;


import java.util.PriorityQueue;

public class Leecode414 {
    public int thirdMax(int[] nums) {
        PriorityQueue<Long> stack = new PriorityQueue<Long>((a, b) -> b - a > 0 ? -1 : 1);
        for(int t:nums){
            if(stack.size()<3){
                if(!stack.contains((long)t)){
                    stack.add((long)t);
                }

            }else {
                if(stack.peek()<t){
                    if(!stack.contains((long)t)){
                        stack.poll();
                        stack.add((long)t);
                    }

                }
            }
        }
        long result = stack.peek();
        if(stack.size()<3){
            while (!stack.isEmpty()){
                result=stack.poll();
            }

        }
        return (int) result;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,5,3,5};
        Leecode414 leecode414 = new Leecode414();
        System.out.println(leecode414.thirdMax(nums));
    }
}
