package questions.evrydaystep;

/**
 * 给你 二维 平面上两个 由直线构成的 矩形，请你计算并返回两个矩形覆盖的总面积。
 *
 * 每个矩形由其 左下 顶点和 右上 顶点坐标表示：
 *
 * 第一个矩形由其左下顶点 (ax1, ay1) 和右上顶点 (ax2, ay2) 定义。
 * 第二个矩形由其左下顶点 (bx1, by1) 和右上顶点 (bx2, by2) 定义。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rectangle-area
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */

public class Leecode223 {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int result = 0;
        int xLeft = 0;
        int xRight = 0;
        int xTop = 0;
        int xBottom = 0;
        if (ax1 - bx1 >= 0) {
            xLeft=ax1;
        }else {
            xLeft=bx1;
        }
        if(ax2-bx2>=0){
            xRight=bx2;
        }else {
            xRight=ax2;
        }

        if(ay1>=by1){
            xBottom=ay1;
        }else {
            xBottom=by1;
        }

        if(ay2>=by2){
            xTop=by2;
        }else {
            xTop=ay2;
        }
        result =(ax2-ax1)*(ay2-ay1)+(bx2-bx1)*(by2-by1)-(Math.max(xTop-xBottom,0))*(Math.max(xRight-xLeft,0));

        return result;
    }


    public static void main(String[] args) {
        int ax1 = -2;
        int ay1 = -2;
        int ax2 = 2;
        int ay2 = 2;
        int bx1 = 3;
        int by1 = 3;
        int bx2 = 4;
        int by2 = 4;

        Leecode223 leecode223 = new Leecode223();
        System.out.println(leecode223.computeArea( ax1,  ay1,  ax2,  ay2,  bx1,  by1,  bx2,  by2));

    }
}
