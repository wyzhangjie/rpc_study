package questions;

public class Leecode1518 {

    public int numWaterBottles(int numBottles, int numExchange) {

        int result = numBottles;
        while (numBottles>=numExchange){
            int inc = numBottles/numExchange;
            int left = numBottles%numExchange;
            result+=inc;
            numBottles = left+inc;

        }
    return  result;
    }

    public static void main(String[] args) {
      int  numBottles = 9;
              int numExchange = 3;
        Leecode1518 leecode1518 = new Leecode1518();
        System.out.println(leecode1518.numWaterBottles(numBottles,numExchange));
    }

}
