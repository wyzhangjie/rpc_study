package questions.evrydaystep;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 993. 二叉树的堂兄弟节点
 * 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
 *
 * 如果二叉树的两个节点深度相同，但 父节点不同 ，则它们是一对堂兄弟节点。
 *
 * 我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。
 *
 * 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,2,3,4], x = 4, y = 3
 * 输出：false
 * 示例 2：
 *
 *
 * 输入：root = [1,2,3,null,4,null,5], x = 5, y = 4
 * 输出：true
 * 示例 3：
 *
 *
 *
 * 输入：root = [1,2,3,null,4], x = 2, y = 3
 * 输出：false
 *
 *
 * 提示：
 *
 * 二叉树的节点数介于 2 到 100 之间。
 * 每个节点的值都是唯一的、范围为 1 到 100 的整数。
 *
 *
 * 通过次数28,969提交
 * */
public class Leecode993 {
    public boolean isCousins(TreeNode root, int x, int y) {
        List<Integer> findX=new ArrayList<>();
        List<Integer> findY = new ArrayList<>();
         findLevelInfo(root,x,0,findX);
        findLevelInfo(root,y,0,findY);
        if(findX.size()==2 && findY.size()==2){
                if(findX.get(0)==findY.get(0) && findX.get(1)!=findY.get(1)){
                    return true;
                }
        }

        return false;
    }



    private void findLevelInfo(TreeNode root, int x, int i,List<Integer> result) {
        if(root!=null){

            if(root.left!=null){
                 findLevelInfo(root.left,x,i+1,result);
                if(root.left.val==x){
                    result.add(i+1);
                    result.add(root.val);
                    return ;
                }

            }
            if(root.right!=null){
                 findLevelInfo(root.right,x,i+1,result);
                if(root.right.val==x){
                    result.add(i+1);
                    result.add(root.val);
                    return ;
                }

            }

        }
        return ;



    }

    public static void main(String[] args) {
        //[1,2,3,null,4,null,5]
        //5
        //4
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        root.left=node1;
        root.right=node2;
        node1.right=node4;
        node2.right=node5;
        Leecode993 leecode993 = new Leecode993();
        System.out.println(leecode993.isCousins(root,5,4));
    }

}
