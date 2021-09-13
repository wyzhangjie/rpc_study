package questions.evrydaystep;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 295. 数据流的中位数
 * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 * <p>
 * 例如，
 * <p>
 * [2,3,4] 的中位数是 3
 * <p>
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 * <p>
 * 设计一个支持以下两种操作的数据结构：
 * <p>
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * 示例：
 * <p>
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 * 进阶:
 * <p>
 * 如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？
 * 如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？
 * 通过次数48,592提交次数93,149
 */
public class Leecode295 {
    //大顶堆
    PriorityQueue<Integer> minStack;
    //小顶堆
    PriorityQueue<Integer> maxStack;


    public Leecode295() {
        minStack = new PriorityQueue<>((a, b) -> b - a);
        maxStack = new PriorityQueue<>((a, b) -> a - b);
    }

    public void addNum(int num) {
        if (minStack.size() == 0) {
            minStack.add(num);
            return;
        }
        if (num < minStack.peek()) {
            minStack.offer(num);
            if(minStack.size()>maxStack.size()+1){
                maxStack.offer(minStack.poll());
            }


        } else {
            maxStack.offer(num);
            if (maxStack.size() > minStack.size()) {
                minStack.offer(maxStack.poll());
            }

        }

    }

    public double findMedian() {
        if (minStack.size() > maxStack.size()) {
            return (double) minStack.peek();

        }
        return (double) (minStack.peek() + maxStack.peek()) / 2;
    }

    public static void main(String[] args) {
        Leecode295 leecode295 = new Leecode295();
        leecode295.addNum(-1);
        leecode295.addNum(-2);
     /*   leecode295.addNum(-3);
        leecode295.addNum(-4);*/
        System.out.println(leecode295.findMedian());
    }
}
