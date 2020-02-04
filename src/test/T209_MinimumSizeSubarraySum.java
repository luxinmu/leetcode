package test;

/**
 * 209. Minimum Size Subarray Sum
 * Difficult: Medium
 * <p>
 * Given an array of n positive integers and a positive integer s,
 * find the minimal length of a contiguous subarray of which the sum ≥ s.
 * If there isn't one, return 0 instead.
 * <p>
 * Example:
 * Input: s = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: the subarray [4,3] has the minimal length under the problem constraint.
 * <p>
 * Follow up:
 * If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
 */
public class T209_MinimumSizeSubarraySum {

    public static void main(String[] args) {
        T209_MinimumSizeSubarraySum t209 = new T209_MinimumSizeSubarraySum();
        System.out.println(t209.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }

    /**
     * 滑动窗口解法
     * 执行用时 :2 ms, 89.40%
     * 内存消耗 :36.8 MB, 98.33%
     */
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int i = -1;  //左端点
        int j = 0;  //右端点
        int sum = 0;
        int min = Integer.MAX_VALUE;
        while (j < nums.length || sum >= s) {
            if (sum < s) {
                sum += nums[j++];
            } else {
                min = Math.min(min, j - i - 1);
                sum -= nums[++i];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
