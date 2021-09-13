package questions.evrydaystep;

public class Leecode345 {
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int left=0;
        int right =chars.length-1;

        while (left<right){
            while (!isYuanyin(chars[left]) && left<right){
                left++;
            }
            while (!isYuanyin(chars[right]) && left<right){
               right--;
            }
                char temp = chars[left];
                chars[left]=chars[right];
                chars[right]=temp;
                left++;
                right--;
        }

        return new String(chars);
    }

    public boolean isYuanyin(char s){
        return s=='a' || s=='e' || s=='i' || s=='o' || s=='u' || s=='A' || s=='E' || s=='I' || s=='O' || s=='U';
    }

    public static void main(String[] args) {
        //输入："leetcode"
        //输出："leotcede
        String s= ".,";
        Leecode345 leecode345 = new Leecode345();
        System.out.println(leecode345.reverseVowels(s));
    }
}
