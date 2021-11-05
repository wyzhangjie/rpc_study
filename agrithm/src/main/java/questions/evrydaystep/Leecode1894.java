package questions.evrydaystep;

public class Leecode1894 {

    public int chalkReplacer(int[] chalk, int k) {
        long sum=0;
        for(int c:chalk){
            sum+=c;
        }
        int yushu =0;
        if(k<sum){
            yushu =k;
        }else {
            yushu =(int)(k-sum*(k/sum));
        }

        for(int i=0;i<chalk.length;i++){
            yushu=yushu-chalk[i];
            if(yushu>=0){
              continue;
            }else {
                return i;
            }
        }
        return -1;

    }


    public int chalkReplacer1(int[] chalk, int k) {
        int len = chalk.length;
       int[] preSum=new int[len];

       preSum[0]=chalk[0];
       for(int i=1;i<len;i++){
           preSum[i]=chalk[i]+preSum[i-1];
       }
        int yushu =0;
        if(k<=preSum[len-1]){
            yushu =k;
        }else {
            yushu =(int)(k-preSum[len-1]*(k/preSum[len-1]));
        }

      return binSearch(yushu,0,len-1,preSum);
    }

    private int binSearch(int yushu, int begin, int end, int[] preSum) {
        while (begin<end){

            int mid=begin+(end-begin)/2;
            //找到左面第一个大于yushu的那个位置
            if(preSum[mid]>yushu){
                end=mid;
            }else {
                begin=mid+1;
            }
        }
        return begin;
    }

    public static void main(String[] args) {

        int[] chalk = new int[]{1,2,3};
       int k = 539095482;
        Leecode1894 leecode1894 = new Leecode1894();
        System.out.println(leecode1894.chalkReplacer(chalk,k));
        System.out.println(leecode1894.chalkReplacer1(chalk,k));
    }
}
