package questions.evrydaystep;

public class Leecode34 {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        //怎么找到最后一个跟target相同的位置？
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }

        }
        int targetLeft = right;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid+1;

            } else {
                right= mid;
            }

        }
        int targetRight = right;
        int count = 0;
        for (int i = targetLeft; i <= targetRight; i++) {
            if (nums[i] == target) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        Leecode34 leecode34 = new Leecode34();
        System.out.println(leecode34.search(nums, 8));

    }
}
