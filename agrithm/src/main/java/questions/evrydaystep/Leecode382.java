package questions.evrydaystep;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Leecode382 {
    int n=0;
    Random random;
    List<Integer> list = new ArrayList<>();
    public Leecode382(ListNode<Integer> head) {
        random =new Random();
        ListNode<Integer>  temp = head;
        while (temp!=null){
            n++;
            list.add(temp.data);
            temp=temp.next;
        }
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));

    }

    public static void main(String[] args) {

    }
}
