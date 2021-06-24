package questions.evrydaystep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.function.IntConsumer;
import java.util.stream.Collectors;

/**
 * 40. 组合总和 II
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 *
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 * */
public class Leecode40 {
    Set<List<Integer>> result = new HashSet<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> temp = new LinkedList<>();
        comSubs(candidates,target,temp,0);
        List<List<Integer>> deadLine = new ArrayList<>();
        result.forEach((a)->deadLine.add(a));
        return deadLine;

    }

    private void comSubs(int[] candidates, int target,  List<Integer> temp,int index) {
        if(index== candidates.length ){
            int sum = temp.stream().reduce(Integer::sum).orElse(0);
            if(target==sum){
                result.add(new LinkedList<>(temp));
            }

            return;
        }
            temp.add(candidates[index]);
            comSubs(candidates,target,temp,index+1);
             temp.remove(temp.size()-1);
            comSubs(candidates,target,temp,index+1);
    }

    public static void main(String[] args) {
        /**
         * [1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1]
         * 27
         * */
        int[]  candidates = new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        Leecode40 leecode40 = new Leecode40();
        System.out.println(leecode40.combinationSum2(candidates,27));

    }
}
