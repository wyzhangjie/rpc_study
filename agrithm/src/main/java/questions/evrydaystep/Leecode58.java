package questions.evrydaystep;
/**
 * 58. 最后一个单词的长度
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中最后一个单词的长度。
 *
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "Hello World"
 * 输出：5
 * 示例 2：
 *
 * 输入：s = "   fly me   to   the moon  "
 * 输出：4
 * 示例 3：
 *
 * 输入：s = "luffy is still joyboy"
 * 输出：6
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 104
 * s 仅有英文字母和空格 ' ' 组成
 * s 中至少存在一个单词
 * */
public class Leecode58 {
    public int lengthOfLastWord(String s) {
        int result=0;
        int total=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' '){
                if(total!=0){
                    result=total;
                }

                total=0;
            }else {
                total++;
            }
        }
        if(total!=0){
            result=total;
        }
        return result;
    }


    public int lengthOfLastWord1(String s) {
        int result=0;
        int time=0;
        int len = s.length();
        for(int i=len-1;i>=0;i--){
            if(s.charAt(i)==' ' ){
                if(time==1){
                    break;
                }
                continue;
            }else {
                time=1;
                result++;
            }

        }
        return result;
    }

    public static void main(String[] args) {
        String s = "   fly me   to   the moon  ";
        Leecode58 leecode58= new Leecode58();
        System.out.println(leecode58.lengthOfLastWord1(s));
    }
}
