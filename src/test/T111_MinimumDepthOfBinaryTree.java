package test;

/*
 * 111. Minimum Depth of Binary Tree
 * Difficult: Easy
 *
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * Note: A leaf is a node with no children.
 *
 * Example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * return its minimum depth = 2.
 */
public class T111_MinimumDepthOfBinaryTree {
    public static void main(String[] args) {
        T111_MinimumDepthOfBinaryTree t111 = new T111_MinimumDepthOfBinaryTree();
        TreeNode tree1 = TreeNode.plantTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        TreeNode.show(tree1);
        System.out.println(t111.minDepth(tree1));
        TreeNode tree2 = TreeNode.plantTree(new Integer[]{1, 2, 2, 3, 3, null, 3, 4, 4});
        TreeNode.show(tree2);
        System.out.println(t111.minDepth(tree2));
        TreeNode tree3 = TreeNode.plantTree(new Integer[]{1, 2});
        TreeNode.show(tree3);
        System.out.println(t111.minDepth(tree3));
        TreeNode tree4 = TreeNode.plantTree(new Integer[]{1});
        TreeNode.show(tree4);
        System.out.println(t111.minDepth(tree4));
        TreeNode tree5 = TreeNode.plantTree(new Integer[]{-9, -3, 2, null, 4, 4, 0, -6, null, -5});
        TreeNode.show(tree5);
        System.out.println(t111.minDepth(tree5));
    }

    /**
     * 执行用时 :0 ms, 100.00%
     * 内存消耗 :38 MB, 49.42%
     *
     * 思路:
     * 1 若根为null, 则深度为0
     * 2 若左子树为null, 则返回右子树最小深度加1
     * 3 若右子树为null, 则返回左子树最小深度加1
     * 4 若左、右子树都不为null, 则返回左、右子树最小深度的较小值加1
     */
    public int minDepth(TreeNode root) {
        return root == null ? 0 :
                root.left == null ? minDepth(root.right) + 1 :
                        root.right == null ? minDepth(root.left) + 1 :
                                Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
