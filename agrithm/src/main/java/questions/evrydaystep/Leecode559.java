package questions.evrydaystep;

import java.util.List;

public class Leecode559 {

    public int maxDepth(Node root) {
        if (root.children==null){
            return 1;
        }
        int max=1;
        for(Node child:root.children){
            max = Math.max(max,maxDepth(child)+1);

        }
       return max;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }



}
