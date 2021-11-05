package questions.evrydaystep;


import java.util.Stack;

public class Leecode430 {
    public Node flatten(Node head) {
        Node newhead=head;
        Stack<Node> stack = new Stack<>();
        Node cursor = newhead;
        while (cursor!=null){
            if(cursor.child!=null){
                stack.push(cursor);
                cursor= cursor.child;
            }else {
                cursor=cursor.next;
            }
        }
        while (!stack.isEmpty()){
            Node hasChild= stack.pop();
             cursor = hasChild.child;
            Node next = hasChild.next;
            hasChild.next=hasChild.child;
            hasChild.child.prev=hasChild;

            while (cursor.next!=null){
                cursor=cursor.next;
            }
            cursor.next=next;
            if(next!=null){
                next.prev=cursor;
            }
            hasChild.child=null;
        }
        return newhead;
    }

    public static void main(String[] args) {
        //head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
        Node head = new Node(1);
        Node nod1 = new Node(2);
        Node nod2 = new Node(3);
        Node nod3 = new Node(4);
        Node nod4 = new Node(5);
        Node nod5 = new Node(6);
        Node nod6 = new Node(7);
        Node nod7 = new Node(8);
        Node nod8 = new Node(9);
        Node nod9 = new Node(10);
        Node nod10 = new Node(11);
        Node nod11 = new Node(12);
        head.next=nod1;
        nod1.prev=head;
        nod1.next=nod2;
        nod2.prev=nod1;
        nod2.next=nod3;
        nod3.prev=nod2;
        nod3.next=nod4;
        nod4.prev=nod3;
        nod4.next=nod5;
        nod5.prev=nod4;



        nod2.child=nod6;
        nod6.next=nod7;
        nod7.prev=nod6;
        nod7.next=nod8;
        nod8.prev=nod7;
        nod8.next=nod9;
        nod9.prev=nod8;
        nod9.child=nod10;


        nod10.next=nod11;
        nod11.prev=nod10;
        Leecode430 leecode430 = new Leecode430();
        Node result = leecode430.flatten(head);
        while (result!=null){
            System.out.println(result.val);
            result=result.next;
        }
    }
}
