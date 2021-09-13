package questions.evrydaystep;

public class Leecode70 {
    public int climbStairs(int n) {
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
    int[] dp =new int[n+1];
    dp[0]=1;
    dp[1]=1;
    dp[2]=2;
    for(int i=2;i<=n;i++){
        dp[i]=dp[i-1]+dp[i-2];
    }
    return dp[n];
    }
    public int climbStairs1(int n) {
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        int[] dp =new int[3];
        dp[0]=1;
        dp[1]=1;
        dp[2]=2;
        for(int i=2;i<=n;i++){
            dp[2]=dp[1]+dp[0];
            dp[0]= dp[1];
            dp[1]=dp[2];

        }
        return dp[2];
    }

    public static void main(String[] args) {
        int n=1;
        Leecode70 leecode70 = new Leecode70();
        System.out.println(leecode70.climbStairs(n));
        System.out.println(leecode70.climbStairs1(n));
    }

}
