package questions.evrydaystep;

import java.util.*;
/**
 * 示例：
 *
 * 给出 nums = [1,3,-1,-3,5,3,6,7]，以及 k = 3。
 *
 * 窗口位置                      中位数
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       1
 *  1 [3  -1  -3] 5  3  6  7      -1
 *  1  3 [-1  -3  5] 3  6  7      -1
 *  1  3  -1 [-3  5  3] 6  7       3
 *  1  3  -1  -3 [5  3  6] 7       5
 *  1  3  -1  -3  5 [3  6  7]      6
 *  因此，返回该滑动窗口的中位数数组 [1,-1,-1,3,5,6]。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sliding-window-median
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class Leecode480 {
    PriorityQueue<Integer> large = new PriorityQueue(Comparator.reverseOrder());
    PriorityQueue<Integer> small = new PriorityQueue();
    public double[] medianSlidingWindow(int[] nums, int k) {
        //第一步维护两个堆，一个大顶堆，一个小顶堆。
        //大顶堆里面放的是小数据，那么头的数据是最大的。小顶堆放的是大数据，那么头数据放的是最小的
        //如果能够保持大顶堆的数据要么跟小顶堆数据长度相同，要么比小顶堆的小一个，那么如果是k是基数
        //的时候，那么去小顶堆的数据就可以了，如果k是偶数，那么直接取两个堆的头数据的平均数即可。
        int numsLen = nums.length;

        int left=0;
        int right=0;
        double[] result = new double[numsLen-k+1];
        int cursor=0;
        while(right<k){
            //放置工具维护大小堆
            putNum(nums[right]);

            right++;
        }
        //获取中间数据放置结果集中
        double tmp = getMid(k);
        result[cursor++]= tmp;

        //放弃左面的数据，新加入右面的数据
        while(right<numsLen){
            del(nums[left]);
            left++;

            putNum(nums[right]);
            tmp = getMid(k);
            result[cursor++]= tmp;
            right++;

        }
        return result;
    }

    private double getMid(int k) {
        double result =0;
        if(k%2==0){
            result = ((double)large.peek()+(double)small.peek())/2L;
        }else {
            result= large.peek();
        }
        return result;
    }

    private void del(int num) {
        if(small.contains(num)){
            small.remove(num);
            resumeBalance();
            return;
        }
        if(large.contains(num)){
            large.remove(num);
            resumeBalance();
            return;
        }

    }

    private void putNum(int num) {
        //首先放置到可以多的小顶堆
        large.add(num);
        resumeBalance();

    }

    private void resumeBalance() {
        if(small.size()>0 && large.size()>0 && large.peek()> small.peek()){
            Integer  temp =large.peek();
            small.add(temp);
            large.remove(temp);
        }
        if(large.size()-small.size()>1){
            Integer  temp =large.peek();
            small.add(temp);
            large.remove(temp);
        }
        if(small.size()-large.size()>0){
            Integer  temp =small.peek();
            large.add(temp);
            small.remove(temp);
        }
    }

    public static void main(String[] args) {
        //[1,3,-1,-3,5,3,6,7]
        //[1.00000,-1.00000,-1.00000,3.00000,5.00000,6.00000]
        int[] a = new int[]{1,3,-1,-3,5,3,6,7};
        Leecode480 leecode480 = new Leecode480();
        double[] result = leecode480.medianSlidingWindow(a,3);
        int len = result.length;
        for(int i=0;i<len;i++){
            System.out.println(result[i]);
        }
    }

}



