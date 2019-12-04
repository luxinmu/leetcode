package test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
 * 103. Binary Tree Zigzag Level Order Traversal
 * Difficult : Medium
 * Given a binary tree, return the zigzag level order traversal of its nodes' values.
 * (ie, from left to right, then right to left for the next level and alternate between).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its zigzag level order traversal as:
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 */
public class T103_BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {
        T103_BinaryTreeZigzagLevelOrderTraversal t103 = new T103_BinaryTreeZigzagLevelOrderTraversal();
        TreeNode tree1 = TreeNode.plantTree(new Integer[]{3, 9, 20, 2, 1, 15, 7});
        TreeNode.show(tree1);
        System.out.println(t103.zigzagLevelOrder1(tree1));
        TreeNode tree2 = TreeNode.plantTree(new Integer[]{1, 2, 3, 4, null, null, 5});
        TreeNode.show(tree2);
        System.out.println(t103.zigzagLevelOrder1(tree2));
    }

    /** 优化: 使用一个队列完成。
     * 执行用时 :1 ms, 99.52%
     * 内存消耗 :36.2 MB, 40.11%
     */
    public List<List<Integer>> zigzagLevelOrder1(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null) return ans;
        LinkedList<Integer> ans0 = new LinkedList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        TreeNode cur;
        int curLevelNum = 1;
        int nextLevelNum = 0;
        boolean positive = true;
        while (!deque.isEmpty()) {
            cur = deque.poll();
            if (positive)  // KEYPOINT
                ans0.addLast(cur.val);
            else
                ans0.addFirst(cur.val);
            if (cur.left != null) {
                deque.offer(cur.left);
                nextLevelNum++;
            }
            if (cur.right != null) {
                deque.offer(cur.right);
                nextLevelNum++;
            }
            if (--curLevelNum == 0) {
                positive = !positive;
                ans.add(ans0);
                ans0 = new LinkedList<>();
                curLevelNum = nextLevelNum;
                nextLevelNum = 0;
            }
        }
        return ans;
    }

    /**
     * 执行用时 :1 ms, 99.52%
     * 内存消耗 :36.2 MB, 40.11%
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null) return ans;
        LinkedList<Integer> ans0 = new LinkedList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        Deque<TreeNode> deque0 = new LinkedList<>();
        deque.offer(root);
        TreeNode cur;
        boolean reverse = false;
        while (!deque.isEmpty()) {
            cur = deque.poll();
            if (!reverse)  // KEYPOINT
                ans0.offer(cur.val);
            else
                ans0.offerFirst(cur.val);
            if (cur.left != null) deque0.offer(cur.left);
            if (cur.right != null) deque0.offer(cur.right);
            if (deque.isEmpty()) {
                reverse = !reverse;
                ans.add(ans0);
                ans0 = new LinkedList<>();
                while (!deque0.isEmpty())
                    deque.offer(deque0.poll());
            }
        }
        return ans;
    }
}
