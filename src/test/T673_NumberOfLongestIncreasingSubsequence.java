package test;

import java.util.Arrays;

/**
 * 673. Number of Longest Increasing Subsequence
 * Difficult: medium
 * <p>
 * Given an unsorted array of integers, find the number of longest increasing subsequence.
 * <p>
 * Example 1:
 * Input: [1,3,5,4,7]
 * Output: 2
 * Explanation: The two longest increasing subsequence are [1, 3, 4, 7] and [1, 3, 5, 7].
 * <p>
 * Example 2:
 * Input: [2,2,2,2,2]
 * Output: 5
 * Explanation: The length of longest continuous increasing subsequence is 1,
 * and there are 5 subsequences' length is 1, so output 5.
 * <p>
 * Note: Length of the given array will be not exceed 2000 and the answer
 * is guaranteed to be fit in 32-bit signed int.
 *
 * @see T300_LongestIncreasingSubsequence
 */
public class T673_NumberOfLongestIncreasingSubsequence {
    public static void main(String[] args) {
        T673_NumberOfLongestIncreasingSubsequence test = new T673_NumberOfLongestIncreasingSubsequence();
        System.out.println(test.findNumberOfLIS(new int[]{1, 3, 5, 4, 7}));
        System.out.println(test.findNumberOfLIS(new int[]{2, 2, 2, 2, 2}));
        System.out.println(test.findNumberOfLIS(new int[]{2, 6, 5, 4, 1, 3, 7}));
    }

    /**
     * ��̬�滮����
     * ִ����ʱ :18 ms, 47.27%
     * �ڴ����� :40 MB, 7.44%
     */
    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int len = nums.length;
        // ״̬���壺dp[i]��ʾ��nums[i]��β������������еĳ���
        int[] dp = new int[len];
        // ״̬���壺count[i]��ʾ��nums[i]��β������������еĸ���
        int[] count = new int[len];
        int max = dp[0];
        // ��ʼ״̬��dp[i] ����Ԫ����1��������ÿ��Ԫ�ض����ٿ��Ե�����Ϊ�����У���ʱ���ȶ�Ϊ1��
        Arrays.fill(dp, 1);
        // ��ʼ״̬��count[i] ����Ԫ����1�����������������β��������е����������һ�֡�
        Arrays.fill(count, 1);
        /*
         * nums  2, 6, 5, 4, 1, 3, 7
         * dp    1  2  2  2  1  2  3
         * max   1  2  2  2  2  2  3
         * count 1  1  1  1  1  2  5
         */
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    } else if (dp[i] == dp[j] + 1)
                        count[i] += count[j];
                }
            }
            //����������еĳ���
            max = Math.max(max, dp[i]);
        }
        int cnt = 0;
        for (int i = 0; i < len; i++)
            if (dp[i] == max)
                cnt += count[i];
        return cnt;
    }
}
