package questions.evrydaystep;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * 示例 3:
 *
 * 输入: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
 * 输出：-1
 * 解释：
 * 无法旋转到目标数字且不被锁定。
 * 示例 4:
 *
 * 输入: deadends = ["0000"], target = "8888"
 * 输出：-1
 *  
 *
 * 提示：
 *
 * 1 <= deadends.length <= 500
 * deadends[i].length == 4
 * target.length == 4
 * target 不在 deadends 之中
 * target 和 deadends[i] 仅由若干位数字组成
 * 通过次数47,882提交次数94,398
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/open-the-lock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class Leecode752 {
    public int openLock(String[] deadends, String target) {
        List<List<Map<Integer,Integer>>> newList= new LinkedList<>();
        char[] targets = target.toCharArray();
        for(char a:targets){
            Map<Integer,Integer> a1 = new HashMap<>();
            a1.put(1,Character.getNumericValue(a));
            Map<Integer,Integer> a2 = new HashMap<>();
            a2.put(Character.getNumericValue(a),9);
            List<Map<Integer,Integer>> b1 = new LinkedList<>();
            b1.add(a1);
            b1.add(a2);
            newList.add(b1);
        }
        return  -1;
    }

    public static void main(String[] args) {
        String[] deadends = new String[]{"8887","8889","8878","8898","8788","8988","7888","9888"};
        Leecode752 leecode752 = new Leecode752();

    }
}
