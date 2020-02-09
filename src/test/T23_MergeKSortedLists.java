package test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 23. Merge k Sorted Lists
 * Difficult: Hard
 * <p>
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * Example:
 * Input:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 *
 * @see T21_MergeTwoSortedLists
 */
public class T23_MergeKSortedLists {

    public static void main(String[] args) {
        T23_MergeKSortedLists t = new T23_MergeKSortedLists();
        ListNode[] lists = new ListNode[3];
        lists[0] = ListNode.create(new int[]{1, 4, 5});
        lists[1] = ListNode.create(new int[]{1, 3, 4});
        lists[2] = ListNode.create(new int[]{2, 6});
        for (ListNode l : lists) ListNode.print(l);
        ListNode.print(t.mergeKLists(lists));

    }

    /**
     * 快慢指针解法
     * 执行用时 :4 ms, 71.87%
     * 内存消耗 :41.1 MB, 57.51%
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null)
            return null;
        int left = 0;
        int right = lists.length - 1;
        while (right > 0) {
            // 单次merge， 对前后两部分链表进行两两合并，结果赋给前面的节点
            // 单次merge的时间复杂度为O(n)
            // K路merge一次变为K/2，需要logK次merge，时间复杂度O(logK)
            // 总时间复杂度O(nlogK)
            while (left < right)
                lists[left] = mergeTwoLists(lists[left++], lists[right--]);
            left = 0;
        }
        return lists[0];
    }

    /**
     * 辅助队列解法
     * 执行用时 :6 ms, 59.36%
     * 内存消耗 :43.1 MB, 33.73%
     */
    public ListNode mergeKLists1(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;
        Queue<ListNode> queue = new LinkedList<>();
        for (ListNode l : lists)
            if (l != null)
                queue.offer(l);
        while (queue.size() > 1) {
            ListNode l1 = queue.poll();
            ListNode l2 = queue.poll();
            queue.offer(mergeTwoLists(l1, l2));
        }
        return queue.poll();
    }

    /**
     * 逐一合并的解法
     * 执行用时 :198 ms, 19.04%
     * 内存消耗 :49.4 MB, 24.30%
     */
    public ListNode mergeKLists10(ListNode[] lists) {
        if (lists == null)
            return null;
        ListNode ans = null;
        for (ListNode l : lists)
            ans = mergeTwoLists(ans, l);
        return ans;
    }

    /**
     * @see T21_MergeTwoSortedLists
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        else if (l2 == null)
            return l1;
        else if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
