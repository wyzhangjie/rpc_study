package questions.stack;
/**
 *
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 *
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 *
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 *
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "3[a]2[bc]"
 * 输出："aaabcbc"
 * 示例 2：
 *
 * 输入：s = "3[a2[c]]"
 * 输出："accaccacc"
 * 示例 3：
 *
 * 输入：s = "2[abc]3[cd]ef"
 * 输出："abcabccdcdcdef"
 * 示例 4：
 *
 * 输入：s = "abc3[cd]xyz"
 * 输出："abccdcdcdxyz"
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/2021-spring-recruitment/9h0rur/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * */
public class Leecode349 {
    public String decodeString(String s) {
        Stack<String> stack = new Stack();
        char[] chars = s.toCharArray();
        if(chars.length==0){
            return null;
        }else {
            for(int i=0;i<chars.length;i++){
               if(chars[i]!=']' &&chars[i]!='[' ){
                   stack.push(String.valueOf(chars[i]));
               }

            }
            System.out.println(stack.elementData);
            while(!stack.empty()){
                String temp;
                temp= stack.pop();
              /*  if(temp)*/
            }
        }
        return null;

    }

    public static void main(String[] args) {
        String s= "abc3[cd]xyz";
    }
}
