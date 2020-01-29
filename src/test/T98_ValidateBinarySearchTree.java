package test;

import java.util.Stack;

/*
 * 98. Validate Binary Search Tree
 * Difficult: Medium
 *
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * Assume a BST is defined as follows:
 *     The left subtree of a node contains only nodes with keys less than the node's key.
 *     The right subtree of a node contains only nodes with keys greater than the node's key.
 *     Both the left and right subtrees must also be binary search trees.
 * Example 1:
 *     2
 *    / \
 *   1   3
 * Input: [2,1,3]
 * Output: true
 *
 * Example 2:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * Input: [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 */
public class T98_ValidateBinarySearchTree {
    public static void main(String[] args) {
        T98_ValidateBinarySearchTree t98 = new T98_ValidateBinarySearchTree();
        TreeNode tree = TreeNode.plantTree(new Integer[]{5, 1, 4, null, null, 3, 6});
        TreeNode.show(tree);
        System.out.println(t98.isValidBST(tree)); //false
        TreeNode tree1 = TreeNode.plantTree(new Integer[]{3, 1, 5, 0, 2, 4, 6, null, null, null, 3});
        TreeNode.show(tree1);
        System.out.println(t98.isValidBST1(tree1)); //false
    }

    /**
     * 递归法
     * 执行用时 :1 ms, 86.71%
     * 内存消耗 :39.2 MB, 9.85%
     * 假设一个二叉搜索树具有如下特征：
     * 节点的左子树只包含小于当前节点的数;
     * 节点的右子树只包含大于当前节点的数;
     * 所有左子树和右子树自身必须也是二叉搜索树.
     */
    public boolean isValidBST(TreeNode root) {
        return valid(root, null, null);
    }

    private boolean valid(TreeNode root, Integer min, Integer max) {
        if (root == null)
            return true;
        if (min != null && min >= root.val)
            return false;
        if (max != null && max <= root.val)
            return false;
        return valid(root.left, min, root.val) && valid(root.right, root.val, max);
    }

    /**
     * 迭代法
     * 执行用时 :3 ms, 29.11%
     * 内存消耗 :38.8 MB, 18.62%
     * 一个二叉搜索树的中序遍历是有序的.
     */
    public boolean isValidBST1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        long pre = Long.MIN_VALUE;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val <= pre)
                return false;
            pre = root.val;
            root = root.right;
        }
        return true;
    }
}
