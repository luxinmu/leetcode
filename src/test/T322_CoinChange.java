package test;

import java.util.Arrays;

/**
 * 322. Coin Change
 * Difficult: Medium
 * <p>
 * You are given coins of different denominations and a total amount of money amount.
 * Write a function to compute the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 * <p>
 * Example 1:
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * <p>
 * Example 2:
 * Input: coins = [2], amount = 3
 * Output: -1
 * <p>
 * Note:
 * You may assume that you have an infinite number of each kind of coin.
 */
public class T322_CoinChange {
    public static void main(String[] args) {
        T322_CoinChange test = new T322_CoinChange();
        System.out.println(test.coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(test.coinChange(new int[]{1, 2, 4, 5}, 12));
        System.out.println(test.coinChange(new int[]{2}, 3));
    }

    /**
     * 动态规划解法
     * 执行用时 :12 ms, 88.62%
     * 内存消耗 :40.7 MB, 5.05%
     */
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0)
            return -1;
        int[] dp = new int[amount + 1];  // When amount is very large, it's disaster.
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int c : coins) {
                if (i - c >= 0)
                    min = Math.min(dp[i - c], min);
            }
            if (min != Integer.MAX_VALUE)
                dp[i] = min + 1;
        }
        return Integer.MAX_VALUE == dp[amount] ? -1 : dp[amount];
    }
}
