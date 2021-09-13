package questions.evrydaystep;

/**
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * 返回同样按升序排列的结果链表。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 * 示例 2：
 *
 *
 * 输入：head = [1,1,1,2,3]
 * 输出：[2,3]
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class Leecode82  {
    public  ListNode deleteDuplicates(ListNode head) {
        ListNode dumey = new ListNode(-1);
        dumey.next = head;
        ListNode pre=dumey;
        ListNode cur=head;
        if(cur==null ||cur.next==null){
            return head;
        }
       while (cur!=null){
           while (cur!=null && cur.next!=null && cur.val==cur.next.val){
               cur=cur.next;
           }
           if(pre.next==cur){
               pre=pre.next;
           }else {
               pre.next=cur.next;

           }
            cur=cur.next;
       }

        return dumey.next;
    }
    public  ListNode deleteDuplicatesRecurse(ListNode head) {
        //终止条件是什么，递归最重要的第一步
        if(head==null || head.next==null){
            return head;
        }else  if(head.val!= head.next.val){
            //递归主题要做什么？
            //主题就是要连接这些节点，怎么连接？
            //如果该节点和下一个节点他们的值不相同，那么直接连接就好了
            head.next=deleteDuplicatesRecurse(head.next);
        }else {
            //如果该节点和下一个节点的值相同，那么就继续递归，找到那个不相等的之后，上面那个操作就会连接到他们
               ListNode temp =head;
               while (temp!=null && temp.next!=null && temp.val == temp.next.val){
                   temp = temp.next;
               }
               //千万注意这块，一定要循环找到下一个能够接入的点继续返回这个点，要不然不符合整体逻辑
            //即：我们用递归来连接所有能够连接起来的点，不能连接的越过去
                return deleteDuplicatesRecurse(temp.next);
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
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(4);
        ListNode n6 = new ListNode(4);
        listNode.next = n1;
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=n6;
        Leecode82 leecode82 = new Leecode82();
        ListNode result = leecode82.deleteDuplicates(listNode);
        printList(result);
        result = leecode82.deleteDuplicatesRecurse(listNode);
        printList(result);

    }
}
