package questions.evrydaystep;

import com.sun.javafx.image.IntPixelGetter;

import java.util.LinkedList;
import java.util.List;

/**
 * 请考虑一棵二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。
 *
 *
 *
 * 举个例子，如上图所示，给定一棵叶值序列为 (6, 7, 4, 9, 8) 的树。
 *
 * 如果有两棵二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。
 *
 * 如果给定的两个根结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
 * 输出：true
 * 示例 2：
 *
 * 输入：root1 = [1], root2 = [1]
 * 输出：true
 * 示例 3：
 *
 * 输入：root1 = [1], root2 = [2]
 * 输出：false
 * 示例 4：
 *
 * 输入：root1 = [1,2], root2 = [2,2]
 * 输出：true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/leaf-similar-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class Leecode872 {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> left = new LinkedList<>();
        List<Integer> right = new LinkedList<>();
        getResult(root1,left);
        getResult(root2,right);
        if(left.size()!=right.size()){
            return false;
        }
        for(int i=0;i<left.size();i++){
            if(left.get(i)!=right.get(i)){
                return false;
            }
        }
        return true;

    }

    private void getResult(TreeNode root2, List<Integer> right) {
       if(root2!=null){
           getResult(root2.left,right);
           if(root2.left==null && root2.right==null){
               right.add(root2.val);
           }
           getResult(root2.right,right);
       }


    }

    public static void main(String[] args) {

    }

}
