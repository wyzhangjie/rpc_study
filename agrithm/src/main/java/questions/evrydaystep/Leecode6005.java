package questions.evrydaystep;

/**
 * ClassName Leecode6005
 * Description
 * Create by jie.zhang02
 * Date 2022/2/14 11:33 上午
 */

import java.util.*;

/**
 * @author jie.zhang
 * @date 2022年02月14日 11:33 上午
 */
public class Leecode6005 {
    public int minimumOperations(int[] nums) {
        int result=0;
        if(nums.length==1){
            return 0;
        }
        Map<Integer, Integer> odd = new HashMap<>();

        Map<Integer, Integer> even = new HashMap<>();

        for (int i = 0; i < nums.length; i += 2) {
            even.put(nums[i], even.getOrDefault(nums[i], 0) + 1);
        }
        for (int i = 1; i < nums.length; i += 2) {
            odd.put(nums[i], odd.getOrDefault(nums[i], 0) + 1);
        }


        List<Map.Entry<Integer, Integer>> oddSort = new ArrayList<>(odd.entrySet());
        Collections.sort(oddSort, (o1, o2) -> {
            if (o1.getValue() < o2.getValue()) {
                return 1;
            } else if (o1.getValue() > o2.getValue()) {
                return -1;
            } else {
                return 0;
            }

        });

        List<Map.Entry<Integer, Integer>> evenSort = new ArrayList<>(even.entrySet());
        Collections.sort(evenSort, (o1, o2) -> {
            if (o1.getValue() < o2.getValue()) {
                return 1;
            } else if (o1.getValue() > o2.getValue()) {
                return -1;
            } else {
                return 0;
            }

        });
        if (!oddSort.get(0).getKey().equals(evenSort.get(0).getKey())) {
            return nums.length-oddSort.get(0).getValue()-evenSort.get(0).getValue();
        }
        if (oddSort.get(0).getKey().equals(evenSort.get(0).getKey())) {
            //return Math.min(nums.length-oddSort.get(0).getValue()-evenSort.get(1).getValue(),nums.length-oddSort.get(1).getValue()-evenSort.get(0).getValue());
            if (oddSort.size() == 1 && evenSort.size() == 1) {
                return nums.length - Math.max(evenSort.get(0).getValue(), oddSort.get(0).getValue());
            } else if (oddSort.size() == 1) {
                return Math.min(oddSort.get(0).getValue(), evenSort.get(1).getValue());
            } else if (evenSort.size() == 1) {
                return Math.min(oddSort.get(1).getValue(), evenSort.get(0).getValue());
            } else {
                return nums.length - Math.max(oddSort.get(1).getValue() + evenSort.get(0).getValue(), oddSort.get(0).getValue() + evenSort.get(1).getValue());
            }

        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,2,2};
        Leecode6005 leecode6005 = new Leecode6005();
        System.out.println(
                leecode6005.minimumOperations(nums)
        );

    }

}
