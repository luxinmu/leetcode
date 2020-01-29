package test;

/*
 * 450. Delete Node in a BST
 * Difficult: Medium
 *
 * Given a root node reference of a BST and a key, delete the node with the given key in the BST.
 * Return the root node reference (possibly updated) of the BST.
 * Basically, the deletion can be divided into two stages:
 *   Search for a node to remove.
 *   If the node is found, delete the node.
 *
 * Note: Time complexity should be O(height of tree).
 *
 * Example:
 * root = [5,3,6,2,4,null,7]
 * key = 3
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 * Given key to delete is 3. So we find the node with value 3 and delete it.
 *
 * One valid answer is [5,4,6,2,null,null,7], shown in the following BST.
 *     5
 *    / \
 *   4   6
 *  /     \
 * 2       7
 *
 * Another valid answer is [5,2,6,null,4,null,7].
 *     5
 *    / \
 *   2   6
 *    \   \
 *     4   7
 */
public class T450_DeleteNodeInABST {
    public static void main(String[] args) {
        TreeNode tree = TreeNode.plantTree(new Integer[]{5, 3, 6, 2, 4, null, 7});
        TreeNode.show(tree);
        T450_DeleteNodeInABST t450 = new T450_DeleteNodeInABST();
        TreeNode.show(t450.deleteNode1(tree, 5));
    }

    /**
     * 执行用时 :0 ms, 100.00%
     * 内存消耗 :38.8 MB, 45.92%
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val > key) //要删除的节点在左子树
            root.left = deleteNode(root.left, key);
        else if (root.val < key) //要删除的节点在右子树
            root.right = deleteNode(root.right, key);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            else {
                TreeNode t = rightSubTreeMinimum(root.right); // 找到右子树的最小节点
                t.right = removeRightSubTreeMinimum(root.right);
                t.left = root.left;
                root.left = root.right = null;
                return t;
            }
        }
        return root;
    }

    /* 删除root的最小(最左)节点，并返回删除后的树根节点 */
    private TreeNode removeRightSubTreeMinimum(TreeNode root) {
        if (root == null)
            return null;
        if (root.left == null)
            return root.right;
        TreeNode pre = root;
        TreeNode cur = root.left;
        while (cur.left != null) {
            pre = pre.left;
            cur = cur.left;
        }
        pre.left = cur.right;
        return root;
    }

    private TreeNode rightSubTreeMinimum(TreeNode root) {
        if (root == null) return null;
        while (root.left != null)
            root = root.left;
        return root;
    }

    /**
     * 执行用时 :0 ms, 100.00%
     * 内存消耗 :39 MB, 35.37%
     * 1. 如果目标节点没有子节点，我们可以直接移除该目标节点。
     * 2. 如果目标节只有一个子节点，我们可以用其子节点作为替换。
     * 3. 如果目标节点有两个子节点，我们需要用其中序后继节点或者前驱节点来替换，再删除该目标节点。
     * Successor 代表的是中序遍历序列的下一个节点。即比当前节点大的最小节点，称后继节点;
     * Predecessor 代表的是中序遍历序列的前一个节点。即比当前节点小的最大节点，简称前驱节点.
     */
    public TreeNode deleteNode1(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val > key) //要删除的节点在左子树
            root.left = deleteNode(root.left, key);
        else if (root.val < key) //要删除的节点在右子树
            root.right = deleteNode(root.right, key);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            else {
                int val;
                TreeNode successor = Successor(root);
                val = successor.val;  // swap and delete
                successor.val = root.val;
                root.val = val;
                root.right = deleteNode(root.right, key);
            }
        }
        return root;
    }

    private TreeNode Successor(TreeNode root) {
        if (root == null || root.right == null)
            return null;
        root = root.right;
        while (root.left != null)
            root = root.left;
        return root;
    }

    private TreeNode Predecessor(TreeNode root) {
        if (root == null || root.right == null)
            return null;
        root = root.left;
        while (root.right != null)
            root = root.right;
        return root;
    }

}
