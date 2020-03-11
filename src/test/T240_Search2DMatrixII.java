package test;

/**
 * 240. Search a 2D Matrix II
 * Difficult: Medium
 * <p>
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 * <p>
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 * <p>
 * Example:
 * Consider the following matrix:
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * Given target = 5, return true.
 * Given target = 20, return false.
 *
 * @see T74_Searcha2DMatrix
 */
public class T240_Search2DMatrixII {

    public static void main(String[] args) {
        T240_Search2DMatrixII test = new T240_Search2DMatrixII();
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(test.searchMatrix(matrix, 5));
        System.out.println(test.searchMatrix(matrix, 20));
        System.out.println(test.searchMatrix(matrix, 8));
        System.out.println(test.searchMatrix(matrix, 100));
    }

    /**
     * 执行用时 :7 ms, 89.43%
     * 内存消耗 :42.9 MB, 53.26%
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int ROW = matrix.length;
        int COL = matrix[0].length;
        if (target < matrix[0][0] || target > matrix[ROW - 1][COL - 1])
            return false;
        //KEYPOINT
        //选取左下角的点开始
        int i = ROW - 1;
        int j = 0;
        while (i >= 0 && j < COL) {
            if (matrix[i][j] == target)
                return true;
            else if (matrix[i][j] > target)
                i--;  //大于目标值，向上移动，使值减小
            else
                j++;  //小于目标值，向右移动，使值增大
        }
        // 当不满足循环条件，即数组越界时，任然未找到时，证明目标值不存在。
        return false;
    }
}
