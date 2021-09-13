package questions.evrydaystep;

import questions.list.CommonList;

/**
 * 你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 *  
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 * 示例 2：
 *
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 *  
 *
 * 提示：
 *
 * 链表中节点数目为 n
 * 1 <= n <= 500
 * -500 <= Node.val <= 500
 * 1 <= left <= right <= n
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class Leecode92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummey = new ListNode(-1);
        ListNode pre;
        dummey.next=head;
        pre=dummey;
        for(int i=0;i<left-1;i++){
            pre=pre.next;
        }
        ListNode cur=pre.next;
        ListNode next;
        for(int i=0;i<right-left;i++){
            next=cur.next;
            cur.next=next.next;
            next.next=pre.next;
            pre.next=next;
        }
        return dummey.next;

    }

    public void print(ListNode head){
        while (head!=null){
            System.out.println(head.data);
            head=head.next;
        }
    }

    public static void main(String[] args) {
        case1();
     //   case2();
     //   case3();

    }

    private static void case1() {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        Leecode92 leecode92 = new Leecode92();
        leecode92.reverseBetween(head,2,4);
        leecode92.print(head);
    }

    private static  void case2(){
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        head.next=node2;
        Leecode92 leecode92 = new Leecode92();
        head= leecode92.reverseBetween(head,1,2);
        leecode92.print(head);
    }
    private static  void case3(){
        ListNode head = new ListNode(1);

        Leecode92 leecode92 = new Leecode92();
        head = leecode92.reverseBetween(head,1,1);
        leecode92.print(head);
    }
}
