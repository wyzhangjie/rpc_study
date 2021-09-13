package questions.evrydaystep;

/**
 * 1035. 不相交的线
 * 在两条独立的水平线上按给定的顺序写下 nums1 和 nums2 中的整数。
 * <p>
 * 现在，可以绘制一些连接两个数字 nums1[i] 和 nums2[j] 的直线，这些直线需要同时满足满足：
 * <p>
 * nums1[i] == nums2[j]
 * 且绘制的直线不与任何其他连线（非水平线）相交。
 * 请注意，连线即使在端点也不能相交：每个数字只能属于一条连线。
 * <p>
 * 以这种方法绘制线条，并返回可以绘制的最大连线数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums1 = [1,4,2], nums2 = [1,2,4]
 * 输出：2
 * 解释：可以画出两条不交叉的线，如上图所示。
 * 但无法画出第三条不相交的直线，因为从 nums1[1]=4 到 nums2[2]=4 的直线将与从 nums1[2]=2 到 nums2[1]=2 的直线相交。
 * 示例 2：
 * <p>
 * 输入：nums1 = [2,5,1,2,5], nums2 = [10,5,2,1,5,2]
 * 输出：3
 * 示例 3：
 * <p>
 * 输入：nums1 = [1,3,7,1,7,5], nums2 = [1,9,2,5,1]
 * 输出：2
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums1.length <= 500
 * 1 <= nums2.length <= 500
 * 1 <= nums1[i], nums2[i] <= 2000
 */
public class Leecode1035 {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        //如果对手方是空，那么自己肯定也都是空
        int[][] dp = new int[nums1.length+1][nums2.length+1];

        for(int i=1;i<=nums1.length;i++){
            for(int j=1;j<=nums2.length;j++){
                if(nums1[i-1]==nums2[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }

            }
        }
        return dp[nums1.length][nums2.length];
 }

    public int maxUncrossedLines1(int[] nums1, int[] nums2) {
        //如果对手方是空，那么自己肯定也都是空
        int[] dp = new int[nums2.length+1];
        int temp=0;
        for(int i=1;i<=nums1.length;i++){
            int last = temp;
            for(int j=1;j<=nums2.length;j++){
                if(nums1[i-1]==nums2[j-1]){
                    dp[j] = last+1;
                }else {
                    dp[j] = Math.max(dp[j],dp[j-1]);
                }

            }
            temp =dp[nums2.length];
        }
        return dp[nums2.length];
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{2,5,1,2,5};
        int[] num2 = new int[]{10,5,2,1,5,2};
        Leecode1035 leecode1035 = new Leecode1035();
        System.out.println(leecode1035.maxUncrossedLines(nums1,num2));
        System.out.println(leecode1035.maxUncrossedLines1(nums1,num2));
    }









}
