package questions.evrydaystep;
/**
 * 1646. 获取生成数组中的最大值
 * 给你一个整数 n 。按下述规则生成一个长度为 n + 1 的数组 nums ：
 *
 * nums[0] = 0
 * nums[1] = 1
 * 当 2 <= 2 * i <= n 时，nums[2 * i] = nums[i]
 * 当 2 <= 2 * i + 1 <= n 时，nums[2 * i + 1] = nums[i] + nums[i + 1]
 * 返回生成数组 nums 中的 最大 值。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 7
 * 输出：3
 * 解释：根据规则：
 *   nums[0] = 0
 *   nums[1] = 1
 *   nums[(1 * 2) = 2] = nums[1] = 1
 *   nums[(1 * 2) + 1 = 3] = nums[1] + nums[2] = 1 + 1 = 2
 *   nums[(2 * 2) = 4] = nums[2] = 1
 *   nums[(2 * 2) + 1 = 5] = nums[2] + nums[3] = 1 + 2 = 3
 *   nums[(3 * 2) = 6] = nums[3] = 2
 *   nums[(3 * 2) + 1 = 7] = nums[3] + nums[4] = 2 + 1 = 3
 * 因此，nums = [0,1,1,2,1,3,2,3]，最大值 3
 * 示例 2：
 *
 * 输入：n = 2
 * 输出：1
 * 解释：根据规则，nums[0]、nums[1] 和 nums[2] 之中的最大值是 1
 * 示例 3：
 *
 * 输入：n = 3
 * 输出：2
 * 解释：根据规则，nums[0]、nums[1]、nums[2] 和 nums[3] 之中的最大值是 2
 *
 *
 * 提示：
 *
 * 0 <= n <= 100
 * */
public class Leecode1646 {
    public int getMaximumGenerated(int n) {
        int max =0;
        int[] nums = new int[n+1];
        if(n==0){
            return 0;
        }
        nums[0]=0;
        nums[1]=1;
        max=1;
        for(int i=2;i<=n;i++){
            if(i%2==0){
                nums[i]=nums[i/2];
            }else {
                nums[i]=nums[i/2]+nums[i/2+1];
            }
            max=Math.max(max,nums[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int n=2;
        int n1=3;
        int t=0;
        Leecode1646 leecode1646 = new Leecode1646();
        System.out.println(leecode1646.getMaximumGenerated(n));
        System.out.println(leecode1646.getMaximumGenerated(n1));
        System.out.println(leecode1646.getMaximumGenerated(t));
    }
}
