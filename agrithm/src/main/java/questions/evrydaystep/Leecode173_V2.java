package questions.evrydaystep;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leecode173_V2 {
    //动态维护
    Stack<Integer> stack;
    TreeNode cur;

    public Leecode173_V2(TreeNode root) {
        cur = root;
    }


    public int next() {
        if (stack == null) {
            stack = new Stack<>();
        }
        while (cur != null) {
            stack.push(cur.val);
            cur = cur.left;
        }
        int val = stack.peek();
        stack.pop();
        cur = cur.right;
        return val;
    }

    public boolean hasNext() {
        return cur != null || !stack.isEmpty();

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

    }
}
