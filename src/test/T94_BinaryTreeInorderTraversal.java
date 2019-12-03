package test;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/*
 * 94. Binary Tree Inorder Traversal
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * <p>
 * Example:
 * <p>
 * Input: [1,null,2,3]
 *   1
 *    \
 *     2
 *    /
 *   3
 * <p>
 * Output: [1,3,2]
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class T94_BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        T94_BinaryTreeInorderTraversal t94 = new T94_BinaryTreeInorderTraversal();
        TreeNode tree1 = TreeNode.plantTree(new Integer[]{1, null, 2, 3});
        TreeNode.show(tree1);
        System.out.println(t94.preorderTraversal(tree1));   //[1, 2, 3]
        System.out.println(t94.inorderTraversal(tree1));    //[1, 3, 2]
        System.out.println(t94.postorderTraversal(tree1));  //[3, 2, 1]

        System.out.println(t94.preorderTraversalRecursion(tree1));  //[1, 2, 3]
        System.out.println(t94.inorderTraversalRecursion(tree1));   //[1, 3, 2]
        System.out.println(t94.postorderTraversalRecursion(tree1)); //[3, 2, 1]
        //        1
        //      /   \
        //     2      3
        //   /  \      \
        //  4    5      6
        TreeNode tree2 = TreeNode.plantTree(new Integer[]{1, 2, 3, 4, 5, null, 6});
        TreeNode.show(tree2);
        System.out.println(t94.preorderTraversal(tree2));   //[1, 2, 4, 5, 3, 6]
        System.out.println(t94.inorderTraversal(tree2));    //[4, 2, 5, 1, 3, 6]
        System.out.println(t94.postorderTraversal(tree2));  //[4, 5, 2, 6, 3, 1]
        System.out.println(t94.levelOrder1(tree2));         //[1, 2, 3, 4, 5, 6]
    }

    /**
     * 前序遍历迭代法
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                ans.add(root.val);  //KEYPOINT
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return ans;
    }

    /**
     * 中序遍历迭代法
     * 执行用时 :1 ms, 86.27%
     * 内存消耗 :34.7 MB, 39.40%
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {  // KEYPOINT
            while (root != null) {  //中序遍历, 左支先入栈
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();     //栈顶为当前最左侧节点
            ans.add(root.val);      //记录最左侧节点value
            root = root.right;      //遍历右支 若右支为空且栈为空, 则遍历完成
        }
        return ans;
    }

    /**
     * 后序遍历迭代法
     * 前序遍历为 root->left->right，后序遍历为 left->right->root。
     * 可以修改前序遍历成为 root->right->left，然后倒序就是left->right->root。
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> ans = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                ans.addFirst(root.val);  //KEYPOINT 倒序插入
                stack.push(root);
                root = root.right;
            }
            root = stack.pop();
            root = root.left;
        }
        return ans;
    }

    public List<Integer> levelOrder(TreeNode root) {
        if (root == null) return null;
        List<Integer> ans = new LinkedList<>();
        TreeNode td;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            td = queue.poll();
            ans.add(td.val);
            if (td.left != null) queue.add(td.left);
            if (td.right != null) queue.add(td.right);
        }
        return ans;
    }

    public List<List<Integer>> levelOrder1(TreeNode root) {
        if (root == null)
            return new LinkedList<>();
        List<List<Integer>> ans = new LinkedList<>();
        List<Integer> integerList = new LinkedList<>();
        TreeNode cur;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> queue0 = new LinkedList<>();
        queue.add(root);
        while (true) {
            if (queue.isEmpty()) {
                ans.add(integerList);
                if (queue0.isEmpty()) break;
                while (!queue0.isEmpty())
                    queue.offer(queue0.poll());
                integerList = new LinkedList<>();
            } else {
                cur = queue.poll();
                integerList.add(cur.val);
                if (cur.left != null) queue0.add(cur.left);
                if (cur.right != null) queue0.add(cur.right);
            }
        }
        return ans;
    }

    /**
     * 迭代法
     * 执行用时 : 1 ms , 86.92%
     * 内存消耗 : 34.8 MB , 39.36%
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
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

    public List<Integer> preorderTraversalRecursion(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        preorder(root, ans);
        return ans;
    }

    private void preorder(TreeNode root, List<Integer> ans) {
        if (root == null) return;
        ans.add(root.val);
        preorder(root.left, ans);
        preorder(root.right, ans);
    }

    /**
     * 递归法
     * 执行用时 : 0 ms , 100.00%
     * 内存消耗 : 34.7 MB , 39.40% 的用户
     */
    public List<Integer> inorderTraversalRecursion(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        inorder(root, ans);
        return ans;
    }

    private void inorder(TreeNode root, List<Integer> ans) {
        if (root == null) return;
        if (root.left != null)
            inorder(root.left, ans);
        ans.add(root.val);
        if (root.right != null)
            inorder(root.right, ans);
    }

    public List<Integer> postorderTraversalRecursion(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        postorder(root, ans);
        return ans;
    }

    private void postorder(TreeNode root, List<Integer> ans) {
        if (root == null) return;
        postorder(root.left, ans);
        postorder(root.right, ans);
        ans.add(root.val);
    }
}
