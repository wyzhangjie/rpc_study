package questions.evrydaystep;

public class Leecode495 {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int result=0;
        long step=0;
        for(int timeSery:timeSeries){
            if(step==0){
                step+=timeSery+duration;
                result+=duration;
            }else {
                if(step<timeSery){
                    result+=duration;
                    step=timeSery+duration;
                }else {
                    long overlap = (timeSery+duration)-step<0?0:(timeSery+duration)-step;
                    step+=overlap;
                    result+=overlap;
                }

            }

        }
        return  result;
    }

    public static void main(String[] args) {
       int[] timeSeries = new int[]{1,2};
       int duration = 2;
        Leecode495 leecode495 = new Leecode495();
        System.out.println(leecode495.findPoisonedDuration(timeSeries,duration));
    }
}
