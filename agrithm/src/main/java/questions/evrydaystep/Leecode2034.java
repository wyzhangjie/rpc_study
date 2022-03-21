package questions.evrydaystep;

import java.util.*;

public class Leecode2034 {
    private TreeMap<Integer, Integer> treeMap;
    private Map<Integer, Integer> map;
    private int maxIndex;

    public Leecode2034() {
        map = new HashMap<>();
        treeMap = new TreeMap<>();
        maxIndex = 0;
    }

    public void update(int timestamp, int price) {
        Integer oldPrice = map.put(timestamp, price);
        if (oldPrice != null) {
            int count = treeMap.getOrDefault(oldPrice, 0);
            if (count <= 1) {
                treeMap.remove(oldPrice);
            }else {
                treeMap.put(oldPrice,count-1);
            }
        }
        treeMap.put(price, treeMap.getOrDefault(price,0)+1);
        if (timestamp > maxIndex) {
            maxIndex = timestamp;
        }
    }

    public int current() {
        return map.get(maxIndex);
    }

    public int maximum() {
        return treeMap.lastKey();
    }

    public int minimum() {
        return treeMap.firstKey();
    }

    public static void main(String[] args) {
        Leecode2034 stockPrice = new Leecode2034();
        stockPrice.update(1,10);
        stockPrice.update(2,5);
        System.out.println(stockPrice.maximum());
        stockPrice.update(2,8);
        System.out.println(stockPrice.minimum());
        stockPrice.update(1,7);
        System.out.println(stockPrice.maximum());
    }
}
