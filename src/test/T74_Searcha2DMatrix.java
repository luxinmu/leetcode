package test;

public class T74_Searcha2DMatrix {
    public static void main(String[] args) {
        T74_Searcha2DMatrix t74 = new T74_Searcha2DMatrix();
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        System.out.println(t74.searchMatrix(matrix, 3));
        System.out.println(t74.searchMatrix(matrix, 13));
        System.out.println(t74.searchMatrix(matrix, 0));
        System.out.println(t74.searchMatrix(matrix, 30));
        System.out.println(t74.searchMatrix(matrix, 51));
        int[][] matrix1 = {{1, 1}};
        System.out.println(t74.searchMatrix(matrix1, 2));
    }

    /**
     * 执行用时 : 0 ms , 100.00%
     * 内存消耗 : 42.4 MB , 41.57%
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int R = matrix.length;
        int C = matrix[0].length;
        int start = 0;
        int end = R - 1;
        int mid = 0, midC;
        if (R > 1) {
            while (start <= end) {
                mid = (start + end) / 2;
                if (matrix[mid][0] <= target && target <= matrix[mid][C - 1]) break;
                else if (matrix[mid][0] < target) start = mid + 1;
                else end = mid - 1;
            }
            if (start > end)
                return false;
        }
        start = 0;
        end = C - 1;
        while (start <= end) {
            midC = (start + end) / 2;
            if (matrix[mid][midC] == target) return true;
            else if (matrix[mid][midC] < target) start = midC + 1;
            else end = midC - 1;
        }
        return false;
    }

    /**
     * 执行用时 : 0 ms , 100.00%
     * 内存消耗 : 42.6 MB , 38.63%
     */
    public boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int R = matrix.length;
        int C = matrix[0].length;
        int begin = 0;
        int end = R * C - 1;
        int mid, midVal;
        while (begin <= end) {
            mid = (begin + end) / 2;
            midVal = matrix[mid / C][mid % C];  // KEYPOINT
            if (target == midVal) return true;
            else if (target < midVal) end = mid - 1;
            else begin = mid + 1;
        }
        return false;
    }

    /**
     * 执行用时 : 1 ms , 54.24%
     * 内存消耗 : 42.6 MB , 39.71%
     */
    public boolean searchMatrix1(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int row = 0;
        int col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0)
            if (matrix[row][col] < target) row++;
            else if (matrix[row][col] > target) col--;
            else return true;
        return false;
    }
}
