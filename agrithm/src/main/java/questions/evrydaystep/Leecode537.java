package questions.evrydaystep;/**
 * ClassName Leecode537
 * Description
 * Create by jie.zhang02
 * Date 2022/2/25 10:10 上午
 */

/**
 *
 * 输入：num1 = "1+1i", num2 = "1+1i"
 * 输出："0+2i"
 * 解释：(1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/complex-number-multiplication
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * @author jie.zhang
 * @date 2022年02月25日 10:10 上午
 */
public class Leecode537 {
    public String complexNumberMultiply(String num1, String num2) {
        String[] a =num1.split("\\+");
        String[] b= num2.split("\\+");
        int t1 =Integer.valueOf(a[0])*Integer.valueOf(b[0]);
       int t2= Integer.valueOf(a[0])*(Integer.valueOf(b[1].substring(0,b[1].length()-1))) +Integer.valueOf(b[0])*Integer.valueOf(a[1].substring(0,a[1].length()-1));
        int t3=-(Integer.valueOf(b[1].substring(0,b[1].length()-1)) * Integer.valueOf(a[1].substring(0,a[1].length()-1)));
        return t1+t3+"+"+t2+"i";
    }

    public static void main(String[] args) {
        Leecode537 leecode537 = new Leecode537();
        String num1 = "1+-1i", num2 = "1+-1i";
        System.out.println(leecode537.complexNumberMultiply(num1,num2));
    }
}
