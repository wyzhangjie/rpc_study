package questions.evrydaystep;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 提示：
 *
 * 给定的树是非空的。
 * 树上的每个结点都具有唯一的值0 <= node.val <= 500。
 * 目标结点target是树上的结点。
 * 0 <= K <= 1000.
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/all-nodes-distance-k-in-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class Leecode863 {
    Map<Integer,TreeNode> parentInfo = new HashMap<>();
    List<Integer> list =new ArrayList<>();

    public List<Integer> distanceK1(TreeNode root, TreeNode target, int k) {
        findParent(root);
        findDistanceK(target,null,0,k);
        return list;
    }

    private void findDistanceK(TreeNode target, Object parent, int step, int total) {
        if(target==null){
            return;
        }
        if(step==total){
            list.add(target.val);
        }
        if(target.left!=parent ){
            findDistanceK(target.left,target,step+1,total);
        }
        if(target.right!=parent ){
            findDistanceK(target.right,target,step+1,total);
        }
        if(parentInfo.get(target.val)!=parent){
            findDistanceK(parentInfo.get(target.val),target,step+1,total);
        }
    }

    private void findParent(TreeNode root) {
        if(root.left!=null){
            parentInfo.put(root.left.val,root);
            findParent(root.left);
        }
        if(root.right!=null){
            parentInfo.put(root.right.val,root);
            findParent(root.right);
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        deepRecurse(root,map);

        int distence=1;
        Queue<Integer> queue = new ArrayDeque<>();
        List<Integer> list = map.get(target.val);
        list.stream().forEach((a)->queue.add(a));
        Boolean flag=false;
        if(list.contains(root.val)){
            flag=true;
        }
        while (distence<k){
            Queue<Integer> temp = new ArrayDeque<>();
            while (!queue.isEmpty()){
                temp.addAll(map.get(queue.poll()).stream().filter((a)->a!=target.val).collect(Collectors.toList()));
            }
            queue.addAll(temp);
            distence++;
        }
        while (!queue.isEmpty()){
            result.add(queue.poll());
        }
        return result;
    }

    private void deepRecurse(TreeNode root, Map<Integer, List<Integer>> map) {
        if(root!=null){
            map.putIfAbsent(root.val,new ArrayList<>());
            if(root.left!=null){
                map.get(root.val).add(root.left.val);
                map.putIfAbsent(root.left.val,new ArrayList<>());
                map.get(root.left.val).add(root.val);
            }
            if(root.right!=null){
                map.get(root.val).add(root.right.val);
                map.putIfAbsent(root.right.val,new ArrayList<>());
                map.get(root.right.val).add(root.val);
            }
        }
        if(root.left!=null){
            deepRecurse(root.left,map);
        }
        if(root.right!=null){
            deepRecurse(root.right,map);
        }
    }

    public static void main(String[] args) {
        //输入：root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
        //输出：[7,4,1]

        TreeNode first= new TreeNode(3);
        TreeNode node1= new TreeNode(5);
        TreeNode node2= new TreeNode(1);
        TreeNode node3= new TreeNode(6);
        TreeNode node4= new TreeNode(2);
        TreeNode node5= new TreeNode(0);
        TreeNode node6= new TreeNode(8);
        TreeNode node7= new TreeNode(7);
        TreeNode node8= new TreeNode(4);
        first.left=node1;
        first.right=node2;
        node1.left=node3;
        node1.right=node4;
        node2.left=node5;
        node2.right=node6;
        node4.left=node7;
        node4.right=node8;
        Leecode863 leecode863 = new Leecode863();
        System.out.println(leecode863.distanceK(first,node1,2));
        System.out.println(leecode863.distanceK1(first,node1,2));

        leecode863.testWrong();

    }

    private void testWrong() {
        //[0,2,1,null,null,3]
        //3
        //3
        TreeNode first= new TreeNode(0);
        TreeNode second= new TreeNode(2);
        TreeNode node2= new TreeNode(1);
        TreeNode node3= new TreeNode(3);
        first.left=second;
        first.right=node2;
        node2.left=node3;
        Leecode863 leecode863 = new Leecode863();
        System.out.println(leecode863.distanceK(first,node3,3));
        System.out.println(leecode863.distanceK1(first,node3,3));
    }
}
