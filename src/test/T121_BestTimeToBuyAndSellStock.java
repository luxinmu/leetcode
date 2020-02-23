package test;

/**
 * 121. Best Time to Buy and Sell Stock
 * Difficult: Easy
 * <p>
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell
 * one share of the stock), design an algorithm to find the maximum profit.
 * Note that you cannot sell a stock before you buy one.
 * <p>
 * Example 1:
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 *              Not 7-1 = 6, as selling price needs to be larger than buying price.
 * Example 2:
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */
public class T121_BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        T121_BestTimeToBuyAndSellStock t121 = new T121_BestTimeToBuyAndSellStock();
        System.out.println(t121.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(t121.maxProfit(new int[]{7, 6, 5, 3, 1}));
    }

    /**
     * 执行用时 : 2 ms ,  70.57%
     * 内存消耗 : 38 MB ,  57.01%
     * 时间复杂度 : O(n)
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int lowIndex = 0, max = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < prices[lowIndex])
                lowIndex = i;
            max = Math.max(prices[i] - prices[lowIndex], max);
        }
        return max;
    }

    /**
     * 对每日股票价格的求差，得到利润差数组，然后问题可以转化为
     * 求数组连续序列最大和问题。总收益等于每天股票价格变化的总和。
     * <p>
     * 执行用时 :2 ms, 60.63%
     * 内存消耗 :49.5 MB, 5.01%
     *
     * @see T53_MaximumSubarray
     */
    public int maxProfit1(int[] prices) {
        if (prices == null || prices.length <= 1)
            return 0;
        int len = prices.length;
        int diff, sum = 0, max = 0;
        for (int i = 1; i < len; i++) {
            diff = prices[i] - prices[i - 1];
            sum = sum > 0 ? sum + diff : diff;
            max = Math.max(max, sum);
        }
        return max;
    }
}
