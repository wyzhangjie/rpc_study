package questions.dpproblem;
/**
 560. 和为K的子数组
 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。

 示例 1 :

 输入:nums = [1,1,1], k = 2
 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 说明 :

 数组的长度为 [1, 20,000]。
 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
 通过次数139,839提交次数312,865
 请问您在哪类招聘中遇到此题？


 */
public class Leecode560 {

    public int subarraySum(int[] nums, int k) {

        int[] prefix = new int[nums.length+1];
        prefix[0]=0;
        for(int i=1;i<=nums.length;i++){
            prefix[i]=prefix[i-1]+nums[i-1];
        }
        int sum =0;
        for(int i=0;i<=nums.length;i++){

            for(int j=i+1;j<=nums.length;j++){
                if(prefix[j]-prefix[i]==k){
                    sum++;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums =new int[]{1,1,1};
        Leecode560 leecode560 = new Leecode560();
        System.out.println(leecode560.subarraySum(nums,2));
    }
}
