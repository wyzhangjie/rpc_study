package questions.evrydaystep;
/**
 * 给定两个字符串 a 和 b，寻找重复叠加字符串 a 的最小次数，使得字符串 b 成为叠加后的字符串 a 的子串，如果不存在则返回 -1。
 *
 * 注意：字符串 "abc" 重复叠加 0 次是 ""，重复叠加 1 次是 "abc"，重复叠加 2 次是 "abcabc"。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：a = "abcd", b = "cdabcdab"
 * 输出：3
 * 解释：a 重复叠加三遍后为 "abcdabcdabcd", 此时 b 是其子串。
 * 示例 2：
 *
 * 输入：a = "a", b = "aa"
 * 输出：2
 * 示例 3：
 *
 * 输入：a = "a", b = "a"
 * 输出：1
 * 示例 4：
 *
 * 输入：a = "abc", b = "wxyz"
 * 输出：-1
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/repeated-string-match
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * */
public class Leecode686 {
    public int repeatedStringMatch(String A, String B) {
        int d=B.length()/A.length();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<d;i++){sb.append(A);}
        if(isSubString(B,sb.toString())){return d;}
        if(isSubString(B,sb.append(A).toString())){return d+1;}
        if(isSubString(B,sb.append(A).toString())){return d+2;}
        return -1;
    }
    public boolean isSubString(String s,String t){
        //判断s是否为t的子串
        if(s.length()>t.length()){return false;}
        for(int i=0;i<=t.length()-s.length();i++){if(s.equals(t.substring(i,i+s.length()))){return true;}}
        return false;
    }




    public int repeatedStringMatch3(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int ans = 0;
        while (sb.length() < b.length() && ++ans > 0) sb.append(a);
        sb.append(a);
        int idx = strHash(sb.toString(), b);
        if (idx == -1) return -1;
        return idx + b.length() > a.length() * ans ? ans + 1 : ans;
    }
    int strHash(String ss, String b) {
        int P = 131;
        int n = ss.length(), m = b.length();
        String str = ss + b;
        int len = str.length();
        int[] h = new int[len + 10], p = new int[len + 10];
        p[0] = 1;
        for (int i = 0; i < len; i++) {
            p[i + 1] = p[i] * P;
            h[i + 1] = h[i] * P + str.charAt(i);
        }
        int r = len, l = r - m + 1;
        int target = h[r] - h[l - 1] * p[r - l + 1]; // b 的哈希值
        for (int i = 1; i <= n; i++) {
            int j = i + m - 1;
            int cur = h[j] - h[i - 1] * p[j - i + 1]; // 子串哈希值
            if (cur == target) return i - 1;
        }
        return -1;
    }


    public int repeatedStringMatch2(String a, String b) {
        // 如果b里面有a不存在的字符，直接返回-1
        boolean[] arr = new boolean[26];
        for (int i = 0; i < a.length(); i++) {
            arr[a.charAt(i) - 'a'] = true;
        }
        for (int i = 0; i < b.length(); i++) {
            if (!arr[b.charAt(i) - 'a']) {
                return -1;
            }
        }

        int count = b.length() / a.length();
        String tmp =a;
        for(int i=1;i<count;i++){
            tmp+=a;
        }
        StringBuilder sb = new StringBuilder(tmp);
        if(count==0){
            count=1;
        }
        for (int i = 0; i <= 2; i++) {
            if (sb.indexOf(b) >= 0) {

                return count + i;
            }
            sb.append(a);
        }

        return -1;
    }






    public int repeatedStringMatchKMP(String a, String b) {
        int an = a.length(), bn = b.length();
        int index = strStr(a, b);
        if (index == -1) {
            return -1;
        }
        if (an - index >= bn) {
            return 1;
        }
        return (bn + index - an - 1) / an + 2;
    }

    public int strStr(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        if (m == 0) {
            return 0;
        }
        int[] pi = new int[m];
        for (int i = 1, j = 0; i < m; i++) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }
            pi[i] = j;
        }
        for (int i = 0, j = 0; i - j < n; i++) { // b 开始匹配的位置是否超过第一个叠加的 a
            while (j > 0 && haystack.charAt(i % n) != needle.charAt(j)) { // haystack 是循环叠加的字符串，所以取 i % n
                j = pi[j - 1];
            }
            if (haystack.charAt(i % n) == needle.charAt(j)) {
                j++;
            }
            if (j == m) {
                return i - m + 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        //"abcd"
        //"cdabcdab"
        //"abc"
        //"cabcabca"
        String a="abc";
        String b="cabcabca";
        Leecode686 leecode686= new Leecode686();
        System.out.println(leecode686.repeatedStringMatch2(a,b));
    }

}
