package questions.evrydaystep;/**
 * ClassName Leecode2049
 * Description
 * Create by jie.zhang02
 * Date 2022/3/11 9:59 上午
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author jie.zhang
 * @date 2022年03月11日 9:59 上午
 */
public class Leecode2049 {
    long maxInt = -1;
    int count = 0;
    int len;

    public int countHighestScoreNodes(int[] parents) {
        len = parents.length;
        TreeNode[] tree = new TreeNode[parents.length];
        for (int i = 0; i < parents.length; i++) {
            tree[i] = new TreeNode();
        }
        for (int i = 1; i < parents.length; i++) {
            tree[parents[i]].addChinld(tree[i]);
        }
        dfs(tree[0]);
        return count;
    }

    private int dfs(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        int left = dfs(treeNode.left);
        int right = dfs(treeNode.right);
        int inner = len - left - right - 1 == 0 ? 1 : len - left - right - 1;
        Long score = help(left) * help(right) * inner;
        if (score > maxInt) {
            maxInt = score;
            count = 1;
        } else if (score == maxInt) {
            count++;
        }
        return left + right + 1;
    }

    private long help(int left) {
        if (left == 0) {
            return 1;
        } else {
            return left;
        }
    }


    class TreeNode {
        TreeNode left;
        TreeNode right;


        public void addChinld(TreeNode node) {
            if (left == null) {
                left = node;
            } else {
                right = node;
            }
        }
    }

    public static void main(String[] args) {
        int[] parents = {-1, 2, 0, 2, 0};
        Leecode2049 leecode2049 = new Leecode2049();
        System.out.println(leecode2049.countHighestScoreNodes(parents));
    }
}
