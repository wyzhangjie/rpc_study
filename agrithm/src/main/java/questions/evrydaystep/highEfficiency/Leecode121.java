package questions.evrydaystep.highEfficiency;/**
 * ClassName Leecode112
 * Description
 * Create by jie.zhang02
 * Date 2022/3/8 12:05 下午
 */

/**
 * @author jie.zhang
 * @date 2022年03月08日 12:05 下午
 */
public class Leecode121 {
    public int maxProfit(int[] prices) {
        if(prices.length==1){
            return 0;
        }
       int max=0;
        int min=prices[0];
        for(int i=1;i<prices.length;i++){
            max=Math.max(max,prices[i]-min);
            min=Math.min(min,prices[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] prices =new int[]{7,1,5,3,6,4};
        Leecode121 leecode121 = new Leecode121();
        System.out.println(leecode121.maxProfit(prices));
    }
}
