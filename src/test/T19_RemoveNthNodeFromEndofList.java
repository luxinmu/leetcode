package test;

public class T19_RemoveNthNodeFromEndofList {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		ListNode n1 = new ListNode(2);
		ListNode l1 = n1;
		ListNode n2 = new ListNode(4);
		ListNode n3 = new ListNode(3);
		n1.next = n2;
		n2.next = n3;
		ListNode m1 = new ListNode(0);
		ListNode l2 = m1;
		ListNode m2 = new ListNode(3);
		ListNode m3 = new ListNode(6);
		ListNode m4 = new ListNode(9);
		m1.next = m2;
		m2.next = m3;
		m3.next = m4;
		ListNode q1 = new ListNode(8);
		ListNode l3 = q1;
		ListNode.print(l1);
		ListNode.print(l2);
		ListNode.print(l3);
		ListNode.print(removeNthFromEnd(l1, 2));
		ListNode.print(removeNthFromEnd(l2, 4));
		ListNode.print(removeNthFromEnd(l3, 1));
		System.out.println("cost:" + (System.currentTimeMillis() - start) + "ms");
	}

	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummy0 = new ListNode(0);
		dummy0.next = head;
		ListNode first = dummy0;
		ListNode second = dummy0;
		for (int i = 0; i <= n; i++) {
			first = first.next;
		}
		while (first != null) {
			first = first.next;
			second = second.next;
		}
		second.next = second.next.next;
		return dummy0.next;
	}

	public static ListNode removeNthFromEnd10(ListNode head, int n) {
		if (head == null || n <= 0)
			return null;
		ListNode first = head;
		int len = 0;
		while (first != null) {
			first = first.next;
			len++;
		}
		if (len < n)
			return head;
		ListNode dummy0 = new ListNode(0);
		dummy0.next = head;
		first = dummy0;
		int k = len - n;
		while (k-- > 0) {
			first = first.next;
		}
		first.next = first.next.next;
		return dummy0.next;
	}
}
