package questions.evrydaystep;

import java.util.*;

public class Leecode1024 {
    public List<List<String>> groupAnagrams(String[] strs) {
            Map<String,List<String>> result = new HashMap<>();
            for(String str:strs){
                char[] chars = str.toCharArray();
                Arrays.sort(chars);
                String key = new String(chars);
                List<String> values= result.getOrDefault(key,new LinkedList<>());
                values.add(str);
                result.put(key,values);

            }
            return new LinkedList<>(result.values());
    }


    public List<List<String>> groupAnagrams1(String[] strs) {
        Map<String,List<String>> result = new HashMap<>();
        for(String str:strs){
            Integer temp = getNumber(str);
            String key = temp.toString();
            List<String> values= result.getOrDefault(key,new LinkedList<>());
            values.add(str);
            result.put(key,values);

        }
        return new LinkedList<>(result.values());
    }

    public Integer getNumber(String str){
        char[] chars = str.toCharArray();
        int result = 0;
        for(int i=0;i<chars.length;i++){
            int temp =chars[i]-'a';
            result+=temp;
        }
        return result;
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        Leecode1024 leecode1024 = new Leecode1024();
        System.out.println(leecode1024.groupAnagrams(strs));
        System.out.println(leecode1024.groupAnagrams1(strs));
        System.out.println(leecode1024.getNumber("duh"));
        System.out.println(leecode1024.getNumber("ill"));
    }
}
