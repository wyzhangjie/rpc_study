package questions.find;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 *  
 *
 * 示例:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 *提示：
 *
 * board 和 word 中只包含大写和小写英文字母。
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 1 <= word.length <= 10^3
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/2021-spring-recruitment/5f4p7i/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/2021-spring-recruitment/5f4p7i/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * */
public class Leecode79 {
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        List<Position> positionList = getFirstWord(board,words[0]);
        for(int pos=0;pos<positionList.size();pos++){
            Position current = positionList.get(pos);
            boolean flag =true;
            List<String> visited = new ArrayList<>();
            visited.add(current.i+"|"+current.j);
            for(int i=1;i<words.length;i++){
                current =check(words[i],board,current,visited);
                if(current==null) {
                    flag =false;
                    break;
                }
                visited.add(current.i+"|"+current.j);
            }
            if(flag)
                return true;
        }
        return false;

    }

    private Position check(char word,char[][] board, Position pos, List<String> visited) {
        if(pos.i+1<board.length && word==board[pos.i+1][pos.j]  ){
            Position position = new Position();
            position.i=pos.i+1;
            position.j=pos.j;
            return position;
        }
        if( pos.j+1<board[0].length && word==board[pos.i][pos.j+1]){
            Position position = new Position();
            position.i=pos.i;
            position.j=pos.j+1;
            return position;
        }
        if(!visited.contains(pos.i+"|"+(pos.j-1))&&pos.j-1>=0&& word==board[pos.i][pos.j-1]){
            Position position = new Position();
            position.i=pos.i;
            position.j=pos.j-1;
            return position;

        }
        return null;
    }

    private List<Position> getFirstWord(char[][] board, char word) {
        int width = board.length;
        int height = board[0].length;
        List<Position> positions = new ArrayList<>();
        for(int i=0;i<width;i++){
            for(int j=0;j<height;j++){
                if (board[i][j]==word) {
                    Position position = new Position();
                    position.i=i;
                    position.j=j;
                    positions.add(position);
                }
            }
        }
        return positions;
    }

    public class Position{
      public   int i;
      public   int j;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        Leecode79 leecode79 = new Leecode79();
        System.out.println(leecode79.exist(board,"ABCCED"));
        System.out.println(leecode79.exist(board,"SEE"));
        System.out.println(leecode79.exist(board,"ABCB"));
    }
}
