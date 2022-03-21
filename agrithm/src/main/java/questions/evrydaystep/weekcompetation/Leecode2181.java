package questions.evrydaystep.weekcompetation;

/**
 * ClassName Leecode2181
 * Description
 * Create by jie.zhang02
 * Date 2022/2/23 11:04 上午
 */


/**
 * @author jie.zhang
 * @date 2022年02月23日 11:04 上午
 */
public class Leecode2181 {
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int t) {
            this.val = t;
        }
    }

    public ListNode mergeNodes(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode pre=head;
        ListNode next=pre.next;
        if(next==null){
            return head;
        }
        while (next!=null){
            int sum=0;
            while (next.val!=0){
                sum+=next.val;
                next=next.next;
            }
            pre.val=sum;
            if(next.next==null){
                pre.next=null;
            }else {
                pre.next=next;
            }

            pre=next;
            next=next.next;

        }


        return head;
    }

    public static void main(String[] args) {
        //head = [0,3,1,0,4,5,2,0]
        ListNode head = new ListNode(0);
        ListNode head3 = new ListNode(3);
        ListNode head1 = new ListNode(1);
        ListNode head00 = new ListNode(0);
        ListNode head4 = new ListNode(4);
        ListNode head5 = new ListNode(5);
        ListNode head2 = new ListNode(2);
        ListNode head000 = new ListNode(0);
        head.next=head3;
        head3.next=head1;
        head1.next=head00;
        head00.next=head4;
        head4.next=head5;
        head5.next=head2;
        head2.next=head000;
        Leecode2181 leecode2181 = new Leecode2181();
        leecode2181.mergeNodes(head);
        while (head!=null){
            System.out.println(head.val);
            head=head.next;
        }
    }

}
