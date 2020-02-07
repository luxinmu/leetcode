package test;

/**
 * 19. Remove Nth Node From End of List
 * Difficult: Medium
 * Given a linked list, remove the n-th node from the end of list and return its head.
 * <p>
 * Example:
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * <p>
 * Note:
 * Given n will always be valid.
 * Follow up:
 * Could you do this in one pass?
 */
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
		T19_RemoveNthNodeFromEndofList t = new T19_RemoveNthNodeFromEndofList();
		ListNode.print(t.removeNthFromEnd(l1, 2));
		ListNode.print(t.removeNthFromEnd(l2, 4));
		ListNode.print(t.removeNthFromEnd(l3, 1));
		System.out.println("cost:" + (System.currentTimeMillis() - start) + "ms");
	}

	/**
	 * 双指针优化版。遍历一次，一个循环搞定
	 * 执行用时 :1 ms, 64.53%
	 * 内存消耗 :35 MB, 17.99%
	 */
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null || n <= 0)
			return null;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode fast = head;
		ListNode slow = dummy;
		while (fast != null) {
			fast = fast.next;
			if (n-- <= 0)
				slow = slow.next;
		}
		slow.next = slow.next.next;
		return dummy.next;
	}

	public ListNode removeNthFromEnd9(ListNode head, int n) {
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

	public ListNode removeNthFromEnd10(ListNode head, int n) {
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
