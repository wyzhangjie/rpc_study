package questions.evrydaystep;

public class Leecode747 {
    public int dominantIndex(int[] nums) {
        int max = Integer.MIN_VALUE;
        int subMax = Integer.MIN_VALUE;
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                subMax =max;
                max = nums[i];

                index = i;
            } else {
                if (subMax < nums[i]) {
                    subMax = nums[i];
                }
            }


        }
        return max >= subMax * 2 ? index : -1;
    }

    public static void main(String[] args) {
        int[] nums = {3,6,1,0};
        Leecode747 leecode747 = new Leecode747();
        System.out.println(leecode747.dominantIndex(nums));
    }

}
