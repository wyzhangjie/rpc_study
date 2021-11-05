package questions.evrydaystep;

import javax.sound.sampled.Line;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Leecode1436 {
    public String destCity(List<List<String>> paths) {
        List<String> right=new ArrayList<>();
        for(List<String> aa:paths){
            right.add(aa.get(1));
        }
        for(List<String> aa:paths){
            if(right.contains(aa.get(0))){
                right.remove(aa.get(0));
            }

        }
        return right.get(0);
    }



    public static void main(String[] args) {
        //paths = [["A","Z"]]
        List<String> one = new LinkedList<>();
        one.add("A");
        one.add("Z");
        List<List<String>> two = new LinkedList<>();
        two.add(one);
        Leecode1436 leecode1436 = new Leecode1436();
        System.out.println(leecode1436.destCity(two));
    }
}
