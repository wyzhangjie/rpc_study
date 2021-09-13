package questions.evrydaystep;
/**
 * 483. 最小好进制
 * 对于给定的整数 n, 如果n的k（k>=2）进制数的所有数位全为1，则称 k（k>=2）是 n 的一个好进制。
 *
 * 以字符串的形式给出 n, 以字符串的形式返回 n 的最小好进制。
 *
 *
 *
 * 示例 1：
 *
 * 输入："13"
 * 输出："3"
 * 解释：13 的 3 进制是 111。
 * 示例 2：
 *
 * 输入："4681"
 * 输出："8"
 * 解释：4681 的 8 进制是 11111。
 * 示例 3：
 *
 * 输入："1000000000000000000"
 * 输出："999999999999999999"
 * 解释：1000000000000000000 的 999999999999999999 进制是 11。
 *
 *
 * 提示：
 *
 * n的取值范围是 [3, 10^18]。
 * 输入总是有效且没有前导 0。
 *
 * */
public class Leecode483 {

    public String smallestGoodBase(String n) {
        long longPre=Long.parseLong(n);
        //这样思考，n的范围是[3, 10^18 所以是一定小于long的
        //long类型的二进制是64位，也就是说n用1来表示不会大于64位
        //如果我们能够把这些64个位置1按照二分法获取结果，那么就好办了
        int left=1;
        int right=64;
        while (left<=right){
            int mid=left+(right-left)/2;
            long gain = binaryInfo(mid,longPre);
            if(gain==0){
                return String.valueOf(mid);
            }
            //说明小了
            if(gain<0){
                left=mid+1;
            }else {
                right=mid-1;
            }
        }
        return "-1";

    }

    private long binaryInfo(int mid,long respect) {
        long result=0;
        for(int i=0;i<=mid;i++){
            result+=mid^i;
        }
        return result;
    }

    public static void main(String[] args) {
        Leecode483 leecode483 = new Leecode483();
        System.out.println(leecode483.smallestGoodBase("4681"));

        System.out.println(leecode483.smallestGoodBase("13"));
        System.out.println(leecode483.smallestGoodBase("1000000000000000000"));
    }

}
