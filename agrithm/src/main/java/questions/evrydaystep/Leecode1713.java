package questions.evrydaystep;

import java.util.*;

public class Leecode1713 {
    public int minOperations(int[] target, int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<target.length;i++){
            map.put(target[i],i);
        }
        List<Integer> list = new ArrayList<>();
        for(int a:arr){
            if(map.containsKey(a)) {
                int index = map.get(a);
                int pos = binchSearch(list,index);
                if(pos!=list.size()){
                    list.set(pos,index);
                }else {
                    list.add(index);
                }
            }

        }
        return target.length-list.size();
    }

    private int binchSearch(List<Integer> list, int index) {
        if(list.size()==0|| list.get(list.size()-1)<index){
            return list.size();
        }
        int left=0;
        int right=list.size();
        while (left<right){
            int mid = left+(right-left)/2;
            if(list.get(mid)<index){
                left= mid+1;
            }else {
                right=mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        //target = [5,1,3], arr = [9,4,2,3,4]
        //target = [6,4,8,1,3,2], arr = [4,7,6,2,3,8,6,1]
        int[] target = new int[]{5,1,3};
        int[] arr= new int[]{9,4,2,3,4};
        Leecode1713 leecode1713 = new Leecode1713();
        System.out.println(leecode1713.minOperations(target,arr));
    }
}
