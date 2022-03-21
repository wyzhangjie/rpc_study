package questions.evrydaystep;
/**
 * 1220. 统计元音字母序列的数目
 * 给你一个整数 n，请你帮忙统计一下我们可以按下述规则形成多少个长度为 n 的字符串：
 *
 * 字符串中的每个字符都应当是小写元音字母（'a', 'e', 'i', 'o', 'u'）
 * 每个元音 'a' 后面都只能跟着 'e'
 * 每个元音 'e' 后面只能跟着 'a' 或者是 'i'
 * 每个元音 'i' 后面 不能 再跟着另一个 'i'
 * 每个元音 'o' 后面只能跟着 'i' 或者是 'u'
 * 每个元音 'u' 后面只能跟着 'a'
 *
 * class Solution {
 * public:
 *     int countVowelPermutation(int n) {
 *         const int M = 1e9+7;
 *         long a = 1, e = 1, i = 1, o = 1, u = 1;
 *         for (int k = 2; k <= n; k++) {
 *             long aa = (e+i+u)%M;
 *             long ee = (a+i)%M;
 *             long ii = (e+o)%M;
 *             long oo = i;
 *             long uu = (o+i)%M;
 *             a = aa;
 *             e = ee;
 *             i = ii;
 *             o = oo;
 *             u = uu;
 *         }
 *         return (a+e+i+o+u)%M;
 *     }
 * };
 * */
public class Leecode1220 {
    int MOD = (int)1e9+7;
    public int countVowelPermutation(int n) {
        long[][] dp=new long[2][5];
        for(int i=0;i<5;i++){
            dp[0][i]=1;
        }
        for(int i=2;i<=n;i++){
            dp[1][0]=(dp[1][0]+dp[0][1])%MOD;
            dp[1][0]=(dp[1][0]+dp[0][2])%MOD;
            dp[1][0]=(dp[1][0]+dp[0][4])%MOD;

            dp[1][1]=(dp[1][1]+dp[0][0])%MOD;
            dp[1][1]=(dp[1][1]+dp[0][2])%MOD;

            dp[1][2]=(dp[1][2]+dp[0][1])%MOD;
            dp[1][2]=(dp[1][2]+dp[0][3])%MOD;

            dp[1][3]=(dp[1][3]+dp[0][2])%MOD;


            dp[1][4]=(dp[1][4]+dp[0][2])%MOD;
            dp[1][4]=(dp[1][4]+dp[0][3])%MOD;

            /*dp[0][0]=(dp[0][0]+dp[1][0])%MOD;
            dp[0][1]=(dp[0][0]+dp[1][1])%MOD;
            dp[0][2]=(dp[0][2]+dp[1][2])%MOD;
            dp[0][3]=(dp[0][3]+dp[1][3])%MOD;
            dp[0][4]=(dp[0][4]+dp[1][4])%MOD;*/
            dp[0][0]=(dp[1][0])%MOD;
            dp[0][1]=(dp[1][1])%MOD;
            dp[0][2]=(dp[1][2])%MOD;
            dp[0][3]=(dp[1][3])%MOD;
            dp[0][4]=(dp[1][4])%MOD;
            dp[1][0]=0;
            dp[1][1]=0;
            dp[1][2]=0;
            dp[1][3]=0;
            dp[1][4]=0;

        }
        long ans=0;
        for(int i=0;i<5;i++){
            ans=(ans+dp[0][i])%MOD;
        }
        return (int)ans;
    }

    public static void main(String[] args) {
        Leecode1220 leecode1220 =new Leecode1220();
        System.out.println(leecode1220.countVowelPermutation(144));
        System.out.println(leecode1220.countVowelPermutation(2));
        System.out.println(leecode1220.countVowelPermutation(5));
    }
}
