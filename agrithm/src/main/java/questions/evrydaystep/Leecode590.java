package questions.evrydaystep;/**
 * ClassName Leecode590
 * Description
 * Create by jie.zhang02
 * Date 2022/3/14 11:08 上午
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import  questions.current.Node;

/**
 * @author jie.zhang
 * @date 2022年03月14日 11:08 上午
 */
public class Leecode590 {
    //后序遍历
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node last = queue.peekLast();
            if (last.children == null) {
                queue.pollLast();
                result.add(last.val);
            } else {
                for(int i=last.children.size()-1;i>=0;i--){
                    queue.addLast(last.children.get(i));
                }



                last.children=null;

            }

        }
        return  result;

    }


    public static void main(String[] args) {
        Node first = new Node(1);

        List<Node> _children = new ArrayList();
        Node node3= new Node(3);
        _children.add(node3);
        Node node2 = new Node(2);
        _children.add(node2);
        Node node4 = new Node(4);
        _children.add(node4);
        first.children=_children;


        List _children2= new ArrayList();
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        _children2.add(node5);
        _children2.add(node6);
        node3.children=_children2;
        Leecode590 leecode590 =new Leecode590();
        System.out.println(leecode590.postorder(first));
    }



}
