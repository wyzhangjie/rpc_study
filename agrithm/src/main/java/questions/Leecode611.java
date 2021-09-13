package questions;

import java.util.Arrays;

/**
 *
 * 611. 有效三角形的个数
 * 给定一个包含非负整数的数组，你的任务是统计其中可以组成三角形三条边的三元组个数。
 *
 * 示例 1:
 *
 * 输入: [2,2,3,4]
 * 输出: 3
 * 解释:
 * 有效的组合是:
 * 2,3,4 (使用第一个 2)
 * 2,3,4 (使用第二个 2)
 * 2,2,3
 * 注意:
 *
 * 数组长度不超过1000。
 * 数组里整数的范围为 [0, 1000]。*/
public class Leecode611 {
    public int triangleNumber(int[] nums) {
        int result=0;
        int num = nums.length;
        if(num<3){
            return 0;
        }
        Arrays.sort(nums);
        for(int i=0;i<num-2;i++){
            for(int j=i+1;j<num;j++){
                int k=j+1;
                while (k<num && nums[k]<(nums[i]+nums[j])){
                    k++;
                }
                result+=k-j-1;
            }
        }
        return result;
    }


    public int triangleNumber1(int[] nums) {
        int result=0;
        int num = nums.length;
        if(num<3){
            return 0;
        }
        Arrays.sort(nums);
        for(int i=0;i<num-2;i++){
            for(int j=i+1;j<num;j++){
              int left =j+1;
              int right = num-1;
              int k= j;
              while (left<=right){
                  int mid = left+(right-left)/2;
                  if(nums[mid]<nums[i]+nums[j]){
                      k=mid;
                      left=mid+1;

                  }else {
                      right=mid-1;
                  }
              }
              result+=k-j;
            }
        }
        return result;
    }



    public static void main(String[] args) {
        int[] nums = new int[]{2,2,3,4};
        Leecode611 leecode611 = new Leecode611();
  //      System.out.println(leecode611.triangleNumber(nums));
        System.out.println(leecode611.triangleNumber1(nums));
    }
}
