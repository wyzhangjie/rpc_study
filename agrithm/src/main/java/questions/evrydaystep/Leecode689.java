package questions.evrydaystep;

public class Leecode689 {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        if(nums == null || nums.length == 0) return null;
        int len = nums.length;

        int[] left = new int[len];
        int[] right = new int[len];

        int[] sum = new int[len + 1]; // 前缀和， 第一项为0
        for(int i = 0; i < len; i++){
            sum[i+1] = sum[i] + nums[i];
        }

        // 从左向右扫描
        int leftMax = sum[k]-sum[0]; // 前缀和， 第一项sum[0]为0
        left[k-1] = 0;
        for (int i=k; i<len; i++) {
            if (sum[i+1] - sum[i+1-k] > leftMax) { // 区间大小为k
                left[i] = i-k+1; // 更新左index
                leftMax = sum[i+1] - sum[i+1-k];// 更新最大值
            } else {
                left[i] = left[i-1];
            }
        }

        // 从右向左扫描
        int rightMax = sum[len] - sum[len-k]; // 右边最大index是len , 最大的左index 是 len - k
        right[len-k] = len-k;
        for (int i=len-k-1; i>=0; i--) {
            if (sum[i+k] - sum[i] >= rightMax) {
                right[i] = i;
                rightMax = sum[i+k] - sum[i];
            } else {
                right[i] = right[i+1];
            }
        }

        // 中间部分 区间范围 k<=i<=n-2k
        int[] res = new int[3];
        int max = 0;
        for (int i=k; i<=len-2*k; i++) {
            int l = left[i-1];
            int r = right[i+k];
            int total = (sum[l+k] - sum[l]) + (sum[i+k] - sum[i]) + (sum[r+k] - sum[r]);
            if (total > max) {
                max = total;
                res[0] = l;
                res[1] = i;
                res[2] = r;
            }
        }
        return res;

    }

}
