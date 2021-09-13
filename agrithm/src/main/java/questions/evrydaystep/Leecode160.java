package questions.evrydaystep;
/**
 * 160. 相交链表
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
 *
 * 图示两个链表在节点 c1 开始相交：
 *
 *
 *
 * 题目数据 保证 整个链式结构中不存在环。
 *
 * 注意，函数返回结果后，链表必须 保持其原始结构 。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Intersected at '8'
 * 解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
 * 从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。
 * 在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 * 示例 2：
 *
 *
 *
 * 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * 输出：Intersected at '2'
 * 解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。
 * 从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。
 * 在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
 * 示例 3：
 *
 *
 *
 * 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * 输出：null
 * 解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。
 * 由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
 * 这两个链表不相交，因此返回 null 。
 *
 *
 * 提示：
 *
 * listA 中节点数目为 m
 * listB 中节点数目为 n
 * 0 <= m, n <= 3 * 104
 * 1 <= Node.val <= 105
 * 0 <= skipA <= m
 * 0 <= skipB <= n
 * 如果 listA 和 listB 没有交点，intersectVal 为 0
 * 如果 listA 和 listB 有交点，intersectVal == listA[skipA + 1] == listB[skipB + 1]
 *
 *
 * 进阶：你能否设计一个时间复杂度 O(n) 、仅用 O(1) 内存的解决方案？
 * */
public class Leecode160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null){
            return null;
        }
        ListNode afirst=headA;
        ListNode bfirst=headB;
        while (afirst!=null || bfirst!=null){
            if(afirst==bfirst){
                return afirst;
            }
            if(afirst==null){
                afirst=headB;
            }
            if(bfirst==null){
                bfirst=headA;
            }
            if(afirst==bfirst){
                return afirst;
            }
            afirst=afirst.next;
            bfirst=bfirst.next;
        }

        return null;
    }
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        /**
         定义两个指针, 第一轮让两个到达末尾的节点指向另一个链表的头部, 最后如果相遇则为交点(在第一轮移动中恰好抹除了长度差)
         两个指针等于移动了相同的距离, 有交点就返回, 无交点就是各走了两条指针的长度
         **/
        if(headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        // 在这里第一轮体现在pA和pB第一次到达尾部会移向另一链表的表头, 而第二轮体现在如果pA或pB相交就返回交点, 不相交最后就是null==null
        while(pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
    public static void main(String[] args) {
        Leecode160 leecode160 = new Leecode160();
       // listA = [4,1,8,4,5], listB = [5,0,1,8,4,5]
        //8
        //[4,1,8,4,5]
        //[5,6,1,8,4,5]
        //2
        //3
    /*    ListNode head1= new ListNode(4);
        ListNode node2= new ListNode(1);
        ListNode node3= new ListNode(8);
        ListNode node4= new ListNode(4);
        ListNode node5= new ListNode(5);
        head1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;

        ListNode head11= new ListNode(5);
        ListNode node21= new ListNode(6);
        ListNode node31= new ListNode(1);
        head11.next=node21;
        node21.next=node31;
        node31.next=node3;


        System.out.println(leecode160.getIntersectionNode(head1,head11).data);
        System.out.println(leecode160.getIntersectionNode1(head1,head11).data);*/
        leecode160.test();
    }

    public void test(){
        Leecode160 leecode160 = new Leecode160();
        //3
        //[3]
        //[2,3]
        //0
        //1
        ListNode head1= new ListNode(3);
        ListNode node2= new ListNode(2);
        node2.next=head1;
        System.out.println(leecode160.getIntersectionNode(head1,node2).data);
        System.out.println(leecode160.getIntersectionNode1(head1,node2).data);
    }

}
