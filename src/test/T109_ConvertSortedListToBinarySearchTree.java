package test;

/*
 * 109. Convert Sorted List to Binary Search Tree
 * Difficult: Medium
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 * For this problem, a height-balanced binary tree is defined as a binary tree in which
 * the depth of the two subtrees of every node never differ by more than 1.
 *
 * Example:
 * Given the sorted linked list: [-10,-3,0,5,9],
 *
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 */
public class T109_ConvertSortedListToBinarySearchTree {
    public static void main(String[] args) {
        T109_ConvertSortedListToBinarySearchTree t109 = new T109_ConvertSortedListToBinarySearchTree();
        ListNode list1 = ListNode.create(new int[]{-10, -3, 0, 5, 9});
        TreeNode.show(t109.sortedListToBST(list1));
        ListNode list2 = ListNode.create(new int[]{0, 1, 2, 3, 4, 5});
        TreeNode.show(t109.sortedListToBST(list2));
    }

    /**
     * 执行用时 :1 ms, 99.93%
     * 内存消耗 :39.3 MB, 96.69%
     */
    public TreeNode sortedListToBST(ListNode head) {
        return helper(head);
    }

    /*
     * 快慢指针法, 当快指针走到结尾时，慢指针走至链表总长度的中间位置.
     * */
    private TreeNode helper(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        ListNode prev = head;
        while (fast != null && fast.next != null) {
            prev = prev.next;
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode root = new TreeNode(slow.val);
        prev.next = null;
        root.left = helper(head);
        root.right = helper(slow.next);
        return root;
    }
}
