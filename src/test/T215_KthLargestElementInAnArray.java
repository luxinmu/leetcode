package test;

import java.util.PriorityQueue;

/**
 * 215. Kth Largest Element in an Array
 * Difficult: Medium
 * <p>
 * Find the kth largest element in an unsorted array.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * <p>
 * Example 1:
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 * <p>
 * Example 2:
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 *
 * @see test.T703_KthLargestElementInAStream.KthLargest
 */
public class T215_KthLargestElementInAnArray {
    public static void main(String[] args) {
        T215_KthLargestElementInAnArray test = new T215_KthLargestElementInAnArray();
        System.out.println(test.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        System.out.println(test.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }

    /**
     * 最小堆解法
     * 执行用时 :5 ms, 66.35%
     * 内存消耗 :46.6 MB, 5.08%
     * 当数组特别大时，构建K大小的最小堆，求第K大的值的空间复杂度为O(k)
     * 时间复杂度为O(Nlogk)
     */
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length < k)
            return -1;
        // comparator不指定时, PriortyQueue默认为最小堆
        PriorityQueue<Integer> q = new PriorityQueue<>();
//        PriorityQueue<Integer> q = new PriorityQueue<>((n1, n2) -> n1 - n2);
        for (int i = 0; i < k; i++)
            q.offer(nums[i]); //前k个元素入队
        Integer p;
        //后n - k个元素依次和队首元素比较，若大于堆顶元素，则堆顶出队，该元素入堆
        for (int i = k; i < nums.length; i++) {
            if ((p = q.peek()) != null && p < nums[i]) {
                q.poll();
                q.offer(nums[i]);
            }
        }
        //堆顶为第k大的数
        return (p = q.poll()) != null ? p : -1;
    }
}
