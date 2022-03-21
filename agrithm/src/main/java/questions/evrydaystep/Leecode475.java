package questions.evrydaystep;

import java.util.Arrays;

public class Leecode475 {
    public int findRadius(int[] houses, int[] heaters) {
        int heaterLen = heaters.length;
        int houseLen = houses.length;
        Arrays.sort(houses);
        Arrays.sort(heaters);
       int result=0;
       for(int i=0,j=0;i<houseLen;i++){
           int curDistance = Math.abs(houses[i]-heaters[j]);
           while (j<heaterLen-1 && curDistance>=Math.abs(houses[i]-heaters[j+1])){
               curDistance = Math.abs(houses[i]-heaters[j+1]);
               j++;
           }
           result=Math.max(result,curDistance);
       }
        return result;
    }

    public static void main(String[] args) {
     int[] houses = new int[]{1,5};
     int[] heaters = {2};
        Leecode475 leecode475 = new Leecode475();
        System.out.println(leecode475.findRadius(houses,heaters));
    }
}
