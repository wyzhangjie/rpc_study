package questions.evrydaystep;/**
 * ClassName Leecode653
 * Description
 * Create by jie.zhang02
 * Date 2022/3/21 10:26 上午
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author jie.zhang
 * @date 2022年03月21日 10:26 上午
 */
public class Leecode653 {
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> map = new HashSet<>();
        boolean result = deep(root, map, k);

        return result;
    }

    private boolean deep(TreeNode root, Set<Integer> map, int k) {
        if (root == null) {
            return false;
        }
        if (map.contains(k - root.val)) {
            return true;
        }
        map.add(root.val);
        return deep(root.left, map, k) || deep(root.right, map, k);
    }
}
