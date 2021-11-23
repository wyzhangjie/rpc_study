package questions.evrydaystep;

public class Leecode375 {

    static int N = 210;
    static int[][] cache = new int[N][N];

    public int getMoneyAmount(int n) {

       return dfs(1,n);
    }



    private int dfs(int left, int right) {
        if(left>=right){
            return 0;
        }
        if(cache[left][right]!=0){
            return cache[left][right];
        }
        int ans = 0x3f3f3f3f;
        for(int i=left;i<=right;i++){
            int cur = Math.max(dfs(left,i-1),dfs(i+1,right))+i;
            ans = Math.min(ans,cur);
        }
        cache[left][right]=ans;
        return ans;
    }

    public int getMoneyAmount1(int n) {
        int[][] dp = new int[n+1][n+1];
        for(int i=2;i<=n;i++){
            for(int j=1;j<=i;j++){
                int mincost= 0x3f3f3f3f;
                for(int k=j;k<i;k++){
                    int cur=Math.max(dp[j][k-1],dp[k+1][i]) + k;
                    mincost=Math.min(mincost,cur);
                }
                dp[j][i]=mincost;



            }
        }
        return dp[1][n];

    }


    public int getMoneyAmount2(int n) {
        int[][] dp = new int[n+1][n+1];

        for(int i=n-1;i>=1;i--){
            for(int j=i+1;j<=n;j++){
                int minCost = Integer.MAX_VALUE;
                for(int k=i;k<j;k++){
                    int cost = k + Math.max(dp[i][k - 1], dp[k + 1][j]);
                    minCost = Math.min(minCost, cost);

                }
                dp[i][j] = minCost;
            }
        }
        return dp[1][n];


    }

    public static void main(String[] args) {
        int n=10;
        Leecode375 leecode375  = new Leecode375();
        System.out.println(leecode375.getMoneyAmount1(n));
        System.out.println(leecode375.getMoneyAmount2(n));
    }
}
