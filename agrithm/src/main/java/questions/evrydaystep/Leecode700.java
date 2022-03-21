package questions.evrydaystep;

public class Leecode700 {
    TreeNode result;
    public TreeNode searchBST(TreeNode root, int val) {
        dpBST(root,val);
        return  result;

    }

    private void dpBST(TreeNode root, int val) {
        if(root==null) return;
        if(root.val==val){
            result=root;
            return;
        }
        dpBST(root.left,val);
        dpBST(root.right,val);

    }

    public TreeNode searchBST1(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (val == root.val) {
            return root;
        }
        return searchBST1(val < root.val ? root.left : root.right, val);
    }

    public static void main(String[] args) {
        Leecode700 leecode700= new Leecode700();
        TreeNode treeNode= new TreeNode(1);
        TreeNode node1= new TreeNode(2);
        TreeNode node2= new TreeNode(3);
        treeNode.left=node1;
        treeNode.right=node2;
        leecode700.searchBST1(treeNode,3);
    }
}
