package test;

/**
 * 518. Coin Change II
 * Difficult: Medium
 * <p>
 * You are given coins of different denominations and a total amount of money.
 * Write a function to compute the number of combinations that make up that amount.
 * You may assume that you have infinite number of each kind of coin.
 * <p>
 * Example 1:
 * Input: amount = 5, coins = [1, 2, 5]
 * Output: 4
 * Explanation: there are four ways to make up the amount:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * <p>
 * Example 2:
 * Input: amount = 3, coins = [2]
 * Output: 0
 * Explanation: the amount of 3 cannot be made up just with coins of 2.
 * <p>
 * Example 3:
 * Input: amount = 10, coins = [10]
 * Output: 1
 * <p>
 * Note:
 * You can assume that
 * 0 <= amount <= 5000
 * 1 <= coin <= 5000
 * the number of coins is less than 500
 * the answer is guaranteed to fit into signed 32-bit integer
 *
 * @see T39_CombinationSum
 * @see T377_CombinationSumIV
 */
public class T518_CoinChangeII {
    public static void main(String[] args) {
        T518_CoinChangeII test = new T518_CoinChangeII();
        System.out.println(test.change(5, new int[]{1, 2, 5}));
        System.out.println(test.change(7, new int[]{1, 3, 4}));
    }

    public int change(int amount, int[] coins) {
        if (amount > 5000 || coins == null || coins.length == 0)
            return 0;
        /* coins 1, 3, 4  amount 7
         *     dp [0 1 2 3 4 5 6 7]
         *     0   1 0 0 0 0 0 0 0
         * coin[1] 1 1 1 1 1 1 1 1
         * coin[3] 1 1 1 2 2 2 3 3
         * coin[4] 1 1 1 2 3 3 4 5
         */
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
}
