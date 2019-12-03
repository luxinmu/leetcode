package test;

import java.util.HashMap;
import java.util.Map;

/*
 * 106. Construct Binary Tree from Inorder and Postorder Traversal
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * Note: You may assume that duplicates do not exist in the tree.
 *
 * For example, given
 *
 * inorder = [9,3,15,20,7]
 * postorder = [9,15,7,20,3]
 * Return the following binary tree:
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class T106_ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public static void main(String[] args) {
        T106_ConstructBinaryTreeFromInorderAndPostorderTraversal t106 = new T106_ConstructBinaryTreeFromInorderAndPostorderTraversal();
        TreeNode tree = t106.buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
        TreeNode.show(tree);
    }

    Map<Integer, Integer> map;
    int[] postorder;

    /**
     * 执行用时 : 3 ms , 93.76%
     * 内存消耗 : 39.2 MB , 45.43%
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0)
            return null;
        this.postorder = postorder;
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(0, postorder.length - 1, postorder.length);
    }

    private TreeNode helper(int iStart, int pEnd, int length) {
        if (length < 1) return null;
        TreeNode root = new TreeNode(postorder[pEnd]);
        if (length == 1)
            return root;
        int rootIdx = map.get(postorder[pEnd]);
        int len1 = rootIdx - iStart;
        int len2 = length - len1 - 1;
        root.left = helper(iStart, pEnd - len2 - 1, len1);
        root.right = helper(rootIdx + 1, pEnd - 1, len2);
        return root;
    }

}
