package questions.evrydaystep;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**888. 公平的糖果棒交换
 爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 根糖果棒的大小，B[j] 是鲍勃拥有的第 j 根糖果棒的大小。

 因为他们是朋友，所以他们想交换一根糖果棒，这样交换后，他们都有相同的糖果总量。（一个人拥有的糖果总量是他们拥有的糖果棒大小的总和。）

 返回一个整数数组 ans，其中 ans[0] 是爱丽丝必须交换的糖果棒的大小，ans[1] 是 Bob 必须交换的糖果棒的大小。

 如果有多个答案，你可以返回其中任何一个。保证答案存在。



 示例 1：

 输入：A = [1,1], B = [2,2]
 输出：[1,2]
 示例 2：

 输入：A = [1,2], B = [2,3]
 输出：[1,2]
 示例 3：

 输入：A = [2], B = [1,3]
 输出：[2,3]
 示例 4：

 输入：A = [1,2,5], B = [2,4]
 输出：[5,4]
 * sum(A)-x+y = sum(B) +x -y
 * sum(A)-sum(B) = 2x -2y
 * 2(x-y) = sum(A)-Sum(B)
 * x-y=(sum(A)-sum(B))/2
 * x = y+(sum(A)-sum(B))/2
 *  首先算出分别的和，然后按照公式，变量b数组每一个值，判断a当中是否有符合公式的x,为了减少变量，用hash表存储a数组里面的值
 * */
public class Leecode888 {
    public int[] fairCandySwap(int[] A, int[] B) {
      int sumA = Arrays.stream(A).sum();
      int sumB = Arrays.stream(B).sum();
        int[] result = new int[2];
      Map<Integer,Integer> mapA = new HashMap<>();
      for(int i=0;i<A.length;i++){
          mapA.put(A[i],i);
      }
      for(int j=0;j<B.length;j++){
          int tmp = B[j] +(sumA-sumB)/2;
          if(mapA.get(tmp)!=null){
              result[0]=tmp;
              result[1]=B[j];
          }
      }
      return result;

    }

    public static void main(String[] args) {
        int[] a= new int[]{1,2,5};
        int[] b = new int[]{2,4};
        Leecode888 leecode888 =new Leecode888();
        int[] result = leecode888.fairCandySwap(a,b);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }
}
