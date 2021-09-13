package questions.evrydaystep;

/**
 * 551. 学生出勤记录 I
 * 给你一个字符串 s 表示一个学生的出勤记录，其中的每个字符用来标记当天的出勤情况（缺勤、迟到、到场）。记录中只含下面三种字符：
 * <p>
 * 'A'：Absent，缺勤
 * 'L'：Late，迟到
 * 'P'：Present，到场
 * 如果学生能够 同时 满足下面两个条件，则可以获得出勤奖励：
 * <p>
 * 按 总出勤 计，学生缺勤（'A'）严格 少于两天。
 * 学生 不会 存在 连续 3 天或 3 天以上的迟到（'L'）记录。
 * 如果学生可以获得出勤奖励，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "PPALLP"
 * 输出：true
 * 解释：学生缺勤次数少于 2 次，且不存在 3 天或以上的连续迟到记录。
 * 示例 2：
 * <p>
 * 输入：s = "PPALLL"
 * 输出：false
 * 解释：学生最后三天连续迟到，所以不满足出勤奖励的条件。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 1000
 * s[i] 为 'A'、'L' 或 'P'
 */
public class Leecode551 {
    public boolean checkRecord(String s) {
        char[] chars = s.toCharArray();
        int absence = 0;
        int late = 0;
        for (char a : chars) {
            if ('A' == a) {
                absence++;
            }
            if ('L' == a) {
                late++;
                if(late>=3){
                    break;
                }
            } else {
                late = 0;
            }
        }
        if (late >= 3 || absence >= 2) {
            return false;
        } else {
            return true;
        }
    }



    public boolean checkRecordChange(String s) {
        char[] chars = s.toCharArray();
        int absence = 0;
        int late = 0;
        for (char a : chars) {
            if ('A' == a) {
                absence++;
                if(absence>=2){
                    return false;
                }
            }
            if ('L' == a) {
                late++;
                if(late>=3){
                   return false;
                }
            } else {
                late = 0;
            }
        }
      return true;
    }
    public static void main(String[] args) {
        String s = "LLLALL";
        Leecode551 leecode551 = new Leecode551();
        System.out.println(leecode551.checkRecordChange(s));
    }
}
