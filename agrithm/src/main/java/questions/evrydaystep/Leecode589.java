package questions.evrydaystep;/**
 * ClassName Leecode589
 * Description
 * Create by jie.zhang02
 * Date 2022/3/10 9:57 上午
 */

import java.util.*;

/**
 * @author jie.zhang
 * @date 2022年03月10日 9:57 上午
 */
public class Leecode589 {
    List<Integer> list = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        subNode(root);
        return list;

    }

    public List<Integer> preorderNonRecursion(Node root) {
        Deque<Node> queue= new LinkedList<>();
        if(root==null){
            return list;
        }
        queue.addLast(root);
        while (!queue.isEmpty()){
            Node node =  queue.pollLast();
            list.add(node.val);
            if(node.children!=null){
                Collections.reverse(node.children);
                for(Node a:node.children){
                    queue.addLast(a);
                }

            }
        }
        return  list;
    }

    private void subNode(Node root) {
        if(root==null){
            return;
        }
        list.add(root.val);
        for(Node node: root.children){
            subNode(node);
        }

    }


    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

}
