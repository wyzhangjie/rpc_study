package questions.evrydaystep;


import java.util.Stack;

/**
 * 你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 *
 * 整数除法仅保留整数部分。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "3+2*2"
 * 输出：7
 * 示例 2：
 *
 * 输入：s = " 3/2 "
 * 输出：1
 * 示例 3：
 *
 * 输入：s = " 3+5 / 2 "
 * 输出：5
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 3 * 105
 * s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开
 * s 表示一个 有效表达式
 * 表达式中的所有整数都是非负整数，且在范围 [0, 231 - 1] 内
 * 题目数据保证答案是一个 32-bit 整数
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/basic-calculator-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class Leecode227 {

    public static void main(String[] args) {
        String s = " 3+5 / 2 ";
        String s1="3+2*2";
        String s2=" 3/2 ";
        String s3="0";
        String s4="42";
        String s5="1*2*3*4*5*6*7*8*9*10";
        Leecode227 leecode227 = new Leecode227();
        System.out.println(leecode227.calculate(s5));
        System.out.println(leecode227.calculate(s1));
    }

    public int calculate(String s) {
        Character ope=null;
        char[] chars = s.toCharArray();
        int i=0;
        Stack<Integer> nums = new Stack<>();
        while (i<s.length()){
            if(chars[i]==' '){
                i++;
                continue;
            }
            if(isOpeHigh(chars[i])){
                if(ope==null){
                   // int second = Character.getNumericValue(chars[i+1]);
                    int jin = 1;
                    int second =0;
                    char opsTemp = chars[i];
                    while (i+1<s.length()&&!isOpeOrWhite(chars[i+1]) ){
                        second= second*jin+Character.getNumericValue(chars[i+1]);
                        jin=10;
                        i++;
                    }

                    int first = nums.pop();
                    nums.push(culculate(first,second,opsTemp));
                    i++;
                    continue;
                }
                if(isOpeLow(ope)){
                    while (chars[i+1]==' '){
                        i++;
                    }
                   // int second = Character.getNumericValue(chars[i+1]);
                    char opsTemp = chars[i];
                    int jin = 1;
                    int second =0;
                    while (i+1<s.length()&&!isOpeOrWhite(chars[i+1]) ){
                        second= second*jin+Character.getNumericValue(chars[i+1]);
                        jin=10;
                        i++;
                    }
                    int first = nums.pop();
                    nums.push(culculate(first,second,opsTemp));
                    i++;
                    continue;
                }
            }
            if(isOpeLow(chars[i])){
                if(ope==null) {
                    ope = chars[i];

                }else {
                    int second = nums.pop();
                    int first = nums.pop();
                    nums.push(culculate(first,second,ope));
                    ope=chars[i];

                }

            }
            if(Character.isDigit(chars[i])){
                int jin = 1;
                int digit =0;
                while (i<s.length()&&!isOpeOrWhite(chars[i]) ){
                    digit= digit*jin+Character.getNumericValue(chars[i]);
                    jin=10;
                    i++;
                }
                nums.push(digit);
                continue;
            }

            i++;
        }
        while (ope!=null){
            int second = nums.pop();
            int first = nums.pop();
            nums.push(culculate(first,second,ope));
            ope=null;
        }
        return nums.peek();
    }

    private Integer culculate(int first, int second, char aChar) {
        if(aChar=='+'){
            return first+second;
        }
        if(aChar=='-'){
            return first-second;
        }
        if(aChar=='*'){
            return first*second;
        }else {
            return first/second;
        }
    }

    private boolean isOpeOrWhite(char aChar) {
        if(aChar=='+' || aChar=='-' || aChar=='*' || aChar=='/' ||aChar==' '){
            return true;
        }
        return false;
    }
    private boolean isOpeHigh(char aChar) {
        if( aChar=='*' || aChar=='/'){
            return true;
        }
        return false;
    }
    private boolean isOpeLow(char aChar) {
        if(aChar=='+' || aChar=='-'){
            return true;
        }
        return false;
    }


}
