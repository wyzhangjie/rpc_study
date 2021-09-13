package questions.evrydaystep;

/**
 * 171. Excel表列序号
 * 给你一个字符串 columnTitle ，表示 Excel 表格中的列名称。返回该列名称对应的列序号。
 *
 *
 *
 * 例如，
 *
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28
 *     ...
 *
 *
 * 示例 1:
 *
 * 输入: columnTitle = "A"
 * 输出: 1
 * 示例 2:
 *
 * 输入: columnTitle = "AB"
 * 输出: 28
 * 示例 3:
 *
 * 输入: columnTitle = "ZY"
 * 输出: 701
 * 示例 4:
 *
 * 输入: columnTitle = "FXSHRXW"
 * 输出: 2147483647
 *
 *
 * 提示：
 *
 * 1 <= columnTitle.length <= 7
 * columnTitle 仅由大写英文组成
 * columnTitle 在范围 ["A", "FXSHRXW"] 内
 *
 * */
public class Leecode171 {
    public int titleToNumber(String columnTitle) {
        int result=0;
        char[] chars = columnTitle.toCharArray();
        int exp=0;
        for(int i=chars.length-1;i>=0;i--){
            int base =chars[i]-'0'-16;
            result+=base*Math.pow(26,exp++);
        }
        return result;

    }

    public static void main(String[] args) {
        System.out.println('A'-'0');
        System.out.println('B'-'0');
        System.out.println('C'-'0');
        System.out.println('Y'-'0');
        System.out.println('Z'-'0');
        Leecode171 leecode171 = new Leecode171();
        System.out.println(leecode171.titleToNumber("AB"));
        System.out.println(leecode171.titleToNumber("ZY"));
    }
}
