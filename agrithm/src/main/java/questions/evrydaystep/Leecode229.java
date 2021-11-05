package questions.evrydaystep;

import java.util.ArrayList;
import java.util.List;

public class Leecode229 {
    public List<Integer> majorityElement(int[] nums) {

        int first=0;
        int second=0;
        int firstcount=0;
        int secondcount=0;
        for(int a:nums){
            if(firstcount!=0 && first==a){
                firstcount++;
            }
          else   if(secondcount!=0 && second==a){
                secondcount++;
            }
           else if(firstcount==0 ){
                firstcount++;
                first=a;
            }
           else if(secondcount==0 ){
                secondcount++;
                second=a;
            }else {
                firstcount--;
                secondcount--;
            }
        }
        firstcount=0;
        secondcount=0;

        for(int i=0;i<nums.length;i++){
            if(nums[i]==first){
                firstcount++;
            }else if(nums[i]==second){
                secondcount++;
            }
        }
        List<Integer> list = new ArrayList<>();
        if(firstcount>nums.length/3){
           list.add(first);
        }
       else if(secondcount>nums.length/3){
            list.add(second);
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2};
        Leecode229 leecode229 = new Leecode229();
        System.out.println(
                leecode229.majorityElement(nums)
        );
    }
}
