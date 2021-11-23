package questions.evrydaystep;

/**
 * 859. 亲密字符串
 * 给你两个字符串 s 和 goal ，只要我们可以通过交换 s 中的两个字母得到与 goal 相等的结果，就返回 true ；否则返回 false 。
 * <p>
 * 交换字母的定义是：取两个下标 i 和 j （下标从 0 开始）且满足 i != j ，接着交换 s[i] 和 s[j] 处的字符。
 * <p>
 * 例如，在 "abcd" 中交换下标 0 和下标 2 的元素可以生成 "cbad" 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "ab", goal = "ba"
 * 输出：true
 * 解释：你可以交换 s[0] = 'a' 和 s[1] = 'b' 生成 "ba"，此时 s 和 goal 相等。
 * 示例 2：
 * <p>
 * 输入：s = "ab", goal = "ab"
 * 输出：false
 * 解释：你只能交换 s[0] = 'a' 和 s[1] = 'b' 生成 "ba"，此时 s 和 goal 不相等。
 * 示例 3：
 * <p>
 * 输入：s = "aa", goal = "aa"
 * 输出：true
 * 解释：你可以交换 s[0] = 'a' 和 s[1] = 'a' 生成 "aa"，此时 s 和 goal 相等。
 * 示例 4：
 * <p>
 * 输入：s = "aaaaaaabc", goal = "aaaaaaacb"
 * 输出：true
 */
public class Leecode859 {
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) return false;
        char[] base = new char[26];
        if (s.equals(goal)) {
            for (int i = 0; i < s.length(); i++) {
                int index = s.charAt(i) - 'a';
                base[index]++;
                if (base[index] > 1) {
                    return true;
                }

            }
        } else {
            int first=-1;
            int second=-1;
            int sum=0;
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)!=goal.charAt(i)){
                    sum++;
                    if(first==-1){
                        first=i;
                    }else {
                        second=i;
                    }
                    if(sum>2) break;

                }

            }
            return first!=-1 && second!=-1 && sum==2 && s.charAt(first)==goal.charAt(second) && s.charAt(second)==goal.charAt(first);
        }
        return false;


    }

    public static void main(String[] args) {
      String  s = "ab";
      String goal = "ba";
        Leecode859 leecode859 = new Leecode859();
        System.out.println(leecode859.buddyStrings(s,goal));
    }
}
