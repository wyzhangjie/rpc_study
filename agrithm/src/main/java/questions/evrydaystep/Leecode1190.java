package questions.evrydaystep;


import java.util.Stack;

/**
 * 1190. 反转每对括号间的子串
 * 给出一个字符串 s（仅含有小写英文字母和括号）。
 * <p>
 * 请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。
 * <p>
 * 注意，您的结果中 不应 包含任何括号。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "(abcd)"
 * 输出："dcba"
 * 示例 2：
 * <p>
 * 输入：s = "(u(love)i)"
 * 输出："iloveu"
 * 示例 3：
 * <p>
 * 输入：s = "(ed(et(oc))el)"
 * 输出："leetcode"
 * 示例 4：
 * <p>
 * 输入：s = "a(bcdefghijkl(mno)p)q"
 * 输出："apmnolkjihgfedcbq"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 2000
 * s 中只有小写英文字母和括号
 * 我们确保所有括号都是成对出现的
 * 通过次数18,469提交次数29,609
 */
public class Leecode1190 {

    public String reverseParentheses(String s) {
        Stack<Integer> symbal = new Stack<>();
        char[] subS = s.toCharArray();
        int len = s.length();
        int i = 0;
        while (i < len) {
            char aa = s.charAt(i);
            if (aa == '(') {
                symbal.push(i);
            }
            if (aa == ')') {
                Integer left = symbal.pop();
                reverse(subS, left, i);
            }
            i++;
        }

        StringBuffer sb = new StringBuffer();
        for (i = 0; i < len; i++) {
            if (subS[i] != '(' && subS[i] != ')') {
                sb.append(subS[i]);
            }
        }

        return sb.toString();
    }

    private void reverse(char[] subS, Integer left, int i) {
        while (left < i) {
            char mid = subS[left];
            subS[left] = subS[i];
            subS[i] = mid;
            left++;
            i--;

        }
    }


    public String reverseParentheses1(String s) {
        int left = s.lastIndexOf("(");
        if (left < 0) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        if (left > 0) {
            sb.append(s, 0, left);
        }
        int right = s.indexOf(")", left);
        if (left + 1 != right) {
            String a = s.substring(left + 1, right);
            char[] cc = a.toCharArray();
            int l = cc.length;
            char[] tc = new char[l];
            int offset = l - 1;
            for (int i = 0; i < l; i++) {
                tc[i] = cc[offset - i];
            }
            sb.append(tc);
        }
        sb.append(s, right + 1, s.length());
        return reverseParentheses1(sb.toString());
    }


    public String reverseParentheses3(String s) {
        int left = s.lastIndexOf("(");
        if (left < 0) {
            return s;
        }
        StringBuilder sb = new StringBuilder();

        int right = s.indexOf(")", left);
        sb.append(s, left + 1, right);
        sb.reverse();

        if (left > 0) {
            sb.insert(0, s, 0, left);
        }
        sb.append(s, right + 1, s.length());

        return reverseParentheses3(sb.toString());
    }



    public String reverseParentheses5(String s) {
        int left = s.lastIndexOf("(");
        if (left < 0) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        if (left > 0) {
            sb.append(s, 0, left);
        }
        int right = s.indexOf(")", left);
        if (left + 1 != right) {
            String a = s.substring(left + 1, right);
            char[] cc = a.toCharArray();
            int l = cc.length;
            char[] tc = new char[l];
            int offset = l - 1;
            for (int i = 0; i < l; i++) {
                tc[i] = cc[offset - i];
            }
            sb.append(tc);
        }
        sb.append(s, right + 1, s.length());

        return reverseParentheses5(sb.toString());
    }

    public static void main(String[] args) {
        String s = "a(bcdefghijkl(mno)p)q";
        Leecode1190 leecode1190 = new Leecode1190();
        System.out.println(leecode1190.reverseParentheses(s));
    }
}
