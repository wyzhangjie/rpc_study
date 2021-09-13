package questions.evrydaystep;
/**
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
 *
 * 返回同样按升序排列的结果链表。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 * 示例 2：
 *
 *
 * 输入：head = [1,1,2,3,3]
 * 输出：[1,2,3]
 *  
 *
 * 提示：
 *
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序排列
 * 通过次数215,989提交次数406,710
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class Leecode83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while (cur!=null&& cur.next!=null){
            if(cur.val==cur.next.val){
                cur.next=cur.next.next;
            }else {
                cur=cur.next;
            }

        }
        return head;

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
        ListNode listNode = new ListNode(1);
        ListNode n1= new ListNode(1);
        ListNode n2 = new ListNode(1);

        listNode.next = n1;
        n1.next=n2;

        Leecode83 leecode83 = new Leecode83();
        printList(leecode83.deleteDuplicates(listNode));
    }
}
