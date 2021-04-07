package questions.evrydaystep;

public class Leecode1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int len2= text2.toCharArray().length+1;
        int len1 = text1.toCharArray().length+1;
        if(len1<2 || len2<2){
            return 0;
        }
        int[][] p1 = new int[len1][len2];
        //边界
        for(int i=0;i<len1;i++){
            p1[i][0]=0;
        }
        for(int j=0;j<len2;j++){
            p1[0][j]=0;
        }
        for(int i=1;i<len1;i++){
            for(int j=1;j<len2;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    p1[i][j]=p1[i-1][j-1]+1;
                }else {
                    p1[i][j] = Math.max(p1[i-1][j],p1[i][j-1]);
                }
            }
        }
        return p1[len1-1][len2-1];
    }

    public static void main(String[] args) {
       String text1 = "abcde";
       String text2 = "ace";
        Leecode1143 leecode1143 = new Leecode1143();
        System.out.println(leecode1143.longestCommonSubsequence(text1,text2));
    }
}
