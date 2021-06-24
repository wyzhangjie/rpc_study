package questions.evrydaystep;


/**
 * 给你一棵二叉搜索树，请你 按中序遍历 将其重新排列为一棵递增顺序搜索树，使树中最左边的节点成为树的根节点，并且每个节点没有左子节点，只有一个右子节点。
 */

public class Leecode897 {
    TreeNode rightTreeRoot;
    TreeNode cursor;
    public TreeNode increasingBST(TreeNode root) {

        transMidTraval(root);
        return rightTreeRoot;

    }

    private void transMidTraval(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            transMidTraval(root.left);
        }
        if (rightTreeRoot == null) {
            rightTreeRoot = new TreeNode(root.val);
            cursor = rightTreeRoot;
        } else {
            TreeNode cur = new TreeNode(root.val);
            cursor.right = cur;
            cursor = cur;
        }
        if (root.right != null) {
            transMidTraval(root.right);
        }

    }

    public static void main(String[] args) {
        TreeNode list1 = new TreeNode(3);
        TreeNode list2 = new TreeNode(9);
        TreeNode list3 = new TreeNode(20);
        TreeNode list4 = new TreeNode(15);
        TreeNode list5 = new TreeNode(7);
        TreeNode list6 = new TreeNode(7);
        list1.left = list2;
        list1.right = list3;
        list3.left = list4;
        list3.right = list5;
        Leecode897 leecode897 = new Leecode897();
        System.out.println(leecode897.increasingBST(list1));
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
