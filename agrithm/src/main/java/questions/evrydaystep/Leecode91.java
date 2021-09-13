package questions.evrydaystep;

/**
 * 91. 解码方法
 * 一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为：
 * <p>
 * "AAJF" ，将消息分组为 (1 1 10 6)
 * "KJF" ，将消息分组为 (11 10 6)
 * 注意，消息不能分组为  (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。
 * <p>
 * 给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。
 * <p>
 * 题目数据保证答案肯定是一个 32 位 的整数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "12"
 * 输出：2
 * 解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 示例 2：
 * <p>
 * 输入：s = "226"
 * 输出：3
 * 解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 * 示例 3：
 * <p>
 * 输入：s = "0"
 * 输出：0
 * 解释：没有字符映射到以 0 开头的数字。
 * 含有 0 的有效映射是 'J' -> "10" 和 'T'-> "20" 。
 * 由于没有字符，因此没有有效的方法对此进行解码，因为所有数字都需要映射。
 * 示例 4：
 * <p>
 * 输入：s = "06"
 * 输出：0
 * 解释："06" 不能映射到 "F" ，因为字符串含有前导 0（"6" 和 "06" 在映射中并不等价）。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 100
 * s 只包含数字，并且可能包含前导零。
 */
public class Leecode91 {

    public int numDecodings(String s) {
        int len = s.length();
        int[] pos = new int[len+1];
        pos[0]=1;

        for (int i = 1; i < len+1; i++) {
            if(!isO(s.charAt(i-1))){
                pos[i]+=pos[i-1];
            }
          if(i>1 &&!isO(s.charAt(i-2)) && ((s.charAt(i-2)-'0')*10+s.charAt(i-1)-'0')<=26 ){
              pos[i]+=pos[i-2];
          }
        }
        return pos[len];

    }

    public boolean isO(char s) {
        if (s - '0' == 0) {
            return true;
        }
        return false;

    }

    public boolean isIn1To6(char s) {
        if (s - '0' <= 6 && s - '0' >= 1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isIn1To2(char s) {
        if (s == '1' || s == '2') {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String s = "10";
        Leecode91 leecode91 = new Leecode91();
        System.out.println(leecode91.numDecodings(s));
         s="12";
        System.out.println(leecode91.numDecodings(s));
        s = "27";
        System.out.println(leecode91.numDecodings(s));
    }
}
