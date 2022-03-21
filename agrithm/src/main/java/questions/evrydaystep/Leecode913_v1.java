package questions.evrydaystep;

public class Leecode913_v1 {
    int MOUSE_WIN = 1;
    int CAT_WIN = 2;
    int even = 0;

    public int catMouseGame(int[][] graph) {
        return deep(1, 2, 0, graph);
    }

    private int deep(int mouse_pos, int cat_pos, int step, int[][] graph) {
        if (step >= 2 * graph.length) {
            return even;
        }
        if (mouse_pos == 0) {
            return MOUSE_WIN;
        }
        if (mouse_pos == cat_pos) {
            return CAT_WIN;
        }
        if (step % 2 == 0) {
            int ans = CAT_WIN;
            //接下来老鼠移动
            for (int pos : graph[mouse_pos]) {
              int  tempAns= deep(pos, cat_pos, step + 1, graph);
                if(tempAns==MOUSE_WIN){
                    return MOUSE_WIN;
                }
                if(tempAns==even){
                    ans = even;
                }
            }
            return ans;
        } else {
            int ans = MOUSE_WIN;

            for (int pos : graph[cat_pos]) {
                if(pos!=0){
                    int  tempAns= deep(mouse_pos, pos, step + 1, graph);
                    if(tempAns==CAT_WIN){
                        return CAT_WIN;
                    }
                    if(tempAns==even){
                        ans = even;
                    }
                }

            }
            return ans;
        }


    }

    public static void main(String[] args) {
        int[][]  graph = {{2,5},{3},{0,4,5},{1,4,5},{2,3},{0,2,3}};
        Leecode913_v1 leecode913_v1 = new Leecode913_v1();
        System.out.println(leecode913_v1.catMouseGame(graph));
    }
}
