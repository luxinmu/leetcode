package test;

public class T64_MinimumPathSum {
    public static void main(String[] args) {
        T64_MinimumPathSum t64 = new T64_MinimumPathSum();
        System.out.println(t64.minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
    }

    /**
     * 执行用时 :3 ms, 90.18%
     * 内存消耗 :40.6 MB, 77.48%
     * */
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++)
                if (i == 0)
                    grid[i][j] = j == 0 ? grid[0][0] : grid[i][j - 1] + grid[i][j];
                else if (j == 0)
                    grid[i][j] = grid[i - 1][j] + grid[i][j];
                else
                    grid[i][j] = Math.min(grid[i - 1][j] + grid[i][j], grid[i][j - 1] + grid[i][j]);
        return grid[row - 1][col - 1];
    }

    /**
     * 执行用时 :3 ms, 90.18%
     * 内存消耗 :42.5 MB, 40.56%
     * */
    public int minPathSum1(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int row = grid.length;
        int col = grid[0].length;
        int [][]ans = new int[row][col];
        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++)
                if (i == 0)
                    ans[i][j] = j == 0 ? grid[0][0] : ans[i][j - 1] + grid[i][j];
                else if (j == 0)
                    ans[i][j] = ans[i - 1][j] + grid[i][j];
                else
                    ans[i][j] = Math.min(ans[i - 1][j] + grid[i][j], ans[i][j - 1] + grid[i][j]);
        return ans[row - 1][col - 1];
    }
}
