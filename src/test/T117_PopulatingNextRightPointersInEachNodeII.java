package test;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 117. Populating Next Right Pointers in Each Node II
 * Difficult: Medium
 *
 * Given a binary tree:
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
 *     /   \                   /   \
 *   2       3               2  ->  3 -> null
 *  / \       \            /   \     \
 * 4   5       7          4 ->  5  -> 7 -> null
 *
 * Input: root = [1,2,3,4,5,null,7]
 * Output: [1,#,2,3,#,4,5,7,#]
 * Explanation: Given the above binary tree (Figure A), your function should populate
 * each next pointer to point to its next right node, just like in Figure B.
 * The serialized output is in level order as connected by the next pointers,
 * with '#' signifying the end of each level.
 *
 * Constraints:
 * The number of nodes in the given tree is less than 6000.
 * -100 <= node.val <= 100
 */
public class T117_PopulatingNextRightPointersInEachNodeII {
    public static void main(String[] args) {
        T117_PopulatingNextRightPointersInEachNodeII t116 = new T117_PopulatingNextRightPointersInEachNodeII();
        Node tree1 = Node.plantTree(new Integer[]{1, 2, 3, 4, 5, null, 7});
        Node.show(tree1);
        t116.connect(tree1);
        Node.showNext(tree1);

        Node tree2 = Node.plantTree(new Integer[]{2, 1, 3, 0, 7, 9, 1, 2, null, 1, 0, null, null, 8, 8, null, null, null, null, 7});
        Node.show(tree2);
        t116.connect(tree2);
        Node.showNext(tree2);
    }

    /**
     * 递归法
     * 执行用时 : 0 ms , 100.00%
     * 内存消耗 : 37.5 MB , 100.00%
     */
    public Node connect(Node root) {
        if (root == null) return null;
        if (root.left != null)
            root.left.next = root.right != null ? root.right : findLeft(root.next);
        if (root.right != null)
            root.right.next = findLeft(root.next);
        //一定要先右后左, 否则会出现构建左侧子树的next时,
        // 右侧子树next还未构建,会得到root的最左子节点为null.
        connect(root.right);  // KEYPOINT
        connect(root.left);   // KEYPOINT
        return root;
    }

    private Node findLeft(Node root) {
        while (root != null) {  //KEYPOINT
            if (root.left != null) return root.left;
            if (root.right != null) return root.right;
            root = root.next;
        }
        return null;
    }

    /**
     * BFS法
     * 执行用时 : 2 ms , 56.08%
     * 内存消耗 : 37.8 MB , 100.00%
     */
    public Node connect1(Node root) {
        if (root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int curLvlNum = 1;
        int nextLvlNum = 0;
        Node curNode, preNode = null;
        boolean first = true;
        while (!queue.isEmpty()) {
            curNode = queue.poll();
            if (curNode.left != null) {
                nextLvlNum++;
                queue.offer(curNode.left);
            }
            if (curNode.right != null) {
                nextLvlNum++;
                queue.offer(curNode.right);
            }
            if (curLvlNum > 0) {
                if (first) {
                    preNode = curNode;
                    first = false;
                } else {
                    preNode.next = curNode;
                    preNode = preNode.next;
                }
            }
            if (--curLvlNum == 0) {
                curLvlNum = nextLvlNum;
                nextLvlNum = 0;
                first = true;
            }
        }
        return root;
    }
}