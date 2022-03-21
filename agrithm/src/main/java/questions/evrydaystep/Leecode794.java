package questions.evrydaystep;

public class Leecode794 {
    public boolean validTicTacToe(String[] board) {
        char[][] chars = new char[3][3];
        int x = 0;
        int o = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i].charAt(j) == 'X') {
                    x++;
                }
                if (board[i].charAt(j) == 'O') {
                    o++;
                }
                chars[i][j] = board[i].charAt(j);

            }
        }
        boolean xWin = check(chars, 'X');
        boolean oWin = check(chars, 'O');
        //由于 X 先手，O 后手，两者轮流下子。因此 O 的数量不会超过 X，且两者数量差不会超过 11，否则为无效局面；
        //若局面是 X 获胜，导致该局面的最后一个子必然是 X，此时必然有 X 数量大于 O（X 为先手），否则为无效局面；
        //若局面是 O 获胜，导致该局面的最后一个子必然是 O，此时必然有 X 数量等于 O（X 为先手），否则为无效局面；
        //局面中不可能出现两者同时赢（其中一方赢后，游戏结束）。
        if(o>x || x-o>1) return false;
        if(xWin && o>=x) return false;
        if(oWin && x!=o) return false;
        if(xWin && oWin) return false;
        return true;


    }

    private boolean check(char[][] chars, char o) {
        for (int i = 0; i < 3; i++) {
            if (chars[i][0] == o && chars[i][1] == o && chars[i][2] == o) {
                return true;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (chars[0][i] == o && chars[1][i] == o && chars[2][i] == o) {
                return true;
            }
        }
        if (chars[0][0] == o && chars[1][1] == o && chars[2][2] == o) {
            return true;
        }
        if (chars[0][2] == o && chars[1][1] == o && chars[2][0] == o) {
            return true;
        }
        return false;


    }

    public static void main(String[] args) {
        Leecode794 leecode794 = new Leecode794();
        String[]  board = new String[]{"XOX","O O","XOX"};
        System.out.println(leecode794.validTicTacToe(board));

    }
}
