package test;

/*
 * 236. Lowest Common Ancestor of a Binary Tree
 * Difficult: Medium
 * <p>
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * According to the definition of LCA on Wikipedia: "The lowest common ancestor is defined
 * between two nodes p and q as the lowest node in T that has both p and q as descendants
 * (where we allow a node to be a descendant of itself).”
 *              3
 *          /      \
 *       5           1
 *     /   \       /   \
 *   6       2   0       8
 *          / \
 *         7   4
 * <p>
 * Example 1:
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of nodes 5 and 1 is 3.
 * <p>
 * Example 2:
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * Output: 5
 * Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 * <p>
 * Note:
 * All of the nodes' values will be unique.
 * p and q are different and both values will exist in the binary tree.
 */
public class T236_LowestCommonAncestorOfABinaryTree {
    public static void main(String[] args) {
        TreeNode tree = TreeNode.plantTree(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});
        TreeNode.show(tree);
        T236_LowestCommonAncestorOfABinaryTree t236 = new T236_LowestCommonAncestorOfABinaryTree();
        System.out.println(t236.lowestCommonAncestor(tree, new TreeNode(5), new TreeNode(1)).val); // 3
        System.out.println(t236.lowestCommonAncestor(tree, new TreeNode(5), new TreeNode(4)).val); // 5
    }

    /**
     * 1：左右子树上均能找到，说明此时的p结点和q结点分居root结点两侧，此时就应当直接返回 root 结点
     * 2：左子树上能找到，但是右子树上找不到，此时就应当直接返回左子树的查找结果；
     * 3：右子树上能找到，但是左子树上找不到，此时就应当直接返回右子树的查找结果；
     * 执行用时 :8 ms, 99.76%
     * 内存消耗 :39.4 MB, 5.01%
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null || root.val == p.val || root.val == q.val)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        return left != null && right != null
                ? root
                : left != null ? left : right;
    }
}
