package questions.evrydaystep;

import java.util.ArrayList;
import java.util.List;

public class Leecode524 {
    public String findLongestWord(String s, List<String> dictionary) {
        String result = new String();
        for (String target : dictionary) {
            int j = 0;
            int i = 0;
            while (i < s.length() && j < target.length()) {
                if (s.charAt(i) == target.charAt(j)) {
                    i++;
                    j++;
                } else {
                    i++;
                }
            }
            if (j == target.length()) {
                if (result.length() < target.length() || (result.length() ==target.length() && result.compareTo(target) >= 0)) {
                    result = target;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "abpcplea";
        //String[]{"ale","apple","monkey","plea"};
        List<String> dictionary = new ArrayList<>();
        dictionary.add("ale");
        dictionary.add("apple");
        dictionary.add("monkey");
        dictionary.add("plea");
        Leecode524 leecode524 = new Leecode524();
        System.out.println(leecode524.findLongestWord(s, dictionary));
    }
}
