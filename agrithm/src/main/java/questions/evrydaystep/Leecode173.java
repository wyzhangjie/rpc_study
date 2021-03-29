package questions.evrydaystep;

import java.util.ArrayList;
import java.util.List;

public class Leecode173 {
    int index;
    List<Integer> data;

    public Leecode173(TreeNode root) {
        data = new ArrayList<>();
        nodetoList(root, data);
        index = 0;
    }

    private void nodetoList(TreeNode root, List<Integer> data) {
        if (root == null) {
            return;
        }
        nodetoList(root.left, data);
        data.add(root.val);
        nodetoList(root.right, data);
    }

    public int next() {
        return data.get(index++);

    }

    public boolean hasNext() {
        return index < data.size();

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
