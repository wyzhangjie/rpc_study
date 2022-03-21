package questions.evrydaystep;

import java.util.*;

/**
 * 2013. 检测正方形
 * 给你一个在 X-Y 平面上的点构成的数据流。设计一个满足下述要求的算法：
 * <p>
 * 添加 一个在数据流中的新点到某个数据结构中。可以添加 重复 的点，并会视作不同的点进行处理。
 * 给你一个查询点，请你从数据结构中选出三个点，使这三个点和查询点一同构成一个 面积为正 的 轴对齐正方形 ，统计 满足该要求的方案数目。
 * 轴对齐正方形 是一个正方形，除四条边长度相同外，还满足每条边都与 x-轴 或 y-轴 平行或垂直。
 * <p>
 * 实现 Leecode2013 类：
 * <p>
 * Leecode2013() 使用空数据结构初始化对象
 * void add(int[] point) 向数据结构添加一个新的点 point = [x, y]
 * int count(int[] point) 统计按上述方式与点 point = [x, y] 共同构造 轴对齐正方形 的方案数。
 * <p>
 * point.length == 2
 * 0 <= x, y <= 1000
 * 调用 add 和 count 的 总次数 最多为 5000
 */
public class Leecode2013 {
    //存放各个节点。
    Map<Integer, Integer> map;
    int index = 10000;

    public Leecode2013() {
        map = new HashMap<>();
    }

    public void add(int[] point) {
        int key = point[0] * index + point[1];
        map.put(key, map.getOrDefault(key, 0) + 1);

    }

    public int count(int[] point) {
       // int count = map.get(point[0] * index + point[1])==null?1:map.get(point[0] * index + point[1]);
        int singelNum = getSingelNum(point);
        return  singelNum;
    }

    private int getSingelNum(int[] point) {
        //存放符合条件的所有跟point[0]相同的节点
        List<int[]> sameX =new ArrayList<>();
        //存放符合条件的所有跟point[1]相同的节点
        List<int[]> sameY = new ArrayList<>();

      Set<Integer> xs=  map.keySet();
      for(Integer aa:xs){
          //排除跟point重合的点
          if(aa!=(point[0] * index + point[1])){
              if(aa/index==point[0]){
                  sameX.add(new int[]{aa/index,aa%index});
              }
              if(aa%index==point[1]){
                  sameY.add(new int[]{aa/index,aa%index});
              }
          }
      }
      int count=0;
      for(int[] x:sameX){
          for(int[] y:sameY){
             if(map.get(y[0]*index+x[1])!=null){
                 //排除不能形成正方形的那些形成长方形的点。
                 if(Math.abs(y[0]-x[0])==Math.abs(y[1]-x[1])){
                     count+=(map.get(y[0]*index+x[1]))*(map.get(x[0]*index+ x[1]))*(map.get(y[0]*index+y[1]));
                 }

             }
          }
      }
      return count;

    }

    public static void main(String[] args) {
        //[[5,10]],[[10,5]],[[10,10]],[[5,5]],
        //[[3,0]],[[8,0]],[[8,5]],[[3,5]]
        //[[9,0]],[[9,8]],[[1,8]],[[1,0]]
        //[[0,0]],[[8,0]],[[8,8]],[[0,8]],
        Leecode2013 Leecode2013 = new Leecode2013();
        Leecode2013.add(new int[]{5, 10});
        Leecode2013.add(new int[]{10, 5});
        Leecode2013.add(new int[]{10, 10});
        System.out.println( Leecode2013.count(new int[] {5, 5}));  // 返回 0 。查询点无法与数据结构中的这些点构成正方形。
        Leecode2013.add(new int[] {3, 0});    // 允许添加重复的点。
        Leecode2013.add(new int[] {8, 0});
        Leecode2013.add(new int[] {8, 5});
        System.out.println(Leecode2013.count(new int[]{3, 5})); // 返回 2 。你可以选择：

        Leecode2013.add(new int[] {9, 0});    // 允许添加重复的点。
        Leecode2013.add(new int[] {9, 8});
        Leecode2013.add(new int[] {1, 8});
        System.out.println(Leecode2013.count(new int[]{1, 0}));

        Leecode2013.add(new int[] {0, 0});    // 允许添加重复的点。
        Leecode2013.add(new int[] {8, 0});
        Leecode2013.add(new int[] {8, 8});
        System.out.println(Leecode2013.count(new int[]{0, 8}));

    }

}
