package questions;

import java.util.*;

public class Leecode38 {
    public String countAndSay(int n) {
        LinkedList<Integer> mid = new LinkedList<>();
        LinkedList<Integer> sb = new LinkedList<>();
        if(n==1){
            return "1";
        }
        int i = 2;
        sb.add(1);
        sb.add(1);
        while (i < n) {
          for(Integer aa:sb){
              if(mid.size()==0){
                  mid.add(1);
                  mid.add(aa);
              }else {
                  if(mid.get(mid.size()-1)==aa){
                    Integer elemInfo=  mid.get(mid.size()-2);
                    Integer elemPos =mid.size()-2;
                      mid.set(elemPos,elemInfo+1);
                  }else {
                      mid.add(1);
                      mid.add(aa);
                  }
              }

          }
          sb.clear();
          sb.addAll(mid);
          mid.clear();
            i++;
        }
        StringBuffer result = new StringBuffer();
        for(Integer aa:sb){
            result.append(aa);
        }

        return result.toString();

    }

    public static void main(String[] args) {
        //1.     1
        //2.     11
        //3.     21
        //4.     1211
        //5.     111221
        Leecode38 leecode38 = new Leecode38();
        System.out.println(leecode38.countAndSay(6));
    }
}
