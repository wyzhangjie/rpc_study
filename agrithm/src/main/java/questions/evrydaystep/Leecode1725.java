package questions.evrydaystep;/**
 * ClassName Leecode1725
 * Description
 * Create by jie.zhang02
 * Date 2022/2/4 7:34 上午
 */

/**
 * @author jie.zhang
 * @date 2022年02月04日 7:34 上午
 */
public class Leecode1725 {
    public int countGoodRectangles(int[][] rectangles) {
        int[] t = new int[rectangles.length];
        for (int i = 0; i < rectangles.length; i++) {
            t[i] = Math.min(rectangles[i][0], rectangles[i][1]);
        }
        int max = -1;
        for (int aa : t) {
            max = Math.max(max, aa);
        }
        int ans=0;
        for (int aa : t) {
            if(aa==max){
                ans++;
            }
        }
        return ans;


    }
    public int countGoodRectangles1(int[][] rectangles) {
       int ans=0;
       int maxLen=0;
       for(int[] a:rectangles){

           int min=Math.min(a[0],a[1]);
           if(min==maxLen){
               ans++;
           }else if(min>maxLen){
               maxLen=min;
               ans=1;

           }
       }
        return ans;


    }

    public static void main(String[] args) {
        int[][] rectangles = {{5,8},{3,9},{5,12},{16,5}};
        Leecode1725 leecode1725 =new Leecode1725();
        System.out.println(leecode1725.countGoodRectangles(rectangles));
        System.out.println(leecode1725.countGoodRectangles1(rectangles));
    }
}
