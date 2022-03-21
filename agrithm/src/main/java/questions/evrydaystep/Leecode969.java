package questions.evrydaystep;/**
 * ClassName Leecode969
 * Description
 * Create by jie.zhang02
 * Date 2022/2/19 9:36 下午
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author jie.zhang
 * @date 2022年02月19日 9:36 下午
 */
public class Leecode969 {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> list = new ArrayList<>();
        int[] pos= new int[arr.length+1];
        for(int i=0;i<arr.length;i++){
            pos[arr[i]]=i;
        }
        for(int i=arr.length-1;i>=0;i--){
            if(arr[i]==(i+1)){
                continue;
            }else {
                int right = pos[i+1];
                if(right!=0){
                    list.add(right+1);
                    reverse(0,right,arr,pos);
                }

                list.add(i+1);
                reverse(0,i,arr,pos);
            }
        }
        return list;
    }

    private void reverse(int left, int right, int[] arr,int[] pos) {
        while (left<right){
            pos[arr[left]]=right;
            pos[arr[right]]=left;
            int temp = arr[left];
            arr[left]=arr[right];
            arr[right]=temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] arr= {3,2,4,1};
        Leecode969 leecode969 = new Leecode969();
        System.out.println(leecode969.pancakeSort(arr));

    }
}
