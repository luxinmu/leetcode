package test;

import java.util.HashSet;
import java.util.Set;

/*
 * 653. Two Sum IV - Input is a BST
 * Difficult: Easy
 *
 * Given a Binary Search Tree and a target number, return true if there exist
 * two elements in the BST such that their sum is equal to the given target.
 *
 * Example 1:
 * Input:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 * Target = 9
 * Output: True
 *
 * Example 2:
 * Input:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 * Target = 28
 * Output: False
 */
public class T653_TwoSumIV_InputIsBST {

    public static void main(String[] args) {
        TreeNode t = TreeNode.plantTree(new Integer[]{4, 2, 5, 1, 3, null, 6});
        TreeNode.show(t);
        /*       4
         *     /   \
         *   2       5
         *  / \       \
         * 1   3       6 */
        T653_TwoSumIV_InputIsBST test = new T653_TwoSumIV_InputIsBST();
        System.out.println(test.findTarget1(t, 3)); //true
        System.out.println(test.findTarget1(t, 8)); //true
        System.out.println(test.findTarget1(t, 2)); //false
    }

    BSTreeNode BST;

    /**
     * 使用HashSet存放遍历过的数据，空间换时间
     * 执行用时 :5 ms, 53.89%
     * 内存消耗 :40.4 MB, 60.76%
     */
    public boolean findTarget1(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return findHelper(root, k, set);
    }

    private boolean findHelper(TreeNode root, final int k, Set<Integer> set) {
        if (root == null)
            return false;
        if (set.contains(k - root.val))
            return true;
        set.add(root.val);
        return findHelper(root.left, k, set) || findHelper(root.right, k, set);
    }

    /**
     * 类似双指针法
     * 执行用时 :4 ms, 73.63%
     * 内存消耗 :41.6 MB, 48.09%
     */
    public boolean findTarget(TreeNode root, int k) {
        if (root == null)
            return false;
        enhanceBST(root);
        BSTreeNode first = getFirst(BST);
        BSTreeNode last = getLast(BST);
        while (first != null && last != null && first != last)
            if (getVal(first) + getVal(last) == k)
                return true;
            else if (getVal(first) + getVal(last) < k)
                // 小于target， 获取后继节点
                first = successor(first);
            else
                // 大于target， 获取前驱节点
                last = predecessor(last);
        return false;
    }

    private void enhanceBST(TreeNode root) {
        if (root == null)
            return;
        if (BST == null)
            BST = BSTreeNode.buildBST(root);
    }

    private int getVal(BSTreeNode root) {
        return BSTreeNode.getVal(root);
    }

    private BSTreeNode getFirst(BSTreeNode root) {
        return BSTreeNode.findFirst(root);
    }

    private BSTreeNode getLast(BSTreeNode root) {
        return BSTreeNode.findLast(root);
    }

    private BSTreeNode successor(BSTreeNode root) {
        return BSTreeNode.successor(root);
    }

    private BSTreeNode predecessor(BSTreeNode root) {
        return BSTreeNode.predecessor(root);
    }

    static class BSTreeNode {

        TreeNode cur;
        BSTreeNode left;
        BSTreeNode right;
        BSTreeNode parent;

        BSTreeNode(TreeNode cur) {
            this.cur = cur;
        }

        // 使用原tree构建BST树，进行增强，增加父节点的引用
        private static BSTreeNode buildBST(TreeNode root) {
            if (root == null)
                return null;
            BSTreeNode bst = new BSTreeNode(root);
            if ((bst.left = buildBST(root.left)) != null)
                bst.left.parent = bst;
            if ((bst.right = buildBST(root.right)) != null)
                bst.right.parent = bst;
            return bst;
        }

        // 获取最小节点
        private static BSTreeNode findFirst(BSTreeNode root) {
            if (root != null)
                while (root.left != null)
                    root = root.left;
            return root;
        }

        // 获取最大节点
        private static BSTreeNode findLast(BSTreeNode root) {
            if (root != null)
                while (root.right != null)
                    root = root.right;
            return root;
        }

        // 获取后继节点
        private static BSTreeNode successor(BSTreeNode root) {
            if (root == null)
                return null;
            else if (root.right != null) {
                BSTreeNode p = root.right;
                while (p.left != null)
                    p = p.left;
                return p;
            } else {
                BSTreeNode p = root.parent;
                BSTreeNode cur = root;
                while (p != null && p.right == cur) {
                    cur = p;
                    p = p.parent;
                }
                return p;
            }
        }

        // 获取前驱节点
        private static BSTreeNode predecessor(BSTreeNode root) {
            if (root == null)
                return null;
            else if (root.left != null) {
                BSTreeNode p = root.left;
                while (p.right != null)
                    p = p.right;
                return p;
            } else {
                BSTreeNode p = root.parent;
                BSTreeNode cur = root;
                while (p != null && p.left == cur) {
                    cur = p;
                    p = p.parent;
                }
                return p;
            }
        }

        private static int getVal(BSTreeNode bsTreeNode) {
            assert bsTreeNode != null;
            return bsTreeNode.cur.val;
        }
    }
}
