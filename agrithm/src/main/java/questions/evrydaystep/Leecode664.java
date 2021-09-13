package questions.evrydaystep;
/**
 * 664. 奇怪的打印机
 * 有台奇怪的打印机有以下两个特殊要求：
 *
 * 打印机每次只能打印由 同一个字符 组成的序列。
 * 每次可以在任意起始和结束位置打印新字符，并且会覆盖掉原来已有的字符。
 * 给你一个字符串 s ，你的任务是计算这个打印机打印它需要的最少打印次数。
 *
 *
 * 示例 1：
 *
 * 输入：s = "aaabbb"
 * 输出：2
 * 解释：首先打印 "aaa" 然后打印 "bbb"。
 * 示例 2：
 *
 * 输入：s = "aba"
 * 输出：2
 * 解释：首先打印 "aaa" 然后在第二个位置打印 "b" 覆盖掉原来的字符 'a'。
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 100
 * s 由小写英文字母组成
 * */
public class Leecode664 {
    public int strangePrinter(String s) {
        int len =s.length();
        int[][] dp = new int[len][len];
        for(int i=0;i<len;i++){
            dp[i][i]=1;
        }
        for(int i=len-1;i>=0;i--){
            for(int j=i+1;j<len;j++){
                if(s.charAt(i)==s.charAt(j)){
                    dp[i][j]=dp[i+1][j];
                }else {
                    int min = Integer.MAX_VALUE;
                    for(int z=i;z<j;z++){
                        min=Math.min(min,dp[i][z]+dp[z+1][j]);
                    }
                    dp[i][j]=min;
                }

            }
        }
        return dp[0][len-1];
    }

    public static void main(String[] args) {
        String s = "aaabbb";
        Leecode664 leecode664 = new Leecode664();
        System.out.println(leecode664.strangePrinter(s));
    }
}
