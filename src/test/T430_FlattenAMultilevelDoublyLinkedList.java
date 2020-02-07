package test;

/*
 * 430. Flatten a Multilevel Doubly Linked List
 * Difficult: Medium
 * <p>
 * You are given a doubly linked list which in addition to the next and previous pointers,
 * it could have a child pointer, which may or may not point to a separate doubly linked list.
 * These child lists may have one or more children of their own, and so on,
 * to produce a multilevel data structure, as shown in the example below.
 * <p>
 * Flatten the list so that all the nodes appear in a single-level,
 * doubly linked list. You are given the head of the first level of the list.
 * <p>
 * Example 1:
 * Input: head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
 * Output: [1,2,3,7,8,11,12,9,10,4,5,6]
 * Explanation:
 * <p>
 * The multilevel linked list in the input is as follows:
 * After flattening the multilevel linked list it becomes:
 * Example 2:
 * Input: head = [1,2,null,3]
 * Output: [1,3,2]
 * Explanation:
 * The input multilevel linked list is as follows:
 * 1---2---NULL
 * |
 * 3---NULL
 * <p>
 * Example 3:
 * Input: head = []
 * Output: []
 * How multilevel linked list is represented in test case:
 * We use the multilevel linked list from Example 1 above:
 * 1---2---3---4---5---6--NULL
 *         |
 *         7---8---9---10--NULL
 *             |
 *            11--12--NULL
 * The serialization of each level is as follows:
 * <p>
 * [1,2,3,4,5,6,null]
 * [7,8,9,10,null]
 * [11,12,null]
 * <p>
 * To serialize all levels together we will add nulls in each level to signify no node connects
 * to the upper node of the previous level. The serialization becomes:
 * <p>
 * [1,2,3,4,5,6,null]
 * [null,null,7,8,9,10,null]
 * [null,11,12,null]
 * <p>
 * Merging the serialization of each level and removing trailing nulls we obtain:
 * [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
 * <p>
 * Constraints:
 * Number of Nodes will not exceed 1000.
 * 1 <= Node.val <= 10^5
 */

import java.util.Stack;

/**
 * @see T114_FlattenBinaryTreeToLinkedList
 */
public class T430_FlattenAMultilevelDoublyLinkedList {

    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node(int val) {
            this.val = val;
        }

        public Node(int _val, Node _prev, Node _next, Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }

        public static void show(Node head) {
            while (head != null) {
                System.out.print(head.val + ", ");
                head = head.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        T430_FlattenAMultilevelDoublyLinkedList t = new T430_FlattenAMultilevelDoublyLinkedList();
        Node n1 = new Node(1);
        Node n2 = new Node(2, n1, null, null);
        Node n3 = new Node(3, n2, null, null);
        Node n4 = new Node(4, n3, null, null);
        Node n5 = new Node(5, n4, null, null);
        Node n6 = new Node(6, n5, null, null);
        Node n7 = new Node(7, n6, null, null);
        Node n8 = new Node(8, n7, null, null);
        Node n9 = new Node(9, n8, null, null);
        Node n10 = new Node(10, n9, null, null);
        Node n11 = new Node(11, n10, null, null);
        Node n12 = new Node(12, n11, null, null);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n7.next = n8;
        n8.next = n9;
        n9.next = n10;
        n11.next = n12;
        n3.child = n7;
        n8.child = n11;
        Node.show(n1);
        Node.show(n7);
        Node.show(n11);
        /*
         * 1---2---3---4---5---6--NULL
         *         |
         *         7---8---9---10--NULL
         *             |
         *            11--12--NULL
         */
        Node.show(t.flatten1(n1));
    }

    /**
     * 递归加迭代的解法，参考114题二叉树的展开，看着图做就行。
     * 执行用时 :0 ms, 100.00%
     * 内存消耗 :35.7 MB, 84.25%
     */
    public Node flatten(Node head) {
        if (head == null)
            return null;
        // 当前结点的child为null，展开next，返回当前结点即可。
        if (head.child == null) {
            flatten(head.next);
            return head;
        }
        Node next = head.next;  // 记录next
        Node childFlatten = flatten(head.child);  //展开child节点
        head.child = null;  // child节点置null
        head.next = childFlatten;  // 双链表next prev赋值
        childFlatten.prev = head;
        while (childFlatten.next != null)  //找到展开的子节点的尾节点
            childFlatten = childFlatten.next;
        childFlatten.next = next;
        if (next != null)
            next.prev = childFlatten;
        flatten(next);  //继续展开next节点
        return head;
    }

    /**
     * 利用栈进行迭代
     * 执行用时 :0 ms, 100.00%
     * 内存消耗 :35.8 MB, 75.59%
     */
    public Node flatten1(Node head) {
        if (head == null)
            return null;
        Stack<Node> stack = new Stack<>();
        Node dummy = new Node(0);
        Node prev = dummy;
        Node cur;
        stack.push(head);
        while (!stack.isEmpty()) {
            cur = stack.pop();
            prev.next = cur;
            cur.prev = prev;
            //优化，当无child节点时，直接向后移动当前指针，无需反复出入栈
            while (cur.child == null && cur.next != null)
                cur = cur.next;
            prev = cur;
            if (cur.next != null)
                stack.push(cur.next);
            if (cur.child != null) {
                stack.push(cur.child);
                cur.child = null;  // KEYPOINT
            }
        }
        dummy.next.prev = null;
        return dummy.next;
    }
}

