package questions.sort;
/**
 * 215. 数组中的第 K 个最大元素
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 *
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/2021-spring-recruitment/5ff3rs/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * */
public class Leecode215 {
    public int findKthLargest(int[] nums, int k) {
        int position =k-1;
        int start =0;
        int end = nums.length-1;
        int mid= start +(end-start)/2;

        quickSort(nums, start, end, mid);
        while(mid != position){
            if(mid>position){
                //数据在左面
                start=0;
                end = mid-1;
            }
            if(mid<position){
                //数据在右面
                start = mid+1;

            }
            quickSort(nums, start, end, mid);

        }
        if(mid==position){
            return mid;
        }else {
            return Integer.MIN_VALUE;
        }
    }

    private void quickSort(int[] nums, int start, int end, int mid) {
        while(start < end){
            while(nums[start]>= nums[mid]) start++;
            while (nums[end]< nums[mid]) end--;
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end]=temp;
        }
        if(start == end){
            int temp = nums[start];
            nums[start] = nums[mid];
            nums[mid]=temp;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{3,2,1,5,6,4};
        Leecode215 leecode215 = new Leecode215();
        int t = leecode215.findKthLargest(a,2);
        System.out.println(t);
    }
}
