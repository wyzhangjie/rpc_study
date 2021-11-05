package questions.evrydaystep;

public class Leecode437 {
    int sum = 0;
    int tempSum=0;

    public int pathSum(TreeNode root, int targetSum) {
        if(root==null){
            return 0;
        }
        deepSum(root,targetSum);
        pathSum(root.left,targetSum);
        pathSum(root.right,targetSum);
        return sum;
    }

    private void deepSum(TreeNode root, int targetSum) {
        if(root==null) return;
        targetSum=targetSum-root.val;
        if(targetSum==0){
            sum++;
        }
        deepSum(root.left,targetSum);
        deepSum(root.right,targetSum);
    }

    private void deepPathSum(TreeNode root, int targetSum) {
        if (targetSum == tempSum) {
            sum++;
        }
        System.out.println("结束；"+tempSum);
        if (root == null) return;

        if (root.left != null) {
            tempSum=tempSum+ root.val;
            deepPathSum(root.left, targetSum);
            tempSum=tempSum-root.val;
        }
        if (root.right != null) {
            tempSum=tempSum+ root.val;
            deepPathSum(root.right , targetSum);
            tempSum=tempSum-root.val;
        }




    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode t1 = new TreeNode(5);
        TreeNode t2 = new TreeNode(-3);
        root.left = t1;
        root.right = t2;
        TreeNode t11 = new TreeNode(3);
        TreeNode t12 = new TreeNode(2);
        t1.left = t11;
        t1.right = t12;
        TreeNode t21 = new TreeNode(11);
        t2.right = t21;
        TreeNode t111 = new TreeNode(3);
        TreeNode t112 = new TreeNode(-2);
        t11.left = t111;
        t11.right = t112;
        TreeNode t122 = new TreeNode(1);
        t12.right = t122;

        TreeNode m = new TreeNode(11);
        t2.right = m;
        Leecode437 leecode437 = new Leecode437();
        System.out.println(leecode437.pathSum(root, 8));
    }
}
