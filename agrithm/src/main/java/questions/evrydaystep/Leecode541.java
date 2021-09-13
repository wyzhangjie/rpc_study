package questions.evrydaystep;

import java.util.Arrays;

/**
 * 541. 反转字符串 II
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每 2k 个字符反转前 k 个字符。
 *
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 *
 *
 * 示例 1：
 *
 * 输入：s = "abcdefg", k = 2
 * 输出："bacdfeg"
 * 示例 2：
 *
 * 输入：s = "abcd", k = 2
 * 输出："bacd"
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 104
 * s 仅由小写英文组成
 * 1 <
 * */
public class Leecode541 {
    public String reverseStr(String s, int k) {
       int totalLen = s.length();
       int leftLen = totalLen%(2*k);
       char[] chars = s.toCharArray();
       //全部翻转
       int flag=1;
       if(leftLen==0){
           flag=0;
       }
       //标志当前剩余长度为k-2k之间
       if(leftLen>k){
           flag=2;
       }
       int k2Size = totalLen/(2*k);

       for(int i=0;i<k2Size;i++){
           reverseSub(chars,i*2*k+0,i*2*k+k-1);
       }
       if(flag==1){
           reverseSub(chars,k2Size*2*k,totalLen-1);
       }
        if(flag==2){
            reverseSub(chars,k2Size*2*k,k2Size*2*k+k-1);
        }
        return new String(chars);
    }

    private void reverseSub(char[] s, int begin, int end) {
        while (begin<end){
            char temp =s[begin];
            s[begin]=s[end];
            s[end]=temp;
            begin++;
            end--;
        }

    }

    public static void main(String[] args) {
      String  s = "abcd";
      int k = 4;
        Leecode541 leecode541 = new Leecode541();
        System.out.println(leecode541.reverseStr(s,k));
    }
}
