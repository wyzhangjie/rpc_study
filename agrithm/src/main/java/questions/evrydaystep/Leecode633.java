package questions.evrydaystep;

/**
 * 633. 平方数之和
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：c = 5
 * 输出：true
 * 解释：1 * 1 + 2 * 2 = 5
 * 示例 2：
 * <p>
 * 输入：c = 3
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：c = 4
 * 输出：true
 * 示例 4：
 * <p>
 * 输入：c = 2
 * 输出：true
 * 示例 5：
 * <p>
 * 输入：c = 1
 * 输出：true
 */
public class Leecode633 {
    public boolean judgeSquareSum(int c) {
        int left = 0;
        int right = (int) Math.sqrt(c);
        while (left <= right) {
            if (left * left + right * right == c) {
                return true;
            }else if(left * left + right * right > c){
                right--;
            }else {
                left++;
            }


        }
        return false;

    }

    public static void main(String[] args) {
        Leecode633 leecode633 = new Leecode633();
        System.out.println(leecode633.judgeSquareSum(4));
    }
}
