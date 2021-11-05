package questions.evrydaystep;

public class Leecode650 {
    int impossibleMax=10000;
    public int minSteps(int n) {
        int[][] memo = new int[n][n];
    //  return   deeps(n,1,0);
     //   return   deepsWithMemory(n,1,0,memo);
        return  dpMethod(n);
    }

    private int dpMethod(int n) {

        //白板上字符个数和剪贴板上字符个数之间的关系
        int[][] dp = new int[n][n];
        dp[1][0]=0;
        dp[1][1]=1;
        for(int i=2;i<n;i++){
            int min = impossibleMax;
            for(int j=0;j<=i;j++){
                if(i!=j){
                    //是一次粘贴操作
                    dp[i][j]=dp[i-j][j]+1;
                    min = Math.min(min,dp[i][j]);
                }else {
                    //试一次赋值操作
                    dp[i][j] = min+1;

                }
            }
        }
        return 0;
    }

    private int deepsWithMemory(int n, int ground, int clipboard,int[][] memo) {
        if(ground>n){
            return impossibleMax;
        }
        if(ground==n){
            return 0;
        }
        if(memo[ground][clipboard]!=0){
            return memo[ground][clipboard];
        }
        int ans= impossibleMax;
        //将剪贴板上的值粘贴出来
        if(clipboard>0){
            ans= Math.min(ans,deepsWithMemory(n,ground+clipboard,clipboard,memo));
        }

        if(ground!=clipboard){
            ans = Math.min(ans,deepsWithMemory(n,ground,ground,memo));
        }
        memo[ground][clipboard]=ans+1;

        return ans+1;
    }

    private int deeps(int n, int ground, int clipboard) {
        if(ground>n){
            return impossibleMax;
        }
        if(ground==n){
            return 0;
        }
        int ans= impossibleMax;
        //将剪贴板上的值粘贴出来
        if(clipboard>0){
            ans= Math.min(ans,deeps(n,ground+clipboard,clipboard));
        }

        if(ground!=clipboard){
            ans = Math.min(ans,deeps(n,ground,ground));
        }
        return ans+1;
    }

    public static void main(String[] args) {
        Leecode650 leecode650 = new Leecode650();
        System.out.println(leecode650.minSteps(3));
    }
}
