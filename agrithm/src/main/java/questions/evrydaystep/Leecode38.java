package questions.evrydaystep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 *
 * 剑指 Offer 38. 字符串的排列
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 *
 *
 *
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 *
 *
 *
 * 示例:
 *
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 *
 *
 * 限制：
 *
 * 1 <= s 的长度 <= 8
 *
 * 通过次数118,283提交次数205,799
 * */
public class Leecode38 {

    private HashSet<String> result=new HashSet<>();
    public String[] permutation(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        Boolean[] flags = new Boolean[chars.length];
        for(int i=0;i<flags.length;i++){
            flags[i]=false;
        }
        List<Character> temp = new ArrayList<>();
        pernumtationSub(chars,temp,0,flags);
        String[] preResult = new String[result.size()];

        return preResult;
    }

    private void pernumtationSub(char[] chars, List<Character> temp, int i,Boolean[] flags) {
        if(i==chars.length){
            result.add(temp.toString());
            return;
        }

        for(int j=0;j<chars.length;j++){
           if(!flags[j]){
               flags[j]=true;
               temp.add(chars[j]);
               pernumtationSub(chars,temp,i+1,flags);
               temp.remove(temp.get(temp.size()-1));
               flags[j]=false;
           }

        }
    }

    public static void main(String[] args) {
        String s = "abc";
        Leecode38 leecode38 = new Leecode38();
        String[] result =leecode38.permutation(s);
        for(int i=0;i< result.length;i++){
            System.out.println(result[i]);
        }
    }
}
