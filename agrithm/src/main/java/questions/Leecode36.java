package questions;
/**
 * board.length == 9
 * board[i].length == 9
 * board[i][j] 是一位数字或者 '.'
 *
 * */
public class Leecode36 {
    public boolean isValidSudoku(char[][] board) {
    int[][] hangs = new int [board.length][10];
    int[][] lies = new int[board[0].length][10];
    int[][][] kuang = new int[3][3][10];
    for(int i=0;i<board.length;i++){

        for(int j=0;j<board[0].length;j++){
            if(board[i][j]!='.'){
                hangs[i][board[i][j]-'0']++;
                lies[j][board[i][j]-'0']++;
                kuang[i/3][j/3][board[i][j]-'0']++;
                if(hangs[i][board[i][j]-'0']>1 ||  lies[j][board[i][j]-'0']>1 || kuang[i/3][j/3][board[i][j]-'0']>1){
                    return false;
                }
            }

        }
    }
    return true;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]
                {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                        , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                        , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                        , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                        , {'8', '.', '.', '8', '.', '3', '.', '.', '1'}
                        , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                        , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                        , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                        , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
                };

        Leecode36 leecode36 = new Leecode36();
        System.out.println(leecode36.isValidSudoku(board));
    }
}
