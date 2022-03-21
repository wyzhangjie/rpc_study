package questions.evrydaystep.highEfficiency;/**
 * ClassName Leecode11
 * Description
 * Create by jie.zhang02
 * Date 2022/3/10 11:00 上午
 */

/**
 * @author jie.zhang
 * @date 2022年03月10日 11:00 上午
 */
public class Leecode11 {
    public int maxArea(int[] height) {
        int left=0;
        int right=height.length-1;
        int ans=0;
        while (left<right){
            ans=Math.max(ans,Math.min(height[right],height[left])*(right-left));
            if(height[right]>=height[left]){
                left++;
            }else {
                right--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Leecode11 leecode11 = new Leecode11();
        int[] height ={1,8,6,2,5,4,8,3,7};
        System.out.println(leecode11.maxArea(height));
    }
}
