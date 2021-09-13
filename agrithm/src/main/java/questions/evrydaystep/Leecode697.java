package questions.evrydaystep;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *给定一个非空且只包含非负数的整数数组 nums，数组的度的定义是指数组里任一元素出现频数的最大值。
 *
 * 你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[1, 2, 2, 3, 1]
 * 输出：2
 * 解释：
 * 输入数组的度是2，因为元素1和2的出现频数最大，均为2.
 * 连续子数组里面拥有相同度的有如下所示:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * 最短连续子数组[2, 2]的长度为2，所以返回2.
 * 示例 2：
 *
 * 输入：[1,2,2,3,1,4,2]
 * 输出：6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/degree-of-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class Leecode697 {
    public int findShortestSubArray(int[] nums) {
        int small = Integer.MAX_VALUE;
        int maxNum = -1;
        int len = nums.length;
        Map<Integer,int[]> map = new HashMap<>();
        //想明白这个多元数组非常的重要，第一个key一定是数值，值一定是三元数组
        //第一个位置是个数，第二个位置是起始位置，第三个是结束位置。
        for(int i=0;i<len;i++){
            int[] pair = new int[3];
            if(map.get(nums[i])!=null){

                pair[0]=map.get(nums[i])[0]+1;
                pair[1]=map.get(nums[i])[1];
                pair[2]=i;
                map.put(nums[i],pair);
            }else {
                pair = new int[]{1,i,i};
                map.put(nums[i],pair);
            }
            if(maxNum <pair[0]){
                maxNum =pair[0];
                //后面出来的个数更大
                small=pair[2] - pair[1]+1;
            }else if(maxNum ==pair[0]){
                if((pair[2] - pair[1])< small){
                    small = pair[2] - pair[1]+1;
                }
            }
        }

       return small;
         }

    public static void main(String[] args) {
        int[] nums= {1,2,2,3,1,4,2};
        Leecode697 leecode697 = new Leecode697();
        System.out.println(leecode697.findShortestSubArray(nums));
    }
}
