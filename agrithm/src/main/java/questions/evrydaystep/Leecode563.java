package questions.evrydaystep;

public class Leecode563 {
    int sum=0;
    public int findTilt(TreeNode root) {
        //
        findSum(root);
         findSubTilt(root);
        return sum;
    }

    private void findSubTilt(TreeNode root) {
        if(root==null) return;
        if(root!=null){
            int left = root.left==null?0:root.left.val;
            int right =root.right==null?0:root.right.val;
            root.val=Math.abs(left-right);
            sum+=root.val;
        }
        findSubTilt(root.left);
        findSubTilt(root.right);

    }

    private void findSum(TreeNode root) {
        if(root==null) return;
        if(root.left==null && root.right==null) return;
        findSum(root.left);
        findSum(root.right);
        if(root==null)return;

        int left=0;
        int right=0;
        if(root.left!=null){
            left=root.left.val;
        }
        if(root.right!=null){
            right=root.right.val;
        }
        root.val = root.val+left+right;

    }

    public static void main(String[] args) {
        Leecode563 leecode563 = new Leecode563();
        TreeNode root = new TreeNode(4);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(9);
        TreeNode left3 = new TreeNode(3);
        TreeNode right5= new TreeNode(5);
        TreeNode right7= new TreeNode(7);
        left.left = left3;
        left.right = right5;

        root.left=left;
        root.right=right;
        right.right = right7;

        System.out.println(leecode563.findTilt(root));
    }
}
