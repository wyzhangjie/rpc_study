package questions.evrydaystep;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * 783. 二叉搜索树节点最小距离
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 *
 * 注意：本题与 530：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/ 相同
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [4,2,6,1,3]
 * 输出：1
 * 示例 2：
 *
 *
 * 输入：root = [1,0,48,null,null,12,49]
 * 输出：1
 *
 *
 * 提示：
 *
 * 树中节点数目在范围 [2, 100] 内
 * 0 <= Node.val <= 105
 * */
public class Leecode783 {
    public int minDiffInBST(TreeNode root) {
        int smallest=200;
        List<TreeNode> levelBST = new LinkedList<>();
        List<Integer> vals= new ArrayList<>();
        vals.add(root.val);
        levelBST.add(root);
        while (levelBST.size()>0){
            TreeNode cur = levelBST.remove(0);
            if(cur.left!=null){
                vals.add(cur.left.val);
                levelBST.add(cur.left);
            }
            if(cur.right!=null){
                vals.add(cur.right.val);
                levelBST.add(cur.right);
            }

        }
        vals.sort(Comparator.comparingInt(o -> o));
        while (vals.size()>1){
            Integer cur = vals.remove(0);
            if(Math.abs(cur-vals.get(0))<smallest){
                smallest = Math.abs(cur-vals.get(0));
            }
        }
        return smallest;

    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int t) {
            this.val = t;
        }
    }

}
