package test;

import java.util.Stack;

/*
 * 173. Binary Search Tree Iterator
 * Difficult: Medium
 * <p>
 * Implement an iterator over a binary search tree (BST).
 * Your iterator will be initialized with the root node of a BST.
 * <p>
 * Calling next() will return the next smallest number in the BST.
 * <p>
 * Example:
 *      7
 *    /  \
 *  3     15
 *       /  \
 *      9   20
 * BSTIterator iterator = new BSTIterator(root);
 * iterator.next();    // return 3
 * iterator.next();    // return 7
 * iterator.hasNext(); // return true
 * iterator.next();    // return 9
 * iterator.hasNext(); // return true
 * iterator.next();    // return 15
 * iterator.hasNext(); // return true
 * iterator.next();    // return 20
 * iterator.hasNext(); // return false
 * Note:
 * next() and hasNext() should run in average O(1) time and uses O(h) memory,
 * where h is the height of the tree.
 * You may assume that next() call will always be valid, that is,
 * there will be at least a next smallest number in the BST when next() is called.
 */
public class T173_BinarySearchTreeIterator {
    public static void main(String[] args) {
        TreeNode tree = TreeNode.plantTree(new Integer[]{7, 3, 15, null, null, 9, 20});
        TreeNode.show(tree);
        BSTIterator iterator = new BSTIterator(tree);
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        BSTIterator iterator1 = new BSTIterator(tree);
        while (iterator1.hasNext())
            System.out.println(iterator1.next());
    }

    static class BSTIterator {

        Stack<TreeNode> stack;

        public BSTIterator(TreeNode root) {
            stack = new Stack<>();
            push(root);
        }

        private void push(TreeNode root) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
        }

        /**
         * @return the next smallest number
         */
        public int next() {
            TreeNode root = stack.pop();
            int val = root.val;
            push(root.right);
            return val;
        }

        /**
         * @return whether we have a next smallest number
         */
        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }
}
