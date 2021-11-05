package questions.evrydaystep;

public class Leecode725 {
    public ListNode[] splitListToParts(ListNode head, int k) {
        int len = getLen(head);
        if (k >= len) {
            return getOneNode(head, k, len);
        } else {
            int headLen = len / k + len % k;
            int count = len % k;
            return getCommonNode(head, k, len, count);
        }

    }

    private ListNode[] getCommonNode(ListNode head, int k, int len, int countLen) {
        ListNode[] result = new ListNode[k];
        ListNode temp = head;
        ListNode pre = head;
        result[0] = head;
        int headLen = len / k + 1;
        for (int i = 0; i < countLen; i++) {
            int j = 0;
            ListNode slot = temp;
            while (j < headLen) {
                pre = temp;
                temp = temp.next;
                j++;
            }
            pre.next = null;
            pre = temp;
            result[i] = slot;
        }
        int everyCount = len / k;
        int count;

        for (int i = countLen; i < k; i++) {
            ListNode slot = temp;
            count = 0;
            while (count < everyCount) {
                pre = temp;
                temp = temp.next;
                count++;
            }
            pre.next = null;
            pre = temp;
            count = 0;
            result[i] = slot;

        }
        return result;
    }

    private ListNode[] getOneNode(ListNode head, int k, int len) {
        ListNode[] result = new ListNode[k];
        ListNode temp = head;
        ListNode pre = head;
        for (int i = 0; i < len; i++) {
            pre = temp;
            temp = temp.next;
            pre.next = null;
            result[i] = pre;
        }
        return result;
    }

    private int getLen(ListNode head) {
        ListNode temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
      /*  ListNode node5 = new ListNode(6);
        ListNode node6 = new ListNode(7);
        ListNode node7 = new ListNode(8);
        ListNode node8 = new ListNode(9);
        ListNode node9 = new ListNode(10);*/
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
     /*   node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;*/
        Leecode725 leecode725 = new Leecode725();
        ListNode[] result = leecode725.splitListToParts(head, 3);
        for (ListNode listNode : result) {
            if (listNode != null) {
                while (listNode != null) {
                    System.out.print(listNode.data);
                    listNode = listNode.next;
                }
                System.out.println("--");

            }

        }

    }
}
