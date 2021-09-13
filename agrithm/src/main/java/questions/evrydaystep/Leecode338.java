package questions.evrydaystep;
/**
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 *
 * 示例 1:
 *
 * 输入: 2
 * 输出: [0,1,1]
 * 示例 2:
 *
 * 输入: 5
 * 输出: [0,1,1,2,1,2]
 * 进阶:
 *
 * 给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？
 * 要求算法的空间复杂度为O(n)。
 * 你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作。
 * 通过次数83,723提交次数107,525
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/counting-bits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class Leecode338 {
    public int[] countBitsWay1(int num) {
        int[] bitNum = new int[num+1];
        for(int i=0;i<=num;i++){
            bitNum[i]=  getBit(i);
        }
            return bitNum;
    }

    private int getBit(int i) {
        int count=0;
        while (i>0){
            i&=(i-1);
            count++;
        }
        return count;

    }

    public int[] countBitsWay2(int num) {
        int[] bitNum = new int[num+1];
        int hightPos=0;
        for(int i=1;i<=num;i++){

            if((i&(i-1))==0){
                hightPos=i;
            }
            bitNum[i]=bitNum[i-hightPos]+1;
        }
        return bitNum;
    }
    public int[] countBitsWay3(int num) {
        int[] bitNum = new int[num+1];
        bitNum[0]=0;
        for(int i=1;i<=num;i++){
            //偶数
            if((i&1)==0){
                bitNum[i]=bitNum[i/2];
            }else {
                bitNum[i]=bitNum[i-1]+1;
            }

        }
        return bitNum;
    }
    public static void main(String[] args) {
        int num =5;
        Leecode338 leecode338 =new Leecode338();
        int[] result = leecode338.countBitsWay1(num);
        leecode338.print(result);
        System.out.println("==========");
         result = leecode338.countBitsWay2(num);
        leecode338.print(result);
    }
    public void print(int[] a){
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }
}
