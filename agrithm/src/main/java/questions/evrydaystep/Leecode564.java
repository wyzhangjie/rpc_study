package questions.evrydaystep;/**
 * ClassName Leecode564
 * Description
 * Create by jie.zhang02
 * Date 2022/3/2 2:20 下午
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author jie.zhang
 * @date 2022年03月02日 2:20 下午
 */
public class Leecode564 {
    public String nearestPalindromic(String n) {
        long longN = Long.parseLong(n);
        List<Long> candidates;
        candidates = getCandidate(n);
        long min=-1;
        for(Long t:candidates){
            if(t != longN){
                /**
                 * 不等于本身，则本身不是回文数！
                 * 则从五个答案中选择 与原数 绝对值差最小的！
                 * 如果遇见绝对值差一样的则判断是否两个数的大小，选择较小的！
                 */
                if(min == -1 || Math.abs(t - longN) < Math.abs(min - longN) || (Math.abs(t - longN) == Math.abs(min - longN) && t < min)){
                    min = t;
                }
            }
        }
        return String.valueOf(min);
    }

    private List<Long> getCandidate(String n) {
        List<Long> candidates = new ArrayList<>();
        int len = n.length();
        candidates.add((long)Math.pow(10,len)+1);
        candidates.add((long) Math.pow(10,len-1)-1);
        long selfPrex=Long.parseLong(n.substring(0,(len+1)/2));
        for(long i=selfPrex-1;i<=selfPrex+1;i++){
            StringBuffer sb = new StringBuffer();
            sb.append(i);
            StringBuilder suffix = new StringBuilder(sb).reverse();
            sb.append(suffix.substring(len & 1));
            candidates.add(Long.parseLong(sb.toString()));
        }
        return candidates;

    }

    public static void main(String[] args) {
        String n="123";
        Leecode564 leecode564 = new Leecode564();
        System.out.println(leecode564.nearestPalindromic(n));
    }
}
