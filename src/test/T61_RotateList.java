package test;

public class T61_RotateList {
    public static void main(String[] args) {
        T61_RotateList t61 = new T61_RotateList();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        ListNode.print(n1);
        ListNode.print(t61.rotateRight(n1, 2));
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;
        int count = 1;  //链表节点数
        ListNode tail = head;
        while (tail.next != null) {
            count++;
            tail = tail.next;
        }
        tail.next = head;  //KEYPOINT make circle
        ListNode prevBreak = head;
        int loop = count - k % count - 1;  // KEYPOINT
        while (loop-- > 0)
            prevBreak = prevBreak.next;
        head = prevBreak.next;  //set new head
        prevBreak.next = null;  //cut circle
        return head;
    }
}
