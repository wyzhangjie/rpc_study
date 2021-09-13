package questions.evrydaystep;

/**
 * 1049. 最后一块石头的重量 II
 * 有一堆石头，用整数数组 stones 表示。其中 stones[i] 表示第 i 块石头的重量。
 * <p>
 * 每一回合，从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 * <p>
 * 如果 x == y，那么两块石头都会被完全粉碎；
 * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 最后，最多只会剩下一块 石头。返回此石头 最小的可能重量 。如果没有石头剩下，就返回 0。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：stones = [2,7,4,1,8,1]
 * 输出：1
 * 解释：
 * 组合 2 和 4，得到 2，所以数组转化为 [2,7,1,8,1]，
 * 组合 7 和 8，得到 1，所以数组转化为 [2,1,1,1]，
 * 组合 2 和 1，得到 1，所以数组转化为 [1,1,1]，
 * 组合 1 和 1，得到 0，所以数组转化为 [1]，这就是最优值。
 * 示例 2：
 * <p>
 * 输入：stones = [31,26,33,21,40]
 * 输出：5
 * 示例 3：
 * <p>
 * 输入：stones = [1,2]
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= stones.length <= 30
 * 1 <= stones[i] <= 100
 * 通过次数22,904提交次数38,044
 */
public class Leecode1049 {

    public int lastStoneWeightII(int[] stones) {
        int maxSum=0;
        for(int s:stones){
            maxSum+=s;
        }
        int halfMax = maxSum/2;
        // 分量是i的情况下dp是真还是假
        boolean[] dp = new boolean[halfMax+1];
        //初始化说的是如果分量为0，那么自然就成立。分量为0 的时候碾碎，能达到最佳状态的最小值
        dp[0]=true;
        int len= stones.length;
        //每一个是否去试算，在这个石头参与和不参与两种情况下，是否能够达到最大的j,
        //这道题由于是撵石头，可以达到的最大中间值就是能够剩下的最少石头重量
        //具体 Min(a-b) a+b=sum b=sum-a 剩下的最少数量就是a-b =|sum -2a|
        //a如果能够越靠近中间值，sum-2a的绝对值越小，所以说，最大堆，最大值要死劲往
        //中间值靠近，就转化成为，什么时候这些石头组合能达到这个状态，每一个石头都有选、不选
        //两种情况，按照这两种情况的动态规划方法获取到能够达到的最大中间数，结果就是sum -2a （a为能够达到的最大中间数）
        //也就是又变成了类似494那道题了
        for(int i=0;i<len;i++){
            for(int j=halfMax;j>=stones[i];j--){
                dp[j]=dp[j]|| dp[j-stones[i]];
            }
        }
        for(int j=halfMax;;j--){
           if(dp[j]){
               return maxSum-2*j;
           }
        }


    }
    //所以按照494的方式在实现一遍简单的回溯方式，怎么靠近最接近中间值的那个方法就是回溯的集中计算方式
    private int minDiff;
    private int maxMidsum;
    public int lastStoneWeightIII(int[] stones) {
        int maxSum=0;
        for(int s:stones){
            maxSum+=s;
        }
        int halfMax = maxSum/2;
        minDiff=halfMax;
       getMaxMid(halfMax,0,stones,0);
        return maxSum-2*maxMidsum;
    }

    private void getMaxMid(int halfMax, int addSum, int[] stones,int index ) {
        if(index==stones.length){
            if(halfMax-addSum>=0 && halfMax-addSum<minDiff){
                minDiff=halfMax-addSum;
                maxMidsum=addSum;
            }
        }else {
            getMaxMid(halfMax,addSum,stones,index+1);
            getMaxMid(halfMax,addSum+stones[index],stones,index+1);

        }

    }

    public static void main(String[] args) {
        int[] stones = new int[]{31,26,33,21,40};
        Leecode1049 leecode1049 = new Leecode1049();
        System.out.println(leecode1049.lastStoneWeightII(stones));
        System.out.println(leecode1049.lastStoneWeightIII(stones));
    }


}
