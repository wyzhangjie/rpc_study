package questions.evrydaystep;/**
 * ClassName Leecode838
 * Description
 * Create by jie.zhang02
 * Date 2022/2/21 10:09 上午
 */

/**
 * @author jie.zhang
 * @date 2022年02月21日 10:09 上午
 */
public class Leecode838 {
    public String pushDominoes(String dominoes) {
        int len =dominoes.length();
        StringBuilder sb = new StringBuilder(dominoes);
        StringBuilder preBuilder = new StringBuilder(dominoes);
        while (true){
            boolean hasMove=false;
            for(int i=0;i<len;i++){
                char current =preBuilder.charAt(i);
                if (current != '.'){
                    continue;
                }
                char pre='.';
                if(i!=0){
                    pre = preBuilder.charAt(i-1);
                }
                char next = '.';
                if(i!=len-1){
                    next = preBuilder.charAt(i+1);
                }
                if(pre!='R' && next=='L'){
                    hasMove=true;
                    sb.setCharAt(i,'L');
                }
                if(pre=='R' && next!='L'){
                    hasMove=true;
                    sb.setCharAt(i,'R');
                }
            }
            //更新下一轮的preDominoes
            preBuilder = new StringBuilder(sb);
            //没有多米诺变化, 结束循环
            if (!hasMove){
                break;
            }
        }
        return sb.toString();

    }

    public static void main(String[] args) {
     //  String dominoes = "RR.L";
        String dominoes=".L.R...LR..L..";
        Leecode838 leecode838 = new Leecode838();
        System.out.println(leecode838.pushDominoes(dominoes));
    }
}
