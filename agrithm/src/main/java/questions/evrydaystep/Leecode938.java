package questions.evrydaystep;

public class Leecode938 {
    public int result=0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root==null){
            return 0;
        }
        rangeSumSubBST(root,low,high);
        return result;

    }

    private void rangeSumSubBST(TreeNode root, int low, int high) {
        if(root==null){
            return;
        }
        rangeSumSubBST(root.right,low,high);
        rangeSumSubBST(root.left,low,high);

        if(root.val>=low && root.val<=high){
            result+=root.val;
        }
    }
    private int rangeSumSubBST_2(TreeNode root, int low, int high) {
       if(root==null){
           return 0;
       }
       if(root.val<low){
           return rangeSumSubBST_2(root.right,low,high);
       }
       if(root.val>high){
           return rangeSumSubBST_2(root.left,low,high);
       }
       return root.val+rangeSumSubBST_2(root.left,low,high)+rangeSumSubBST_2(root.right,low,high);

    }
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int t) {
            this.val = t;
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
        Leecode938 leecode938 = new Leecode938();
        System.out.println(leecode938.rangeSumSubBST_2(list1,3,7));
    }
}
