package test;

/**
 * 221. Maximal Square
 * Difficult: Medium
 * <p>
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 * <p>
 * Example:
 * Input:
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * Output: 4
 */
public class T221_MaximalSquare {
    public static void main(String[] args) {
        T221_MaximalSquare test = new T221_MaximalSquare();
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}};
        System.out.println(test.maximalSquare(matrix));
    }

    /**
     * 动态规划解法
     * 执行用时 :7 ms, 44.51%
     * 内存消耗 :43.2 MB, 18.26%
     */
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return 0;
        int maxLen = 0;
        int R = matrix.length;
        int C = matrix[0].length;
        //dp[i][j]表示以i、j为右下标，组成的最大正方形的边长
        //二维数组扫描完成后，各个i、j的最大边长中求得最大的，然后平方就是答案
        int[][] dp = new int[R][C];
        for (int i = 0; i < R; i++)
            for (int j = 0; j < C; j++)
                if (matrix[i][j] == '1') {
                    dp[i][j] = i - 1 < 0 || j - 1 < 0  //小于0时，证明时最外边，赋值为1
                            ? 1
                            : 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                    maxLen = Math.max(maxLen, dp[i][j]);  //所有i、j最大边长中找最大的
                }
        return maxLen * maxLen;
    }
}
