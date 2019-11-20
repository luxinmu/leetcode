package test;

public class T24_SwapNodesinPairs {

	public static void main(String[] args) {
		ListNode n1 = new ListNode(2);
		ListNode n2 = new ListNode(3);
		ListNode n3 = new ListNode(4);
		n1.next = n2;
		n2.next = n3;
		ListNode m1 = new ListNode(0);
		ListNode m2 = new ListNode(3);
		ListNode m3 = new ListNode(6);
		ListNode m4 = new ListNode(9);
		ListNode m5 = new ListNode(7);
		m1.next = m2;
		m2.next = m3;
		m3.next = m4;
		m4.next = m5;
		ListNode.print(n1);
		ListNode.print(m1);
		ListNode.print(swapPairs(n1));
		ListNode.print(swapPairs(m1));
	}

	public static ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode first = head;
		ListNode second = first.next;
		head = second;
		ListNode prev = null;
		while (second != null) {
			first.next = second.next;
			second.next = first;
			if (prev != null)
				prev.next = second;
			prev = first;
			first = first.next;
			second = first == null ? null : first.next;
		}
		return head;
	}

}
