package test;

/**
 * 200. Number of Islands
 * Difficult: Medium
 * <p>
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 * <p>
 * Example 1:
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 * Output: 1
 * <p>
 * Example 2:
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 * Output: 3
 *
 * @see T695_MaxAreaOfIsland
 */
public class T200_NumberOfIslands {
    public static void main(String[] args) {
        T200_NumberOfIslands test = new T200_NumberOfIslands();
        char[][] grid1 = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'},
        };
        System.out.println(test.numIslands(grid1));
        char[][] grid2 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'},
        };
        System.out.println(test.numIslands(grid2));
    }

    int R;
    int C;

    /**
     * DFS解法
     * 执行用时 :3 ms, 54.15%
     * 内存消耗 :41.5 MB, 10.76%
     * 发现一块陆地，总数增加1，将该陆地和连接的陆地全部弄沉
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        R = grid.length;
        C = grid[0].length;
        int count = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (grid[i][j] == '0') continue;
                count++;
                dfs(grid, i, j);
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        grid[i][j] = '0';
        if (i + 1 < R && grid[i + 1][j] == '1')
            dfs(grid, i + 1, j);
        if (i - 1 >= 0 && grid[i - 1][j] == '1')
            dfs(grid, i - 1, j);
        if (j + 1 < C && grid[i][j + 1] == '1')
            dfs(grid, i, j + 1);
        if (j - 1 >= 0 && grid[i][j - 1] == '1')
            dfs(grid, i, j - 1);
    }
}
