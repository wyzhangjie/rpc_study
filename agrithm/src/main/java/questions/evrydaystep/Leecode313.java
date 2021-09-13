package questions.evrydaystep;

import java.util.Arrays;
/**
 * 313. 超级丑数
 * 超级丑数 是一个正整数，并满足其所有质因数都出现在质数数组 primes 中。
 *
 * 给你一个整数 n 和一个整数数组 primes ，返回第 n 个 超级丑数 。
 *
 * 题目数据保证第 n 个 超级丑数 在 32-bit 带符号整数范围内。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 12, primes = [2,7,13,19]
 * 输出：32
 * 解释：给定长度为 4 的质数数组 primes = [2,7,13,19]，前 12 个超级丑数序列为：[1,2,4,7,8,13,14,16,19,26,28,32] 。
 * 示例 2：
 *
 * 输入：n = 1, primes = [2,3,5]
 * 输出：1
 * 解释：1 不含质因数，因此它的所有质因数都在质数数组 primes = [2,3,5] 中。
 *
 * 提示：
 *
 * 1 <= n <= 106
 * 1 <= primes.length <= 100
 * 2 <= primes[i] <= 1000
 * 题目数据 保证 primes[i] 是一个质数
 * primes 中的所有值都 互不相同 ，且按 递增顺序 排列
 * */
public class Leecode313 {
    /**
     * 1、计算第几个丑数，就是从小到大排序
     * 2、一个轮肯定是最小的丑数个数为1的情况。
     * 3、后面我们给每一个丑数的单元元素增加一个计数器。这个非常关键的是，不能用计数器乘以单元元素来计算丑数，你想2的倍数 2 4，8 可不是2 4 6.所以
     * 我们这里面说的丑数应该不分在dp当中已经算出来的丑数，一部分还在原数组中剩余的个数为初始化1的元素。
     * 4、官方的技巧就是在dp的位置1维护1，那些没有放置到dp里面的元素个数肯定都是1，而那些已经放置在dp里面的元素会找到其它丑数跟他相乘，最终我们取
     * 每轮最小的值，就是dp的i位置的数值。
     * */
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp = new int[n+1];
        dp[0]=0;
        dp[1]=1;
        int[] index = new int[primes.length];
        index[0]=1;
        Arrays.fill(index,1);

        for(int i=2;i<=n;i++){
            int[] nums = new int[primes.length];
            int min = Integer.MAX_VALUE;
            for(int j=0;j<primes.length;j++){
                nums[j]=dp[index[j]]*primes[j];
                min=Math.min(min,nums[j]);
            }
            dp[i]=min;
            for(int j=0;j<primes.length;j++){
                if(nums[j]==min){
                    index[j]++;
                }
            }
        }
        return dp[n];

    }
//[1,2,4,7,8,13,14,16,19,26,28,32]
    public static void main(String[] args) {
        int[]  primes = new int[]{2,7,13,19};
        int[]  primes1 = new int[]{2,3,5};
        Leecode313 leecode313 = new Leecode313();
        System.out.println(leecode313.nthSuperUglyNumber(2,primes1));
    }
}
