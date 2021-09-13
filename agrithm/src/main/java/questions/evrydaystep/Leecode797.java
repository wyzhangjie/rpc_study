package questions.evrydaystep;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leecode797 {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        int num = graph.length;
        boolean[] booleans = new boolean[num];
        List list = new ArrayList<>();
        list.add(0);
        deepInfo(graph,list,num-1,booleans,0,result);
        return  result;
    }

    private void deepInfo(int[][] graph,List<Integer> list,int total,boolean[] flags,int mid,List<List<Integer>> result) {
        if(list.size()>=1 && list.get(list.size()-1)==total){
            List<Integer> subResult = new ArrayList<>(list);
            result.add(subResult);
        }else {
           int[] temp = graph[mid];

            for(int p:temp){
                list.add(p);
                flags[p]=true;
                deepInfo(graph,list,total,flags,p,result);
                list.remove((Integer) p);
                flags[p]=false;
            }
        }
    }

    public static void main(String[] args) {
        //[[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
      int[][] nums= {{4,3,1},{3,2,4},{3},{4},{}};
      int[][] nums1={{1},{}};
        Leecode797 leecode797 = new Leecode797();
        System.out.println(leecode797.allPathsSourceTarget(nums));
        System.out.println(leecode797.allPathsSourceTarget(nums1));
    }
}
