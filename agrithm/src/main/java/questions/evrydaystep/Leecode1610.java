package questions.evrydaystep;

import java.util.*;

/**
 * 1)角度转换为弧度公式： 弧度 = 角度÷180×π
 * 2) 弧度转换为角度公式： 角度 = 弧度×180÷π
 */
public class Leecode1610 {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        //计算各个节点之间和初始点之间的弧度制，并进入到list当中
        int posX = location.get(0);
        int posY = location.get(1);
        List<Double> list = new LinkedList<>();
        int same = 0;

        for (List<Integer> point : points) {
            if (point.get(0) == posX && point.get(1) == posY) {
                same++;
            } else {
                //计算弧度制的角度
                list.add(Math.atan2(point.get(1) - posY, point.get(0) - posX));
            }

        }
        //从小到大排序
        Collections.sort(list);
        //每个点转360度(相当于把-40 变成340度，所有的都变成正值了)
        int size = list.size();
        for (int i=0;i<size;i++) {
            list.add(list.get(i) + 2 * Math.PI);
        }
        double angleDegree = angle * Math.PI / 180;
        int max = 0;
        int i = 0, j = 0;
        while (i < size) {
            // 滑动窗口，简单点，list是有序的，使用二分查找也是可以的
            while (j < list.size() && list.get(j) - list.get(i) <= angleDegree) {
                j++;
            }
            max = Math.max(max, j - i);
            i++;
        }
        return max + same;


    }

    public int visiblePoints1(List<List<Integer>> points, int angle, List<Integer> location) {
        // 算出每一个坐标相对于location位置与x轴的夹角（弧度制），扔到List中排序
        // 然后对于每一个点，使用二分或滑动窗口找出小于这个点+angle（转成弧度制）的最大坐标点
        // 两者之间的下标差就是从这个点出发，辐射angle角度的点数量
        // 注意，与location点相同的点的特殊处理

        int same = 0;
        List<Double> list = new ArrayList<>();
        int x = location.get(0), y = location.get(1);
        for (List<Integer> point : points) {
            int a = point.get(0), b = point.get(1);
            if (a == x && b == y) {
                // 与location同点
                same++;
            } else {
                // 计算角度（弧度制）
                list.add(Math.atan2(b - y, a - x));
            }
        }

        // 排序
        Collections.sort(list);

        // 把前面所有的数添加一遍到后面，类似于于循环数组的使用
        int size = list.size();
        for (int i = 0; i < size; i++) {
            // 加 360度，然后范围相当于变成了 [-pi, 3*pi]
            list.add(list.get(i) + 2 * Math.PI);
        }

        double angleDegree = angle * Math.PI / 180;
        int max = 0;
        int i = 0, j = 0;
        while (i < size) {
            // 滑动窗口，简单点，list是有序的，使用二分查找也是可以的
            while (j < 2 * size && list.get(j) - list.get(i) <= angleDegree) {
                j++;
            }
            max = Math.max(max, j - i);
            i++;
        }

        return max + same;
    }
}
