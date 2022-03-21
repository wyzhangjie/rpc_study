package questions.evrydaystep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Leecode427 {
    private Node root = new Node();
    class Node{
        Node[] children;
        boolean isEnd;
        public Node(){
            children=new Node[26];
            isEnd=false;
        }
    }
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> result =new ArrayList<>();
        Arrays.sort(words, Comparator.comparingInt(String::length));

        for(String s:words){
            if(s.length()!=0){
                if(deepCheck(s,0)){
                    result.add(s);
                }else {
                    insert(s);
                }
            }

        }
        return result;
    }

    private boolean deepCheck(String s, int i) {
        if(i==s.length()){
            return true;
        }
        Node priot = root;
        while (i<s.length()){
            if(priot.children[s.charAt(i)-'a']==null){
                return false;
            }
            priot= priot.children[s.charAt(i)-'a'];
            if(priot.isEnd && deepCheck(s,i+1)){
                return true;
            }
            i++;
        }
        return false;

    }

    private void insert(String s) {
        Node pirot= this.root;
        for(int i=0;i<s.length();i++){
            if(pirot.children[s.charAt(i)-'a']==null){
                pirot.children[s.charAt(i)-'a']=new Node();
            }
            pirot= pirot.children[s.charAt(i)-'a'];
        }
        pirot.isEnd=true;
    }

    public static void main(String[] args) {
     String[]   words = {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
        Leecode427 leecode427 = new Leecode427();
        System.out.println(leecode427.findAllConcatenatedWordsInADict(words));


    }
}
