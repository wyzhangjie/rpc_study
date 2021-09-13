package questions.evrydaystep;

import java.util.Arrays;

public class Leecode881 {
    public int numRescueBoats(int[] people, int limit) {
        int sum =0;
        Arrays.sort(people);
        int i=0;
        int j=people.length-1;
        while (i<=j){
            if(people[i]+people[j]<=limit){
                i++;
            }
            j--;
            sum++;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2};
        Leecode881 leecode881 = new Leecode881();
        System.out.println(leecode881.numRescueBoats(nums,3));
    }
}
