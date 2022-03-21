package questions.evrydaystep;

import java.util.HashSet;
import java.util.Set;

public class Leecode1044 {
    long[] hash;
    long[] p;
    //借助这道题学习三叶姐的字符串hash的方法
    public String longestDupSubstring(String s) {
        //首先计算一个前缀数组
        //Rabin-Karp字符串查找算法 可以这么理解，首先按照位置我们先计算前缀hash和。
        //当要想知道i-j这段的前缀和的时候，要减去之前由于位置而造成的偏差值
        // 所以我们首先维护两个数组 一个维度前缀hash和，还有一个可以调整的数组
        int P = 1313131;
        hash = new long[s.length() + 10];
         p = new long[s.length() + 10];
        p[0] = 1;
        for (int i = 0; i < s.length(); i++) {
            p[i + 1] = p[i] * P;
            hash[i + 1] = hash[i] * P + s.charAt(i);
        }

        //维护完毕两个Rabin-Karp的数组，我们开始用二分法来看那个重复出现过，最大长度
        String result = "";
        int left = 0;
        int right = s.length();
        while (left < right) {
            int mid = left + (right - left) / 2;
            String temp = getCheck(s, mid);
            result = result.length() < temp.length() ? temp : result;
        }
        return result;

    }

    private String getCheck(String s, int len) {
        Set<Long> set = new HashSet<>();
        for (int i = 0; i + len - 1 <= s.length(); i++) {
            int j= i+len-1;
            long cur = hash[j+1]- hash[i-1]*p[j-i+1];
            if (set.contains(cur)){
                return s.substring(i-1,j);
            }else {
                set.add(cur);
            }
        }
        return "";
    }
}
