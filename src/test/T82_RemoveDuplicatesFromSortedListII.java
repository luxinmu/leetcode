package test;

public class T82_RemoveDuplicatesFromSortedListII {
    public static void main(String[] args) {
        T82_RemoveDuplicatesFromSortedListII t82 = new T82_RemoveDuplicatesFromSortedListII();
        ListNode m1 = new ListNode(1);
        ListNode m2 = new ListNode(1);
        ListNode m3 = new ListNode(1);
        ListNode m4 = new ListNode(3);
        ListNode m5 = new ListNode(4);
        ListNode m6 = new ListNode(6);
        ListNode m7 = new ListNode(6);
        m1.next = m2;
        m2.next = m3;
        m3.next = m4;
        m4.next = m5;
        m5.next = m6;
        m6.next = m7;
        ListNode.print(m1);
        ListNode.print(t82.deleteDuplicates(m1));
    }

    /**
     * 执行用时 :1 ms, 98.69%
     * 内存消耗 :36.4 MB, 65.24%
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode ok = dummy;
        boolean isDel = false;
        while (head.next != null) {
            if (head.val == head.next.val)
                isDel = true;
            else {
                if (isDel) {
                    ok.next = head.next;
                    isDel = false;
                } else {
                    ok.next = head;
                    ok = ok.next;
                }
            }
            head = head.next;
        }
        if (isDel)
            ok.next = null;
        return dummy.next;
    }
}
