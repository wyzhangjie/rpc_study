package questions.evrydaystep.highEfficiency;/**
 * ClassName Leecode42
 * Description
 * Create by jie.zhang02
 * Date 2022/3/10 11:40 上午
 */

/**
 * @author jie.zhang
 * @date 2022年03月10日 11:40 上午
 */
public class Leecode42 {
    public int trap(int[] height) {
        int[] left = new int[height.length];
        int[] right= new int[height.length];
        left[0]=height[0];
        right[height.length-1]=height[height.length-1];
        for(int i=1;i<left.length;i++){
            left[i]=Math.max(left[i-1],height[i]);
        }
        for(int i=right.length-2;i>=0;i--){
            right[i]=Math.max(right[i+1],height[i]);
        }
        int sum=0;
        for(int i=0;i<height.length;i++){
            sum+=Math.min(left[i],right[i])-height[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        Leecode42 leecode42 = new Leecode42();
        int[] height={0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(leecode42.trap(height));
    }
}
