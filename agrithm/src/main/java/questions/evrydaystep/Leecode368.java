package questions.evrydaystep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 368. 最大整除子集
 * 给你一个由 无重复 正整数组成的集合 nums ，请你找出并返回其中最大的整除子集 answer ，子集中每一元素对 (answer[i], answer[j]) 都应当满足：
 * answer[i] % answer[j] == 0 ，或
 * answer[j] % answer[i] == 0
 * 如果存在多个有效解子集，返回其中任何一个均可。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[1,2]
 * 解释：[1,3] 也会被视为正确答案。
 * 示例 2：
 *
 * 输入：nums = [1,2,4,8]
 * 输出：[1,2,4,8]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= 2 * 109
 * nums 中的所有整数 互不相同
 * 通过次数18,262提交次数43,176
 * */
public class Leecode368 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int len = nums.length;
        int[] maxLens = new int[len];
        int[] maxPrePos = new int[len];
        Arrays.fill(maxLens,1);
        Arrays.sort(nums);
        maxLens[0]=1;
        maxPrePos[0]=-1;
        for(int i=1;i<len;i++){
           int tempLen=1;
           int pre=i;
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j]==0){
                    if(maxLens[j]+1>maxLens[i]){
                        tempLen = maxLens[j]+1;
                        pre=j;
                    }
                }
            }
            maxLens[i]=tempLen;
            maxPrePos[i]=pre;
        }

        int max=-1;
        int index=-1;

        for(int i=0;i<maxLens.length;i++){
            if(maxLens[i]>max){
                max=maxLens[i];
                index=i;
            }
        }
        List<Integer> result = new ArrayList<>();
        int j=0;
        while (j++<max){
            result.add(nums[index]);
            index=maxPrePos[index];
        }
        return result;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,4,8};
        Leecode368 leecode368 = new Leecode368();
        List<Integer> result = leecode368.largestDivisibleSubset(nums);
        for(Integer a:result){
            System.out.println(a);
        }

    }
}
