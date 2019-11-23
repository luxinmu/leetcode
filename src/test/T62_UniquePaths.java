package test;

import java.util.Arrays;

public class T62_UniquePaths {

    public static void main(String[] args) {
        T62_UniquePaths t62 = new T62_UniquePaths();
        System.out.println(t62.uniquePaths(3, 2));
        System.out.println(t62.uniquePaths(7, 3));
        System.out.println(t62.uniquePaths(50, 50));
    }

    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) return 1;
        int ans[] = new int[n];
        Arrays.fill(ans, 1);
        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                ans[j] += ans[j - 1];
        return ans[n - 1];
    }

    public int uniquePaths1(int m, int n) {
        int N = n + m - 2;
        int k = m - 1;
        long ans = 1;
        for (int i = 1; i <= k; i++)
            ans = ans * (N - k + i) / i;
        return (int) ans;
    }

    public int uniquePaths2(int m, int n) {
        if (m == 1 || n == 1) return 1;
        int ans[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            ans[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            ans[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                ans[i][j] = ans[i - 1][j] + ans[i][j - 1]; //KEYPOINT
            }
        }
        return ans[m - 1][n - 1];
    }

    public int uniquePaths_Timeout(int m, int n) {
        if (m == 1 || n == 1) return 1;
        return uniquePaths_Timeout(m - 1, n) + uniquePaths_Timeout(m, n - 1);
    }
}
