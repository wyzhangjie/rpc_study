package questions.evrydaystep.swardoffer;

import questions.evrydaystep.Leecode897;

/**
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 *  
 *
 * 示例 1：
 *
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 * 示例 2：
 *
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 *  
 *
 * 限制：
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class Leecode28 {
    public boolean isSymmetric(TreeNode root) {
    return root==null?true:isSymmetricDeep(root.left,root.right);
    }

    private boolean isSymmetricDeep(TreeNode left, TreeNode right) {
        if((left==null && right!=null) || (right==null && left!=null) || left.val!=right.val) {
            return false;
        }else if(left==null && right==null) {
            return true;
        }
       return isSymmetricDeep(left.left,right.right) && isSymmetricDeep(left.right,right.left);
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
