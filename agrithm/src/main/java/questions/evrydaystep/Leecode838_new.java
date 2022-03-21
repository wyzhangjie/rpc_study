package questions.evrydaystep;/**
 * ClassName Leecode838_new
 * Description
 * Create by jie.zhang02
 * Date 2022/2/21 6:14 下午
 */

/**
 * @author jie.zhang
 * @date 2022年02月21日 6:14 下午
 */
public class Leecode838_new {
    public String pushDominoes(String dominoes) {
        char[] s = dominoes.toCharArray();
        int i=0;
        char left='L';
        int n = dominoes.length();
        while (i<n){
            int j=i;
            while (j<n && dominoes.charAt(j)=='.'){
                j++;
            }

            char right= j<n?dominoes.charAt(j):'R';
            if(left==right){
                while (i<j){
                   s[i]=left;
                   i++;
                }
            }else if(left=='R' && right=='L'){
                int k=j-1;
                while (i<k){
                    s[i++]='R';
                    s[k--]='L';
                }
            }
             left=right;
            i=j+1;

        }
        return new String(s);
    }

    public static void main(String[] args) {
        String dominoes=".L.R...LR..L..";
        Leecode838_new leecode838 = new Leecode838_new();
        System.out.println(leecode838.pushDominoes(dominoes));
    }
}
