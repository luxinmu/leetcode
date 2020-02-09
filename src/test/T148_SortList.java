package test;

/**
 * 148. Sort List
 * Difficult: Medium
 * <p>
 * Sort a linked list in O(n log n) time using constant space complexity.
 * Example 1:
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 * <p>
 * Example 2:
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
 *
 * @see test.T21_MergeTwoSortedLists
 * @see test.T23_MergeKSortedLists
 */
public class T148_SortList {

    public static void main(String[] args) {
        ListNode list = ListNode.create(new int[]{4, 2, 1, 3});
        T148_SortList test = new T148_SortList();
        ListNode.print(test.sortList(list));
    }

    /**
     * 归并排序解法，有两个大的步骤
     * 1、利用快慢指针分而治之
     * 2、子链表合并
     * 执行用时 :4 ms, 81.48%
     * 内存消耗 :40.1 MB, 58.86%
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode fast = head.next;
        ListNode slow = head;
        //模板代码，停止循环时，slow为链表中点
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = slow.next;  //复用fast， slow为中间，此时fast相当于mid + 1
        slow.next = null;  //从中点cut链表
        head = sortList(head);
        fast = sortList(fast);
        return mergeTwoLists(head, fast);
    }

    /**
     * @see test.T21_MergeTwoSortedLists
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null)
            return l1 == null ? l2 : l1;
        ListNode head;
        if (l1.val <= l2.val) {
            head = l1;
            l1 = l1.next;
        } else {
            head = l2;
            l2 = l2.next;
        }
        ListNode p = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        p.next = l1 == null ? l2 : l1;
        return head;
    }
}
