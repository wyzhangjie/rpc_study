package questions.evrydaystep;

public class Leecode1109 {

    public int[] corpFlightBookings(int[][] bookings, int n) {
    int[] result = new int[n];
    //1、序号从1-n 而我们的下角标是从0-n-1，所以要时刻记住自己的位置。
    //2、如果有一个从a->b的航班，航班人数是k，那么我们只要在a-1的位置加上这个k人数，在b的位置
    //减去这个人数，当前的数组含义是这个k人所在的a->b都应该加上这个k，很容易会选择前缀和方法。
    //又因为我们已经把这个k在b位置减去了，所以这个k不会再累加到b之后的位置上去了。
    for(int i=0;i<bookings.length;i++){
        result[bookings[i][0]-1]+=bookings[i][2];
        if(bookings[i][1]<n){
            result[bookings[i][1]]-=bookings[i][2];
        }

    }
    for(int j=1;j<n;j++){
        result[j]+=result[j-1];
    }
    return  result;
    }

    public static void main(String[] args) {
      int[][]  bookings = new int[][]{{1,2,10},{2,3,20},{2,5,25}};
      int n = 5;
        Leecode1109 leecode1109 = new Leecode1109();
        int[] result = leecode1109.corpFlightBookings(bookings,n);
        for(int a:result){
            System.out.println(a);
        }

    }
}
