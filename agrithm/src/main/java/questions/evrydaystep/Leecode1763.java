package questions.evrydaystep;/**
 * ClassName Leecode1763
 * Description
 * Create by jie.zhang02
 * Date 2022/2/2 7:36 上午
 */

/**
 * @author jie.zhang
 * @date 2022年02月02日 7:36 上午
 */
public class Leecode1763 {
    public String longestNiceSubstring(String s) {
        int maxPos=0;
        int maxLen=0;
        for(int i=0;i<s.length();i++){
            int low=0;
            int high=0;
            for(int j=i;j<s.length();j++){

                if(Character.isLowerCase(s.charAt(j))){
                    low |= 1<< (s.charAt(j)-'a');
                }else {
                    high |= 1<< (s.charAt(j)-'A');
                }
                if(low==high && (j-i+1)>maxLen){
                    maxLen=j-i+1;
                    maxPos=i;
                }
            }
        }
        return s.substring(maxPos,maxPos+maxLen);
    }

    public static void main(String[] args) {
        String s = "aAa";
        Leecode1763 leecode1763 = new Leecode1763();
        System.out.println(leecode1763.longestNiceSubstring(s));
    }
}
