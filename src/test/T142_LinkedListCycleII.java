package test;

import java.util.HashSet;
import java.util.Set;

/*
 * 142. Linked List Cycle II
 * Difficult: Medium
 * <p>
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed)
 * in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
 * Note: Do not modify the linked list.
 * <p>
 * Example 1:
 *      ↓   <-     ↑
 * 3 -> 2 -> 0 -> -4
 * Input: head = [3,2,0,-4], pos = 1
 * Output: tail connects to node index 1
 * Explanation: There is a cycle in the linked list, where tail connects to the second node.
 * <p>
 * Example 2:
 * ↓ <- ↑
 * 1 -> 2
 * Input: head = [1,2], pos = 0
 * Output: tail connects to node index 0
 * Explanation: There is a cycle in the linked list, where tail connects to the first node.
 * <p>
 * Example 3:
 * Input: head = [1], pos = -1
 * Output: no cycle
 * Explanation: There is no cycle in the linked list.
 * <p>
 * Follow-up:
 * Can you solve it without using extra space?
 */
public class T142_LinkedListCycleII {
    public static void main(String[] args) {
        ListNode l1 = ListNode.create(new int[]{3, 2, 0, -4});
        ListNode l2 = new ListNode(3);
        ListNode tail = l2.append(new int[]{2, 0, -4});
        tail.next = l2.next;  // node(2) is cycle head

        T142_LinkedListCycleII t = new T142_LinkedListCycleII();
        ListNode ans1 = t.detectCycle(l1);
        System.out.println(t.hasCycle(l1));
        System.out.println(ans1 == null ? null : ans1.val);

        ListNode ans2 = t.detectCycle(l2);
        System.out.println(t.hasCycle(l2));
        System.out.println(ans2 == null ? null : ans2.val);
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null)
            return null;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
                break;
        }
        // 无环直接返回null
        if (fast == null || fast.next == null)
            return null;
        // 有环时，此时slow和fast都指向相遇点
        // 相遇点和head同时出发，再次相遇时，就是环的入口
        while (head != slow) {
            head = head.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode detectCycle1(ListNode head) {
        if (head == null)
            return null;
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head))
                return head;
            set.add(head);
            head = head.next;
        }
        return null;
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;
        ListNode fast = head.next.next;
        ListNode slow = head;
        while (fast != null && fast != slow) {
            fast = fast.next == null ? null : fast.next.next;
            slow = slow.next;
        }
        return fast != null;
    }
}
