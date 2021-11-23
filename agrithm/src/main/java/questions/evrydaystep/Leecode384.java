package questions.evrydaystep;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.Random;

public class Leecode384 {
    int[] orginNums;
    int[] nums;
    public Leecode384(int[] nums) {
        this.nums=nums;
        orginNums = Arrays.copyOf(nums,nums.length);
    }

    public int[] reset() {
        nums= Arrays.copyOf(orginNums,orginNums.length);
        return nums;
    }

    public int[] shuffle() {
        Random random = new Random();
        for(int j=0;j<nums.length;j++){
            int x = j+random.nextInt(nums.length-j);
            int temp = nums[j];
            nums[j]=nums[x];
            nums[x]=temp;
        }
        return nums;

    }

    public static void main(String[] args) {
        int[] nums={1,2,3,4};
        Leecode384 leecode384 =  new Leecode384(nums);
        leecode384.shuffle();
        System.out.println();
        System.out.println(JSON.toJSONString(nums));
        System.out.println(JSON.toJSONString(leecode384.reset()));
    }
}
