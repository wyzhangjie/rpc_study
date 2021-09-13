package questions;


import questions.evrydaystep.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Leecode377 {
    // Encodes a tree to a single string.

    private TreeNode empty = new TreeNode(-2000);
    public String serialize(TreeNode root) {
        StringBuffer temp = new StringBuffer();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            temp.append("-");
            temp.append("|");
        } else {
            queue.add(root);
            temp.append(root.val);
            temp.append("|");
            while (!queue.isEmpty()) {
                TreeNode treeNode = queue.poll();
                if(!treeNode.equals(empty)){
                    if (treeNode.left != null) {
                        temp.append(treeNode.left.val);
                        temp.append("|");
                        queue.add(treeNode.left);
                    } else {
                        temp.append("-");
                        temp.append("|");
                        queue.add(empty);
                    }
                    if (treeNode.right != null) {
                        temp.append(treeNode.right.val);
                        temp.append("|");
                        queue.add(treeNode.right);
                    } else {
                        temp.append("-");
                        temp.append("|");
                        queue.add(empty);
                    }
                }


            }
        }

        return temp.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Map<Integer, TreeNode> map = new HashMap<>();
        String[] temp = data.split("\\|");
        if ("-".equalsIgnoreCase(temp[0])) {
            return null;
        }
        TreeNode head = null;
        for (int i = 0; i < temp.length / 2; i++) {
            if ("-".equalsIgnoreCase(temp[i])) {
                continue;
            }
            TreeNode iNode;
            if (map.get(i) != null) {
                iNode = map.get(i);
            } else {
                iNode = new TreeNode(Integer.parseInt(temp[i]));
                map.put(i, iNode);
            }



            if (i == 0) {
                head = iNode;
            }

            if (!"-".equalsIgnoreCase(temp[2 * i + 1])) {
                TreeNode left = new TreeNode(Integer.parseInt(temp[2 * i + 1]));
                iNode.left = left;
                map.put(2 * i + 1, left);

            }
            if (!"-".equalsIgnoreCase(temp[2 * i + 2])) {
                TreeNode right = new TreeNode(Integer.parseInt(temp[2 * i + 2]));
                iNode.right = right;
                map.put(2 * i + 2, right);
            }
        }
        return head;
    }

    public void print(TreeNode head) {
        while (head != null) {
            System.out.println(head.val);

        }
    }

    public static void main(String[] args) {
        test2();

    }

    private static void test2(){
        /**
         * [1,2,null,3,null,4,null,5]
         * */
        TreeNode root = new TreeNode(1);
        TreeNode nod1 = new TreeNode(2);
        TreeNode nod3 = new TreeNode(3);
        TreeNode nod4 = new TreeNode(4);
        TreeNode nod5 = new TreeNode(5);
        root.left=nod1;
        nod1.left=nod3;
        nod3.left=nod4;
        nod4.left=nod5;
        Leecode377 leecode377 = new Leecode377();
        leecode377.deserialize(leecode377.serialize(root));
    }

    private static void test1() {
        /**
         * 输入：root = [1,2,3,null,null,4,5]
         * 输出：[1,2,3,null,null,4,5]
         * */
        TreeNode root = new TreeNode(1);
        TreeNode nod1 = new TreeNode(2);
        TreeNode nod3 = new TreeNode(3);
        TreeNode nod4 = new TreeNode(4);
        TreeNode nod5 = new TreeNode(5);
        root.left = nod1;
        root.right = nod3;
        nod3.left = nod4;
        nod3.right = nod5;
        Leecode377 leecode377 = new Leecode377();
        leecode377.deserialize(leecode377.serialize(root));
        leecode377.deserialize(leecode377.serialize(null));
    }
}
