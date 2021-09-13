package questions.evrydaystep;
/**
 * 1442. 形成两个异或相等数组的三元组数目
 * 给你一个整数数组 arr 。
 *
 * 现需要从数组中取三个下标 i、j 和 k ，其中 (0 <= i < j <= k < arr.length) 。
 *
 * a 和 b 定义如下：
 *
 * a = arr[i] ^ arr[i + 1] ^ ... ^ arr[j - 1]
 * b = arr[j] ^ arr[j + 1] ^ ... ^ arr[k]
 * 注意：^ 表示 按位异或 操作。
 *
 * 请返回能够令 a == b 成立的三元组 (i, j , k) 的数目。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [2,3,1,6,7]
 * 输出：4
 * 解释：满足题意的三元组分别是 (0,1,2), (0,2,2), (2,3,4) 以及 (2,4,4)
 * 示例 2：
 *
 * 输入：arr = [1,1,1,1,1]
 * 输出：10
 * 示例 3：
 *
 * 输入：arr = [2,3]
 * 输出：0
 * 示例 4：
 *
 * 输入：arr = [1,3,5,7,9]
 * 输出：3
 * 示例 5：
 *
 * 输入：arr = [7,11,12,9,5,2,7,17,22]
 * 输出：8
 * */
public class Leecode1442 {

    public int countTriplets1(int[] arr) {
        int n = arr.length;
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) sum[i] = sum[i - 1] ^ arr[i - 1];
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                for (int k = j; k <= n; k++) {
                    int a = sum[j - 1] ^ sum[i - 1];
                    int b = sum[k] ^ sum[j - 1];
                    if (a == b) ans++;
                }
            }
        }
        return ans;
    }

    public int countTriplets(int[] arr) {
        int result=0;
        int[] preXor = new int[arr.length+1];
        for(int i=1;i<=arr.length;i++){
            preXor[i]=preXor[i-1]^arr[i-1];
        }
        for(int i=1;i<=arr.length;i++){
            for(int j=i+1;j<=arr.length;j++){
                for(int k=j;k<=arr.length;k++){
                    int a = preXor[i-1]^preXor[j-1];
                    int b= preXor[k]^preXor[j-1];
                    if(a==b){
                        result++;
                    }
                }


            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr= new int[]{2,3,1,6,7};
        Leecode1442 leecode1442 = new Leecode1442();
        System.out.println(leecode1442.countTriplets(arr));
        System.out.println(leecode1442.countTriplets1(arr));
    }
}
