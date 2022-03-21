package questions.weekcontent;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName Leecode5981
 * Description
 * Create by jie.zhang02
 * Date 2022/1/30 10:39 上午
 */
public class Leecode5981 {
    public List<Integer> maxScoreIndices(int[] nums) {
        //前缀和，左前缀和表示0的个数
        int[] left = new int[nums.length+1];
        left[0] =0;
        for (int i = 1; i <=nums.length; i++) {
            left[i]=left[i-1]+(nums[i-1]==0?1:0);
        }
        //后缀和，右后缀和 表示1的个数
        int[] right = new int[nums.length+1];
        right[nums.length] =0;

        for(int i=nums.length-1;i>=0;i--){
            right[i]=right[i+1]+(nums[i]==1?1:0);
        }
        int max=-1;
        List<Integer> result = new ArrayList<>();

        if(left[0]>max){
            max=left[0];
            result.add(0);
        }
        if(left[nums.length]>=max){

            if(left[nums.length]!=max){
                result.clear();
            }
            max=left[nums.length];

            result.add(nums.length);
        }
        if(right[0]>=max){


            if(right[0]!=max){
                result.clear();
            }
            max=right[0];
            result.add(0);
        }

        if(right[nums.length]>=max){

            if(right[nums.length]!=max){
                result.clear();
            }
            max=right[nums.length];
            result.add(right[nums.length]);
        }

        for(int i=0;i<nums.length-1;i++){
            if(left[i+1]+right[i+1]>max){
                max = left[i+1]+right[i+1];
                result.clear();
                result.add(i+1);
            }else if(left[i+1]+right[i+1]==max){
                result.add(i+1);
            }
        }
        return result;

    }

    public static void main(String[] args) {
        //输入：
        //[1,1]
        //输出：
        //[0,1]
        //预期：
        //[0]
      int[]  nums = new int[]{1,1};
        Leecode5981 leecode5981 = new Leecode5981();
        System.out.println(leecode5981.maxScoreIndices(nums));
    }
}
