package questions.evrydaystep;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文。
 *
 * 返回符合要求的 最少分割次数 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "aab"
 * 输出：1
 * 解释：只需一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
 * 示例 2：
 *
 * 输入：s = "a"
 * 输出：0
 * 示例 3：
 *
 * 输入：s = "ab"
 * 输出：1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-partitioning-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class Leecode132 {

    public int minCut(String s) {
        int len = s.length();
        Boolean[][] dp = new Boolean[len][len];
        for(int i=0;i<len;i++){
         dp[i][i] =true;
        }

        for(int i=len-1;i>=0;i--){
            for(int j=i+1;j<len;j++){
                if(j==i+1){
                    dp[i][j] = s.charAt(i)==s.charAt(j);
                }else {
                    dp[i][j] =dp[i+1][j-1] &&(s.charAt(i)==s.charAt(j));
                }
            }
        }
            int[] result = new int[len];
            Arrays.fill(result,Integer.MAX_VALUE);
            for(int k=0;k<len;k++){
                if(dp[0][k]){
                    result[k]= 0;
                }else {
                    for(int j=0;j<k;j++){
                        if(dp[j+1][k]){
                            result[k]=Math.min(result[k],result[j]+1);
                        }

                    }
                }
            }



        return result[len-1];
    }

    public static void main(String[] args) {
        String s = "leet";
        Leecode132 leecode132 = new Leecode132();
        System.out.println(leecode132.minCut(s));
    }
}
