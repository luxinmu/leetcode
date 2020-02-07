package test;

/**
 * 92. Reverse Linked List II
 * Reverse a linked list from position m to n. Do it in one-pass.
 * Note: 1 ≤ m ≤ n ≤ length of list.
 * <p>
 * Example:
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
 */
public class T92_ReverseLinkedListII {
    public static void main(String[] args) {
        T92_ReverseLinkedListII t92 = new T92_ReverseLinkedListII();
        ListNode list = ListNode.create(new int[]{1, 2, 3, 4, 5});
        ListNode.print(t92.reverseBetween(list, 2, 5));
    }

    /**
     * 执行用时 : 0 ms , 100.00%
     * 内存消耗 : 34.3 MB , 84.83%
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        int k = n - m + 1;  //得到翻转次数
        while (--m > 0)     //cur指向首个翻转点之前节点
            cur = cur.next;
        while (n-- > 0)     //head指向翻转部分后首节点
            head = head.next;
        ListNode pre = cur;
        cur = cur.next;
        ListNode oriNext;
        while (k-- > 0) {
            oriNext = cur.next;  // KEYPOINT
            cur.next = head;
            head = cur;
            cur = oriNext;
        }
        pre.next = head;
        return dummy.next;
    }

    /**
     * 206. Reverse Linked List
     * Difficult: Easy
     * Reverse a singly linked list.
     * <p>
     * Example:
     * Input: 1->2->3->4->5->NULL
     * Output: 5->4->3->2->1->NULL
     */
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return null;

        ListNode pre = null, after;
        ListNode cur = head;
        // 容易想糊涂, 拿纸画一下, 找中间的一个结点, 写一下该结点赋值过程。
        while (cur != null) {
            after = cur.next;
            cur.next = pre;
            pre = cur;
            cur = after;
        }
        return pre;
    }

    /**
     * 203. Remove Linked List Elements
     * Difficult: Easy
     * <p>
     * Remove all elements from a linked list of integers that have value val.
     * Example:
     * Input:  1->2->6->3->4->5->6, val = 6
     * Output: 1->2->3->4->5
     * <p>
     * 执行用时 :1 ms, 100.00%
     * 内存消耗 :40.3 MB, 5.39%
     */
    public ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;
        ListNode pre = dummy;
        while (cur != null) {
            if (cur.val == val)
                pre.next = cur.next;
            else
                pre = cur;
            cur = cur.next;
        }
        return dummy.next;
    }

    /**
     * 237. Delete Node in a Linked List
     * Difficult: Easy
     * Write a function to delete a node (except the tail) in a singly linked list,
     * given only access to that node.
     * Given linked list -- head = [4,5,1,9], which looks like following:
     * Example 1:
     * Input: head = [4,5,1,9], node = 5
     * Output: [4,1,9]
     * Explanation: You are given the second node with value 5, the linked list should
     * become 4 -> 1 -> 9 after calling your function.
     * Note:
     * The linked list will have at least two elements.
     * All of the nodes' values will be unique.
     * The given node will not be the tail and it will always be a valid node of the linked list.
     * Do not return anything from your function.
     */
    public void deleteNode(ListNode node) {
        // 开始以为脑残题，后来才看明白，还挺巧妙的~ 题意就是删除当前结点，但没传入head，
        // 不知道当前结点的prev是啥， 没法在链表中删除当前结点，怎么办呢？
        // 那就把下一个结点的值赋给当前结点，删除下一个结点好了~
        node.val = node.next.val;
        node.next = node.next.next;
    }

    /**
     * 328. Odd Even Linked List
     * Difficult: Medium
     * <p>
     * Given a singly linked list, group all odd nodes together followed by the even nodes.
     * Please note here we are talking about the node number and not the value in the nodes.
     * You should try to do it in place. The program should run in O(1) space complexity
     * and O(nodes) time complexity.
     * <p>
     * Example 1:
     * Input: 1->2->3->4->5->NULL
     * Output: 1->3->5->2->4->NULL
     * <p>
     * 执行用时 :0 ms, 100.00%
     * 内存消耗 :36.3 MB, 55.50%
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = head.next;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
