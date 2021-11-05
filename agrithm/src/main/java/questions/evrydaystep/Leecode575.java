package questions.evrydaystep;

import java.util.HashSet;
import java.util.Set;

public class Leecode575 {


    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet();
        for(int aa :candyType){
        set.add(aa);
        }
        return set.size()>candyType.length/2?candyType.length/2: set.size();
    }

    public static void main(String[] args) {
      int[]  candies = new int[]{1,1,2,3};
        Leecode575 leecode575 = new Leecode575();
        System.out.println(leecode575.distributeCandies(candies));
    }
}
