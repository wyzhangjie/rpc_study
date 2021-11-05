package questions.evrydaystep;

public class Leecode453 {
    public int minMoves(int[] nums) {
        int min=Integer.MAX_VALUE;
        for(int a:nums){
            if(a<min){
                min=a;
            }
        }
        int result=0;
        for(int t:nums){
            result+=(t-min);
        }
        return result;
    }

    public static void main(String[] args) {
    int[]    nums = new int[] {1,1,1};
        Leecode453 leecode453 =new Leecode453();
        System.out.println(leecode453.minMoves(nums));
    }
}
