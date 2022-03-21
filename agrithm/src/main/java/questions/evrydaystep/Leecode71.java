package questions.evrydaystep;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Leecode71 {
    public String simplifyPath(String path) {

        String[] ss = path.split("/");
        Deque<String> stack = new ArrayDeque<String>() {
        };

        for (int i = 0; i < ss.length; i++) {
            if("".equals(ss[i])){
                continue;
            }
            if (".".equals(ss[i])) {
                continue;
            }
            if ("..".equals(ss[i])) {
                if(!stack.isEmpty()){
                    stack.pop();
                }

            } else {
                stack.push(ss[i]);
            }
        }
        if(stack.isEmpty()){
            return "/";
        }

       String result = new String();
        while (!stack.isEmpty()){
            result+= "/"+stack.pollLast();
        }
        return result;
    }

    public static void main(String[] args) {
        Leecode71 leecode71= new Leecode71();
        System.out.println(leecode71.simplifyPath("/home//foo/"));
    }
}
