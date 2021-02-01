package questions.other;

import java.util.ArrayList;
import java.util.List;

public class Leecode54 {

    public static void main(String[] args) {
        int[][] a={{1,2,3},{4,5,6},{7,8,9}};
        getRow(a);
    }

    private static void getRow(int[][] a) {
        List<Integer> result = new ArrayList<>();
        int left=0;
        int right= a[0].length-1;
        int top =0;
        int bottom =a.length-1;
        while (left<=right && top<=bottom){
            for(int column=left;column<=right;column++){
                result.add(a[top][column]);
            }
            for(int column=top+1;column<=bottom;column++){
                result.add(a[column][right]);
            }
            if(right>=left){
                for(int column=right-1;column>left;column--){
                    result.add(a[bottom][column]);
                }
            }
            if(bottom>=top){
                for(int column=bottom-1;column>top;column--){
                    result.add(a[column][left]);
                }
            }
            left++;
            top++;
            right--;
            bottom--;
        }
        result.stream().forEach((b)->{
            System.out.println(b);
        });

    }

}
