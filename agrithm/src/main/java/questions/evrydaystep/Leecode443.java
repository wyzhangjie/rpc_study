package questions.evrydaystep;

import questions.stack.Stack;

public class Leecode443 {
    public int compress(char[] chars) {
        if (chars.length == 1) {
            return 1;
        }

        int left = 0;
        int right = 1;
        int position = 0;
        while (left < chars.length) {
            if(right==-1){
                chars[position++] = chars[left];
                break;
            }
            if (chars[left] != chars[right]) {
                chars[position++] = chars[left];
                left = right;
                if(right<chars.length-1){
                    right++;
                }else {
                    right=-1;
                }
            } else {
             while (right<chars.length && chars[right]==chars[left]){
                 right++;
             }
                chars[position++] = chars[left];
             int total =right-left;
             Stack<Integer> stack = new Stack<>();
             while (total!=0){
                 stack.push(total%10);
                 total/=10;
             }
             while (!stack.empty()){
                 chars[position++] = Character.forDigit(stack.pop(),10);
             }
             left=right;
             if(right<chars.length-1){
                 right++;
             }else {
                 right=-1;
             }
            }
        }
        return position;
    }

    public static void main(String[] args) {
        char[] chars = new char[]{'a', 'a', 'c'};
        char[] chars1 = new char[]{'a', 'b', 'c'};
        char[] chars2 = new char[]{'a', 'a', 'a', 'a', 'b', 'a'};
        char[] chars3 = new char[]{'a','a','b','b','c','c','c'};
        char[] chars4 = new char[]{'o','o','o','o','o','o','o','o','o','o'};
        Leecode443 leecode443 = new Leecode443();
        System.out.println(leecode443.compress(chars4));
    }

}
