package questions.evrydaystep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 * 示例 2：
 *
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * 通过次数79,056提交次数126,442
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class Leecode90 {
    List<Integer> temp =new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    //方法1：用二进制来计算
    public List<List<Integer>> subsetsWithDup(int[] nums) {
    int len = nums.length;
    int maskMax=1<<len;
    for(int mask=0;mask<maskMax;mask++){
        temp.clear();
        for(int i=0;i<len;i++){
            if((mask&(1<<i))!=0){
                temp.add(nums[i]);
            }
        }
        ans.add(new ArrayList<>(temp));
        }
    return ans;
    }
    public List<List<Integer>> subsetsWithDupDigui(int[] nums) {
        int len = nums.length;
       diguiEasy(0,nums);
        return ans;
    }

    private void diguiEasy(int i, int[] nums) {
        if(i==nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[i]);
        diguiEasy(i+1,nums);
        temp.remove(temp.size()-1);
        diguiEasy(i+1,nums);
    }

    //方法1：用二进制来计算
    public List<List<Integer>> subsetsWithDupDelChong(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int maskMax=1<<len;
        for(int mask=0;mask<maskMax;mask++){
            temp.clear();
            Boolean flag =true;
            for(int i=0;i<len;i++){

                if((mask&(1<<i))!=0){
                    //平行互斥，如果当前的掩码里面没有上面那个值，说明那个值会在其他掩码出现就会出现重复
                    //如果当前掩码有这个值，说明可以选择这个值不会出现重复，因为大家出现在一起了彼此不互斥
                    if(i>0 && (mask >>(i-1)&1)==0 && nums[i]==nums[i-1]){
                        flag=false;
                        break;
                    }
                    temp.add(nums[i]);
                }
            }
            if(flag){
                ans.add(new ArrayList<>(temp));
            }

        }
        return ans;
    }
    public List<List<Integer>> subsetsWithDupDelChongDigui(int[] nums) {
        Arrays.sort(nums);
        diguiMid(false,0,nums);
        return ans;
    }

    private void diguiMid(Boolean preChoose,int i, int[] nums) {
        if(i==nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }
        diguiMid(false,i+1,nums);
        if(!preChoose && i>0 && nums[i-1]==nums[i]){
            return;
        }
        temp.add(nums[i]);
        diguiMid(true,i+1,nums);
        temp.remove(temp.size()-1);

    }

    public static void main(String[] args) {
       int[] nums =new int[]{1,2,2};
        Leecode90 leecode90 = new Leecode90();
        print(leecode90.subsetsWithDupDelChongDigui(nums));
    }

    private static void print(List<List<Integer>> subsetsWithDup) {
        subsetsWithDup.stream().forEach((a)->{
            a.stream().forEach((b)->{
                System.out.print(b);
            });
            System.out.println();
        });
    }
}
