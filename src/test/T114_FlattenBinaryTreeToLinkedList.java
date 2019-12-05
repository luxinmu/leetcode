package test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
 * 114. Flatten Binary Tree to Linked List
 * Difficult: Medium
 *
 * Given a binary tree, flatten it to a linked list in-place.
 * For example, given the following tree:
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 *
 * The flattened tree should look like:
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 */
public class T114_FlattenBinaryTreeToLinkedList {

    public static void main(String[] args) {
        T114_FlattenBinaryTreeToLinkedList t114 = new T114_FlattenBinaryTreeToLinkedList();
        TreeNode tree1 = TreeNode.plantTree(new Integer[]{1, 2, 5, 3, 4, null, 6});
        TreeNode.show(tree1);
        t114.flatten(tree1);
        TreeNode.show(tree1);
    }

    /**
     * 执行用时 :1 ms, 81.79%
     * 内存消耗 :35.7 MB, 81.87%
     * 思路:
     * 1 记录右子树
     * 2 右子树赋值为左子树
     * 3 记录右子节点
     * 4 找新的右子树的最右子节点
     * 5 最右子节点的右节点赋值为第1步记录的左子树
     * 6 递归处理第3步记录的节点的展开
     */
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        if (root.left == null)
            flatten(root.right);
        if (root.right == null)
            flatten(root.left);
        TreeNode tmp = root.right;
        root.right = root.left;
        TreeNode next = root.left;
        root.left = null;
        while (root.right != null) {
            root = root.right;
        }
        root.right = tmp;
        flatten(next);
    }

    /**
     * 利用栈迭代前序遍历, 再依次修改, 效率较低
     * 执行用时 :2 ms, 20.82%
     * 内存消耗 :35.9 MB, 81.11%
     */
    public void flatten0(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        Queue<TreeNode> queue = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                queue.offer(root);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        TreeNode cur = queue.poll();
        while (cur != null && !queue.isEmpty()) {
            cur.left = null;
            cur.right = queue.poll();
            cur = cur.right;
        }
    }
}
