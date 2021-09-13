package questions.evrydaystep;
/**
 *
 * 面试题 17.10. 主要元素
 * 数组中占比超过一半的元素称之为主要元素。给你一个 整数 数组，找出其中的主要元素。若没有，返回 -1 。请设计时间复杂度为 O(N) 、空间复杂度为 O(1) 的解决方案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[1,2,5,9,5,9,5,5,5]
 * 输出：5
 * 示例 2：
 *
 * 输入：[3,2]
 * 输出：-1
 * 示例 3：
 *
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 * 通过次数43,988提交次数79,979
 * */
public class Leecode1710 {
    public int majorityElement(int[] nums) {
        int begin=0;
        int num=-1;
        int count=0;
        for(int temp:nums){
            if(begin==0){
                num=temp;
                count=1;
                begin=1;
            }else {
                if(temp==num){
                    count++;
                }else {
                    count--;
                    if(count<0){
                        num=temp;
                        count=1;
                    }
                    if(count==0){
                        num=temp;
                        count=0;
                    }
                }

            }
        }
        int result=0;
        for(int temp:nums){
            if(temp==num){
                result++;
            }
        }
        return  result*2>nums.length?num:-1;

    }

    public static void main(String[] args) {
        int[] nums= new int[]{1,2,3};
        int[] nums1= new int[]{2,3,2};
        Leecode1710 leecode1710 = new Leecode1710();
        System.out.println(leecode1710.majorityElement(nums));
        System.out.println(leecode1710.majorityElement(nums1));
    }
}
