package questions.evrydaystep.highEfficiency;/**
 * ClassName Leecode483
 * Description
 * Create by jie.zhang02
 * Date 2022/3/2 11:47 上午
 */

/**
 * @author jie.zhang
 * @date 2022年03月02日 11:47 上午
 */
public class Leecode483 {
    public String smallestGoodBase(String n) {
        //这个long值为多少
        Long nVal = Long.valueOf(n);
        //每次最多的位数为多少
        int mMax = (int) Math.floor(Math.log(nVal) / Math.log(2));
        for(int i=mMax;i>1;i--){
            //进制为多少
            int k = (int) Math.pow(nVal, 1.0 / i);
            long mul = 1, sum = 1;
            for (int t = 0; t < i; t++) {
                mul *= k;
                sum += mul;
            }
            if (sum == nVal) {
                return Integer.toString(k);
            }
        }
        return Long.toString(nVal - 1);


    }
}
