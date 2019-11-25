package test;

public class T73_SetMatrixZeroes {
    public static void main(String[] args) {
        T73_SetMatrixZeroes t73 = new T73_SetMatrixZeroes();
        int[][] a1 = {
                {1, 2, 0},
                {0, 1, 1},
                {1, 1, 1}
        };
        t73.setZeroes(a1);
        Tools.printArray(a1);
        int[][] a2 = {{0, 1}};
        t73.setZeroes(a2);
        Tools.printArray(a2);
    }

    /**
     * 执行用时 : 1 ms , 100.00%
     * 内存消耗 : 48.1 MB , 84.45%
     */
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return;
        int R = matrix.length;
        int C = matrix[0].length;
        boolean firstRowZero = false;
        boolean firstColZero = false;
        for (int i = 0; i < R; i++)
            if (matrix[i][0] == 0) {
                firstColZero = true;
                break;
            }

        for (int i = 0; i < C; i++)
            if (matrix[0][i] == 0) {
                firstRowZero = true;
                break;
            }

        for (int i = 1; i < R; i++)
            for (int j = 1; j < C; j++)
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }

        for (int i = 1; i < R; i++)
            for (int j = 1; j < C; j++)
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;

        if (firstColZero)
            for (int i = 0; i < R; i++)
                matrix[i][0] = 0;

        if (firstRowZero)
            for (int i = 0; i < C; i++)
                matrix[0][i] = 0;
    }
}
