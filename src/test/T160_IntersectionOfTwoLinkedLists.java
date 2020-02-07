package test;

/**
 * 160. Intersection of Two Linked Lists
 * Difficult: Easy
 * <p>
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * For example, the following two linked lists:
 * begin to intersect at node c1.
 * <p>
 * Example 1:
 * Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * Output: Reference of the node with value = 8
 * Input Explanation: The intersected node's value is 8(note that this must not be 0 if the two
 * lists intersect).From the head of A, it reads as [4,1,8,4,5]. From the head of B,
 * it reads as [5,0,1,8,4,5].
 * There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.
 * <p>
 * Example 2:
 * Input: intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * Output: Reference of the node with value = 2
 * Input Explanation: The intersected node's value is 2 (note that this must not be 0 if the two
 * lists intersect). From the head of A, it reads as [0,9,1,2,4]. From the head of B, it reads as [3,2,4].
 * There are 3 nodes before the intersected node in A; There are 1 node before the intersected node in B.
 * <p>
 * Example 3:
 * Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * Output: null
 * Input Explanation: From the head of A, it reads as [2,6,4]. From the head of B, it reads as [1,5].
 * Since the two lists do not intersect, intersectVal must be 0,
 * while skipA and skipB can be arbitrary values.
 * Explanation: The two lists do not intersect, so return null.
 * <p>
 * Notes:
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 */
public class T160_IntersectionOfTwoLinkedLists {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n4;
        n3.next = n4;
        n4.next = n5;
        T160_IntersectionOfTwoLinkedLists t = new T160_IntersectionOfTwoLinkedLists();
        ListNode i = t.getIntersectionNode(n1, n3);
        System.out.println(i == null ? null : i.val);
    }

    /**
     * A和B分别出发，当A走到末尾时，赋值为B的头，
     * 同样，B走至结尾时，赋值为A，当A等于B，结束循环。此时有两种情况，
     * 1、hA为空，证明不相交；
     * 2、hA不为空，则此结点就是交互结点。
     * 执行用时 :1 ms, 100.00%
     * 内存消耗 :41.9 MB, 16.87%
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode hA = headA;
        ListNode hB = headB;
        while (hA != hB) {
            hA = hA != null ? hA.next : headB;
            hB = hB != null ? hB.next : headA;
        }
        return hA;
    }
}
