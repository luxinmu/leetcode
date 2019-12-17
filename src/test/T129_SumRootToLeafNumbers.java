package test;

import java.util.LinkedList;

/*
 * 129. Sum Root to Leaf Numbers
 * Difficult: Medium
 *
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * Find the total sum of all root-to-leaf numbers.
 * Note: A leaf is a node with no children.
 *
 * Example:
 * Input: [1,2,3]
 *     1
 *    / \
 *   2   3
 * Output: 25
 * Explanation:
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Therefore, sum = 12 + 13 = 25.
 *
 * Example 2:
 * Input: [4,9,0,5,1]
 *     4
 *    / \
 *   9   0
 *  / \
 * 5   1
 * Output: 1026
 * Explanation:
 * The root-to-leaf path 4->9->5 represents the number 495.
 * The root-to-leaf path 4->9->1 represents the number 491.
 * The root-to-leaf path 4->0 represents the number 40.
 * Therefore, sum = 495 + 491 + 40 = 1026.
 */
public class T129_SumRootToLeafNumbers {

    public static void main(String[] args) {
        T129_SumRootToLeafNumbers t129 = new T129_SumRootToLeafNumbers();
        TreeNode tree = TreeNode.plantTree(new Integer[]{1, 2, 3});
        TreeNode.show(tree);
        System.out.println(t129.sumNumbers2(tree));
        TreeNode tree1 = TreeNode.plantTree(new Integer[]{4, 9, 0, 5, 1});
        TreeNode.show(tree1);
        System.out.println(t129.sumNumbers3(tree1));
    }

    int sum = 0;

    /**
     * 执行用时 : 0 ms ,  100.00%
     * 内存消耗 : 35 MB ,  42.86%
     */
    public int sumNumbers3(TreeNode root) {
        helper3(root, 0);
        return sum;
    }

    private void helper3(TreeNode root, int tmp) {
        if (root == null) return;
        int sum0 = tmp * 10 + root.val;
        if (root.left == null && root.right == null)
            sum += sum0;
        else {
            helper3(root.left, sum0);
            helper3(root.right, sum0);
        }
    }

    /**
     * 执行用时 : 0 ms ,  100.00%
     * 内存消耗 : 34.7 MB ,  45.24%
     */
    public int sumNumbers2(TreeNode root) {
        int[] ans = {0};
        helper2(root, ans, 0);
        return ans[0];
    }

    private void helper2(TreeNode root, int[] ans, int tmp) {
        if (root == null) return;
        int sum0 = tmp * 10 + root.val;
        if (root.left == null && root.right == null) {
            ans[0] += sum0;
        } else {
            helper2(root.left, ans, sum0);
            helper2(root.right, ans, sum0);
        }
    }

    /**
     * 执行用时 : 0 ms ,  100.00%
     * 内存消耗 : 34.7 MB ,  45.24%
     */
    public int sumNumbers1(TreeNode root) {
        int[] ans = {0, 0};
        helper1(root, ans);
        return ans[0];
    }

    private void helper1(TreeNode root, int[] ans) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            ans[0] += ans[1] * 10 + root.val;
        } else {
            int tmp = ans[1];
            ans[1] = ans[1] * 10 + root.val;
            helper1(root.left, ans);
            helper1(root.right, ans);
            ans[1] = tmp;
        }
    }

    /**
     * 执行用时 : 2 ms ,  22.57%
     * 内存消耗 : 35.6 MB ,  40.71%
     */
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        LinkedList<Integer> list = new LinkedList<>();
        helper(root, list, new LinkedList<>());
        int ans = 0;
        for (int i : list)
            ans += i;
        return ans;
    }

    private void helper(TreeNode root, LinkedList<Integer> list, LinkedList<Integer> tmp) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            int sum = 0;
            for (int i : tmp)
                sum = sum * 10 + i;
            list.add(sum * 10 + root.val);
        } else {
            tmp.add(root.val);
            helper(root.left, list, tmp);
            helper(root.right, list, tmp);
            tmp.removeLast();
        }
    }
}
