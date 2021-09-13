package questions.evrydaystep;

import java.util.HashMap;
import java.util.Map;

public class Leecode1269 {
    private final   int  mod= 1000000007;
    public int numWays(int steps, int arrLen) {
        //存储计算的结果
        Map<String, Integer> map = new HashMap<>();
        //从左上角开始走
        System.out.println(dp(steps,arrLen));
        return dfs(steps, map, arrLen, 0);
    }

    //index表示走到的位置
    private int dfs(int steps, Map<String, Integer> map, int arrLen, int index) {
        //如果步数走完了，就不能往下走了，直接返回，如果最后一步停留在左下角的位置，也就是
        //index=0，说明找到了一个完整的路径回到原点，返回1，否则表示回不到原点，返回0；
        if (steps == 0) {
            return index == 0 ? 1 : 0;
        }
        String key = steps + "*" + index;
        //首先判断是否计算过，如果计算过就从map中取
        if (map.containsKey(key)) {
            return map.get(key);
        }
        long res = 0;
        //计算往3个方向走的结果
        //往左走，注意在最左边的时候是不能往左走的
        if (index > 0)
            res += dfs(steps - 1, map, arrLen, index - 1) % mod;
        //往右走，注意在最右边的时候是不能往右走的
        if (index < arrLen - 1)
            res += dfs(steps - 1, map, arrLen, index + 1) % mod;
        //往下走（也就是停留在原地）
        res += dfs(steps - 1, map, arrLen, index) % mod;
        res %= mod;
        //计算完之后再把结果存储到map中
        map.put(key, (int) res);
        return (int) res;
    }

    /**
     * 执行结果：
     * 通过
     * 显示详情
     * 添加备注
     *
     * 执行用时：
     * 18 ms
     * , 在所有 Java 提交中击败了
     * 44.74%
     * 的用户
     * 内存消耗：
     * 38.8 MB
     * , 在所有 Java 提交中击败了
     * 52.63%
     * 的用户
     * 炫耀一下:
     * */
    public int dp(int step,int arrLen){
        //动态规划需要转移方程，这个数组就是为了转移用的
        //含义是 在step=x的时候，arraLenw位置一共有多少种结果
        //所以说我们需要获得的结果x=step arraLen=0,也就是我的位置是0的情况step这些步骤走完，结果是多少
       int maxLen = Math.min(step,arrLen-1);
        int[][] result = new int[step+1][maxLen+1];
        //需要一个初始化的
        result[0][0] = 1;
        for(int i=1;i<step+1;i++){
            for(int j=0;j<maxLen+1;j++){
                //原地踏步走
                result[i][j] = result[i-1][j];
                if(j>0){
                    //她踏着轻松的脚步从左面踏过来
                    result[i][j]=(result[i][j]+result[i-1][j-1])%mod;
                }
                if(j<maxLen){
                    //她踏着轻松的脚步从右面踏过来
                    result[i][j]=(result[i][j]+result[i-1][j+1])%mod;
                }
            }
        }
        return result[step][0];

    }

    //高端的来了，动态规划，我想如果你想写动态规划，递归的那两种写法一定是胸有成竹了，如果没有，
    //还是不要尝试了，我感觉理解递归才能过度到动态规划

    public static void main(String[] args) {
        Leecode1269 leecode1269= new Leecode1269();
        System.out.println(leecode1269.numWays(27,7));
    }
}
