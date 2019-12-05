package test;

/*
 * 110. Balanced Binary Tree
 * Difficult: Easy
 *
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as:
 *     a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
 *
 * Example 1:
 *
 * Given the following tree [3,9,20,null,null,15,7]:
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * Return true.
 *
 * Example 2:
 * Given the following tree [1,2,2,3,3,null,null,4,4]:
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * Return false.
 */
public class T110_BalancedBinaryTree {
    public static void main(String[] args) {
        T110_BalancedBinaryTree t110 = new T110_BalancedBinaryTree();
        TreeNode tree1 = TreeNode.plantTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        TreeNode.show(tree1);
        System.out.println(t110.isBalanced(tree1));
        TreeNode tree2 = TreeNode.plantTree(new Integer[]{1, 2, 2, 3, 3, null, null, 4, 4});
        TreeNode.show(tree2);
        System.out.println(t110.isBalanced(tree2));
    }

    /** 当如下三种情况，当前节点是高度平衡的:
     *  1 root为空
     *  2 root的左右子树都为空
     *  3 root的左右子树高度差的绝对值小于等于1, 且左右子树也高度平衡。
     * 执行用时 :1 ms, 100.00%
     * 内存消耗 :39.1 MB, 34.48%
     */
    public boolean isBalanced(TreeNode root) {
        return root == null
                || root.left == null && root.right == null
                || Math.abs(depth(root.left) - depth(root.right)) <= 1
                && isBalanced(root.left)
                && isBalanced(root.right);
    }

    private int depth(TreeNode root) {
        return root == null ? 0 : Math.max(1 + depth(root.left), 1 + depth(root.right));
    }
}
