package test;

/*
 * 239. Sliding Window Maximum
 * Difficult: Hard
 * <p>
 * Given an array nums, there is a sliding window of size k which is moving from the very
 * left of the array to the very right. You can only see the k numbers in the window.
 * Each time the sliding window moves right by one position. Return the max sliding window.
 * <p>
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
 * You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.
 * Follow up:
 * Could you solve it in linear time?
 */

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @see SwardOffer59_I_MaxSlidingWindow
 * @see SwardOffer59_II_MaxQueue
 * @see T155_MinStack
 */
public class T239_SlidingWindowMaximum {

    public static void main(String[] args) {
        T239_SlidingWindowMaximum test = new T239_SlidingWindowMaximum();
        Tools.printArray(test.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 1)
            return nums;
        int len = nums.length;
        if (len <= k)
            return new int[]{getMax(nums)};
        int[] ans = new int[len - k + 1];
        int j = 0;
        MaxQueue queue = new MaxQueue();
        for (int i = 0; i < len; i++) {
            if (i >= k) {
                ans[j++] = queue.max_value();
                queue.pop_front();
            }
            queue.push_back(nums[i]);
        }
        ans[j] = queue.max_value();
        return ans;
    }

    private int getMax(int[] nums) {
        int max = nums[0];
        for (int n : nums)
            if (max < n)
                max = n;
        return max;
    }

    private static class MaxQueue {

        // 保存元素
        private Queue<Integer> Q;

        // 双端队列，队头为当前序列最大值
        private Deque<Integer> maxQ;

        public MaxQueue() {
            Q = new LinkedList<>();
            maxQ = new LinkedList<>();
        }

        public int max_value() {
            return maxQ.size() > 0 ? maxQ.getFirst() : -1;
        }

        public void push_back(int value) {
            Q.add(value);  //队尾插入
            //当最大队列不为空，且队尾元素小于要插入的元素时，移除队尾元素
            //目的是将最大队中，小于当前元素的值全部移除
            while (!maxQ.isEmpty() && maxQ.getLast() < value)
                maxQ.removeLast();
            maxQ.addLast(value);
        }

        public void pop_front() {
            if (Q.size() == 0)
                return;
            int v = Q.poll();  //队头取出
            if (v == maxQ.getFirst())
                maxQ.removeFirst();
        }
    }
}
