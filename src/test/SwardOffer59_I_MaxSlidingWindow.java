package test;

/*
 * 59. 滑动窗口的最大值
 * Difficult: Easy
 * <p>
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 * Example:
 * Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * <p>
 * Note:
 * 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
 * Follow up:
 * Could you solve it in linear time?
 *
 */

/**
 * @see SwardOffer59_II_MaxQueue
 * @see T239_SlidingWindowMaximum
 */
public class SwardOffer59_I_MaxSlidingWindow {

    public static void main(String[] args) {
        SwardOffer59_I_MaxSlidingWindow test = new SwardOffer59_I_MaxSlidingWindow();
        Tools.printArray(test.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3));
    }

    /**
     * 维护一个最大队，保持队列长度为k，每入队出队一次，取一次最大值
     * 执行用时 :16 ms, 59.91%
     * 内存消耗 :48.7 MB, 100.00%
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 1)
            return nums;
        int len = nums.length;
        if (len <= k)
            return new int[]{getMax(nums)};
        int[] ans = new int[len - k + 1];  //返回结果长度可以计算
        int j = 0;
        //定义一个最大队列，使用其性质进行求解
        SwardOffer59_II_MaxQueue window = new SwardOffer59_II_MaxQueue();
        for (int i = 0; i < len; i++) {
            if (i >= k) {
                ans[j++] = window.max_value();
                window.pop_front();
            }
            window.push_back(nums[i]);
        }
        ans[j] = window.max_value();  //最后一个元素入队后，未取最大值，需获取
        return ans;
    }

    private int getMax(int[] nums) {
        int max = nums[0];
        for (int n : nums)
            if (max < n)
                max = n;
        return max;
    }
}
