package test;

/**
 * 130. Surrounded Regions
 * Difficult: Medium
 * <p>
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 * <p>
 * Example:
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * After running your function, the board should be:
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * Explanation:
 * Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board
 * are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the
 * border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.
 */
public class T130_SurroundedRegions {
    public static void main(String[] args) {
        T130_SurroundedRegions t130 = new T130_SurroundedRegions();
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}};
        Tools.printArray(board);
        t130.solve(board);
        Tools.printArray(board);
    }

    /**
     * 执行用时 : 1 ms ,  100.00%
     * 内存消耗 : 40.3 MB ,  93.40%
     */
    public void solve(char[][] board) {
        if (board == null || board.length < 2 || board[0].length < 2) return;
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            dfs(board, i, 0);
            dfs(board, i, col - 1);
        }
        for (int j = 1; j < col - 1; j++) {
            dfs(board, 0, j);
            dfs(board, row - 1, j);
        }

        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++)
                board[i][j] = board[i][j] == '$' ? 'O' : 'X';
    }

    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O') return;
        board[i][j] = '$';
        dfs(board, i, j + 1);
        dfs(board, i, j - 1);
        dfs(board, i + 1, j);
        dfs(board, i - 1, j);
    }
}
