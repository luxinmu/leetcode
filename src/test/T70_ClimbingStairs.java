package test;

public class T70_ClimbingStairs {
    public static void main(String[] args) {
        T70_ClimbingStairs t70 = new T70_ClimbingStairs();
        System.out.println(t70.climbStairs(3));
        System.out.println(t70.climbStairs(5));
        System.out.println(t70.climbStairs1(40));
    }

    /**
     * dynamic programming
     * 执行用时 : 0 ms , 100.00%
     * 内存消耗 : 32.9MB , 73.72%
     */
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int dp[] = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i <= n - 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2]; //KEYPOINT
        }
        return dp[n - 1];
    }

    /**
     * Fibonacci sequence
     * 执行用时 : 0 ms , 100.00%
     * 内存消耗 : 33MB , 73.21%
     */
    public int climbStairs1(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int ans = 0;
        int prev2 = 1;
        int prev1 = 2;
        for (int i = 3; i <= n; i++) {
            ans = prev2 + prev1;
            prev2 = prev1;
            prev1 = ans;
        }
        return ans;
    }
}
