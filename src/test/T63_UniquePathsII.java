package test;

public class T63_UniquePathsII {
    public static void main(String[] args) {
        T63_UniquePathsII t63 = new T63_UniquePathsII();
        int[][] nums = {{0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {0, 0, 0, 0, 0}};
        System.out.println(t63.uniquePathsWithObstacles(nums));
        int[][] nums1 = {{0}};
        System.out.println(t63.uniquePathsWithObstacles(nums1));
    }

    /**
     * 执行用时 :1 ms, 94.92%
     * 内存消耗 :37.9 MB, 5.08%
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) return 0;
        if (obstacleGrid[0][0] == 1) return 0;
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        obstacleGrid[0][0] = 1;
        for (int i = 1; i < row; i++)
            obstacleGrid[i][0] = obstacleGrid[i][0] == 1 ? 0 : obstacleGrid[i - 1][0];
        for (int i = 1; i < col; i++)
            obstacleGrid[0][i] = obstacleGrid[0][i] == 1 ? 0 : obstacleGrid[0][i - 1];
        for (int i = 1; i < row; i++)
            for (int j = 1; j < col; j++)
                if (obstacleGrid[i][j] != 1)
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                else
                    obstacleGrid[i][j] = 0;
        return obstacleGrid[row - 1][col - 1];
    }

    /**
     * 执行用时 :1 ms, 94.92%
     * 内存消耗 :37.9 MB, 5.08%
     */
    public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) return 0;
        if (obstacleGrid[0][0] == 1) return 0;
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        obstacleGrid[0][0] = 1;
        for (int i = 1; i < row; i++)
            obstacleGrid[i][0] = obstacleGrid[i - 1][0] & (1 ^ obstacleGrid[i][0]);
        for (int i = 1; i < col; i++)
            obstacleGrid[0][i] = obstacleGrid[0][i - 1] & (1 ^ obstacleGrid[0][i]);
        for (int i = 1; i < row; i++)
            for (int j = 1; j < col; j++)
                if (obstacleGrid[i][j] != 1)
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                else
                    obstacleGrid[i][j] = 0;
        return obstacleGrid[row - 1][col - 1];
    }

    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) return 0;
        if (obstacleGrid[0][0] == 1) return 0;
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][] ans = new int[row][col];
        for (int i = 0; i < row; i++)
            ans[i][0] = i == 0 ? 1 : ans[i - 1][0] & (1 ^ obstacleGrid[i][0]);
        for (int i = 0; i < col; i++)
            ans[0][i] = i == 0 ? 1 : ans[0][i - 1] & (1 ^ obstacleGrid[0][i]);
        for (int i = 1; i < row; i++)
            for (int j = 1; j < col; j++)
                if (obstacleGrid[i][j] != 1)
                    ans[i][j] = ans[i - 1][j] + ans[i][j - 1];
                else
                    ans[i][j] = 0;
        return ans[row - 1][col - 1];
    }
}
