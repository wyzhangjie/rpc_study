package questions.dpproblem;

public class Leecode152 {
    public int maxProduct(int[] nums) {
        int answer = nums[0];
        int max = nums[0];
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tempMax = max;
            int tempMin = min;
            max = Math.max(nums[i] * tempMax, Math.max(nums[i], nums[i] * tempMin));
            min = Math.min(nums[i] * tempMin, Math.min(nums[i], nums[i] * tempMax));
            answer = Math.max(max, answer);
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-1};
        Leecode152 leecode152 = new Leecode152();
        System.out.println(leecode152.maxProduct(nums));
    }
}
