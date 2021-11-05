package questions.evrydaystep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leecode500 {
    public String[] findWords(String[] words) {

        String rowIdx = "12210111011122000010020202";
        List<String> result = new ArrayList<>();

        for (String word : words) {
            boolean flag = true;
            int baseIndex = rowIdx.charAt(Character.toLowerCase(word.charAt(0)) - 'a');
            for (int i = 1; i < word.length(); i++) {
                int tempIndex = rowIdx.charAt(Character.toLowerCase(word.charAt(i)) - 'a');
                if (baseIndex != tempIndex) {
                    flag = false;
                }
            }
            if (flag) {
                result.add(word);
            }


        }
        return result.toArray(new String[result.size()]);

    }

    public static void main(String[] args) {
        String[] a = new String[]{"adsdf"};
        Leecode500 leecode500 = new Leecode500();
        System.out.println(leecode500.findWords(a));
    }
}
