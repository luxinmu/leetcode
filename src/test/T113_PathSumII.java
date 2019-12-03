package test;

import java.util.LinkedList;
import java.util.List;

/*
 * 113. Path Sum II
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * Note: A leaf is a node with no children.
 *
 * Example:
 * Given the below binary tree and sum = 22,
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \    / \
 * 7    2  5   1
 *
 * Return:
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 * */
public class T113_PathSumII {
    public static void main(String[] args) {
        T113_PathSumII t113 = new T113_PathSumII();
        TreeNode tree = TreeNode.plantTree(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1});
        TreeNode.show(tree);
        System.out.println(t113.pathSum(tree, 22));
    }


    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new LinkedList<>();
        helper2(root, sum, new LinkedList<>(), ans);
        return ans;
    }

    /**
     * 执行用时 :20 ms, 5.10%
     * 内存消耗 :53.6 MB, 5.06%
     */
    private void helper(TreeNode root, int sum, LinkedList<Integer> tmp, List<List<Integer>> ans) {
        if (root == null)
            return;
        tmp.add(root.val);
        if (root.left == null && root.right == null && root.val == sum)
            ans.add(tmp);
        else {
            helper(root.left, sum - root.val, new LinkedList<>(tmp), ans);
            helper(root.right, sum - root.val, new LinkedList<>(tmp), ans);
        }
    }

    /**
     * 优化 1
     * 执行用时 :5 ms, 15.94%
     * 内存消耗 :38.9 MB, 60.53%
     */
    private void helper1(TreeNode root, int sum, LinkedList<Integer> tmp, List<List<Integer>> ans) {
        if (root == null)
            return;
        tmp.add(root.val);
        if (root.left == null && root.right == null && root.val == sum) {
            ans.add(tmp);
            return;
        }
        helper1(root.right, sum - root.val, root.right != null && root.left != null ? new LinkedList<>(tmp) : tmp, ans);
        helper1(root.left, sum - root.val, tmp, ans);
    }

    /**
     * 优化 2 利用前序遍历的思想
     * 执行用时 :2 ms, 83.04%
     * 内存消耗 :37.7 MB, 80.82%
     */
    private void helper2(TreeNode root, int sum, LinkedList<Integer> tmp, List<List<Integer>> ans) {
        if (root == null)
            return;
        tmp.add(root.val);
        if (root.left == null && root.right == null) {
            if (root.val == sum)
                ans.add(new LinkedList<>(tmp));
        } else {
            helper2(root.left, sum - root.val, tmp, ans);
            helper2(root.right, sum - root.val, tmp, ans);
        }
        tmp.removeLast();
    }
}
