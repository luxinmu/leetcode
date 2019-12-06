package test;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 297. Serialize and Deserialize Binary Tree
 * Difficult: Hard
 *
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer,
 * or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 *
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work.
 * You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
 *
 * Example:
 * You may serialize the following tree:
 *
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 *
 * as "[1,2,3,null,null,4,5]"
 *
 * Clarification: The above format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format,
 * so please be creative and come up with different approaches yourself.
 * Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
 */
public class T297_SerializeAndDeserializeBinaryTree {

    public static void main(String[] args) {
        T297_SerializeAndDeserializeBinaryTree t297 = new T297_SerializeAndDeserializeBinaryTree();
        TreeNode tree1 = TreeNode.plantTree(new Integer[]{1, 2, 3, null, 3, null, null, 4, null, 5});
//        TreeNode tree1 = TreeNode.plantTree(new Integer[]{1, 2, 5, 3, 4, null, 6});
        TreeNode.show(tree1);
        System.out.println(t297.serialize(tree1));
        TreeNode.show(t297.deserialize(t297.serialize(tree1)));
    }

    /** BFS
     * 执行用时 :15 ms, 85.60%
     * 内存消耗 :38 MB, 97.14%
     */
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        queue.offer(root);
        int nonNullNum = 1;
        while (!queue.isEmpty()) {
            root = queue.poll();
            sb.append(',');
            if (root == null) {
                if (nonNullNum != 0) {
                    sb.append("null");
                    continue;
                } else break;
            } else {
                sb.append(root.val);
                nonNullNum--;
            }

            if (root.left != null) {
                nonNullNum++;
                queue.offer(root.left);
            } else
                queue.offer(null);
            if (root.right != null) {
                nonNullNum++;
                queue.offer(root.right);
            } else
                queue.offer(null);
        }
        return sb.deleteCharAt(0).deleteCharAt(sb.length() - 1).toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) return null;
        String[] strs = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(strs[0]));
        TreeNode ret = root;
        Queue<TreeNode> queue = new LinkedList<>();
        int curLvlNum = 2;
        int nextLvlNum = 0;
        boolean isLeft = true;
        for (int i = 1; root != null && i < strs.length; i++) {
            if (curLvlNum-- > 0) {
                if (!"null".equals(strs[i]))
                    if (isLeft) {
                        root.left = new TreeNode(Integer.parseInt(strs[i]));
                        queue.offer(root.left);
                        nextLvlNum++;
                    } else {
                        root.right = new TreeNode(Integer.parseInt(strs[i]));
                        queue.offer(root.right);
                        nextLvlNum++;
                    }
                if (!isLeft && curLvlNum > 0)
                    root = queue.poll();
                isLeft = !isLeft;
            } else {
                root = queue.poll();
                curLvlNum = nextLvlNum * 2;
                nextLvlNum = 0;
                i--;
            }
        }
        return ret;
    }
}
