package questions.evrydaystep;

import java.util.Stack;

public class Leecode1047 {
    public String removeDuplicates(String S) {
        char[] chars = S.toCharArray();
        StringBuffer stack =new StringBuffer();
        int  top =-1;
        for(int i=0;i<chars.length;i++){
            if(top==-1){
                stack.append(chars[i]);
                top++;
            }else {
                if(stack.charAt(top)==(chars[i])){
                    stack.deleteCharAt(top);
                    top--;
                    continue;
                }else {
                    stack.append(chars[i]);
                    top++;
                }
            }
        }

        return stack.toString();
    }

    public static void main(String[] args) {
        String s="abbaca";
        Leecode1047 leecode1047 = new Leecode1047();
        System.out.println(leecode1047.removeDuplicates(s));
    }
}
