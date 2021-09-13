package questions.evrydaystep;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Leecode138 {

    public Node copyRandomList(Node head) {

        Map<Node, Node> hasMap = new LinkedHashMap<>();
        Map<Node, Node> revertMap = new LinkedHashMap<>();
        if (head == null) {
            return null;
        }
        Node tmp = head;
        Node newHead = getNewNode(tmp);
        hasMap.put(head, newHead);
        revertMap.put(newHead, head);
        Node pre = newHead;
        if (head.next != null) {
            tmp = tmp.next;
            while (tmp != null) {
                Node mid = getNewNode(tmp);
                pre.next = mid;
                pre = mid;
                hasMap.put(tmp, mid);
                revertMap.put(mid, tmp);
                tmp = tmp.next;
            }
        }
        tmp = newHead;
        while (tmp != null) {
            Node oldSame = revertMap.get(tmp);
            tmp.random = hasMap.get(oldSame.random) == null ? null : hasMap.get(oldSame.random);
            tmp = tmp.next;
        }

        return newHead;

    }

    Map<Node, Node> map = new HashMap();

    public Node copyRandomList1(Node head) {
        if (head == null) {
            return null;
        }

        if (!map.containsKey(head)) {
            Node node = getNewNode(head);
            map.put(head, node);
            node.next = copyRandomList(head.next);
            node.random = copyRandomList(head.random);
        }
        return map.get(head);
    }

    public Node copyRandomList12(Node head) {
        if (head == null) {
            return null;
        }
        Node pre = head;
        while (pre != null) {
            Node node = getNewNode(pre);
            node.next = pre.next;
            pre.next = node;
            pre = pre.next.next;
        }
        for(Node a=head;a!=null;a=a.next.next){
            Node newA= a.next;
            newA.random = a.random==null?null:a.random.next;

        }
        Node newHead = head.next;
        Node temp = newHead;
        Node oldTemp = head;

        while (temp.next!=null&& oldTemp.next!=null){
            oldTemp.next=oldTemp.next.next;
            temp.next = temp.next.next;
            oldTemp=oldTemp.next;
            temp=temp.next;
        }
        oldTemp.next=null;
        temp.next=null;
        return newHead;

    }


    private Node getNewNode(Node tmp) {
        Node newNode = new Node(tmp.val);
        return newNode;
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        head.random = node2;
        Leecode138 leecode138 = new Leecode138();
        System.out.println(leecode138.copyRandomList12(head));


    }
}
