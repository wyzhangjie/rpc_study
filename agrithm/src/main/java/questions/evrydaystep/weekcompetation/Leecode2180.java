package questions.evrydaystep.weekcompetation;/**
 * ClassName Leecode2018
 * Description
 * Create by jie.zhang02
 * Date 2022/2/23 10:52 上午
 */

/**
 * @author jie.zhang
 * @date 2022年02月23日 10:52 上午
 */
public class Leecode2180 {
    public int countEven(int num) {
        int result=0;
        for(int i=2;i<=num;i++){
            if(even(i)){
                result++;
            }
        }
        return result;

    }

    private boolean even(int i) {
        int result=0;
        while (i!=0){
            int temp =i%10;
            result+=temp;
            i=(i/10);
        }
        if(result%2==0){
            return true;
        }else {
            return false;
        }
    }
}
