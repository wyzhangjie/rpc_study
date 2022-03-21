package questions.evrydaystep;

import java.util.*;

public class Leecode1345 {
    public int minJumps(int[] arr) {
        //第一步骤：1把所有数值相同的位置，归为一个列表当中
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
           List list =  map.getOrDefault(arr[i],new ArrayList<>());
            list.add(i);
            map.put(arr[i],list);
        }
        //第二步骤，建立一个visit数据，表示各个位置是否被访问过了。
        Set<Integer> visitedIndex = new HashSet<Integer>();
        visitedIndex.add(0);

        Queue<int[]> queue = new ArrayDeque();
        queue.offer(new int[]{0,0});
        while (!queue.isEmpty()){
           int[] temp= queue.poll();
           int index = temp[0];
           int step= temp[1];
           if(index==(arr.length-1)){
               return step;
           }
           step++;
           if(map.containsKey(arr[index])){
               for(int t:map.get(arr[index])){
                   if(visitedIndex.add(t)){
                       queue.offer(new int[] {t,step});
                   }
               }
               map.remove(arr[index]);

           }
           if(index+1<arr.length && visitedIndex.add(index+1)){
               queue.offer(new int[] {index+1,step});
           }
            if(index-1>=0 && visitedIndex.add(index-1)){
                queue.offer(new int[] {index-1,step});
            }
        }
        return -1;


    }

    public static void main(String[] args) {
        Leecode1345 leecode1345 =new Leecode1345();
        int[] a= {100,-23,-23,404,100,23,23,23,3,404};
        System.out.println(leecode1345.minJumps(a));
    }
}
