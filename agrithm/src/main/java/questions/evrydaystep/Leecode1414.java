package questions.evrydaystep;/**
 * ClassName Leecode1414
 * Description
 * Create by jie.zhang02
 * Date 2022/2/4 6:59 上午
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author jie.zhang
 * @date 2022年02月04日 6:59 上午
 */
public class Leecode1414 {
    public int findMinFibonacciNumbers(int k) {
        int a = 1;
        int b = 1;
        List<Integer> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        int c = a + b;
        while (c < 1e9) {
            c = a + b;
            list.add(c);
            a = b;
            b = c;
        }
        return getAns(k, list);
    }

    private int getAns(int k, List<Integer> list) {
        //二分法获取结果
        int ans = 0;
        while (k != 0) {
            int right = list.size() - 1;
            int left = 0;
            while (left < right) {
                int mid = left + right + 1 / 2;
                if (list.get(mid) <= k) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }
            k -= list.get(left);
            ans++;
        }
        return ans;
    }

    public int findMinFibonacciNumbers1(int k) {
        int a = 1;
        int b = 1;
        while (b < k) {
            int c = a + b;
            a = b;
            b = c;
        }
        int ans = 0;
        while (k != 0) {
            if (k >= b) {
                k -= b;
                ans++;
            }
            int c = b - a;
            b = a;
            a = c;

        }
        return ans;
    }

    public static void main(String[] args) {
        int k = 7;
        Leecode1414 leecode1414 = new Leecode1414();
        System.out.println(leecode1414.findMinFibonacciNumbers1(k));
    }
}
