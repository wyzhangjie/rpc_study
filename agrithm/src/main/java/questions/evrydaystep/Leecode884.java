package questions.evrydaystep;

import org.apache.commons.lang3.ArrayUtils;

import java.util.*;

/**
 * ClassName Leecode884
 * Description
 * Create by jie.zhang02
 * Date 2022/1/30 10:17 上午
 */
public class Leecode884 {
    public String[] uncommonFromSentences(String s1, String s2) {
        HashMap<String,Integer> map= new HashMap<>();
        String[] ss1=s1.split(" ");
        String[] ss2 = s2.split(" ");
        for(String a:ss1){
           map.put(a,map.getOrDefault(a,0)+1);
         }
        for(String a:ss2){
            map.put(a,map.getOrDefault(a,0)+1);
        }
        List<String> list = new ArrayList<>();
        map.forEach((a,b)->{
           if(b==1){
               list.add(a);
           }
        });
        String[] strs2 = new String[list.size()];
        for(int i=0;i<list.size();i++){
            strs2[i]=list.get(i);
        }
        return strs2;

    }

    public static void main(String[] args) {
      String  s1 = "this apple is sweet", s2 = "this apple is sour";
        Leecode884 leecode884 = new Leecode884();
        String[]  s=leecode884.uncommonFromSentences(s1,s2);
        for(String a:s){
            System.out.println(a);
        }
    }
}
