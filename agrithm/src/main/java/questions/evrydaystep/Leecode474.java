package questions.evrydaystep;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 474. 一和零
 * 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
 *
 * 请你找出并返回 strs 的最大子集的大小，该子集中 最多 有 m 个 0 和 n 个 1 。
 *
 * 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
 * 输出：4
 * 解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。
 * 其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"} 。{"111001"} 不满足题意，因为它含 4 个 1 ，大于 n 的值 3 。
 * 示例 2：
 *
 * 输入：strs = ["10", "0", "1"], m = 1, n = 1
 * 输出：2
 * 解释：最大的子集是 {"0", "1"} ，所以答案是 2 。
 *
 *
 * 提示：
 *
 * 1 <= strs.length <= 600
 * 1 <= strs[i].length <= 100
 * strs[i] 仅由 '0' 和 '1' 组成
 * 1 <= m, n <= 100
 * 通过次数60,203提交次数100,700
 * */
public class Leecode474 {
    Integer maxResult=0;
    public int findMaxForm1(String[] strs, int m, int n) {
    //第一个数组初始化
        int len = strs.length;
        int[][][] dp = new int[len+1][m+1][n+1];
        for(int i=1;i<=len;i++){
            int[] zeroOrOne = getzeroOrOne(strs[i-1]);
            for(int j=0;j<=m;j++){
                for(int k=0;k<=n;k++){
                    dp[i][j][k]=dp[i-1][j][k];
                    if(j>=zeroOrOne[0] && k>=zeroOrOne[1]){
                        dp[i][j][k]= Math.max( dp[i][j][k],dp[i-1][j-zeroOrOne[0]][k-zeroOrOne[1]]+1);
                    }
                }
            }

        }
        return dp[len][m][n];
    }

    private int[] getzeroOrOne(String str) {
            int[] result = new int[2];
        char[] subChar = str.toCharArray();
        for(int i=0;i<subChar.length;i++){
            result[subChar[i]-'0']++;
        }
        return result;

    }

    public int findMaxForm(String[] strs, int m, int n) {
        //先计算 0 ，1
        Map<Integer,Elemes> map = new HashMap<>();
        for(int i=0;i<strs.length;i++){
            String a = strs[i];
            char[] subChar = a.toCharArray();
            Elemes elemes = new Elemes();
            for(char subA:subChar){
                if(subA=='0'){
                    elemes.zeroNums++;
                }
                if(subA=='1'){
                    elemes.oneNums++;
                }
            }
            map.put(i,elemes);
        }

        digui(map,0,m,n,0);
        return maxResult;
    }

    private void digui(Map<Integer, Elemes> map,int result, int leftzero, int leftone,int begin) {
        if(leftone>=0 && leftzero>=0 &&result>maxResult){
            maxResult=result;
        }
        for(int i=begin;i<map.size();i++){
            leftzero-=map.get(i).zeroNums;
            leftone-=map.get(i).oneNums;
            digui(map,++result,leftzero,leftone,i+1);
            leftzero+=map.get(i).zeroNums;
            leftone+=map.get(i).oneNums;
            digui(map,--result,leftzero,leftone,i+1);
        }
    }

    public class Elemes{
    public    int zeroNums=0;
    public    int oneNums=0;
    }

    public static void main(String[] args) {
        Leecode474 leecode474= new Leecode474();
        String[] strs = new String[]{"10", "0", "1"};
        System.out.println(leecode474.findMaxForm(strs,1,1));
        System.out.println(leecode474.findMaxForm1(strs,1,1));
    }
}
