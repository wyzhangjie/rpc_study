package questions.evrydaystep;


/**
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[4,5,1,2,3]
 * 示例 2：
 *
 *输入：head = [0,1,2], k = 4
 * 输出：[2,0,1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class Leecode61 {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null){
            return head;
        }
        ListNode first=head;
        ListNode second=head;
        for(int i=0;i<k;i++){
            if(first.next!=null){
                first=first.next;
            }else {
                first=head;
            }

        }
        second=head;
        while (first.next!=null){
            second=second.next;
            first=first.next;
        }
        first.next=head;
        ListNode temp = second.next;
        second.next=null;
        return temp;

    }
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int t) {
            this.val = t;
        }
    }
    public static  void printList(ListNode list) {
        while (list != null) {
            System.out.println(list.val);
            list = list.next;
        }
        System.out.println("breautiful line=======================================");

    }
    public static void main(String[] args) {
        ListNode listNode = new ListNode(0);
        ListNode n1= new ListNode(1);
        ListNode n2 = new ListNode(2);

        listNode.next = n1;
        n1.next=n2;
        Leecode61 leecode61 = new Leecode61();

        printList(leecode61.rotateRight(listNode,4));

        test1();

    }

    private static void test1() {
        ListNode listNode = new ListNode(1);
        ListNode n1= new ListNode(2);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(5);
        listNode.next=n1;
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        Leecode61 leecode61 = new Leecode61();

        printList(leecode61.rotateRight(listNode,2));
    }
}
