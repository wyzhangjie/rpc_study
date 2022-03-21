package questions.evrydaystep;/**
 * ClassName Leecode1001
 * Description
 * Create by jie.zhang02
 * Date 2022/2/8 5:09 下午
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author jie.zhang
 * @date 2022年02月08日 5:09 下午
 */
public class Leecode1001 {
    //{{0,0},{0,-1},{0,1},{-1,0},{-1,-1},{-1,1},{1,0},{1,-1},{1,1}};
    int[][] directions= new int[][]{{0,0},{0,1},{0,-1},{-1,-1},{1,0},{-1,1},{0,1},{1,0}};

    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        int[] ans = new int[queries.length];
        long N=n;
        Set<Long> set = new HashSet<>();
        Map<Integer,Integer> top= new HashMap<>(16);
        Map<Integer,Integer> buttom= new HashMap<>(16);
        Map<Integer,Integer> left = new HashMap<>(16);
        Map<Integer,Integer> right = new HashMap<>(16);
        //将有光亮的坐标轴投影线放上数据
        for(int[] lamp:lamps){
            int x= lamp[0];
            int y = lamp[1];
            int xl=x-y;
            int xr=x+y;
            if(set.contains(x*N+y)){
                continue;
            }
            set.add(x*N+y);
            top.put(x,top.getOrDefault(x,0)+1);
            buttom.put(y,buttom.getOrDefault(y,0)+1);
            left.put(xl,left.getOrDefault(xl,0)+1);
            right.put(xr,right.getOrDefault(xr,0)+1);
        }
        for(int i=0;i< queries.length;i++){
            int[] query = queries[i];
            int x=query[0];
            int y= query[1];
            int xl=x-y;
            int xr=x+y;
            if(top.containsKey(x) || buttom.containsKey(y)|| left.containsKey(xl) || right.containsKey(xr)){
                ans[i]=1;
            }
            for(int[] direct:directions){
                int a = x+direct[0];
                int b= x+direct[1];
                int c= a-b;
                int d=a+b;
                if(a<0 || a>=n || b<0 || b>=n) {
                    continue;
                }
                if(set.contains(a*N+b)){
                    set.remove(a*N+b);
                    top.remove(a);
                    buttom.remove(b);
                    left.remove(c);
                    right.remove(d);
                }
            }
        }
        return ans;

    }

    public static void main(String[] args) {
       // n = 5, lamps = [[0,0],[4,4]], queries = [[1,1],[1,1]]
        int n=5;
        int[][] lamps={{0,0},{4,4}};
        int[][] queries = {{1,1},{1,1}};
        Leecode1001 leecode1001 = new Leecode1001();
        int[] ans = leecode1001.gridIllumination(n,lamps,queries);
        for(int a:ans){
            System.out.println(a);
        }
    }
}
