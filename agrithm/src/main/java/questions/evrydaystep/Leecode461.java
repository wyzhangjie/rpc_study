package questions.evrydaystep;
/**
 * 461. 汉明距离
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 *
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 *
 * 注意：
 * 0 ≤ x, y < 231.
 *
 * 示例:
 *
 * 输入: x = 1, y = 4
 *
 * 输出: 2
 *
 * 解释:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 *
 * 上面的箭头指出了对应二进制位不同的位置。
 * 通过次数124,772提交次数155,593
 * */
public class Leecode461 {
    public int hammingDistance(int x, int y) {
        int s = x^y;
        int result=0;
        while (s!=0){
           result+= s&1;
           s>>=1;
        }
        return result;
    }
    public int hammingDistance2(int x, int y) {
        int s = x^y;
        int result=0;
        while (s!=0){
            s=s&(s-1);
            result++;
        }
        return result;
    }

    public static void main(String[] args) {
        int x = 1;
        int y = 4;
        Leecode461 h = new Leecode461();
        System.out.println(h.hammingDistance(x,y));
        System.out.println(h.hammingDistance2(x,y));
    }
}
