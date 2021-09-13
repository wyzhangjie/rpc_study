package questions.evrydaystep;

/**
 * 提示：
 * <p>
 * 树中节点数目在范围 [1, 25] 内
 * 1 <= Node.val <= 231 - 1
 * 对于树中每个节点 root.val == min(root.left.val, root.right.val)
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/second-minimum-node-in-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leecode671 {
    int one = -1;//最小
    int second = -1;//第二小

    public int findSecondMinimumValue(TreeNode root) {

       getSmallest(root);

       getSecondSmallest(root);

        if (second == -1) {
            return -1;
        } else {
            return second;
        }
    }

    private void getSecondSmallest(TreeNode root) {

        if (root == null) {
            return;
        }
        if(root.val>one){
            if (second == -1 ) {
                second = root.val;

            } else if (root.val < second) {
                second = root.val;
            }
        }

        getSecondSmallest(root.left);
        getSecondSmallest(root.right);
    }

    private void getSmallest(TreeNode root) {
        if (root == null) {
            return;
        }
        if (one == -1) {
            one = root.val;
        } else if (root.val < one) {
            one = root.val;
        }
        getSmallest(root.left);
        getSmallest(root.right);
    }



    public static void main(String[] args) {
        TreeNode head = new TreeNode(5);
        TreeNode list2 = new TreeNode(8);
        TreeNode list3 = new TreeNode(5);
 /*       TreeNode list4 = new TreeNode(5);
        TreeNode list5 = new TreeNode(7);*/
        head.left = list2;
        head.right = list3;
       /* list3.left = list4;
        list3.right = list5;*/
        Leecode671 leecode671 = new Leecode671();
        System.out.println(leecode671.findSecondMinimumValue(head));

    }
}
