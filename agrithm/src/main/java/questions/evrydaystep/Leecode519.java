package questions.evrydaystep;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Leecode519 {
    public  int m;
    public int n;
    public int size=0;

    public Map<Integer,Integer> map = new HashMap<>();

    public Leecode519(int m, int n) {
        this.m=m;
        this.n=n;
        size= m*n;
    }

    public int[] flip() {
        Random random= new Random();
       int pos= random.nextInt(size--);
        int last = map.getOrDefault(pos,pos);
        map.put(pos,map.getOrDefault(size,size));
        int p= last/n;
        int q= last%n;
       return new int[]{p,q};
    }


    public void reset() {
        map.clear();
        size=m*n;
        return;

    }
}
