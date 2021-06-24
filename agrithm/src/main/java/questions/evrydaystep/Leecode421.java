package questions.evrydaystep;
/**
 * 421. 数组中两个数的最大异或值
 * 给你一个整数数组 nums ，返回 nums[i] XOR nums[j] 的最大运算结果，其中 0 ≤ i ≤ j < n 。
 *
 * 进阶：你可以在 O(n) 的时间解决这个问题吗？
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [3,10,5,25,2,8]
 * 输出：28
 * 解释：最大运算结果是 5 XOR 25 = 28.
 * 示例 2：
 *
 * 输入：nums = [0]
 * 输出：0
 * 示例 3：
 *
 * 输入：nums = [2,4]
 * 输出：6
 * 示例 4：
 *
 * 输入：nums = [8,10,2]
 * 输出：10
 * 示例 5：
 *
 * 输入：nums = [14,70,53,83,49,91,36,80,92,51,66,70]
 * 输出：127
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 2 * 104
 * 0 <= nums[i] <= 231 - 1
 * */
public class Leecode421 {
    int maxLen = 31;
    public int findMaximumXOR(int[] nums) {
        //思路：构建一颗特殊的字典树
        //字段数也要针对每一个数据分别构建前缀字段数
        //这样每一个数组就找字段数和它在最高位异或是1的那个数值就是这个位置的最大异或值
        //找到的每一次都和结果匹配，最后结果返回
        TrieNode root = new  TrieNode();
        //最终结果放置位置
        int result=0;
        //构建数
        buildTree(nums[0],root);
        for(int i=1;i<nums.length;i++){
           int temp =findMaxSubXor(nums[i],root);
           result= Math.max(result,temp);
            buildTree(nums[i],root);
        }
        return result;
    }

    private int findMaxSubXor(int num, TrieNode root) {
        int temp =0;
        TrieNode cur = root;
        for(int i=maxLen-1;i>=0;i--){
            int pos = (num>>i)&1;
            if(pos==1){
                if(cur.left!=null){
                    temp=temp*2+1;
                    cur=cur.left;
                }else {
                    temp = temp*2;
                    cur=cur.right;
                }
            }else {
                if(cur.right!=null){
                    temp=temp*2+1;
                    cur=cur.right;
                }else {
                    temp = temp*2;
                    cur=cur.left;
                }
            }
        }
        return temp;
    }

    private void buildTree(int num,TrieNode root) {
        TrieNode tempStep =root;
        for(int i=maxLen-1;i>=0;i--){
            if(((num>>i)&1)==0){
                if(tempStep.left==null){
                    tempStep.left=new TrieNode();
                }
                tempStep = tempStep.left;

            }else {
                if(tempStep.right==null){
                    tempStep.right=new TrieNode();
                }
                tempStep = tempStep.right;
            }
        }
    }

    public class TrieNode {
        //每一个数值，有两个结果，要么是0 ，要么是1
        TrieNode left ;
        TrieNode right;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{8,10,2};
        Leecode421 leecode421 =  new Leecode421();
        System.out.println(leecode421.findMaximumXOR(nums));
    }
}
