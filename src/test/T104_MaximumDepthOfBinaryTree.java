package test;

/*
 * 104. Maximum Depth of Binary Tree
 * Difficult: Easy
 *
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root
 * node down to the farthest leaf node.
 * Note: A leaf is a node with no children.
 *
 * Example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its depth = 3.
 */

/**
 * @see T110_BalancedBinaryTree
 * @see T111_MinimumDepthOfBinaryTree
 * @see T543_DiameterOfBinaryTree
 */
public class T104_MaximumDepthOfBinaryTree {

    public static void main(String[] args) {
        T104_MaximumDepthOfBinaryTree test = new T104_MaximumDepthOfBinaryTree();
        TreeNode t = TreeNode.plantTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        System.out.println(test.maxDepth(t));
    }

    public int maxDepth(TreeNode root) {
        return root == null ? 0 : 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
