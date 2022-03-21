package questions.evrydaystep;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Leecode846 {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int len = hand.length;
        if(len%groupSize!=0){
            return false;
        }
        Arrays.sort(hand);
        Map<Integer,Integer> map = new HashMap<>();
        for(int s:hand){
            map.put(s,map.getOrDefault(s,0)+1);
        }
        for(int t:hand){
            if(map.get(t)==null){
                continue;
            }
            for(int i=0;i<groupSize;i++){
                int pos = t+i;
                if(map.get(pos)==null || map.get(pos)<=0){
                    return false;
                }
                map.put(pos, map.get(pos)-1);
                if(map.get(pos)<=0){
                    map.remove(pos);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] hand = new int[]{1,2,3,6,2,3,4,7,8};
        int groupSize = 3;
        Leecode846 leecode846 = new Leecode846();
        System.out.println(leecode846.isNStraightHand(hand,groupSize));
    }
}
