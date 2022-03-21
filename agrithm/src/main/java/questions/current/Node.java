package questions.current;/**
 * ClassName Node
 * Description
 * Create by jie.zhang02
 * Date 2022/3/14 11:47 上午
 */

import questions.evrydaystep.Leecode590;

import java.util.List;

/**
 * @author jie.zhang
 * @date 2022年03月14日 11:47 上午
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List _children) {
        val = _val;
        children = _children;
    }
}
