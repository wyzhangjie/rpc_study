package questions.evrydaystep;
/**
 * 516. 最长回文子序列
 * 给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。
 *
 * 子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "bbbab"
 * 输出：4
 * 解释：一个可能的最长回文子序列为 "bbbb" 。
 * 示例 2：
 *
 * 输入：s = "cbbd"
 * 输出：2
 * 解释：一个可能的最长回文子序列为 "bb" 。
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s 仅由小写英文字母组成
 * */
public class Leecode516 {
    public int longestPalindromeSubseq(String s) {
        char[] chars = s.toCharArray();
        int[][] dp = new int[chars.length][chars.length];
        for(int i=0;i<chars.length;i++){
            dp[i][i] =1;
        }
        for(int i=chars.length-1;i>=0;i--){
          for(int j=i+1;j<chars.length;j++){
              if(chars[i]==chars[j]){
                  dp[i][j]=dp[i+1][j-1]+2;
              }else {
                  dp[i][j]=Math.max(dp[i][j-1],dp[i+1][j]);
              }
          }
        }
        return dp[0][chars.length-1];
    }

    public static void main(String[] args) {
        String s = "cbbd";
        Leecode516 leecode516 = new Leecode516();
        System.out.println(leecode516.longestPalindromeSubseq(s));
    }
}
