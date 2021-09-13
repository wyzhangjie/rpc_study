package questions.evrydaystep;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leecode1104 {
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> list = new ArrayList<>();
        int index = 1;
        int startIndex=1;
        while (startIndex*2<=label){
            index++;
            startIndex*=2;
        }
        if(index%2==0){
            label = getReversed(label,index);
        }

        while (index>=1){
            if(index%2==0){
                list.add(getReversed(label,index));
            }else {
                list.add(label);
            }

            index--;
            label=label/2;
        }
        Collections.reverse(list);
        return list;
    }
    private int getReversed(int label,int row){
        return (1<<row-1)+(1<<row)-1-label;
    }
    public List<Integer> pathInZigZagTree1(int label) {
        int row = 1, rowStart = 1;
        while (rowStart * 2 <= label) {
            row++;
            rowStart *= 2;
        }
        if (row % 2 == 0) {
            label = getReverse(label, row);
        }
        List<Integer> path = new ArrayList<Integer>();
        while (row > 0) {
            if (row % 2 == 0) {
                path.add(getReverse(label, row));
            } else {
                path.add(label);
            }
            row--;
            label >>= 1;
        }
        Collections.reverse(path);
        return path;
    }

    public int getReverse(int label, int row) {
        return (1 << row - 1) + (1 << row) - 1 - label;
    }





    public static void main(String[] args) {
        Leecode1104 leecode1104 = new Leecode1104();
        System.out.println(leecode1104.pathInZigZagTree(14));
        System.out.println(leecode1104.pathInZigZagTree1(14));
    }
}
