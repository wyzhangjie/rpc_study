package questions.evrydaystep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leecode187 {
    static final int L = 10;

    public List<String> findRepeatedDnaSequences(String s) {
        Map<Character, Integer> bin = new HashMap<>();
        List<String> ans = new ArrayList<>();
        bin.put('A', 0);
        bin.put('C', 1);
        bin.put('G', 2);
        bin.put('T', 3);
        if (s.length() <= L) {
            return ans;
        }

        int x = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < L; i++) {
            x = (x << 2) | bin.get(s.charAt(i));
        }
        map.put(x, 1);
        for (int i = L; i < s.length() ; i++) {
            x = ((x << 2) | bin.get(s.charAt(i))) & ((1 << (L * 2)) - 1);
            map.put(x, map.getOrDefault(x, 0) + 1);
            if (map.get(x) == 2) {
                ans.add(s.substring(i - L+1, i+1));
            }
        }
        return ans;


    }


    public static void main(String[] args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        Leecode187 leecode187 = new Leecode187();
        System.out.println(leecode187.findRepeatedDnaSequences(s));
        System.out.println( ((1 << (10 * 2)) - 1));
    }
}
