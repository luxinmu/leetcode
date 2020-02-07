package test;

public class T21_MergeTwoSortedLists {

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
		m1.next = m2;
		m2.next = m3;
		m3.next = m4;
		ListNode.print(n1);
		ListNode.print(m1);
		T21_MergeTwoSortedLists t = new T21_MergeTwoSortedLists();
		ListNode.print(t.mergeTwoLists(n1, m1));
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		ListNode dummy = new ListNode(0);
		ListNode p = dummy;
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				p.next = l1;
				l1 = l1.next;
				p = p.next;
			} else {
				p.next = l2;
				l2 = l2.next;
				p = p.next;
			}
		}
		p.next = l1 == null ? l2 : l1;
		return dummy.next;
	}

	public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		else if (l2 == null)
			return l1;
		else if (l1.val <= l2.val) {
			l1.next = mergeTwoLists1(l1.next, l2);
			return l1;
		} else {
			l2.next = mergeTwoLists1(l1, l2.next);
			return l2;
		}
	}

	public ListNode mergeTwoLists9(ListNode l1, ListNode l2) {
		ListNode dummy0 = new ListNode(0);
		ListNode merge = dummy0;
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				merge.next = new ListNode(l1.val);
				l1 = l1.next;
			} else {
				merge.next = new ListNode(l2.val);
				l2 = l2.next;
			}
			merge = merge.next;
		}
		merge.next = l1 == null ? l2 : l1;
		return dummy0.next;
	}

	public ListNode mergeTwoLists10(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		ListNode dummy0 = new ListNode(0);
		ListNode merge = dummy0;
		while (l1 != null || l2 != null) {
			if (l1 != null && l2 != null) {
				if (l1.val <= l2.val) {
					merge.next = new ListNode(l1.val);
					l1 = l1.next;
				} else {
					merge.next = new ListNode(l2.val);
					l2 = l2.next;
				}
			} else if (l1 == null) {
				merge.next = l2;
				break;
			} else if (l2 == null) {
				merge.next = l1;
				break;
			}
			merge = merge.next;
		}
		return dummy0.next;
	}
}
