package questions.evrydaystep;


import java.util.Stack;

/**
 * 给定一个直方图(也称柱状图)，假设有人从上面源源不断地倒水，最后直方图能存多少水量?直方图的宽度为 1。
 * <p>
 * <p>
 * <p>
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的直方图，在这种情况下，可以接 6 个单位的水（蓝色部分表示水）。 感谢 Marcos 贡献此图。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 * 通过次数16,359提交次数25,657
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/volume-of-histogram-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leecode1721 {

    //木桶效应，每一个位置能够接的水量取决于两边最大边的最小值
    public int trap(int[] height) {

        int len = height.length;
        int result=0;
       for(int i=1;i<len-1;i++){
           int maxLeft= maxL(i,height);
           int maxRight=maxR(i,height);
           if(maxLeft!=-1 && maxRight!=-1){
               int smallTall = Math.min(height[maxLeft],height[maxRight]);
               result+=smallTall-height[i];
           }
       }

        return result;
    }
    public int trapUp1(int[] height) {

        int len = height.length;
        if(len<=2) return 0;
        int result=0;
        int[] maxLeft = new int[len];
        int[] maxRight = new int[len];
        maxLeft[0]=height[0];
        maxRight[len-1]=height[len-1];
        calculateLeft(maxLeft,height);
        calculateRight(maxRight,height);
        for(int i=1;i<len-1;i++){

            int smallTall = Math.min(maxLeft[i],maxRight[i]);
            result+=smallTall-height[i];
        }

        return result;
    }


    public int trapUpMonotonousStack(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int len = height.length;
        if(len<=2) return 0;
        int result =0;

        for(int i=0;i<height.length;i++){
            while (!stack.isEmpty() && height[i]>height[stack.peek()]){
                int top = stack.pop();
                if(stack.empty()) break;
                int left=stack.peek();
                int curWidth = i-left-1;
                int curHeight=Math.min(height[left],height[i])-height[top];
                result+=curHeight*curWidth;

            }
            stack.push(i);
        }


        return result;
    }

    private void calculateRight(int[] maxRight, int[] height) {
        for(int i=height.length-2;i>=0;i--){
            maxRight[i]=Math.max(maxRight[i+1],height[i]);
        }
    }

    private void calculateLeft(int[] maxLeft, int[] height) {
        for(int i=1;i<height.length;i++){
            maxLeft[i]=Math.max(maxLeft[i-1],height[i]);
        }
    }

    private int maxR(int position, int[] height) {
        int h=position;
        for(int t=position+1;t<height.length;t++){
            if(height[t]>height[h]){
                h=t;
            }
        }
        return h==position?-1:h;
    }

    private int maxL(int position,int[] height) {
        int h=position;
        for(int t=position-1;t>=0;t--){
            if(height[t]>height[h]){
                h=t;
            }
        }
        return h==position?-1:h;
    }

    public static void main(String[] args) {
        int[] a = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        Leecode1721 leecode1721 = new Leecode1721();
        System.out.println(leecode1721.trapUpMonotonousStack(a));
    }
}
