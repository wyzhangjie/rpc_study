package questions.evrydaystep;

import java.util.*;

public class Leecode1743 {
    public int[] restoreArray(int[][] adjacentPairs) {

            int start =0;
            int[] result = new int[adjacentPairs.length+1];

            Map<Integer,List<Integer>> map = new HashMap<>();
            for(int i=0;i<adjacentPairs.length;i++){
                map.putIfAbsent(adjacentPairs[i][0],new ArrayList<>());
                map.putIfAbsent(adjacentPairs[i][1],new ArrayList<>());
                map.get(adjacentPairs[i][0]).add(adjacentPairs[i][1]);
                map.get(adjacentPairs[i][1]).add(adjacentPairs[i][0]);

            }
            for(Map.Entry<Integer,List<Integer>> entry:map.entrySet()){
                if(entry.getValue().size()==1){
                    start = entry.getKey();
                    break;
                }
            }
            result[0]=start;

            result[1]=map.get(result[0]).get(0);
            for(int i=2;i<adjacentPairs.length+1;i++){
               result[i]= map.get(result[i-1]).get(0)==result[i-2]? map.get(result[i-1]).get(1):map.get(result[i-1]).get(0);
            }

        return result;

    }

    public static void main(String[] args) {
       int[][] adjacentPairs =new int[][] {{2,1},{3,4},{3,2}};
        Leecode1743 leecode1743 = new Leecode1743();
        System.out.println(leecode1743.restoreArray(adjacentPairs));
        }


}
