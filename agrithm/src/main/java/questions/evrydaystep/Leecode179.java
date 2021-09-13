package questions.evrydaystep;

import org.apache.commons.collections4.EnumerationUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * 179. 最大数
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 * <p>
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [10,2]
 * 输出："210"
 * 示例 2：
 * <p>
 * 输入：nums = [3,30,34,5,9]
 * 输出："9534330"
 * 示例 3：
 * <p>
 * 输入：nums = [1]
 * 输出："1"
 * 示例 4：
 * <p>
 * 输入：nums = [10]
 * 输出："10"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 109
 * 通过次数66,352提交次数169,996
 */
public class Leecode179 {
    public String largestNumber(int[] nums) {
        StringBuffer sb = new StringBuffer();
        Map<String, Integer> hasMap = new HashMap<>();
        Boolean unlock=true;
        while (unlock) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != -1) {
                    int news = String.valueOf(nums[i]).charAt(0) - '0';
                    if (hasMap.get("1") == null || hasMap.get("1") < news) {
                        hasMap.put("1", news);
                        hasMap.put("2", i);

                    } else if (hasMap.get("1") == news && isLarger(nums[i], nums[hasMap.get("2")])) {
                        hasMap.put("1", news);
                        hasMap.put("2", i);
                    }
                }


            }
            if (hasMap.get("1") != null) {
                sb.append(nums[hasMap.get("2")]);
                nums[hasMap.get("2")] = -1;
            }else {
                unlock=false;
            }
            hasMap.clear();
        }
        return sb.toString();

    }

    private boolean isLarger(int news, int old) {
        char[] a = String.valueOf(news).toCharArray();
        char[] b = String.valueOf(old).toCharArray();
        int i = 0;
        int j = 0;
        while (i < a.length && j < b.length) {
            if (a[i] > b[j]) {
                return true;
            }
            i++;
            j++;
        }
        if (i < a.length) {
            if(a[i]>a[i-1]){
                return false;
            }
        return true;
        }

        if (j < b.length) {
            if(b[j]>b[j-1]){
                return true;
            }
            return false;

        }
        return false;

    }

    public static void main(String[] args) {
        /**
         *  输入：nums = [3,30,34,5,9]
         *  * 输出："9534330"
         * */

        int[] nums = new int[]{3, 30, 34, 5, 9};
        Leecode179 leecode179 = new Leecode179();
      /*  System.out.println(leecode179.largestNumber(nums));
        nums = new int[]{10};
        System.out.println(leecode179.largestNumber(nums));
        nums = new int[]{1};
        System.out.println(leecode179.largestNumber(nums));
        nums = new int[]{10,2};
        System.out.println(leecode179.largestNumber(nums));*/

        nums = new int[]{111311, 1113};
        System.out.println(leecode179.largestNumber(nums));
        //[34323,3432]
        nums = new int[]{34323, 3432};
        System.out.println(leecode179.largestNumber(nums));
    }
}
