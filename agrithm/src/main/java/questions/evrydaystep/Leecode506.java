package questions.evrydaystep;

import java.util.*;

public class Leecode506 {

    public String[] findRelativeRanks(int[] score) {
        String[] result = new String[score.length];


        Queue<int[]> queue = new PriorityQueue<>((a, b) -> b[0] - a[0] > 0 ? 1 : -1
        );
        for(int i=0;i<score.length;i++){
            int[] data = new int[2];
            data[0]=score[i];
            data[1]=i;
            queue.add(data);
        }

        for(int i=0;i<score.length;i++){
            int[] temp = queue.poll();
            if(i==0){
                result[temp[1]]="Gold Medal";
            }else
            if(i==1){
                result[temp[1]]="Silver Medal";
            }else
            if(i==2){
                result[temp[1]]="Bronze Medal";
            }else {
                result[temp[1]]=String.valueOf(i+1);
            }
        }
        return result;


    }

    public static void main(String[] args) {
       int[] score = new int[]{5,4,3,2,1};
        Leecode506 leecode506 = new Leecode506();
        String[] result = leecode506.findRelativeRanks(score);
        for(String tep :result){
            System.out.println(tep);
        }
    }
}
