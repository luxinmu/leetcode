package test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * For example, given
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 * Return the following binary tree:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class T105_ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        T105_ConstructBinaryTreeFromPreorderAndInorderTraversal t105 = new T105_ConstructBinaryTreeFromPreorderAndInorderTraversal();
        TreeNode tree = t105.buildTree2(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        TreeNode.show(tree);
        TreeNode tree1 = t105.buildTree2(new int[]{1, 7}, new int[]{1, 7});
        TreeNode.show(tree1);
        TreeNode tree2 = t105.buildTree2(new int[]{1, 2, 3}, new int[]{3, 2, 1});
        TreeNode.show(tree2);
    }

    /**
     * 优化 2
     * 提高运行效率两点：
     * 1、利用map存放根节点在inorder中的索引，缩短查找时间；
     * 2、递归时，不生成新数组，只传递preorder、inorder的开始索引和数组长度。
     * 执行用时 :3 ms, 96.20%
     * 内存消耗 :36.1 MB, 98.06%
     */
    Map<Integer, Integer> map;
    int[] preorder;

    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0)
            return null;
        this.map = new HashMap<>();  //定义map存放inorder索引, 减少查找根节点在inorder索引的时间。
        for (int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);
        this.preorder = preorder;
        return helper1(0, 0, preorder.length);
    }

    private TreeNode helper1(int pFrom, int iFrom, int length) {
        if (length < 1)
            return null;
        TreeNode root = new TreeNode(preorder[pFrom]);
        if (length == 1)
            return root;
        int rootIdx = map.get(preorder[pFrom]);
        // 分左右两个分支, 递归处理
        int len1 = rootIdx - iFrom;
        int len2 = length - len1 - 1;
        root.left = helper1(pFrom + 1, iFrom, len1);
        root.right = helper1(pFrom + 1 + len1, rootIdx + 1, len2);
        return root;
    }

    /**
     * 优化 1
     * 提高运行效率两点：
     * 1、利用map存放根节点在inorder中的索引，缩短查找时间；
     * 2、递归时，不生成新数组，只传递preorder、inorder的开始索引和数组长度。
     * 执行用时 :3 ms, 96.20%
     * 内存消耗 :36.4 MB, 92.01%
     */
    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0)
            return null;
        Map<Integer, Integer> map = new HashMap<>();  //定义map存放inorder索引, 减少查找根节点在inorder索引的时间。
        for (int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);
        return helper(preorder, 0, inorder, 0, preorder.length, map);
    }

    private TreeNode helper(final int[] preorder, int pFrom, final int[] inorder, int iFrom, int length, final Map<?, Integer> map) {
        if (length < 1)
            return null;
        TreeNode root = new TreeNode(preorder[pFrom]);
        if (length == 1)
            return root;
        int rootIdx = map.get(preorder[pFrom]);
        // 分左右两个分支, 递归处理
        int len1 = rootIdx - iFrom;
        int len2 = length - len1 - 1;
        root.left = helper(preorder, pFrom + 1, inorder, iFrom, len1, map);
        root.right = helper(preorder, pFrom + 1 + len1, inorder, rootIdx + 1, len2, map);
        return root;
    }

    /**
     * 执行用时 :18 ms, 32.15%
     * 内存消耗 :82.8 MB, 5.07%
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0)
            return null;
        TreeNode root = new TreeNode(preorder[0]);
        int rootIdx = -1;
        for (int i = 0; i < inorder.length; i++)
            if (inorder[i] == preorder[0]) {
                rootIdx = i;
                break;
            }
        if (rootIdx >= 0) {
            root.left = buildTree(Arrays.copyOfRange(preorder, 1, rootIdx + 1), Arrays.copyOfRange(inorder, 0, rootIdx));
            root.right = buildTree(Arrays.copyOfRange(preorder, rootIdx + 1, preorder.length), Arrays.copyOfRange(inorder, rootIdx + 1, inorder.length));
        }
        return root;
    }
}
