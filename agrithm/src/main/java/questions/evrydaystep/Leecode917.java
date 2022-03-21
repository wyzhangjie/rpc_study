package questions.evrydaystep;/**
 * ClassName Leecode917
 * Description
 * Create by jie.zhang02
 * Date 2022/2/23 10:24 上午
 */

/**
 * @author jie.zhang
 * @date 2022年02月23日 10:24 上午
 */
public class Leecode917 {
    public String reverseOnlyLetters(String s) {
        char[] schars= s.toCharArray();
        int left=0;
        int right = s.length()-1;
        while (left<right){
            while (left<s.length() && !Character.isLetter(schars[left])){
                left++;
            }
            while (right>=0 && !Character.isLetter(schars[right])){
                right--;

            }
            if(left<right){
                swapt(schars,left,right);
            }
            left++;
            right--;
        }
        return new String(schars);
    }

    private void swapt(char[] schars, int left, int right) {
     char a = schars[left];
     schars[left]=schars[right];
     schars[right]=a;

    }

    public static void main(String[] args) {
        Leecode917 leecode917 = new Leecode917();
        String s = "ab-cd";
        System.out.println(leecode917.reverseOnlyLetters(s));
    }
}
