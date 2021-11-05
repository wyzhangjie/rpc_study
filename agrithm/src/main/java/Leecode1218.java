import java.util.HashMap;
import java.util.Map;

/**
 * 218. 最长定差子序列
 * 给你一个整数数组 arr 和一个整数 difference，请你找出并返回 arr 中最长等差子序列的长度，该子序列中相邻元素之间的差等于 difference 。
 *
 * 子序列 是指在不改变其余元素顺序的情况下，通过删除一些元素或不删除任何元素而从 arr 派生出来的序列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [1,2,3,4], difference = 1
 * 输出：4
 * 解释：最长的等差子序列是 [1,2,3,4]。
 * 示例 2：
 *
 * 输入：arr = [1,3,5,7], difference = 1
 * 输出：1
 * 解释：最长的等差子序列是任意单个元素。
 * 示例 3：
 *
 * 输入：arr = [1,5,7,8,5,3,4,2,1], difference = -2
 * 输出：4
 * 解释：最长的等差子序列是 [7,5,3,1]。
 *
 *
 * 提示：
 *
 * 1 <= arr.length <= 105
 * -104 <= arr[i], difference <= 104
 *
 * */
public class Leecode1218 {
    //别忘了，不能双循环！！！用map存储
    public int longestSubsequence(int[] arr, int difference) {
        int[] dp = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            dp[i]=1;
        }
        int max=1;
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j< arr.length;j++){
                if(arr[j]-arr[i]==difference){
                    dp[j]=Math.max(dp[j],dp[i]+1);
                    max=Math.max(max,dp[j]);
                }
            }
        }
        return max;
    }


    public int longestSubsequence1(int[] arr, int difference) {
        int ans=1;
       Map<Integer,Integer> map = new HashMap<>();
       for(int i=0;i<arr.length;i++){
           map.put(arr[i], map.getOrDefault(arr[i]-difference,0)+1);
           ans  =Math.max(ans,map.get(arr[i]));
       }
       return ans;

    }

    public static void main(String[] args) {
        int[] num = new int[]{1,5,7,8,5,3,4,2,1};
        Leecode1218 leecode1218 = new Leecode1218();
        System.out.println(
                leecode1218.longestSubsequence1(num,-2)
        );
    }
}
