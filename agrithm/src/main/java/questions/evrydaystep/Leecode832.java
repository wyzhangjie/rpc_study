package questions.evrydaystep;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。
 *
 * 水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。
 *
 * 反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[[1,1,0],[1,0,1],[0,0,0]]
 * 输出：[[1,0,0],[0,1,0],[1,1,1]]
 * 解释：首先翻转每一行: [[0,1,1],[1,0,1],[0,0,0]]；
 *      然后反转图片: [[1,0,0],[0,1,0],[1,1,1]]
 * 示例 2：
 *
 * 输入：[[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
 * 输出：[[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * 解释：首先翻转每一行: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]]；
 *      然后反转图片: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flipping-an-image
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class Leecode832 {
    public int[][] flipAndInvertImage(int[][] flipAndInvertImage) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(1,0);
        map.put(0,1);
        int zong =flipAndInvertImage[0].length;
        int jLen= flipAndInvertImage[0].length/2;
        if(zong%2==0){
            jLen= flipAndInvertImage[0].length/2-1;
        }

        for(int i=0;i<flipAndInvertImage.length;i++){
            for(int j=0;j<=jLen;j++) {
                if(j!=zong-j-1){

                    flipAndInvertImage[i][j]= map.get(flipAndInvertImage[i][j]);
                    flipAndInvertImage[i][zong-j-1]=    map.get(flipAndInvertImage[i][zong-j-1]);
                    int tmp =flipAndInvertImage[i][j];
                    flipAndInvertImage[i][j]=flipAndInvertImage[i][zong-j-1];
                    flipAndInvertImage[i][zong-j-1]=tmp;
                }else {
                    flipAndInvertImage[i][j]= map.get(flipAndInvertImage[i][j]);

                }

        }
    }
        return flipAndInvertImage;

    }
    public int[][] flipAndInvertImageYouhua(int[][] flipAndInvertImage) {

        int zong =flipAndInvertImage[0].length;
        int jLen= flipAndInvertImage[0].length/2;
        if(zong%2==0){
            jLen= flipAndInvertImage[0].length/2-1;
        }

        for(int i=0;i<flipAndInvertImage.length;i++){
            for(int j=0;j<=jLen;j++) {
                if(j!=zong-j-1){
                    if(flipAndInvertImage[i][j]==flipAndInvertImage[i][zong-j-1]){
                        flipAndInvertImage[i][j]^=1;
                        flipAndInvertImage[i][zong-j-1]^=1;
                    }
                }else {
                    flipAndInvertImage[i][j]^=1;

                }

            }
        }
        return flipAndInvertImage;

    }

    private void reverse(int a, int b) {
        int temp =a;
        a=b;
        b=temp;
    }

    public static void main(String[] args) {
   // int[][] a={{1,1,0},{1,0,1},{0,0,0}};
        int a[][] ={{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}};
        Leecode832 leecode832 = new Leecode832();
        leecode832.print(leecode832.flipAndInvertImage(a));
     }

    private void print(int[][] flipAndInvertImage) {
        for(int i=0;i<flipAndInvertImage.length;i++){
            for(int j=0;j<flipAndInvertImage[0].length;j++){
                System.out.print(flipAndInvertImage[i][j]);
            }
            System.out.println();
        }
    }
}
