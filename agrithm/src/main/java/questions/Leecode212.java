package questions;

import java.util.LinkedList;
import java.util.List;

public class Leecode212 {
    // dfs实现
    public List<String> findWords(char[][] board, String[] words) {

        List<String> result = new LinkedList<>();

        for (String word : words) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    boolean[][] marks = new boolean[board.length][board[0].length];
                    dfs(i, j, word, 0, result, marks, board);
                }
            }

        }
        return result;
    }


    private void dfs(int hang, int lie, String word, int index, List<String> result, boolean[][] marks, char[][] board) {

        if (hang < 0 || lie < 0 || hang > (board.length - 1) || lie > (board[0].length - 1)) {
            return;
        }
        if (marks[hang][lie]) {
            return;
        }
        if (word.charAt(index) == board[hang][lie]) {
            marks[hang][lie] = true;
            if (index == word.length() - 1) {
                if (!result.contains(word)) {
                    result.add(word);
                }

                return;

            }

            dfs(hang + 1, lie, word, index + 1, result, marks, board);
            dfs(hang - 1, lie, word, index + 1, result, marks, board);
            dfs(hang, lie - 1, word, index + 1, result, marks, board);
            dfs(hang, lie + 1, word, index + 1, result, marks, board);
            marks[hang][lie] = false;


        }

    }


    public List<String> test(char[][] board) {
        boolean[][] marks = new boolean[board.length][board[0].length];
        List<String> result = new LinkedList<>();
        dfsTest(0, 0, board, marks, 0);
        return result;
    }

    private void dfsTest(int hang, int lie, char[][] board, boolean[][] marks, int flag) {

        if (hang < 0 || hang >= board.length || lie < 0 || lie >= board[0].length) {
            return;
        }
        if (marks[hang][lie]) {
            return;
        }
        if (!marks[hang][lie]) {
            marks[hang][lie] = true;
            System.out.println(board[hang][lie]);

        }

        if (flag == 0) {
            dfsTest(hang, lie + 1, board, marks, flag);
            dfsTest(hang, lie - 1, board, marks, flag);
            dfsTest(hang + 1, lie, board, marks, flag);

            dfsTest(hang - 1, lie, board, marks, flag);

        }


    }


    public static void main(String[] args) {
        //char[][] board =new char[][] {{"o","a","a","n"},{"e","t","a","e"},{"i","h","k","r"},{"i","f","l","v"}};

        char[][] board = new char[][]{{'a', 'b', 'c'}, {'a', 'e', 'd'}, {'a', 'f', 'g'}};
        String[] words = {"eaabcdgfa"};
        // char[][] board = new char[][]{{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};

        //  String[] words = new String[]{"oath", "pea", "eat", "rain"};
        Leecode212 leecode212 = new Leecode212();
        System.out.println(leecode212.findWords(board, words));
        //   leecode212.test(board);
    }
}
