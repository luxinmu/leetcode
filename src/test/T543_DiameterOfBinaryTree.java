package test;

/*
 * 543. Diameter of Binary Tree
 * Difficult: Easy
 *
 * Given a binary tree, you need to compute the length of the diameter of the tree.
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
 * This path may or may not pass through the root.
 *
 * Example:
 * Given a binary tree
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 * Note: The length of path between two nodes is represented by the number of edges between them.
 */

/**
 * @see T104_MaximumDepthOfBinaryTree
 */
public class T543_DiameterOfBinaryTree {

    public static void main(String[] args) {
        T543_DiameterOfBinaryTree test = new T543_DiameterOfBinaryTree();
        TreeNode t = TreeNode.plantTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        System.out.println(test.diameterOfBinaryTree(t));
    }

    int max;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        max = 0;
        length(root);
        return max;
    }

    private int length(TreeNode root) {
        if (root == null)
            return 0;
        int left = length(root.left);
        int right = length(root.right);
        max = Math.max(left + right, max);
        return 1 + Math.max(left, right);
    }
}
