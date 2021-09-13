package questions.evrydaystep;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * 给你一个大小为 m * n 的矩阵 mat，矩阵由若干军人和平民组成，分别用 1 和 0 表示。
 * <p>
 * 请你返回矩阵中战斗力最弱的 k 行的索引，按从最弱到最强排序。
 * <p>
 * 如果第 i 行的军人数量少于第 j 行，或者两行军人数量相同但 i 小于 j，那么我们认为第 i 行的战斗力比第 j 行弱。
 * <p>
 * 军人 总是 排在一行中的靠前位置，也就是说 1 总是出现在 0 之前。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：mat =
 * [[1,1,0,0,0],
 * [1,1,1,1,0],
 * [1,0,0,0,0],
 * [1,1,0,0,0],
 * [1,1,1,1,1]],
 * k = 3
 * 输出：[2,0,3]
 * 解释：
 * 每行中的军人数目：
 * 行 0 -> 2
 * 行 1 -> 4
 * 行 2 -> 1
 * 行 3 -> 2
 * 行 4 -> 5
 * 从最弱到最强对这些行排序后得到 [2,0,3,1,4]
 * 示例 2：
 * <p>
 * 输入：mat =
 * [[1,0,0,0],
 *  [1,1,1,1],
 *  [1,0,0,0],
 *  [1,0,0,0]],
 * k = 2
 * 输出：[0,2]
 * 解释：
 * 每行中的军人数目：
 * 行 0 -> 1
 * 行 1 -> 4
 * 行 2 -> 1
 * 行 3 -> 1
 * 从最弱到最强对这些行排序后得到 [0,2,3,1]
 *  
 * <p>
 * 提示：
 * <p>
 * m == mat.length
 * n == mat[i].length
 * 2 <= n, m <= 100
 * 1 <= k <= m
 * matrix[i][j] 不是 0 就是 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/the-k-weakest-rows-in-a-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leecode1337 {

    public int[] kWeakestRows(int[][] mat, int k) {
        List<Integer> resultTemp = new LinkedList<>();
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();

        for (int i = 0; i < mat.length; i++) {
            int left = 0;
            int right = mat[i].length-1;
            int pos = -1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (mat[i][mid] == 0) {
                    right = mid - 1;
                } else {
                    pos=mid;
                    left = mid + 1;
                }
            }
            map.putIfAbsent(pos+1 , new ArrayList<>());
            map.get(pos+1).add(i);
        }
        int count = 0;
        while (count < k) {
            Collections.sort(map.firstEntry().getValue(), new MyComparator());

            if (count + map.firstEntry().getValue().size() <= k) {
                resultTemp.addAll(map.firstEntry().getValue());
            } else {
                resultTemp.addAll(map.firstEntry().getValue().subList(0, k - count));
            }
            map.remove(map.firstKey());
            count = resultTemp.size();

        }


        return resultTemp.stream().mapToInt(Integer::valueOf).toArray();


        //到这里就是
    }

    public class MyComparator implements Comparator<Integer> {
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }

    }

    private int getNumOne(int[][] mat, int mid) {
        int[] temp = mat[mid];
        int count = 0;
        for (int i = 0; i < temp.length; i++) {
            if (mat[mid][i] == 1) {
                count++;

            } else {
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] mat = new int[][]
                {{1, 1, 0, 0, 0},
                        {1, 1, 1, 1, 0},
                        {1, 0, 0, 0, 0},
                        {1, 1, 0, 0, 0},
                        {1, 1, 1, 1, 1}};
        Leecode1337 leecode1337 = new Leecode1337();
        System.out.println(JSON.toJSONString(leecode1337.kWeakestRows(mat, 3)));

    }

}
