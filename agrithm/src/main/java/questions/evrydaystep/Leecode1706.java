package questions.evrydaystep;/**
 * ClassName Leecode1706
 * Description
 * Create by jie.zhang02
 * Date 2022/2/24 10:31 上午
 */

/**
 * @author jie.zhang
 * @date 2022年02月24日 10:31 上午
 */
public class Leecode1706 {

    public int[] findBall(int[][] grid) {
        int[] t = new int[grid[0].length];
        for(int i=0;i<grid[0].length;i++){
            int result =findBallSingle(i,grid);
            t[i]=result;
        }
        return t;
    }

    private int findBallSingle(int i, int[][] grid) {
        int[] curPos= {0,i};
        int result=-1;
        while (curPos[0]<grid.length){
            if(grid[curPos[0]][curPos[1]]==1){
                if(curPos[1]==(grid[0].length-1)){
                    break;
                }else {
                    if(grid[curPos[0]][curPos[1]+1]==-1){
                        break;
                    }else {
                        curPos=new int[]{curPos[0]+1,curPos[1]+1};
                    }
                }

            }else{
                if(curPos[1]==0){
                    break;
                }else {
                    if(grid[curPos[0]][curPos[1]-1]==1){
                        break;
                    }else {
                        curPos=new int[]{curPos[0]+1,curPos[1]-1};
                    }
                }

            }
        }
        if(curPos[0]==grid.length){
            result=curPos[1];
        }
        return result;

    }

    public static void main(String[] args) {
      int[][]  grid = {{1,1,1,1,1,1},{-1,-1,-1,-1,-1,-1},{1,1,1,1,1,1},{-1,-1,-1,-1,-1,-1}};

        Leecode1706 leecode1706 = new Leecode1706();
        int[] result = leecode1706.findBall(grid);
        for(int a:result){
            System.out.println(a);
        }

    }

}
