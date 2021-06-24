package questions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * 78. 子集
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 *
 * 输入：nums = [0]
 * 输出：[[],[0]]
 * */
public class Leecode78 {
    private Set<List<Integer>> result=new HashSet<>();

    public List<List<Integer>> subsets2(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> deadLine = new ArrayList<>();
        for(int mask=0;mask<(1<< nums.length);mask++){
            temp.clear();
            for(int i=0;i<nums.length;i++){
                if((mask & (1<<i))!=0){
                    temp.add(nums[i]);
                }
            }
            deadLine.add(new ArrayList<>(temp));
        }
        return deadLine;

    }

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        subsets1(nums,0,temp);
        List<List<Integer>> deadLine = new ArrayList<>();
        result.forEach((a)->deadLine.add(a));
        return deadLine;

    }

    private void subsets1(int[] nums, int i,List<Integer> temp) {
        result.add(new ArrayList<>(temp));
        if(i== nums.length){
            return;
        }

        temp.add(nums[i]);
        subsets1(nums,i+1,temp);
        temp.remove(temp.size()-1);
        subsets1(nums,i+1,temp);
    }

    public static void main(String[] args) {
        Leecode78 leecode78 = new Leecode78();
        int[] nums = new int[]{2,5,2,1,2};
        System.out.println(leecode78.subsets(nums));
        System.out.println(leecode78.subsets2(nums));
    }
}
