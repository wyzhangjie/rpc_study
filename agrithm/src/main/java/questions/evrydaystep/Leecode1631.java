package questions.evrydaystep;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Leecode1631 {
    public int minimumEffortPath(int[][] heights) {
        int heng = heights.length;
        int shu = heights[0].length;
        int[][] result = new int[heng][shu];

        for(int i=0;i<heng;i++){
            for(int j=0;j<shu;j++){
                result[i][j] = Integer.MAX_VALUE;
                int left = Integer.MAX_VALUE;
                int right = Integer.MAX_VALUE;
                int top = Integer.MAX_VALUE;
                int bottom = Integer.MAX_VALUE;
                if(i-1>=0){
                    top = Math.abs(heights[i-1][j]-heights[i][j]);
                }
                if(i+1<heng){
                    bottom =  Math.abs(heights[i][j]-heights[i+1][j]);
                }
                if(j-1>0){
                    left = Math.abs(heights[i][j-1]-heights[i][j]);
                }
                if(j+1<shu){
                    right = Math.abs(heights[i][j]-heights[i][j+1]);
                }

                result[i][j] = Math.min(left,right);
                result[i][j] = Math.min(result[i][j],top);
                result[i][j] = Math.min(result[i][j],bottom);
            }
        }

        for(int i=0;i<heng;i++){
            for(int j=0;j<shu;j++){
                int left = Integer.MAX_VALUE;
                int right = Integer.MAX_VALUE;
                int top = Integer.MAX_VALUE;
                int bottom = Integer.MAX_VALUE;
                if(i-1>=0){
                    top = Math.abs(result[i-1][j]-result[i][j]);
                }
                if(i+1<heng){
                    bottom =  Math.abs(result[i][j]-result[i+1][j]);
                }
                if(j-1>0){
                    left = Math.abs(result[i][j-1]-result[i][j]);
                }
                if(j+1<shu){
                    right = Math.abs(result[i][j]-result[i][j+1]);
                }
                int smaller =left;
                if(bottom<smaller){
                    smaller = bottom;
                }
                if(left<smaller){
                    smaller = left;
                }
                if(right<smaller){
                    smaller = right;
                }

                result[i][j] = Math.max(smaller,result[i][j]);

            }
        }
        return  result[heng-1][shu-1];

    }

    public class Edge{
       public int begin;
       public int end;
       public int len;
    }

    public int minimumEffortPath1(int[][] heights) {
        //1将数组变成一个图
        List<Edge> tu = new ArrayList<>();
        int hengSize = heights.length;
        int shuSize = heights[0].length;
        for(int i=0;i<hengSize;i++){
            for(int j=0;j<shuSize;j++){

                if(i>0){
                    Edge edge = new Edge();
                    edge.begin =(i-1)*shuSize+j;
                    edge.end=i*shuSize+j;
                    edge.len=Math.abs(heights[i-1][j]-heights[i][j]);
                    tu.add(edge);
                }
                if(j>0){
                    Edge edge = new Edge();
                    edge.begin =i*shuSize+j-1;
                    edge.end=i*shuSize+j;
                    edge.len=Math.abs(heights[i][j-1]-heights[i][j]);
                    tu.add(edge);
                }

            }
        }
        //2、将图中的边按照从小到大排序
        tu.stream().sorted(Comparator.comparingInt(a -> a.len));

        //todo 3、按照并查集从小到大放入数据，直到头节点和尾节点放到了一个集合结束，最后一个放入的边长度就是那个最大值
        tu.forEach((a)-> System.out.println(JSON.toJSONString(a)));
        return -1;
    }
    public static void main(String[] args) {
        //[[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
        Leecode1631 leecode1631 =new Leecode1631();
       /* int[][] a= new int[][]{
                {1,2,1,1,1},
                {1,2,1,2,1},
                {1,2,1,2,1},
                {1,2,1,2,1},
                {1,1,1,2,1}
        };

        System.out.println(leecode1631.minimumEffortPath(a));
        //[[1,2,3],[3,8,4],[5,3,5]]
        a= new int[][]{
                {1,2,3},
                {3,8,4},
                {5,3,5},
        };
        System.out.println(leecode1631.minimumEffortPath(a));*/

        int[][] a= new int[][]{
                {1,2,2},
                {3,8,2},
                {5,3,5},
        };
        System.out.println(leecode1631.minimumEffortPath(a));
        leecode1631.minimumEffortPath1(a);
    }
    //[[1,2,2],[3,8,2],[5,3,5]]



}
