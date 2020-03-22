package test;

/**
 * 377. Combination Sum IV
 * Difficult: Medium
 * <p>
 * Given an integer array with all positive numbers and no duplicates,
 * find the number of possible combinations that add up to a positive integer target.
 * <p>
 * Example:
 * nums = [1, 2, 3]
 * target = 4
 * The possible combination ways are:
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 * Note that different sequences are counted as different combinations.
 * Therefore the output is 7.
 * <p>
 * Follow up:
 * What if negative numbers are allowed in the given array?
 * How does it change the problem?
 * What limitation we need to add to the question to allow negative numbers?
 *
 * @see T322_CoinChange
 * @see T518_CoinChangeII
 */
public class T377_CombinationSumIV {
    public static void main(String[] args) {
        T377_CombinationSumIV test = new T377_CombinationSumIV();
        System.out.println(test.combinationSum4(new int[]{1, 2, 3}, 4));
        System.out.println(test.combinationSum4(new int[]{1, 3, 4}, 6));
        System.out.println(test.combinationSum4(new int[]{2, 1, 3}, 35));
    }

    /**
     * 自底向上的动态规划解法
     * 执行用时 :2 ms, 在所有 Java 提交中击败了80.60% 的用户
     * 内存消耗 :36.6 MB, 在所有 Java 提交中击败了10.10%的用户
     */
    public int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return 0;
        /* nums 1, 3, 4  target 7
         * dp[0] = 1
         * dp[1] = dp[0] = 1    [{1}]
         * dp[2] = dp[1] = 1    [{1,1}]
         * dp[3] = dp[2] + dp[0] = 2    [{1,1,1}], [{3}]
         * dp[4] = dp[3] + dp[1] + dp[0] = 4    [{1,1,1,1}, {3,1}], [{1,3}], [{4}]
         * dp[5] = dp[4] + dp[2] + dp[1] = 6    [{1,1,1,1,1}, {3,1,1}, {1,3,1}, {4,1}], [{1,1,3}], [{1,4}]
         * dp[6] = dp[5] + dp[3] + dp[2] = 9    [{1,1,1,1,1,1}, {3,1,1,1}, {1,3,1,1}, {4,1,1}, {1,1,3,1}, {1,4,1}]
         *                                      [{1,1,1,3}, {3,3}], [{1,1,4}]
         */
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++)
            for (int num : nums)
                if (i - num >= 0)
                    dp[i] += dp[i - num];
        return dp[target];
    }

    int ans;

    /**
     * dfs解法会超时
     */
    public int combinationSum4_timeout(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return 0;
        backtrace(nums, target);
        return ans;
    }

    private void backtrace(int[] nums, int target) {
        if (target == 0) {
            ans++;
            return;
        }

        for (int num : nums) {
            int newTarget = target - num;
            if (newTarget >= 0)
                backtrace(nums, newTarget);
        }
    }
}
