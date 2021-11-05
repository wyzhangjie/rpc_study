package questions.evrydaystep;

public class Leecode371 {
    public int getSum(int a, int b) {
    // 把a+b 用二进制表示，思考不进位的a^b 和进位的数 （a&b）<<1
        while (b!=0){
            int carry =(a&b)<<1;
            a=a^b;
            b=carry;
        }
        return a;

    }
}
