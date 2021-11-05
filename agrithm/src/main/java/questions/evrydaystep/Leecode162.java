package questions.evrydaystep;

public class Leecode162 {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }


        if (n == 2) {
            if (nums[0] < nums[1]) {
                return 1;
            } else {
                return -1;
            }
        }
        if (nums[0] > nums[1]) {
            return 0;
        }
        if(nums[n-1]>nums[n-2]){
            return n-1;
        }
        int begin = 1;
        int end = n - 2;
        while (begin <= end) {
            int mid = begin + (end - begin) / 2;
            if (nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            if (nums[mid] < nums[mid + 1]) {
                begin = mid + 1;
            }
            if (nums[mid] > nums[mid + 1]) {
                end = mid - 1;
            }
        }

        return -1;

    }

    public static void main(String[] args) {
        Leecode162 leecode162 = new Leecode162();
        int[] nums = new int[]{1, 2, 0, 1,2};
        System.out.println(leecode162.findPeakElement(nums));
    }
}
