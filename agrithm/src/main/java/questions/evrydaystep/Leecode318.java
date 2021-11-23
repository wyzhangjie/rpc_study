package questions.evrydaystep;

import java.util.HashMap;
import java.util.Map;

public class Leecode318 {
    public int maxProduct(String[] words) {
        int result = 0;
        int[] temp = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            String a = words[i];
            for (int j = 0; j < a.length(); j++) {
                int u = a.charAt(j) - 'a';
                temp[i] |= (1 << u);
            }
        }
        for (int i = 0; i < temp.length; i++) {
            for (int j = i + 1; j < temp.length; j++) {
                if ((temp[i] & temp[j]) == 0) {
                    result = Math.max(result, words[i].length() * words[j].length());
                }
            }
        }
        return result;

    }
    //结果为导向 词频相同的，就保留最长的长度即可，没有必要每一个长度都保留，
    public int maxProduct1(String[] words) {
      int result =0 ;
      // key是mask ,value 是最长的字符串长度
        Map<Integer,Integer> map = new HashMap<>();
        int len = words.length;
        for(int i=0;i<len;i++){
            String word = words[i];
            int mask=0;
            int wordLen = word.length();
            for(int j=0;j<wordLen;j++){
                int c = word.charAt(j)-'a';
                mask|=( 1<< c);
            }
            if(wordLen>map.getOrDefault(mask,0)){
                map.put(mask,wordLen);
            }
        }

        for(int a:map.keySet()){
            for(int b:map.keySet()){
                if((a &b) ==0){
                    result = Math.max(result, map.get(a) * map.get(b));
                }
            }
        }
        return result;

    }


    public static void main(String[] args) {
        String[] a=  {"abcw","baz","foo","bar","xtfn","abcdef"};
        Leecode318 leecode318 = new Leecode318();
        System.out.println(leecode318.maxProduct(a));
        System.out.println(leecode318.maxProduct1(a));
    }
}
