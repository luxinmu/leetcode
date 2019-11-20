package test;

public class ListNode {

	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
	
	public static void print(ListNode head) {
		while (head != null) {
			System.out.print(head.val + (head.next != null ? "->" : ""));
			head = head.next;
		}
		System.out.println();
	}
}
