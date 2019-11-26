package test;

public class T83_RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        T83_RemoveDuplicatesFromSortedList t83 = new T83_RemoveDuplicatesFromSortedList();
        ListNode m1 = new ListNode(1);
        ListNode m2 = new ListNode(1);
        ListNode m3 = new ListNode(2);
        ListNode m4 = new ListNode(3);
        ListNode m5 = new ListNode(3);
        m1.next = m2;
        m2.next = m3;
        m3.next = m4;
        m4.next = m5;
        ListNode.print(m1);
        ListNode.print(t83.deleteDuplicates(m1));
    }

    /**
     * 执行用时 : 1 ms , 99.00%
     * 内存消耗 : 36.4 MB , 69.99% 的用户
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode head0 = head;
        while (head.next != null)
            if (head.val == head.next.val)
                head.next = head.next.next;
            else
                head = head.next;
        return head0;
    }
}
