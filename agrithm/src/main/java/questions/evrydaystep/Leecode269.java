package questions.evrydaystep;

import java.util.Arrays;

/**
 *
 * 628. 三个数的最大乘积
 * 给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: 6
 * 示例 2:
 *
 * 输入: [1,2,3,4]
 * 输出: 24
 * 注意:
 *
 * 给定的整型数组长度范围是[3,104]，数组中所有的元素范围是[-1000, 1000]。
 * 输入的数组中任意三个数的乘积不会超出32位有符号整数的范围。
 *
 * 每日力扣
 * 给一个数组，求出数组中三个数乘积最大的，如果你想尝试每三个数去乘积比较，显然就没有动脑袋。这个数据的数据会呈现什么形态，无非就三种
 * 1、全是正数
 * 2、全是负数
 * 3、有正数，有负数
 * 如果是前两种，那么最大乘积肯定是三个最大数的乘积（负数可能不好绕，例如 -6 -5 -2 -1 是不是最大的那三个相乘最大 -10 和 -60 当然是-10大 ）
 * 如果是第三种情况，是不是最小的那两个数相乘和最大的那个数相乘？( )
 * -1,2,4,5,6 这种跟上面那种一样取的是最大的三个，所以么有新增情况
 *
 * -1 -2 4 6
 * 这种就新增了一个情况，最小的两个数和最大的数相乘就会是结果。
 *
 * -1 -2 4 5 6
 * 依然没有新增情况
 *
 * 综上所述，获取到最大的三个数，和最小的三个数是关键。
 * 方法1、排序获取
 * 方法2、遍历获取
 * */
public class Leecode269 {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        return Math.max(nums[len-1]*nums[len-2]*nums[len-3],nums[len-1]*nums[0]*nums[1]);

    }

    public int maximumProduct1(int[] nums) {
        //最小
        int smaller1 = Integer.MAX_VALUE;
        //次小
        int smaller2= Integer.MAX_VALUE;
        //最大
        int max1 = Integer.MIN_VALUE;
        //中间大
        int max2 = Integer.MIN_VALUE;
        //第三大
        int max3 = Integer.MIN_VALUE;
        int len = nums.length;
        for(int i=0;i<len;i++){
            if(nums[i]>max1){
                max3 = max2;
                max2 = max1;
                max1=nums[i];

            }else if(nums[i]>max2){
                max3 = max2;
                max2 = nums[i];
            }else if(nums[i]>max3){
                max3= nums[i];
            }
            if(nums[i]<smaller1){
                smaller2 = smaller1;
                smaller1 = nums[i];
            }else if(nums[i]<smaller2){
                smaller2 = nums[i];
            }
        }
        return Math.max(max1*max2*max3,smaller1*smaller2*max1);


    }

    public static void main(String[] args) {
        Leecode269 leecode269 = new Leecode269();
        int[] nums = new int[]{-1,2,4,5,6};
        int result = leecode269.maximumProduct1(nums);
        System.out.println(result);

    }
}
