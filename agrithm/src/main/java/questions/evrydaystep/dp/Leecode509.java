package questions.evrydaystep.dp;
/**
 * ClassName Leecode509
 * Description
 * Create by jie.zhang02
 * Date 2022/3/21 3:30 下午
 */

/**
 * @author jie.zhang
 * @date 2022年03月21日 3:30 下午
 */
public class Leecode509 {
    public int fib(int n) {
        int a0 = 0;
        int a1 = 1;
        if(n==0){
            return a0;
        }
        for (int i = 2; i <= n; i++) {
            a0 = a0 + a1;
            int temp = a0;
            a0 = a1;
            a1 = temp;
        }

        return  a1;
    }

    public static void main(String[] args) {
        Leecode509 leecode509 = new Leecode509();
        System.out.println(leecode509.fib(4));
    }
}
