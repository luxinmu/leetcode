package test;

/**
 * 53. Maximum Subarray
 * Difficult: Easy
 * <p>
 * Given an integer array nums, find the contiguous subarray (containing at least one number)
 * which has the largest sum and return its sum.
 * <p>
 * Example:
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * <p>
 * Follow up:
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 *
 * @see T300_LongestIncreasingSubsequence
 */
public class T53_MaximumSubarray {

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{1}));
        System.out.println(maxSubArray(new int[]{1, -1, -2}));
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int ans = nums[0];
        int sum = 0;
        for (int n : nums)
            ans = Math.max(sum = sum > 0 ? sum + n : n, ans);
        return ans;
    }

    /**
     * 关于Kadane算法
     * 最大子数组问题最早于1977年提出, 直到1984年卡内基梅隆大学的 Jay Kadane 才提出了该问题的线性算法.
     * 更多细节详见维基百科最大子数列问题
     * <p>
     * 可以用动态规划的思路来理解Kadane算法:
     * <p>
     * 如果 max_here > 0，则说明 max_here 对截止当前元素的结果有增益效果，则 max_here 保留并加上当前遍历数字
     * 如果 max_here <= 0，则说明 max_here 对截止当前元素的结果无增益效果，需要舍弃，则将 max_here 直接更新为当前遍历数字
     * 如果sum < 0, 找到最大的负数；
     * 如果sum > 0,找到所有sum组合中的最大的
     */
    public static int maxSubArray0(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int ans = nums[0];
        int sum = 0;
        for (int n : nums) {
            if (sum > 0)
                sum += n;
            else
                sum = n;
            ans = Math.max(sum, ans);
        }
        return ans;
    }

    public static int maxSubArray1(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int ans = Integer.MIN_VALUE;
        int i = 0;
        int sum = nums[0];
        while (++i < nums.length) {
            ans = Math.max(ans, sum);
            sum = sum < 0 ? Math.max(sum, nums[i]) : sum + nums[i];
        }
        return Math.max(ans, sum);
    }

    /**
     * 动态规划解法
     * dp[i]表示当前位置为止子序列的最大和
     */
    public static int maxSubArray2(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        /*
         * nums: -2, 1, -3, 4, -1, 2, 1, -5, 4
         * dp  : -2, 1, -2, 4,  3, 5, 6,  1, 5
         * max : -2, 1,  1, 4,  4, 5, 6,  6, 6
         */
        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[i - 1] > 0 ? nums[i] + dp[i - 1] : nums[i];
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
