package questions.evrydaystep;


import java.util.Stack;

/**
 * 678. 有效的括号字符串
 * 给定一个只包含三种字符的字符串：（ ，） 和 *，写一个函数来检验这个字符串是否为有效字符串。有效字符串具有如下规则：
 * <p>
 * 任何左括号 ( 必须有相应的右括号 )。
 * 任何右括号 ) 必须有相应的左括号 ( 。
 * 左括号 ( 必须在对应的右括号之前 )。
 * * 可以被视为单个右括号 ) ，或单个左括号 ( ，或一个空字符串。
 * 一个空字符串也被视为有效字符串。
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: True
 * 示例 2:
 * <p>
 * 输入: "(*)"
 * 输出: True
 * 示例 3:
 * <p>
 * 输入: "(*))"
 * 输出: True
 */
public class Leecode678 {
    //（ ，） 和 *，
    public boolean checkValidString(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            if ('*' == s.charAt(i)) {
                dp[i][i] = true;
            }
        }
        for (int i = 1; i < s.length(); i++) {
            char pre = s.charAt(i - 1);
            char cur = s.charAt(i);
            dp[i - 1][i] = (pre == '(' || pre == '*') && (cur == ')' || cur == '*');
        }
        for (int i = s.length() - 3; i >= 0; i--) {
            char c1 = s.charAt(i);
            for (int j = i + 2; j < s.length(); j++) {
                char c2 = s.charAt(j);
                if ((c1 == '(' || c1 == '*') && (c2 == ')' || c2 == '*')) {
                    dp[i][j] = dp[i + 1][j - 1];
                }
                for (int k = i; k < j && !dp[i][j]; k++) {
                    dp[i][j] = dp[i][k] && dp[k + 1][j];
                }
            }
        }
        return dp[0][s.length() - 1];

    }

    public boolean checkValidString1(String s) {

        Stack<Integer> left = new Stack<>();
        Stack<Integer> stars = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if ('(' == s.charAt(i)) {
                left.push(i);

            } else if (')' == s.charAt(i)) {
                if (!left.isEmpty()) {
                    left.pop();
                } else if (!stars.isEmpty()) {
                    stars.pop();
                } else {
                    return false;
                }

            } else {
                stars.push(i);

            }

        }
        while (!left.isEmpty()) {
            if (stars.isEmpty()) {
                return false;
            }
            if (left.peek() < stars.peek()) {
                left.pop();
                stars.pop();
            } else {
                return false;
            }
        }
        return true;
    }


}
