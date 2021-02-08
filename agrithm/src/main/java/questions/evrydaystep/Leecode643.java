package questions.evrydaystep;
/**
 * 20210204
 * 643. 子数组最大平均数 I
 * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
 *
 *
 *
 * 示例：
 *
 * 输入：[1,12,-5,-6,50,3], k = 4
 * 输出：12.75
 * 解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 *
 *
 * 提示：
 *
 * 1 <= k <= n <= 30,000。
 * 所给数据范围 [-10,000，10,000]。
 * 执行用时：
 * 3 ms
 * , 在所有 Java 提交中击败了
 * 82.47%
 * 的用户
 * 内存消耗：
 * 42.8 MB
 * , 在所有 Java 提交中击败了
 * 39.34%
 * 的用户
 * */
public class Leecode643 {
    public double findMaxAverage(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int sum=0;
        for (int i=0;i<k;i++){
            sum+=nums[i];
        }
        int numsLen = nums.length;
        max=sum;
        int left=0;
        int right=k-1;
        while(right<(numsLen-1)){
            right++;
            sum = sum-nums[left]+nums[right];
            max =Math.max(max,sum);
            left++;
        }
        return (double) max/k;
    }
    /**
     * 执行用时：
     * 2 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 42.7 MB
     * , 在所有 Java 提交中击败了
     * 47.17%
     * 的用户
     * */
    public double findMaxAverage1(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int sum=0;
        for (int i=0;i<k;i++){
            sum+=nums[i];
        }
        int numsLen = nums.length;
        max=sum;

        for(int i=k;i<numsLen;i++){
            sum = sum-nums[i-k]+nums[i];
            max =Math.max(max,sum);
        }
        return (double) max/k;
    }
    public static void main(String[] args) {
        int[] sum = new int[]{1,12,-5,-6,50,3};
        Leecode643 leecode643 = new Leecode643();
        System.out.println(leecode643.findMaxAverage(sum,4));

    }
}
