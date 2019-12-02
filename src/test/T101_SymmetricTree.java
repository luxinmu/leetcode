package test;

import java.util.Deque;
import java.util.LinkedList;

/*
 * 101. Symmetric Tree
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 * But the following [1,2,2,null,3,null,3] is not:
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * */
public class T101_SymmetricTree {
    public static void main(String[] args) {
        T101_SymmetricTree t101 = new T101_SymmetricTree();
        TreeNode tree1 = TreeNode.plantTree(new Integer[]{1, 2, 2, 3, 4, 4, 3});
        TreeNode.show(tree1);
        System.out.println(t101.isSymmetric(tree1));
        TreeNode tree2 = TreeNode.plantTree(new Integer[]{1, 2, 2, null, 3, null, 3});
        TreeNode.show(tree2);
        System.out.println(t101.isSymmetric(tree2));
        TreeNode tree3 = TreeNode.plantTree(new Integer[]{2, 3, 3, 4, 5, 5, 4, null, null, 8, 9, 9, 8});
        TreeNode.show(tree3);
        System.out.println(t101.isSymmetric(tree3));
    }

    /**
     * 执行用时 : 0 ms ,  100.00%
     * 内存消耗 : 37.7 MB ,  67.20%
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return left.val == right.val && isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }

    public boolean isSymmetric9(TreeNode root) {
        if (root == null) return false;
        Deque<TreeNode> deque = new LinkedList<>();
        Deque<TreeNode> deque0 = new LinkedList<>();
        if (root.left != null)
            deque.offer(root.left);
        if (root.right != null)
            deque.offer(root.right);
        while (!deque.isEmpty()) {
            if ((deque.size() & 1) != 0)
                return false;
            while (!deque.isEmpty()) {
                TreeNode t1 = deque.pollFirst();
                TreeNode t2 = deque.pollLast();
                if (t1 != null && t2 != null) {
                    if (t1.val != t2.val)
                        return false;
                    deque0.offerFirst(t1.left);
                    deque0.offerLast(t2.right);
                    deque0.offerFirst(t1.right);
                    deque0.offerLast(t2.left);
                } else if (t1 != null || t2 != null)
                    return false;
            }
            while (!deque0.isEmpty())
                deque.offer(deque0.poll());
        }
        return true;
    }
}
