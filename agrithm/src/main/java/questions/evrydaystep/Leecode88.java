package questions.evrydaystep;

public class Leecode88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n==0){
            return;
        }
        if(m==0){
            for(int i=0;i<n;i++){
                nums1[i]=nums2[i];

            }
            return;
        }
        int i=0;
        int j=0;
        int[] result = new int[m+n];
        int index=0;
        while(i<m&&j<n){
            if(nums1[i]<=nums2[j]){
                result[index++] = nums1[i++];
            }else {
                result[index++] = nums2[j++];
            }
        }
        if(i<m){
            while (i<m){
                result[index++]=nums1[i++];
            }
        }
        if(j<n){
            while (j<n){
                result[index++]=nums2[j++];
            }

        }
        for(i=0;i<(m+n);i++){
            nums1[i]=result[i];
        }
        nums1=result;
    }
    public void print(int[] nums){
        for(int i=0;i<nums.length;i++){
            System.out.println(nums[i]);
        }
    }
    /**
     * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
     * 输出：[1,2,2,3,5,6]*/
    public static void main(String[] args) {
        Leecode88 leecode88 = new Leecode88();
       /* int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2= new int[]{2,5,6};*/
        int[] nums1 = new int[]{1,0};
        int[] nums2= new int[]{2};
        leecode88.merge(nums1,1,nums2,1);
        leecode88.print(nums1);
    }
}
