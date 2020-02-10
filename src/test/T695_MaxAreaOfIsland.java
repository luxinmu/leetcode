package test;

/**
 * 695. Max Area of Island
 * Difficult: Medium
 * <p>
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land)
 * connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
 * Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)
 * <p>
 * Example 1:
 * [
 * [0,0,1,0,0,0,0,1,0,0,0,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,1,1,0,1,0,0,0,0,0,0,0,0],
 * [0,1,0,0,1,1,0,0,1,0,1,0,0],
 * [0,1,0,0,1,1,0,0,1,1,1,0,0],
 * [0,0,0,0,0,0,0,0,0,0,1,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.
 * <p>
 * Example 2:
 * [[0,0,0,0,0,0,0,0]]
 * Given the above grid, return 0.
 * <p>
 * Note: The length of each dimension in the given grid does not exceed 50.
 *
 * @see T200_NumberOfIslands
 */
public class T695_MaxAreaOfIsland {

    public static void main(String[] args) {
        T695_MaxAreaOfIsland test = new T695_MaxAreaOfIsland();
        int[][] grid = {
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        System.out.println(test.maxAreaOfIsland(grid));
    }

    int R;
    int C;

    /**
     * 执行用时 :2 ms, 100.00%
     * 内存消耗 :44.6 MB, 15.23%
     */
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int max = 0, sum;
        R = grid.length;
        C = grid[0].length;
        for (int i = 0; i < R; i++)
            for (int j = 0; j < C; j++) {
                if (grid[i][j] == 0) continue;
                sum = dfs(grid, i, j);
                max = Math.max(max, sum);
            }
        return max;
    }

    private int dfs(int[][] grid, int i, int j) {
        int sum = 1;
        grid[i][j] = 0;
        if (i + 1 < R && grid[i + 1][j] == 1)
            sum += dfs(grid, i + 1, j);
        if (i - 1 >= 0 && grid[i - 1][j] == 1)
            sum += dfs(grid, i - 1, j);
        if (j + 1 < C && grid[i][j + 1] == 1)
            sum += dfs(grid, i, j + 1);
        if (j - 1 >= 0 && grid[i][j - 1] == 1)
            sum += dfs(grid, i, j - 1);
        return sum;
    }
}
