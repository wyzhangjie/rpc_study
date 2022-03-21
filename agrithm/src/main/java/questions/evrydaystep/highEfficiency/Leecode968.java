package questions.evrydaystep.highEfficiency;

/**
 * ClassName Leecode968
 * Description
 * Create by jie.zhang02
 * Date 2022/3/3 3:59 下午
 */

import questions.evrydaystep.TreeNode;

/**
 * @author jie.zhang
 * @date 2022年03月03日 3:59 下午
 */
public class Leecode968 {
    int result;
    public int minCameraCover(TreeNode root) {
        //状态0 未覆盖 状态1 当前位置放灯  状态2当前位置有覆盖
       getResult(root);
       return result;
    }

    private int getCheck(TreeNode root) {
        if(root==null){
            return 2;
        }
        int left = getCheck(root.left);
        int right = getCheck(root.right);
        if(left==2 && right==2){
            return 0;
        }
        if(left==0 || right==0){
            result++;
            return 1;
        }
        if(left==1|| right==1){
            return 2;
        }
        return -1;

    }
    int getResult(TreeNode root) {
        // 情况4
        if (getCheck(root) == 0) { // root 无覆盖
            result++;
        }
        return result;
    }


}
