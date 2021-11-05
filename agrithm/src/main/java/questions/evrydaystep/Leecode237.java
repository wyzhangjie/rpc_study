package questions.evrydaystep;

import lombok.val;

public class Leecode237 {
    public void deleteNode(ListNode node, ListNode head ) {
        ListNode first = node;
        ListNode next = node.next;
        while (next!=null){
            first.data =next.data;
            first = next;
            next=next.next;
        }
        first.data=null;
        first=null;
    }



    public void deleteNode1(ListNode node) {
      node.data=node.next.data;
        node.next=node.next.next;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(9);
        head.next=node1;
        node1.next=node2;
        node2.next=node3;
        Leecode237 leecode237 = new Leecode237();
        leecode237.deleteNode(node1,head);
    }
}
