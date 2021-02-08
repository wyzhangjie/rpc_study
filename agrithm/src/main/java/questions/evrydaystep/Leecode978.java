package questions.evrydaystep;

/**
 * 当 A 的子数组 A[i], A[i+1], ..., A[j] 满足下列条件时，我们称其为湍流子数组：
 * <p>
 * 若 i <= k < j，当 k 为奇数时， A[k] > A[k+1]，且当 k 为偶数时，A[k] < A[k+1]；
 * 或 若 i <= k < j，当 k 为偶数时，A[k] > A[k+1] ，且当 k 为奇数时， A[k] < A[k+1]。
 * 也就是说，如果比较符号在子数组中的每个相邻元素对之间翻转，则该子数组是湍流子数组。
 * <p>
 * 返回 A 的最大湍流子数组的长度。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[9,4,2,10,7,8,8,1,9]
 * 输出：5
 * 解释：(A[1] > A[2] < A[3] > A[4] < A[5])
 * 示例 2：
 * <p>
 * 输入：[4,8,12,16]
 * 输出：2
 * 示例 3：
 * <p>
 * 输入：[100]
 * 输出：1
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 40000
 * 0 <= A[i] <= 10^9
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-turbulent-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leecode978 {
    /**
     * 执行用时：
     * 20 ms
     * , 在所有 Java 提交中击败了
     * 5.96%
     * 的用户
     * 内存消耗：
     * 44.1 MB
     * , 在所有 Java 提交中击败了
     * 22.85%
     * 的用户
     * */
    public int maxTurbulenceSize(int[] arr) {
        int len = arr.length;
        int[][] temp = new int[len][2];
        //0表示升的次数 1表示降的次数
        temp[0][0] = 1;
        temp[0][1] = 1;
        int max = 0;

        for (int i = 1; i < len; i++) {
            if (arr[i] > arr[i - 1]) {
                temp[i][0]=temp[i-1][1]+1;
                temp[i][1]=1;
            }
            if (arr[i] < arr[i - 1]) {
                temp[i][1]=temp[i-1][0]+1;
                temp[i][0]=1;
            }
            if (arr[i] == arr[i - 1]) {
                temp[i][0] = 1;
                temp[i][1] = 1;
            }
        }
        max = findMax(temp);
        return max;

    }
/**
 * 执行用时：
 * 8 ms
 * , 在所有 Java 提交中击败了
 * 34.69%
 * 的用户
 * 内存消耗：
 * 41.8 MB
 * , 在所有 Java 提交中击败了
 * 69.43%
 * 的用户
 * */
    public int maxTurbulenceSizeAA(int[] arr) {
        int len = arr.length;
        int pos0=1;
        int pos1=1;
        int max = 1;

        for (int i = 1; i < len; i++) {
            if (arr[i] > arr[i - 1]) {
                pos0=pos1+1;
                pos1=1;

            }
            if (arr[i] < arr[i - 1]) {
                pos1=pos0+1;
                pos0=1;

            }
            if (arr[i] == arr[i - 1]) {
                pos0=1;
                pos1=1;
            }
            int temp = Math.max(pos0,pos1);
            max = Math.max(temp,max);
        }

        return max;

    }

    private int findMax(int[][] temp) {
        int len = temp.length;
        int max=0;
        for(int i=0;i<len;i++){
            int first =temp[i][0];
            int second =temp[i][1];
            int a = Math.max(first,second);
            max=Math.max(max,a);
        }
        return max;
    }

    public static void main(String[] args) {
        //[0,1,1,0,1,0,1,1,0,0]  {4,8,12,16}
        //[9,4,2,10,7,8,8,1,9]
     //   int[] a = new int[]{9,4,2,10,7,8,8,1,9};
        int[] a = new int[]{100};
        Leecode978 leecode978 = new Leecode978();
        System.out.println(leecode978.maxTurbulenceSizeAA(a));
    }
}
