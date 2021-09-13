package questions.evrydaystep;


import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 实现一个基本的计算器来计算一个简单的字符串表达式 s 的值。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "1 + 1"
 * 输出：2
 * 示例 2：
 *
 * 输入：s = " 2-1 + 2 "
 * 输出：3
 * 示例 3：
 *
 * 输入：s = "(1+(4+5+2)-3)+(6+8)"
 * 输出：23
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 3 * 105
 * s 由数字、'+'、'-'、'('、')'、和 ' ' 组成
 * s 表示一个有效的表达式
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/basic-calculator
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class Leecode224 {

    public int calculate(String s) {
        char[] chars =s.toCharArray();
        List<String> toCalculate = new ArrayList<>();
        int i=0;
        while (i<chars.length){
            if(chars[i]==' '){
                i++;
                continue;
            }
            if(chars[i]=='(' ||chars[i]==')'){
                toCalculate.add(String.valueOf(chars[i]));
                i++;
            }else if(chars[i]=='+' ||chars[i]=='-'){
                if(i==0){
                    toCalculate.add("0");
                    toCalculate.add(String.valueOf(chars[i]));
                    i++;
                }else {
                    toCalculate.add(String.valueOf(chars[i]));
                    i++;
                }
                continue;

            }else {
                int begin=i;
                while (i<chars.length &&Character.isDigit(chars[i])){
                    i++;
                }
                toCalculate.add(s.substring(begin,i));
            }

        }
        //重新组织

        Stack<String> symbol = new Stack<>();
        Stack<Integer> nums = new Stack<>();
        while (toCalculate.size()>0){

                if(isSymbolNonRightBracket(toCalculate.get(0)) ){
                    symbol.push(toCalculate.get(0));
                    toCalculate.remove(0);
                    continue;
                }
                if(isRightBracket(toCalculate.get(0))){
                    while (!symbol.peek().equalsIgnoreCase("(")){
                        int second = nums.pop();
                        String symbal = symbol.pop();
                        int first = nums.pop();
                        nums.push(culculate(first,second,symbal));
                    }
                 if(symbol.peek().equalsIgnoreCase("(")){
                     symbol.pop();
                     if(symbol.size()>0 && nums.size()>1){
                         int second = nums.pop();
                         String symbal = symbol.pop();
                         int first = nums.pop();
                         nums.push(culculate(first,second,symbal));
                     }
                     toCalculate.remove(0);
                     continue;
                 }

                }
                if(isNumeric (toCalculate.get(0))){
                    if(nums.size()>0&& !"(".equalsIgnoreCase(symbol.peek())){
                        int first = nums.pop();
                        String symbal = symbol.pop();
                        int second = Integer.parseInt(toCalculate.get(0));
                       nums.push(culculate(first,second,symbal));
                        toCalculate.remove(0);
                    }else {
                        nums.push(Integer.parseInt(toCalculate.get(0)));
                        toCalculate.remove(0);
                    }
                }

            }

        if(symbol.size()>1){
            //到这里说明都没有记录，要从头开始计算

        }

        while (symbol.size()>0){
            int second = nums.pop();
            int first = nums.pop();
            nums.push(culculate(first,second,symbol.pop()));
        }
        return nums.peek();

    }
    public  boolean isNumeric(CharSequence cs) {
        if (isEmpty(cs)) {
            return false;
        } else {
            int sz = cs.length();

            for(int i = 0; i < sz; ++i) {
                if (!Character.isDigit(cs.charAt(i))) {
                    return false;
                }
            }

            return true;
        }
    }
    public  boolean isEmpty(CharSequence cs) {
        return cs == null || cs.length() == 0;
    }
    private Integer culculate(int first, int second, String symbal) {
        if("+".equals(symbal)){
            return first+second;
        }else {
            return first-second;
        }

    }

    private boolean isRightBracket(String aChar) {
        if(aChar.equals(")") ){
            return true;
        }else {
            return false;
        }
    }

    private boolean isSymbolNonRightBracket(String c) {
        if(c.equals("+") || c.equals("-") ||c.equals("(") ){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        String s1="1 + 1";
        String s2=" 2-1 + 2 ";
        String s3="(1+(4+5+2)-3)+(6+8)";
        String s4="2147483647";
        String s5="-2+ 1";
        String s6="(1+(4+5+2)-3)+(6+8)";
        String s7="(1-(3-4))";
        String s8="(7)-(0)+(4)";
        Leecode224 leecode224 = new Leecode224();
    //    System.out.println(leecode224.calculate(s1));
    //    System.out.println(leecode224.calculate(s2));
      //  System.out.println(leecode224.calculate(s3));
        System.out.println(leecode224.calculate(s8));
    }
}
