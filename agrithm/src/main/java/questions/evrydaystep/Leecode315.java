package questions.evrydaystep;

/**
 * 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 * <p>
 * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
 * <p>
 * 每个孩子至少分配到 1 个糖果。
 * 相邻的孩子中，评分高的孩子必须获得更多的糖果。
 * 那么这样下来，老师至少需要准备多少颗糖果呢？
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,0,2]
 * 输出: 5
 * 解释: 你可以分别给这三个孩子分发 2、1、2 颗糖果。
 * 示例 2:
 * <p>
 * 输入: [1,2,2]
 * 输出: 4
 * 解释: 你可以分别给这三个孩子分发 1、2、1 颗糖果。
 * 第三个孩子只得到 1 颗糖果，这已满足上述两个条件。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/candy
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * 题后感：读懂题太重要了，我只读出来后面的比前面的分数高，则给的糖更多，根本没有读出来，后面的的比前面的分数高，前面的分数糖数一定比后面的多
 * 如果只想着前面，那面会导致 19 2这样的两个孩子得到的糖都是一致的，不符合题意。【相邻的孩子中，评分高的孩子必须获得更多的糖果！！！！！！！！】
 *
 * */
public class Leecode315 {

    public int candy(int[] ratings) {
        int len = ratings.length;
        int candy = len;
        int first = 1;
        for (int i = 1; i < len; i++) {
            if (ratings[i] < ratings[i - 1] && first == 1) {
                first = 0;
                candy++;
            }
            if (ratings[i] == ratings[i - 1]) {
            }
            if (ratings[i] > ratings[i - 1]) {
                candy++;
            }
        }
        return candy;
    }

    public int candy1(int[] ratings) {
        int len = ratings.length;
        int[] candies = new int[len];
        for (int i = 0; i < candies.length; i++) {
            candies[i] = 1;
        }
        if (len <= 1) {
            return 1;
        }
        int total = 0;
        for (int i = 1; i < len; i++) {
            if (ratings[i] < ratings[i - 1] && (i-1) == 0) {
                candies[i - 1]++;
            }
            if (ratings[i] == ratings[i - 1]) {
            }
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        int right=0;
        for (int i=len-1;i>=0;i--){
            if(i<len-1 && ratings[i]>ratings[i+1]){
                right++;
            }else {
                right=1;
            }
            candies[i]=Math.max(candies[i],right);
        }
        for (int i = 0; i < len; i++) {
            total += candies[i];
        }
        return total;

    }

    public static void main(String[] args) {
        //[1,3,2,2,1]
       Leecode315 leecode315 = new Leecode315();
        int[] a = new int[]{1, 0, 2};
       /*  System.out.println(leecode315.candy1(a));
        assert leecode315.candy1(a) == 5;
        a = new int[]{1, 2, 2};
        System.out.println(leecode315.candy(a));
        assert leecode315.candy(a) == 4;
        a = new int[]{1, 3, 2, 2, 1};
        System.out.println(leecode315.candy1(a));*/
        //[1,2,87,87,87,2,1] 13
        a = new int[]{1,2,87,87,87,2,1};
        System.out.println(leecode315.candy1(a));


    }

}
