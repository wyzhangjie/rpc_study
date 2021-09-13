package questions.evrydaystep;
/**
 * 168. Excel表列名称
 * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
 *
 * 例如，
 *
 *     1 -> A
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB
 *     ...
 * 示例 1:
 *
 * 输入: 1
 * 输出: "A"
 * 示例 2:
 *
 * 输入: 28
 * 输出: "AB"
 * 示例 3:
 *
 * 输入: 701
 * 输出: "ZY"
 * */
public class Leecode168 {
    public String convertToTitle(int columnNumber) {

        StringBuffer sb = new StringBuffer();
        while (columnNumber!=0){
            columnNumber--;
            sb.append((char)(columnNumber%26+'A'));
            columnNumber= columnNumber/26;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Leecode168 leecode168 = new Leecode168();
        System.out.println(leecode168.convertToTitle(28));
    }
}
