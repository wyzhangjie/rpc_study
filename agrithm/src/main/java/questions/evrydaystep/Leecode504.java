package questions.evrydaystep;/**
 * ClassName Leecode504
 * Description
 * Create by jie.zhang02
 * Date 2022/3/7 9:58 上午
 */

/**
 * @author jie.zhang
 * @date 2022年03月07日 9:58 上午
 */
public class Leecode504 {
    public String convertToBase7(int num) {

        StringBuffer sb= new StringBuffer();
        String symbol =num<0?"-":"";
        if(num==0 ||num==-0){
            return num+"";
        }
        if(num<0){
            num=-num;
        }
        while (num!=0){
            sb.append(num%7);
            num=num/7;
        }
        return symbol+sb.reverse();
    }

    public static void main(String[] args) {
        int num= -0;
        Leecode504 leecode504 = new Leecode504();
        System.out.println(leecode504.convertToBase7(num));
    }
}
