package test;

/**
 * 92. Reverse Linked List II
 * Reverse a linked list from position m to n. Do it in one-pass.
 * Note: 1 ≤ m ≤ n ≤ length of list.
 * <p>
 * Example:
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
 */
public class T92_ReverseLinkedListII {
    public static void main(String[] args) {
        T92_ReverseLinkedListII t92 = new T92_ReverseLinkedListII();
        ListNode list = ListNode.create(new int[]{1, 2, 3, 4, 5});
        ListNode.print(t92.reverseBetween(list, 2, 5));
    }

    /**
     * 执行用时 : 0 ms , 100.00%
     * 内存消耗 : 34.3 MB , 84.83%
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        int k = n - m + 1;  //得到翻转次数
        while (--m > 0)     //cur指向首个翻转点之前节点
            cur = cur.next;
        while (n-- > 0)     //head指向翻转部分后首节点
            head = head.next;
        ListNode pre = cur;
        cur = cur.next;
        ListNode oriNext;
        while (k-- > 0) {
            oriNext = cur.next;  // KEYPOINT
            cur.next = head;
            head = cur;
            cur = oriNext;
        }
        pre.next = head;
        return dummy.next;
    }
}
