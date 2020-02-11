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
 * You may assume k is always valid, 1 �� k �� array's length.
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
     * ��С�ѽⷨ
     * ִ����ʱ :5 ms, 66.35%
     * �ڴ����� :46.6 MB, 5.08%
     * �������ر��ʱ������K��С����С�ѣ����K���ֵ�Ŀռ临�Ӷ�ΪO(k)
     * ʱ�临�Ӷ�ΪO(Nlogk)
     */
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length < k)
            return -1;
        // comparator��ָ��ʱ, PriortyQueueĬ��Ϊ��С��
        PriorityQueue<Integer> q = new PriorityQueue<>();
//        PriorityQueue<Integer> q = new PriorityQueue<>((n1, n2) -> n1 - n2);
        for (int i = 0; i < k; i++)
            q.offer(nums[i]); //ǰk��Ԫ�����
        Integer p;
        //��n - k��Ԫ�����κͶ���Ԫ�رȽϣ������ڶѶ�Ԫ�أ���Ѷ����ӣ���Ԫ�����
        for (int i = k; i < nums.length; i++) {
            if ((p = q.peek()) != null && p < nums[i]) {
                q.poll();
                q.offer(nums[i]);
            }
        }
        //�Ѷ�Ϊ��k�����
        return (p = q.poll()) != null ? p : -1;
    }
}
