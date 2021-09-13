package questions.evrydaystep;

public class LeecodeOffer22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode first;
        ListNode second;
        ListNode result = null;
        int data = 1;
        second = head;
        first=head;
        int index = 0;
        while (index<k) {
            if(second == null){
                return result;
            }
            second = second.next;
            index++;
        }
        while (second!=null){
           first=first.next;
           second=second.next;
        }
        return first;

    }

    public static void main(String[] args) {

    }
}
