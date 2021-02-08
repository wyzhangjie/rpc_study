package questions.evrydaystep;


/**
 * 给你两个长度相同的字符串，s 和 t。
 *
 * 将 s 中的第 i 个字符变到 t 中的第 i 个字符需要 |s[i] - t[i]| 的开销（开销可能为 0），也就是两个字符的 ASCII 码值的差的绝对值。
 *
 * 用于变更字符串的最大预算是 maxCost。在转化字符串时，总开销应当小于等于该预算，这也意味着字符串的转化可能是不完全的。
 *
 * 如果你可以将 s 的子字符串转化为它在 t 中对应的子字符串，则返回可以转化的最大长度。
 *
 * 如果 s 中没有子字符串可以转化成 t 中对应的子字符串，则返回 0。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "abcd", t = "bcdf", cost = 3
 * 输出：3
 * 解释：s 中的 "abc" 可以变为 "bcd"。开销为 3，所以最大长度为 3。
 * 示例 2：
 *
 * 输入：s = "abcd", t = "cdef", cost = 3
 * 输出：1
 * 解释：s 中的任一字符要想变成 t 中对应的字符，其开销都是 2。因此，最大长度为 1。
 * 示例 3：
 *
 * 输入：s = "abcd", t = "acde", cost = 0
 * 输出：1
 * 解释：你无法作出任何改动，所以最大长度为 1。
 *  
 *
 * 提示：
 *
 * 1 <= s.length, t.length <= 10^5
 * 0 <= maxCost <= 10^6
 * s 和 t 都只含小写英文字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/get-equal-substrings-within-budget
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * */
public class Leecode1208 {
    //双指针解法
    public int equalSubstring(String s, String t, int maxCost) {
        //第一步获取每一个位置的相对差值
        int len = s.toCharArray().length;
        int[] charDiff = new int[len];
        for(int i=0;i<len;i++){
            int diff = s.charAt(i) - t.charAt(i);
            charDiff[i] = diff <0?t.charAt(i)-s.charAt(i): diff;
        }
        //第二步，引入双指针，原则上在差异和尽可能小于maxCost 的基础上left 和right距离就是结果
        int max = 0;
        int left=0;
        int right =0;
        int sum = 0;
        while(right<len){

            sum+=charDiff[right];

            if(sum<=maxCost){

                max = Math.max(max,right-left+1);
            }else {
                sum-=charDiff[left];
                left++;
            }
            right++;
        }
        return max;

    }

    //前缀和+二分查找
    public int equalSubstringForSubSum(String s, String t, int maxCost) {
      //首先获取前缀和
        int len = s.toCharArray().length;
        int[] preSum = new int[len];
        for(int i=0;i<len;i++){
            if(i==0){
                int diff = s.charAt(i) - t.charAt(i);
                preSum[i] = diff <0?t.charAt(i)-s.charAt(i): diff;
            }else {
                int diff = s.charAt(i) - t.charAt(i);
                preSum[i] =preSum[i-1]+( diff <0?t.charAt(i)-s.charAt(i): diff);
            }
        }
        //第二步：二分法获取 每一个位置的最长差
        int maxLen = 0;
        for(int i=1;i<len;i++){
            //获取每一个i能够往前找到最远的start
         int start = binarySearch(preSum,i,preSum[i]-maxCost);
         maxLen =Math.max(maxLen,i-start+1);
        }
        return maxLen;

    }

    private int binarySearch(int[] preSum, int endIndex, int target) {
        int low=0,hight=endIndex;
        while(low<hight){
            int mid=(hight-low)/2+low;
            if(preSum[mid]<target){
                low =mid+1;
            }else {
                hight=mid;
            }
        }
        return low;
    }


    public static void main(String[] args) {
       String s = "abcd";
       String t = "bcdf";
       int cost = 3;
        Leecode1208 leecode1208 = new Leecode1208();
        System.out.println(leecode1208.equalSubstringForSubSum(s,t ,cost));
    }
}
