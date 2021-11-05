package questions.evrydaystep;

public class Leecode29 {

    int LIMIT = Integer.MIN_VALUE / 2;

    public int divide(int dividend, int divisor) {
        // 考虑被除数为最小值的情况
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == 1) {
                return Integer.MIN_VALUE;
            }
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            }
        }
        // 考虑除数为最小值的情况
        if (divisor == Integer.MIN_VALUE) {
            return dividend == Integer.MIN_VALUE ? 1 : 0;
        }
        // 考虑被除数为 0 的情况
        if (dividend == 0) {
            return 0;
        }

        int sign = 1;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            sign = -1;
        }

        dividend = dividend > 0 ? -dividend : dividend;
        divisor = divisor > 0 ? -divisor : divisor;

        int a = dividend;
        int b = divisor;
        int ans = 0;
        while (a <= b) {
            int c = b;
            int d = 1;
            while (c >= LIMIT && d >= LIMIT && c >= a - c) {
                c += c;
                d += d;
            }
            a -= c;
            ans += d;
        }

        return sign == 1 ?  ans:-ans ;

    }

    public static void main(String[] args) {
        Leecode29 leecode29 = new Leecode29();
        System.out.println(leecode29.divide(10,3));
    }
}
