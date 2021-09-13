package questions.evrydaystep;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 给你二叉树的根结点 root ，请你设计算法计算二叉树的 垂序遍历 序列。
 *
 * 对位于 (row, col) 的每个结点而言，其左右子结点分别位于 (row + 1, col - 1) 和 (row + 1, col + 1) 。树的根结点位于 (0, 0) 。
 *
 * 二叉树的 垂序遍历 从最左边的列开始直到最右边的列结束，按列索引每一列上的所有结点，形成一个按出现位置从上到下排序的有序列表。如果同行同列上有多个结点，则按结点的值从小到大进行排序。
 *
 * 返回二叉树的 垂序遍历 序列。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/vertical-order-traversal-of-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class Leecode987 {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>(new LinkedList<>());
        Map<Integer,TreeMap<Integer,List<Integer>>> lieInfo = new TreeMap<>();
        getPosition(root,0,0,lieInfo);

        Set<Map.Entry<Integer, TreeMap<Integer, List<Integer>>>> entrySet =lieInfo.entrySet();
        entrySet.forEach((a)->{
            List<Integer> getOne = new LinkedList<>();
            for (Map.Entry<Integer, List<Integer>> entry : a.getValue().entrySet()) {
                Integer m = entry.getKey();
                List<Integer> n = entry.getValue();
                List<Integer> samePos = n;
                Collections.sort(samePos);

                getOne.addAll(samePos);

            }
            result.add(getOne);
        });
        return result;
    }

    private void getPosition(TreeNode root, int lie, int hang, Map<Integer,TreeMap<Integer,List<Integer>>>  lieInfo) {
        if(root==null) return;
        lieInfo.putIfAbsent(lie, new TreeMap<>());
        lieInfo.get(lie).putIfAbsent(hang,new ArrayList<>());
        lieInfo.get(lie).get(hang).add(root.val);
        getPosition(root.left,lie-1,hang+1,lieInfo);
        getPosition(root.right,lie+1,hang+1,lieInfo);

    }

    public static void main(String[] args) {
        //[1,2,3,4,5,6,7]

        TreeNode first = new TreeNode(1);
        TreeNode second = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        first.left=second;
        first.right=n3;
        second.left=n4;
        second.right=n5;
        n3.left=n6;
        n3.right=n7;

        Leecode987 leecode987 = new Leecode987();
        System.out.println(leecode987.verticalTraversal(first));


    }
}
