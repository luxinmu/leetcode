package test;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 94. Binary Tree Inorder Traversal
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * <p>
 * Example:
 * <p>
 * Input: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * Output: [1,3,2]
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class T94_BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        T94_BinaryTreeInorderTraversal t94 = new T94_BinaryTreeInorderTraversal();
        TreeNode tn1 = new TreeNode(1);
        TreeNode tn2 = new TreeNode(2);
        TreeNode tn3 = new TreeNode(3);
        tn1.right = tn2;
        tn2.left = tn3;
        System.out.println(t94.inorderTraversal(tn1));

        TreeNode tn11 = new TreeNode(3);
        TreeNode tn21 = new TreeNode(1);
        TreeNode tn31 = new TreeNode(2);
        tn11.left = tn21;
        tn21.right = tn31;
        System.out.println(t94.inorderTraversal(tn11));
    }

    /**
     * 执行用时 : 1 ms , 86.92%
     * 内存消耗 : 34.8 MB , 39.36%
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null) {
            while (root.left != null) {
                stack.push(root);
                root = root.left;
            }
            ans.add(root.val);
            while (root != null)
                if (root.right != null) {
                    root = root.right;
                    break;
                } else {
                    if (stack.isEmpty())
                        root = null;
                    else {
                        root = stack.pop();
                        ans.add(root.val);
                    }
                }
        }
        return ans;
    }

    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        inorder(root, ans);
        return ans;
    }

    /**
     * 递归法
     * 执行用时 : 0 ms , 100.00%
     * 内存消耗 : 34.7 MB , 39.40% 的用户
     */
    private void inorder(TreeNode root, List<Integer> ans) {
        if (root == null) return;
        if (root.left != null)
            inorder(root.left, ans);
        ans.add(root.val);
        if (root.right != null)
            inorder(root.right, ans);
    }
}
