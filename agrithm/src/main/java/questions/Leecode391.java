package questions;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.HashSet;
import java.util.Set;
//左下顶点是 (xi, yi) ，右上顶点是 (ai, bi) 。
public class Leecode391 {
    public boolean isRectangleCover(int[][] rectangles) {
        Set<Integer> set = new HashSet<>();
        //左下角
        int x1=Integer.MAX_VALUE;
        int y1 = Integer.MAX_VALUE;
        //右上角
        int a1 = Integer.MIN_VALUE;
        int a2= Integer.MIN_VALUE;
        int sumTotal=0;
        for(int[] rectangle:rectangles){
            int tempx1=rectangle[0];
            int tempy1 = rectangle[1];
            int tempa1 = rectangle[2];
            int tempa2 = rectangle[3];
            sumTotal+=(tempa1-tempx1)*(tempa2-tempy1);
            if(tempx1<x1 || tempy1<y1){
                x1=tempx1;
                y1=tempy1;
            }
            if(tempa1>a1 || tempa2>a2){
                a1=tempa1;
                a2=tempa2;
            }

            findPos(tempx1,tempy1,set);
            findPos(tempx1,tempa2,set);
            findPos(tempa1,tempy1,set);
            findPos(tempa1,tempa2,set);
        }
        if((a1-x1)*(a2-y1)!=sumTotal){
            return false;
        }

        return set.size()==4 && (set.contains(getKey(a1,a2)) && set.contains(getKey(a1,y1)) && set.contains(getKey(x1,y1)) && set.contains(getKey(x1,a2)));


    }

    private void findPos(int tempx1, int tempy1, Set<Integer> set) {
        if(set.contains(getKey(tempx1,tempy1))){
            set.remove(getKey(tempx1,tempy1));
        }else {
            set.add(getKey(tempx1,tempy1));
        }
    }
    private int getKey(int tempx1, int tempy1 ){
        return tempx1*100007+tempy1;
    }

    public static void main(String[] args) {
        int[][] rectangles = {{1,1,3,3},{3,1,4,2},{3,2,4,4},{1,3,2,4},{2,3,3,4}};
        int[][] a1={{1,1,3,3},{3,1,4,2},{1,3,2,4},{3,2,4,4}};
        Leecode391 leecode391 = new Leecode391();
        System.out.println(leecode391.isRectangleCover(a1));
    }

}
