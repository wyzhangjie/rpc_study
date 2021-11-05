package questions.evrydaystep;


public class Leecode639 {
    static final int MOD = 1000000007;

    public int numDecodings(String s) {

        int[] dp = new int[s.length()+1];
        dp[0]=1;
        dp[1] = s.charAt(0) == '*' ? 9 : s.charAt(0) == '0' ? 0 : 1;
        if (s.charAt(0) == '0'){
            dp[0] = dp[1] = 0;
        }
        int n = s.length();
        for (int i = 1; i < n; i++) {
            if(s.charAt(i)=='*'){
                //该位置数据为*的情况
                dp[i]+=dp[i-1]*9;
               if(s.charAt(i)=='1'){
                   dp[i]+=dp[i-1]*9;
               }
               if(s.charAt(i-1)=='2'){
                   dp[i]+=dp[i-1]*6;
               }
               if(s.charAt(i-1)=='*'){

               }
            }else {

            }
        }
return 1;
    }
}
