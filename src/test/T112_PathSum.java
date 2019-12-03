package test;

/*
 * 112. Path Sum
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up
 * all the values along the path equals the given sum.
 * Note: A leaf is a node with no children.
 *
 * Example:
 * Given the below binary tree and sum = 22,
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \      \
 * 7    2      1
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */
public class T112_PathSum {
    public static void main(String[] args) {
        T112_PathSum t112 = new T112_PathSum();
        TreeNode tree = TreeNode.plantTree(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1});
        TreeNode.show(tree);
        System.out.println(t112.hasPathSum(tree, 22));
        TreeNode tree1 = TreeNode.plantTree(new Integer[]{-2, null, -3});
        TreeNode.show(tree1);
        System.out.println(t112.hasPathSum1(tree1, -5));
    }

    /**
     * 执行用时 :0 ms, 100.00%
     * 内存消耗 :39 MB, 25.57%
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        return root.left == null && root.right == null
                ? root.val == sum
                : hasPathSum(root.left, sum - root.val)
                || hasPathSum(root.right, sum - root.val);
    }

    /**
     * 执行用时 :0 ms, 100.00%
     * 内存消耗 :39.3 MB, 21.56%
     */
    public boolean hasPathSum1(TreeNode root, int sum) {
        return has(root, sum, 0);
    }

    private boolean has(TreeNode root, int sum, int curSum) {
        if (root == null) return false;
        return root.left == null && root.right == null
                ? curSum + root.val == sum
                : has(root.left, sum, curSum + root.val)
                || has(root.right, sum, curSum + root.val);
    }
}
