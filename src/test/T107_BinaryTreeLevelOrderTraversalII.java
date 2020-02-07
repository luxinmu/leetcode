package test;

import java.util.*;

/*
 * 107. Binary Tree Level Order Traversal II
 * Difficult : Simple
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values.
 * (ie, from left to right, level by level from leaf to root).
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * return its bottom-up level order traversal as:
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 */
public class T107_BinaryTreeLevelOrderTraversalII {
    public static void main(String[] args) {
        T107_BinaryTreeLevelOrderTraversalII t107 = new T107_BinaryTreeLevelOrderTraversalII();
        TreeNode tree1 = TreeNode.plantTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        TreeNode.show(tree1);
        System.out.println(t107.levelOrderBottom(tree1));
    }

    /**
     * 使用头插法优化
     * 执行用时 :1 ms, 100.00%
     * 内存消耗 :36.5 MB, 14.67%
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> ans = new LinkedList<>();
        if (root == null) return ans;
        List<Integer> ans0 = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode cur;
        int curLvNum = 1;
        int nextLvNum = 0;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            ans0.add(cur.val);
            if (cur.left != null) {
                queue.offer(cur.left);
                nextLvNum++;
            }
            if (cur.right != null) {
                queue.offer(cur.right);
                nextLvNum++;
            }
            if (--curLvNum == 0) {
                ans.addFirst(ans0);
                ans0 = new LinkedList<>();
                curLvNum = nextLvNum;
                nextLvNum = 0;
            }
        }
        return ans;
    }

    /**
     * 执行用时 :2 ms, 59.34%
     * 内存消耗 :36.4 MB, 40.97%
     */
    public List<List<Integer>> levelOrderBottom1(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null) return ans;
        List<Integer> ans0 = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Stack<List<Integer>> stack = new Stack<>();
        queue.offer(root);
        TreeNode cur;
        int curLvNum = 1;
        int nextLvNum = 0;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            ans0.add(cur.val);
            if (cur.left != null) {
                queue.offer(cur.left);
                nextLvNum++;
            }
            if (cur.right != null) {
                queue.offer(cur.right);
                nextLvNum++;
            }
            if (--curLvNum == 0) {
                stack.push(ans0);
                ans0 = new LinkedList<>();
                curLvNum = nextLvNum;
                nextLvNum = 0;
            }
        }
        while (!stack.isEmpty()) ans.add(stack.pop());
        return ans;
    }
}
