package questions.evrydaystep;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 给你一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点。求最多有多少个点在同一条直线上。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：points = [[1,1],[2,2],[3,3]]
 * 输出：3
 * 示例 2：
 * <p>
 * <p>
 * 输入：points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * 输出：4
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= points.length <= 300
 * points[i].length == 2
 * -104 <= xi, yi <= 104
 * points 中的所有点 互不相同
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-points-on-a-line
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leecode149 {
    public int maxPoints(int[][] points) {
        int len = points.length;
        if(len<2){
            return len;
        }
        int rest=0;

        for (int i = 0; i < len; i++) {
            //剪枝
            if(rest>len/2 || rest>=len-i){
                break;
            }
            Map<Integer, Integer> map = new HashMap<>();
           for(int j=i+1;j<len;j++){
            int x=points[i][0]-points[j][0];
            int y=points[i][1]-points[j][1];
            if(x==0){
                y=1;
            }
            if(y==0){
                x=1;
            }else {
                if(y<0){
                    x=-x;
                    y=-y;
                }
                int gcdXY =gcd(Math.abs(x),Math.abs(y));
                x/=gcdXY;
                y/=gcdXY;
            }
            int k= y+x*20001;
            map.put(k,map.getOrDefault(k,0)+1);

           }
           int max=0;
           for(Map.Entry<Integer,Integer> entry:map.entrySet()){
               int num = entry.getValue();
               max=Math.max(num+1,max);
           }
           rest=Math.max(rest,max);
        }
        return rest;
    }

    /**
     * 求a ,b最大公约数
     * */
    public int gcd(int a,int b){
        return b!=0?gcd(b,a%b):a;
    }


    public static void main(String[] args) {
        int[][] points = new int[][]{{1, 1}, {2,2}, {3, 3}};
        Leecode149 leecode149 = new Leecode149();
        System.out.println(leecode149.maxPoints(points));
    }

}

