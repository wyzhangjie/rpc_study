package questions.evrydaystep;/**
 * ClassName Leecode6
 * Description
 * Create by jie.zhang02
 * Date 2022/3/1 10:01 上午
 */

/**
 * @author jie.zhang
 * @date 2022年03月01日 10:01 上午
 * 1 <= s.length <= 1000
 * s 由英文字母（小写和大写）、',' 和 '.' 组成
 * 1 <= numRows <= 1000
 */
public class Leecode6 {
    public String convert(String s, int numRows) {
        int n=s.length();//总数
        int r=numRows;//行
        if(r==1 ||r>=n){
            return s;
        }
        StringBuffer[] sb= new StringBuffer[r];
        for(int i=0;i<r;i++){
            sb[i]=new StringBuffer();
        }
        for(int x=0,i=0,t=2*r-2;i<n;i++){
            sb[x].append(s.charAt(i));
            if((i%t)<(r-1)){
                x++;
            }else {
                x--;
            }
        }
        StringBuffer result = new StringBuffer();
        for(int i=0;i<sb.length;i++){
            result.append(sb[i]);
        }
        return result.toString();


    }

    public static void main(String[] args) {
        //"tttjkxhkgwrrdgkzozmoxphjkllpizhduapgzwrfu"
        //13
   //  String   s = "tttjkxhkgwrrdgkzozmoxphjkllpizhduapgzwrfu";
   //          int numRows = 13;
        //"igrkbpxztuyfkg"
        //7
        String s="igrkbpxztuyfkg";
                int numRows=7;
        Leecode6 leecode6 = new Leecode6();
        System.out.println(leecode6.convert(s,numRows));
    }
}
