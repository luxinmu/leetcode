package test;

public class T86_PartitionList {
    public static void main(String[] args) {
        T86_PartitionList t86 = new T86_PartitionList();
        ListNode l = new ListNode();
        l.append(new int[]{1, 4, 3, 2, 5, 2});
        ListNode.print(l);
        ListNode.print(t86.partition(l, 3));
    }

    /**
     * 执行用时 : 0 ms , 100.00%
     * 内存消耗 : 35.5 MB , 57.14%
     */
    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;
        ListNode less = new ListNode(0);
        ListNode more = new ListNode(0);
        ListNode less0 = less, more0 = more;
        while (head != null) {
            if (head.val < x) {
                less.next = head;
                head = head.next;
                less = less.next;
                less.next = null;
            } else {
                more.next = head;
                head = head.next;
                more = more.next;
                more.next = null;
            }
        }
        less.next = more0.next;
        return less0.next;
    }
}
