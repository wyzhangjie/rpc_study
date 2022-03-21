package questions.weekcontent;

import java.util.Arrays;

/**
 * ClassName Leecode5993
 * Description
 * Create by jie.zhang02
 * Date 2022/1/30 10:33 上午
 */
public class Leecode5993 {
    public int findFinalValue(int[] nums, int original) {
        Arrays.sort(nums);
        for(int a:nums){
            if(a==original){
                original*=2;
            }
        }
        return original;
    }

    public static void main(String[] args) {
        int[] a= new int[]{5,3,6,1,12};
        Leecode5993 leecode5993 = new Leecode5993();
        System.out.println(leecode5993.findFinalValue(a,3));
    }
}
