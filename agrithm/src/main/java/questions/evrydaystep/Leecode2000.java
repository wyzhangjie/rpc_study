package questions.evrydaystep;/**
 * ClassName Leecode2000
 * Description
 * Create by jie.zhang02
 * Date 2022/2/2 7:57 上午
 */

/**
 * @author jie.zhang
 * @date 2022年02月02日 7:57 上午
 */
public class Leecode2000 {
    public String reversePrefix(String word, char ch) {
        int pos = word.indexOf(ch);
        char[] chars = word.toCharArray();
        int left=0;
        int right=pos;
        while (left<right){
            char temp=chars[left];
            chars[left]=chars[right];
            chars[right]=temp;
            left++;
            right--;

        }
        word = new String(chars);
        return word;
    }

    public static void main(String[] args) {
      String  word = "abcdefd";
      char        ch = 'd';
        Leecode2000 leecode2000 = new Leecode2000();
        System.out.println(leecode2000.reversePrefix(word,ch));
    }
}
