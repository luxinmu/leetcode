package test;

import java.util.Arrays;

/**
 * 300. Longest Increasing Subsequence
 * Difficult: Medium
 * <p>
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 * Example:
 * Input: [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 * <p>
 * Note:
 * There may be more than one LIS combination, it is only necessary for you to return the length.
 * Your algorithm should run in O(n2) complexity.
 * Follow up: Could you improve it to O(n log n) time complexity?
 *
 * @see T3_LengthOfLongestSubstring
 * @see T334_IncreasingTripletSubsequence
 * @see T354_RussianDollEnvelopes
 * @see T673_NumberOfLongestIncreasingSubsequence
 */
public class T300_LongestIncreasingSubsequence {

    public static void main(String[] args) {
        T300_LongestIncreasingSubsequence test = new T300_LongestIncreasingSubsequence();
        System.out.println(test.lengthOfLIS1(new int[]{1, 4, 2, 8, 9, 11, 10, 3, 12, 7, 13, 6, 5}));
        System.out.println(test.lengthOfLIS1(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        System.out.println(test.lengthOfLIS1(new int[]{10, 9, 2, 5, 3, 7, 101, 6}));
        System.out.println(test.lengthOfLIS1(new int[]{7, 8, 1, 2}));
    }

    /**
     * 动态规划解法
     * 执行用时 :17 ms, 33.55%
     * 内存消耗 :41.2 MB, 5.00%
     */
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int len = nums.length;
        // 状态定义：dp[i]的值代表以nums[i]结尾的最长上升子序列的长度
        int[] dp = new int[len];
        // 初始状态：dp[i] 所有元素置1，含义是每个元素都至少可以单独成为子序列，此时长度都为1。
        Arrays.fill(dp, 1);
        int max = dp[0];
        /*
         * nums 10, 9, 2, 5, 3, 7, 101, 6
         * dp    1  1  1  2  2  3    4  3
         * max   1  1  1  2  2  3    4  4
         */
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                // 转移方程： 设 j∈[0,i)，考虑每轮计算新dp[i]时，遍历[0,i)列表区间，做以下判断：
                // 1.当 nums[i]>nums[j]时： nums[i]可以接在nums[j] 之后（此题要求严格递增），
                // 此情况下最长上升子序列长度为 dp[j]+1；
                // 2.当 nums[i]<=nums[j]时：nums[i]无法接在nums[j] 之后，此情况上升子序列不成立，跳过。
                // 上述所有 1.情况下计算出的dp[j]+1的最大值，j∈[0,i)。
                // 转移方程： dp[i] = max(dp[i], dp[j] + 1) for j in [0, i)。
                if (nums[j] < nums[i])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    /**
     * 扑克排序(二分查找)解法
     * 执行用时 :1 ms, 96.20%
     * 内存消耗 :40.6 MB, 5.00%
     * 时间复杂度O(nlogn)
     */
    public int lengthOfLIS1(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int[] pokers = new int[nums.length];
        // k为dp数组真实长度, 即扑克排序的牌堆数
        int k = 0;
        // 设low为二分查找未找到结果时，左边界的指向的位置
        // Arrays.binarySearch(array[], target)
        // 若其在数组中存在，则返回其索引；
        // 若不存在，则左边界low指向比target大的数中的最小值的索引，返回值为-(low+1)
        // 1 2 4 5 查找3, 左边界low指向元素4的索引2，返回-3
        // 1 2 4 5 查找6，左边界low指向索引4，返回-5
        // 1 2 4 5 查找-1，左边界low指向元素1的索引0，返回-1
        int low = 0;
        for (int num : nums) {
            int j = Arrays.binarySearch(pokers, 0, k, num);
            if (j < 0) {  //当在dp数组未找到num时，通过返回值算出low，low为这张牌要放的位置。
                low = -(j + 1);
                pokers[low] = num;
            }
            if (low == k) //当放的位置是队尾时，dp数组真实长度加一
                k++;
        }
        return k;
    }
}
