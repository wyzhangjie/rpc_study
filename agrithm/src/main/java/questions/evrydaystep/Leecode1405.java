package questions.evrydaystep;
/**
 * ClassName Leecode1405
 * Description
 * Create by jie.zhang02
 * Date 2022/2/7 8:12 上午
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author jie.zhang
 * @date 2022年02月07日 8:12 上午
 */
public class Leecode1405 {

    public String longestDiverseString(int a, int b, int c) {
        MyChar myChar1 = new MyChar('a', a);
        MyChar myChar2 = new MyChar('b', b);
        MyChar myChar3 = new MyChar('c', c);
        MyChar[] myChars = new MyChar[]{
                myChar1, myChar2, myChar3
        };
        StringBuilder sb = new StringBuilder();
        while (true) {
            Arrays.sort(myChars, (t, l) -> l.count - t.count);
            if (sb.length() >= 2 && sb.charAt(sb.length() - 1) == myChars[0].character && sb.charAt(sb.length() - 2) == myChars[0].character) {
                // 如果次多字符有货
                if (myChars[1].count > 0) {
                    sb.append(myChars[1].character);
                    myChars[1].count--;
                }
                // 第二多的都没货，第三多的更没货
                else {
                    break;
                }
            } else {
                //
                if (myChars[0].count > 0) {
                    sb.append(myChars[0].character);
                    myChars[0].count--;
                }
                // 如果出现频率最高的都没货，那其他更不能有
                else {
                    break;
                }


            }
        }
        return  sb.toString();
    }

    public static void main(String[] args) {
        //输入：a = 1, b = 1, c = 7
        //输出："ccaccbcc"
        int a = 1, b = 1, c = 7;
        Leecode1405 leecode1405 =new Leecode1405();
        System.out.println(leecode1405.longestDiverseString(a,b,c));
    }


    public class MyChar {
        public char character;
        public int count;

        public MyChar(char a, int b) {
            this.character = a;
            this.count = b;
        }
    }
}
