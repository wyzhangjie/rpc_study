package questions.evrydaystep;/**
 * ClassName Leecode969_new
 * Description
 * Create by jie.zhang02
 * Date 2022/2/19 10:25 下午
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author jie.zhang
 * @date 2022年02月19日 10:25 下午
 */
public class Leecode969_new {

        public List<Integer> pancakeSort(int[] arr) {
            int n = arr.length;
            int[] idxs = new int[n + 10];
            for (int i = 0; i < n; i++) idxs[arr[i]] = i;
            List<Integer> ans = new ArrayList<>();
            for (int i = n; i >= 1; i--) {
                int idx = idxs[i];
                if (idx == i - 1) continue;
                if (idx != 0) {
                    ans.add(idx + 1);
                    reverse(arr, 0, idx, idxs);
                }
                ans.add(i);
                reverse(arr, 0, i - 1, idxs);
            }
            return ans;
        }
        void reverse(int[] arr, int i, int j, int[] idxs) {
            while (i < j) {
                idxs[arr[i]] = j; idxs[arr[j]] = i;
                int c = arr[i];
                arr[i++] = arr[j];
                arr[j--] = c;
            }
        }


    public static void main(String[] args) {
        int[] arr= {3,2,4,1};
        Leecode969_new leecode969 = new Leecode969_new();
        System.out.println(leecode969.pancakeSort(arr));

    }

}
