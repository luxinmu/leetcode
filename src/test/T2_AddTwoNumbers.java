package test;

public class T2_AddTwoNumbers {

	public static void main(String[] args) {
		ListNode n1 = new ListNode(2);
		ListNode l1 = n1;
		ListNode n2 = new ListNode(4);
		ListNode n3 = new ListNode(3);
		n1.next = n2;
		n2.next = n3;
		ListNode m1 = new ListNode(0);
		ListNode l2 = m1;
		ListNode m2 = new ListNode(6);
		ListNode m3 = new ListNode(6);
		ListNode m4 = new ListNode(9);
		m1.next = m2;
		m2.next = m3;
		m3.next = m4;
		while (n1 != null) {
			System.out.print(n1.val + ",");
			n1 = n1.next;
		}
		System.out.println();
		while (m1 != null) {
			System.out.print(m1.val + ",");
			m1 = m1.next;
		}
		System.out.println();
		ListNode add = addTwoNumbers2(l1, l2);
		while (add != null) {
			System.out.print(add.val + ",");
			add = add.next;
		}
		System.out.println();
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode head = null;
		ListNode temp = null;
		boolean carry = false;
		while (l1 != null && l2 != null) {
			if (head == null) {
				temp = new ListNode((l1.val + l2.val) % 10);
				head = temp;
			} else {
				temp.next = new ListNode((l1.val + l2.val + (carry ? 1 : 0)) % 10);
				temp = temp.next;
			}
			carry = (l1.val + l2.val + (carry ? 1 : 0)) / 10 > 0 ? true : false;
			l1 = l1.next;
			l2 = l2.next;
		}

		while (l1 != null) {
			temp.next = new ListNode((l1.val + (carry ? 1 : 0)) % 10);
			temp = temp.next;
			carry = (l1.val + (carry ? 1 : 0)) / 10 > 0 ? true : false;
			l1 = l1.next;
		}

		while (l2 != null) {
			temp.next = new ListNode((l2.val + (carry ? 1 : 0)) % 10);
			temp = temp.next;
			carry = (l2.val + (carry ? 1 : 0)) / 10 > 0 ? true : false;
			l2 = l2.next;
		}
		if (carry)
			temp.next = new ListNode(1);
		return head;
	}

	public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
		ListNode head = null;
		ListNode temp = null;
		int carry = 0;
		int sum;
		while (l1 != null || l2 != null) {
			sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
			if (head == null) {
				temp = new ListNode(sum % 10);
				carry = sum / 10;
				head = temp;
			} else {
				temp.next = new ListNode(sum % 10);
				carry = sum / 10;
				temp = temp.next;
			}
			if (l1 != null)
				l1 = l1.next;
			if (l2 != null)
				l2 = l2.next;
		}
		if (carry > 0)
			temp.next = new ListNode(1);
		return head;
	}

	public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		ListNode temp = dummy;
		int carry = 0;
		int sum;
		while (l1 != null || l2 != null) {
			sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
			temp.next = new ListNode(sum % 10);
			temp = temp.next;
			carry = sum / 10;
			if (l1 != null)
				l1 = l1.next;
			if (l2 != null)
				l2 = l2.next;
		}
		if (carry > 0)
			temp.next = new ListNode(1);
		return dummy.next;
	}
}
