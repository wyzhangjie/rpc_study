package questions.evrydaystep;


import java.util.Stack;

/**
 * 剑指 Offer 27. 二叉树的镜像
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 *
 * 例如输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 镜像输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 *
 *
 * 示例 1：
 *
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 *
 * */
public class Sword27 {
    public TreeNode mirrorTree(TreeNode root) {
    Stack<TreeNode> treeNodeStack = new Stack<>();
    treeNodeStack.push(root);
    while (!treeNodeStack.isEmpty()){
        TreeNode popRoot = treeNodeStack.pop();
        if(popRoot.left!=null){
            treeNodeStack.push(popRoot.left);
        }
        if(popRoot.right!=null){
            treeNodeStack.push(popRoot.right);
        }
        TreeNode temp = popRoot.left;
        popRoot.left=popRoot.right;
        popRoot.right= temp;

    }
    return root;
    }
}
