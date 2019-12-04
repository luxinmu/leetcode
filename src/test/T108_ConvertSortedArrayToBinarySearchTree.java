package test;

/*
 * 108. Convert Sorted Array to Binary Search Tree
 * Difficulty: Easy
 *
 * Given an array where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * Example:
 * Given the sorted array: [-10,-3,0,5,9],
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 */
public class T108_ConvertSortedArrayToBinarySearchTree {
    public static void main(String[] args) {
        T108_ConvertSortedArrayToBinarySearchTree t108 = new T108_ConvertSortedArrayToBinarySearchTree();
        TreeNode.show(t108.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9}));
        TreeNode.show(t108.sortedArrayToBST(new int[]{0, 1, 2, 3, 4, 5}));
    }

    /**
     * 思路很关键, 找到中间节点, 然后以此为界分为两堆, 递归
     * 执行用时 : 0 ms ,  100.00%
     * 内存消耗 : 37.3 MB ,  96.76%
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int left, int right) {
        if (left > right) return null;
        int mid = (left + right) >>> 1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid - 1);
        root.right = helper(nums, mid + 1, right);
        return root;
    }
}
