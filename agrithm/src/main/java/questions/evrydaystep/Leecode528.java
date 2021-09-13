package questions.evrydaystep;

public class Leecode528 {
    int[] preSum;

    /**
     * 执行用时：
     * 445 ms
     * , 在所有 Java 提交中击败了
     * 5.22%
     * 的用户
     * 内存消耗：
     * 45 MB
     * , 在所有 Java 提交中击败了
     * 5.11%
     * 的用户
     */
    public Leecode528(int[] w) {
        int[] preSum1 = new int[w.length];
        preSum1[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            preSum1[i] = preSum1[i - 1] + w[i];
        }
        preSum=preSum1;
    }


    public int pickIndex() {

        int total = preSum[preSum.length-1];
        int x = (int) (Math.random() * total) + 1;
        return binarySearch(x);
    }

    private int binarySearch(int x) {
        int left=0;
        int right=preSum.length-1;

        while (left<right){
            int mid=left+(right-left)/2;
            if(preSum[mid]<x){
                left=mid+1;
            }else {
                right=mid;
            }
        }
        return left;
    }


    //前缀和+二分法，把这道题变得好高大上啊，普通算法虽然没超时，但是结果堪忧

    public static void main(String[] args) {
        int[] w = new int[]{3, 14, 1, 7};
        Leecode528 leecode528 = new Leecode528(w);
        System.out.println(leecode528.pickIndex());
        System.out.println(leecode528.pickIndex());
        System.out.println(leecode528.pickIndex());
        System.out.println(leecode528.pickIndex());
        System.out.println(leecode528.pickIndex());
        System.out.println(leecode528.pickIndex());
    }
}
