package questions.evrydaystep.swardoffer;
/**
 * 面试题 17.14. 最小K个数
 * 设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
 *
 * 示例：
 *
 * 输入： arr = [1,3,5,7,2,4,6,8], k = 4
 * 输出： [1,2,3,4]
 * 提示：
 *
 * 0 <= len(arr) <= 100000
 * 0 <= k <= min(100000, len(arr))
 *
 * */
public class Leecode1417 {
    int[] result;
    //快排解决问题
    public int[] smallestK(int[] arr, int k) {
        quickSort(arr, 0, arr.length - 1, k);
        result  = new int[k];
        for(int i=0;i<k;i++){
            result[i]=arr[i];
        }
        return result;
    }

    private void quickSort(int[] arr, int left, int right, int k) {
        if(left<right){
            int mid = quickSortSub(arr,left,right);
            if(mid==k){
                return;
            }else if(k>mid){
                quickSort(arr,mid+1,right,k);
            }else {
                quickSort(arr,left,mid-1,k);
            }


        }
    }

    private int quickSortSub(int[] arr, int start, int end) {
        int left=start;
        int right=end;
        int mid = arr[left];
        while (left<right){
            while (left<right && arr[right]>=mid){
                right--;
            }
            arr[left]=arr[right];
            while (left<right && arr[left]<=mid){
                left++;
            }
            arr[right]=arr[left];
        }
        arr[left]=mid;
        return left;
    }

    public static void main(String[] args) {
        int[]  arr =new int[]{1,3,5,7,2,4,6,8};
        int k = 4;
        Leecode1417 leecode1417 = new Leecode1417();
        int[] result = leecode1417.smallestK(arr,4);
        for(int a:result){
            System.out.println(a);

        }
    }
}
