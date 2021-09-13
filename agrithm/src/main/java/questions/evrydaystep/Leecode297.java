package questions.evrydaystep;

import java.util.Arrays;
/**
 * 1011. 在 D 天内送达包裹的能力
 * 传送带上的包裹必须在 D 天内从一个港口运送到另一个港口。
 *
 * 传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。
 *
 * 返回能在 D 天内将传送带上的所有包裹送达的船的最低运载能力。
 *
 *
 *
 * 示例 1：
 *
 * 输入：weights = [1,2,3,4,5,6,7,8,9,10], D = 5
 * 输出：15
 * 解释：
 * 船舶最低载重 15 就能够在 5 天内送达所有包裹，如下所示：
 * 第 1 天：1, 2, 3, 4, 5
 * 第 2 天：6, 7
 * 第 3 天：8
 * 第 4 天：9
 * 第 5 天：10
 *
 * 请注意，货物必须按照给定的顺序装运，因此使用载重能力为 14 的船舶并将包装分成 (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) 是不允许的。
 * 示例 2：
 *
 * 输入：weights = [3,2,2,4,1,4], D = 3
 * 输出：6
 * 解释：
 * 船舶最低载重 6 就能够在 3 天内送达所有包裹，如下所示：
 * 第 1 天：3, 2
 * 第 2 天：2, 4
 * 第 3 天：1, 4
 * 示例 3：
 *
 * 输入：weights = [1,2,3,1,1], D = 4
 * 输出：3
 * 解释：
 * 第 1 天：1
 * 第 2 天：2
 * 第 3 天：3
 * 第 4 天：1, 1
 * */
public class Leecode297 {
    public int shipWithinDays(int[] weights, int D) {
        int left = Arrays.stream(weights).max().getAsInt();
        int right = Arrays.stream(weights).sum();
        for(int i=left;i<right;i++){
            if(shipWithinLimitDays(weights,D,i)){
                return i;
            }
        }
        return -1;
    }

    public int shipWithinDays_2(int[] weights, int D) {
        int left = Arrays.stream(weights).max().getAsInt();
        int right = Arrays.stream(weights).sum();
        while (left<right){
            int accumulateWeight=0;
            int mid = (right+left)/2;
            int accumulateDay=1;
            for(int j=0;j<weights.length;j++){
                //思路就是变量每一个箱子，如果当前累计大于了中间的mid
                //大小，说明需要重新在第二天开始运输，时间相应增加
                //如果发现该mid下需要的时间大于规定的时候，说明明天运输有点儿少
                //需要加大运输量，left=mid+1;
                //如果发现需要的时间比D少，说明每天运输有点儿多，需要减少每天的运输量，
                //如何减少？right=left.为什么这个时候没有right=mid-1.因为这个时候也有可能
                //已经找到了结果，是一种尝试性的想下寻找。所以不要用right=mid-1，会导致越过结果。
                //那为什么left的时候就可以不需思考就left=mid+1,因为这个时候已经说明时间超过了D
                //这个情况不会有结果了。
                if(accumulateWeight+weights[j]>mid){
                    accumulateDay++;
                    accumulateWeight=weights[j];
                }else {
                    accumulateWeight+=weights[j];
                }
            }
            if(accumulateDay>D){
                left=mid+1;
            }else {
                right=mid;
            }
        }
        return left;
    }

    private boolean shipWithinLimitDays(int[] weights, int d, int limitWeight) {
        int day=1;
        int singleWeight=0;
        for(int i=0;i<weights.length;i++){
            if(singleWeight+weights[i]>limitWeight){
                day++;
                singleWeight=weights[i];
            }else {
                singleWeight+=weights[i];
            }

            if(day>d){
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
    int[] weight=new int[]{3,2,2,4,1,4};
        Leecode297 leecode297 = new Leecode297();
        System.out.println(leecode297.shipWithinDays(weight,3));
        System.out.println(leecode297.shipWithinDays_2(weight,3));
    }
}
