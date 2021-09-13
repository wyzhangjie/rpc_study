package questions.evrydaystep;

import org.apache.commons.collections4.multimap.HashSetValuedHashMap;

import java.util.*;

/**
 *
 * 567. 字符串的排列
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 *
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 *
 * 示例1:
 *
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 *
 *
 * 示例2:
 *
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 *
 *
 * 注意：
 *
 * 输入的字符串只包含小写字母
 * 两个字符串的长度都在 [1, 10,000] 之间
 * */
public class Leecode567 {

    public boolean checkInclusion(String s1, String s2) {
        int s1Len = s1.length();
        int s2Len =s2.length();
        if(s1Len>s2Len){
            return false;
        }

        int[] s1Diff = new int[26];
        int[] s2Diff = new int[26];
        for(int i=0;i<s1Len;i++){
            s1Diff[s1.charAt(i)-'a']++;
            s2Diff[s2.charAt(i)-'a']++;
        }
        if(isSame(s1Diff,s2Diff)){
            return true;
        }
        int left=0;
        for(int i=s1Len;i<s2Len;i++){
            s2Diff[s2.charAt(i)-'a']++;
            s2Diff[s2.charAt(left)-'a']--;
            left++;
            if(isSame(s1Diff,s2Diff)){
                return true;
            }
        }
        return false;

    }

    private boolean isSame(int[] s1Diff, int[] s2Diff) {
        int len =26;
        for(int i=0;i<len;i++){
        if(s1Diff[i]!=s2Diff[i]){
            return false;
        }
        }
        return true;
    }


    public static void main(String[] args) {
        //"adc"
        //"dcda"
        String s1 = "adc";
        String s2 = "dcda";
        Leecode567 leecode567 = new Leecode567();
        System.out.println(leecode567.checkInclusion(s1,s2));
    }
}
