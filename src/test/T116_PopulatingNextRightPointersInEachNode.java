package test;

/*
 * 116. Populating Next Right Pointers in Each Node
 * Difficult: Medium
 *
 * You are given a perfect binary tree where all leaves are on the same level,
 * and every parent has two children. The binary tree has the following definition:
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * Populate each next pointer to point to its next right node.
 * If there is no next right node, the next pointer should be set to NULL.
 * Initially, all next pointers are set to NULL.
 *
 * Follow up:
 * You may only use constant extra space.
 * Recursive approach is fine, you may assume implicit stack space does not count as extra space for this problem.
 *  
 * Example 1:
 *       1                       1 -> null
 *     /   \                   /    \
 *   2       3               2   ->   3 -> null
 *  / \     / \            /  \     /   \
 * 4   5   6   7          4 -> 5 -> 6 -> 7 -> null
 * Input: root = [1,2,3,4,5,6,7]
 * Output: [1,#,2,3,#,4,5,6,7,#]
 * Explanation: Given the above perfect binary tree (Figure A),
 * your function should populate each next pointer to point to its next right node, just like in Figure B.
 * The serialized output is in level order as connected by the next pointers,
 * with '#' signifying the end of each level.
 *  
 * Constraints:
 * The number of nodes in the given tree is less than 4096.
 * -1000 <= node.val <= 1000
 */
public class T116_PopulatingNextRightPointersInEachNode {
    public static void main(String[] args) {
        T116_PopulatingNextRightPointersInEachNode t116 = new T116_PopulatingNextRightPointersInEachNode();
        Node tree1 = Node.plantTree(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        Node.show(tree1);
        t116.connect(tree1);
        Node.showNext(tree1);
    }

    /**
     * 执行用时 : 0 ms , 100.00%
     * 内存消耗 : 39.1 MB , 31.58%
     */
    public Node connect(Node root) {
        if (root == null || root.left == null) return root;
        root.left.next = root.right;
        if (root.next != null)
            root.right.next = root.next.left;
        connect(root.left);
        connect(root.right);
        return root;
    }
}
