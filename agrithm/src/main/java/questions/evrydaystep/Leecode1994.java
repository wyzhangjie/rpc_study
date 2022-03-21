package questions.evrydaystep;/**
 * ClassName Leecode1994
 * Description
 * Create by jie.zhang02
 * Date 2022/2/22 4:14 下午
 */

/**
 * @author jie.zhang
 * @date 2022年02月22日 4:14 下午
 */
public class Leecode1994 {
    private int[] primes={2,3,5,7,11,13,17,19,23,29};
    int mod=1000000007;
    public int numberOfGoodSubsets(int[] nums) {
        //第一步：统计各个数据出现的个数
        int[] t=new int[31];
        for(int i=0;i<nums.length;i++){
            t[nums[i]]++;
        }
        //第二步骤，遍历各个位置的数据，并且把dp数组构造出来
        long[] dp = new long[1024];
        dp[0]=1;
        for(int i=2;i<=30;i++){
            if(t[i]==0 || i%4==0 || i%9==0 || i%25==0){
                continue;
            }
            int mask=0;
            for(int j=0;j<10;j++){
                if(i%primes[j]==0){
                    mask|=(1<<j);
                }
            }
            for(int state=0;state<1024;state++){
                if((mask & state)>0){
                    continue;
                }
                dp[state|mask]=(dp[state|mask]+ dp[state]*t[i])%mod;
            }
        }
        long result=0;
        for(int i=1;i<1024;i++){
            result=(result+dp[i])%mod;

        }
        for(int i=0;i<t[1];i++){
            result=(result*2)%mod;
        }
        return (int) result;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        Leecode1994 leecode1994 = new Leecode1994();
        System.out.println(leecode1994.numberOfGoodSubsets(nums));
    }
}
