package questions.evrydaystep;/**
 * ClassName Leecode1342
 * Description
 * Create by jie.zhang02
 * Date 2022/1/31 10:07 上午
 */

/**
 * @author jie.zhang
 * @date 2022年01月31日 10:07 上午
 */
public class Leecode1342 {
    public int numberOfSteps(int num) {
        int count=0;
       while (num!=0){
           if(num%2==0){
               count++;
               num/=2;
           }else {
               count++;
               num=num-1;
           }

       }
       return count;
    }

    public static void main(String[] args) {
        int num=14;
        Leecode1342 leecode1342 = new Leecode1342();
        System.out.println(leecode1342.numberOfSteps(num));
    }
}
