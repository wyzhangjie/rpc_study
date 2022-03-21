package questions.evrydaystep;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 539. 最小时间差
 * 给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：timePoints = ["23:59","00:00"]
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：timePoints = ["00:00","23:59","00:00"]
 * 输出：0
 */
public class Leecode539 {
    public int findMinDifference(List<String> timePoints) {
        int len = timePoints.size();
        if (len > 1440) {
            return 0;
        }
        int ans=1440;

        int[] base = new int[1440 * 2];
        for (int i = 0; i < len; i++) {
            Integer hour = Integer.parseInt(timePoints.get(i).split(":")[0]);
            Integer second = Integer.parseInt(timePoints.get(i).split(":")[1]);
            base[hour * 60 + second] ++ ;
            base[hour * 60 + second+1440] ++;
        }
        int last=-1;
        for(int i=0;i<=1440*2;i++){
            if(base[i]>1){
                return 0;
            }
            if(base[i]==0){
                continue;
            }
            if(last!=-1){
                ans=Math.min(ans,i-last);

            }
            last=i;


        }
        return ans;

    }


    public static void main(String[] args) {
        Leecode539 leecode539 = new Leecode539();
        //timePoints = ["23:59","00:00"]
        List<String> timePoints = new ArrayList<>();
        timePoints.add("23:59");
        timePoints.add("00:00");

        System.out.println(leecode539.findMinDifference(timePoints));


    }
}
