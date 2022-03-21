package questions.evrydaystep.swardoffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leecode438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        int pLen = p.length();
        int sLen = s.length();
        if (sLen < pLen) {
            return result;
        }
        int[] count = new int[26];
        int[] tcount = new int[26];

        for (int i = 0; i < pLen; i++) {
            count[p.charAt(i) - 'a']++;
            tcount[s.charAt(i) - 'a']++;

        }

        if (check(tcount, count)) {
            result.add(0);
        }
        for (int i = pLen; i < sLen; i++) {
            tcount[s.charAt(i - pLen) - 'a']--;
            tcount[s.charAt(i) - 'a']++;
            if (check(tcount, count)) {
                result.add(i - pLen+1);
            }
        }
        return result;


    }

    private boolean check(int[] tcount, int[] count) {
        for (int i = 0; i < tcount.length; i++) {
            if (tcount[i] != count[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        //"baa"
        //"aa"
        String s = "baa";
        String p = "aa";
        Leecode438 leecode438 = new Leecode438();
        List<Integer> result = leecode438.findAnagrams(s, p);
        for (Integer a : result) {
            System.out.println(a);
        }
    }
}
