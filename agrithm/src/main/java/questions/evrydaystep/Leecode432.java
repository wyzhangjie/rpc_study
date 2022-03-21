package questions.evrydaystep;/**
 * ClassName Leecode432
 * Description
 * Create by jie.zhang02
 * Date 2022/3/16 11:22 上午
 */


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author jie.zhang
 * @date 2022年03月16日 11:22 上午
 */
public class Leecode432 {

    class Node {
        int cnt;
        Set<String> keys = new HashSet<>();
        Node prev, next;

        Node(int _cnt) {
            cnt = _cnt;
        }

        void addKey(String key) {
            this.keys.add(key);
        }

        void removeKey(String key) {
            this.keys.remove(key);
            if (this.keys.isEmpty()) {
                remove();
            }
        }

        void next(Node next) {
            // 在当前节点后面插入一个节点
            Node nextnext = this.next;
            this.next = next;
            next.prev = this;
            next.next = nextnext;
            nextnext.prev = next;
        }

        void prev(Node prev) {
            // 在当前节点前面插入一个节点
            Node prevprev = this.prev;
            this.prev = prev;
            prev.next = this;
            prev.prev = prevprev;
            prevprev.next = prev;
        }

        void remove() {
            // 删除当前节点
            Node prev = this.prev;
            Node next = this.next;
            prev.next = next;
            next.prev = prev;
        }
    }
    //从小到大left-->right

    Map<String, Node> map;
    Node nodeL;
    Node nodeR;


    public Leecode432() {
        nodeL = new Node(-100001);
        nodeR = new Node(10001);
        map = new HashMap<>();
        nodeL.next = nodeR;
        nodeR.prev = nodeL;
    }

    public void inc(String key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            int value = node.cnt;
            value++;
            //

            //增加1，导致自己往前走一步,走后这个节点
            if (node.next != null && node.next.cnt == value) {

                if(node.keys.size()==1){

                    node.remove();
                }else {
                    node.removeKey(key);


                }
                node.next.addKey(key);
                map.put(key,node.next);
            }
            //不能往前走是什么样的？我比后面的扔人小，并且这里面key就我一个，那么久+1即可，如果不行，我只能独立成对
            if (node.next.cnt >value) {
                if(node.keys.size()==1){
                   node.cnt=value;
                }else {
                    Node newNode = new Node(value);
                    node.keys.remove(key);
                    node.next(newNode);
                    newNode.addKey(key);
                    map.put(key, newNode);
                }

            }



        } else {
            //不存在
            if (nodeL.next.cnt == 1) {
                nodeL.next.addKey(key);
                map.put(key, nodeL.next);
            } else {
                Node node = new Node(1);
                node.addKey(key);
                nodeL.next(node);
                map.put(key, node);
            }


        }

    }

    public void dec(String key) {
        Node node = map.get(key);
        int count = node.cnt;
        //情况1，减少1，让自己变没了，直接删了吧
        if (count - 1 == 0) {
            node.removeKey(key);
            map.remove(key);
        }else if(count-1>node.prev.cnt){
            //情况2，减少1，也没让自己跟更小的合并
            Node newNode = new Node(count - 1);
            newNode.addKey(key);
            node.prev(newNode);
            map.put(key, newNode);
            node.removeKey(key);
        }
        //情况2，减少1，自己跟更小大小相同，则合并
        if(count-1==node.prev.cnt){
            node.prev.addKey(key);
            if(node.keys.size()==1){
                node.remove();
            }else {
                node.removeKey(key);
            }

            map.put(key,node.prev);

        }

    }

    public String getMaxKey() {
        if (nodeR.prev == nodeL) {
            return "";
        } else {
            return nodeR.prev.keys.iterator().next();
        }
    }

    public String getMinKey() {
        if (nodeR.prev == nodeL) {
            return "";
        } else {
            return nodeL.next.keys.iterator().next();
        }
    }
//["AllOne","inc","inc","getMaxKey","getMinKey","inc","getMaxKey","getMinKey"]
    //["AllOne","inc","inc","inc","inc","getMaxKey","inc","inc","inc","dec","inc","inc","inc","getMaxKey"]
//[[],["hello"],["goodbye"],["hello"],["hello"],[],["leet"],["code"],["leet"],["hello"],["leet"],["code"],["code"],[]]
//[[],["hello"],["hello"],[],[],["leet"],[],[]]


    // ["AllOne","inc","inc","inc","inc","getMaxKey","inc","inc","inc","dec","inc","inc","inc","getMaxKey"]
    //         [[],["hello"],["goodbye"],["hello"],["hello"],[],["leet"],["code"],["leet"],["hello"],["leet"],["code"],["code"],[]]


    public static void main(String[] args) {
        //["AllOne","inc","inc","inc","inc","inc","dec","dec","getMaxKey","getMinKey"]
        //[[],["a"],["b"],["b"],["b"],["b"],["b"],["b"],[],[]]
        //["AllOne","inc","inc","getMaxKey","getMinKey","inc","getMaxKey","getMinKey"]
        //[[],["hello"],["hello"],[],[],["leet"],[],[]]
        Leecode432 leecode432 = new Leecode432();
        leecode432.inc("inc");
        leecode432.inc("inc");
        System.out.println(leecode432.getMaxKey());
        System.out.println(leecode432.getMinKey());
        leecode432.inc("inc");
       /* leecode432.inc("leet");
        leecode432.inc("code");
        leecode432.inc("leet");
        leecode432.dec("hello");

        leecode432.inc("leet");
        leecode432.inc("code");*/

        System.out.println(leecode432.getMaxKey());
        System.out.println(leecode432.getMaxKey());
        System.out.println(leecode432.getMinKey());
        
        case3();
      //  case4();
    }

    private static void case4() {
        //["AllOne","inc","inc","inc","inc","inc","inc","dec", "dec","getMinKey","dec","getMaxKey","getMinKey"]
        //[[],["a"],["b"],["b"],["c"],["c"],["c"],["b"],["b"],[],["a"],[],[]]

        Leecode432 leecode432 = new Leecode432();
        leecode432.inc("a");
        leecode432.inc("b");
        leecode432.inc("b");
        leecode432.inc("c");
        leecode432.inc("c");
        leecode432.inc("c");
    }

    private static void case3() {
        //["AllOne","inc","inc","inc","inc","inc","inc","dec", "dec","getMinKey","dec","getMaxKey","getMinKey"]
        //[[],["a"],["b"],["b"],["c"],["c"],["c"],["b"],["b"],[],["a"],[],[]]
        Leecode432 leecode432 = new Leecode432();
        leecode432.inc("a");
        leecode432.inc("b");
        leecode432.inc("b");
        leecode432.inc("c");
        leecode432.inc("c");
        leecode432.inc("c");
        leecode432.dec("b");
        leecode432.dec("b");
        System.out.println(leecode432.getMinKey());
        leecode432.dec("a");
        System.out.println(leecode432.getMaxKey());
        System.out.println(leecode432.getMinKey());

    }
}
