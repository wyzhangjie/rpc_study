package questions;/**
 * ClassName Leecode993
 * Description
 * Create by jie.zhang02
 * Date 2022/3/11 10:34 上午
 */

import questions.evrydaystep.TreeNode;

/**
 * @author jie.zhang
 * @date 2022年03月11日 10:34 上午
 */
public class Leecode993 {
    public boolean isCousins(TreeNode root, int x, int y) {
        int[] left= deep(root,null,x,0);
        int[] right= deep(root,null,y,0);
        return left[0]!=right[0]  && left[1]==right[1];

    }

    private int[] deep(TreeNode root, TreeNode parent, int data, int level) {
        if(root==null){
            return new int[]{-1,-1};
        }
        if(data==root.val){
            return  new int[]{parent==null?1:parent.val,level};
        }
        int[] left=deep(root.left,root,data,level+1);
        if(left[0]!=-1 && left[1]!=0){
            return left;
        }
        return deep(root.right,root,data,level+1);
    }
}
