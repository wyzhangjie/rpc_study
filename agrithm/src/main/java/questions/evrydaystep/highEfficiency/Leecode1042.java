package questions.evrydaystep.highEfficiency;/**
 * ClassName Leecode1042
 * Description
 * Create by jie.zhang02
 * Date 2022/3/7 10:40 上午
 */

import java.util.*;

/**
 * @author jie.zhang
 * @date 2022年03月07日 10:40 上午
 */
public class Leecode1042 {
    int[] color = {1, 2, 3, 4};

    public int[] gardenNoAdj(int n, int[][] paths) {
        int[] result = new int[n];
        Arrays.fill(result, 1);
        if(paths.length<1){
            return  result;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(i,new ArrayList<>());
        }
        for (int i = 0; i < paths.length; i++) {

            int a = paths[i][0] - 1;
            int b = paths[i][1] - 1;
            List<Integer> alist = map.getOrDefault(a, new ArrayList<>());
            List<Integer> blist = map.getOrDefault(b, new ArrayList<>());
            alist.add(b);
            blist.add(a);
            map.put(a, alist);
            map.put(b, blist);
        }


            for (int i = 0; i < n; i++) {

                boolean[] used = new boolean[4];
                List<Integer> list = map.get(i);
                for (Integer tt : list) {
                    used[result[tt]-1] = true;
                }
                for (int t = 0; t < used.length; t++) {
                    if (!used[t]) {
                        result[i] = color[t];
                    }
                }
            }


        return result;


    }

    public static void main(String[] args) {
        Leecode1042 leecode1042 = new Leecode1042();
        // int[][] paths = {{1, 2}, {2, 3}, {3, 4}, {4, 1}, {1, 3}, {2, 4}};
        //4
        //[[3,4],[4,2],[3,2],[1,3]]
        //4
        //[[1,2],[2,3],[3,4],[4,1],[1,3],[2,4]]
        //5
        //[[4,1],[4,2],[4,3],[2,5],[1,2],[1,5]]
        //10000
        //[[1,2]]
        int[][] paths = {{1,2}};
        int[] result = leecode1042.gardenNoAdj(10000, paths);
        for (int a : result) {
            System.out.println(a);
        }

    }
}
