package questions.evrydaystep;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class Leecode2034_2 {
    private Map<Integer, Price> map;
    private int maxIndex;

    private PriorityQueue<Price> maxPriority;

    private PriorityQueue<Price> minPriority;


    public Leecode2034_2() {
        map = new HashMap<>();
        maxIndex = 0;
        maxPriority= new PriorityQueue<>((a,b)->b.price-a.price);
        minPriority = new PriorityQueue<>();
    }

    public void update(int timestamp, int price) {
        Price a = new Price(price);
        Price oldPrice=  map.put(timestamp,a);
        oldPrice.error=true;
        maxPriority.offer(a);
        minPriority.offer(a);
        if(timestamp>maxIndex){
            maxIndex=timestamp;
        }

    }

    public int current() {
        return map.get(maxIndex).price;
    }

    public int maximum() {
        while (maxPriority.peek().error){
            maxPriority.poll();
        }
        return maxPriority.peek().price;
    }

    public int minimum() {
        while (minPriority.peek().error){
            minPriority.poll();
        }
        return minPriority.peek().price;
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
    private static class Price {
        boolean error;
        int price;

        Price(int price) {
            this.price = price;
            this.error = false;
        }
    }

}


