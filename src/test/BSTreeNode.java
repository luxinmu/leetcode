package test;

import java.util.Deque;
import java.util.LinkedList;

public class BSTreeNode {
    int val;
    int count;
    BSTreeNode left;
    BSTreeNode right;

    BSTreeNode(int x) {
        val = x;
        count = 1;
    }

    public static BSTreeNode plantTree(Integer[] nums) {
        if (nums.length == 0)
            return new BSTreeNode(0);
        Deque<BSTreeNode> nodeQueue = new LinkedList<>(); // 创建一个根节点
        BSTreeNode root = new BSTreeNode(nums[0]);
        nodeQueue.offer(root);
        BSTreeNode cur;
        int lineNodeNum = 2;// 记录当前行节点的数量（注意不一定是2的幂，而是上一行中非空节点的数量乘2）
        int startIndex = 1; // 记录当前行中数字在数组中的开始位置
        int restLength = nums.length - 1; // 记录数组中剩余的元素的数量
        while (restLength > 0) {
            for (int i = startIndex; i < startIndex + lineNodeNum; i = i + 2) {
                //说明已经将nums中的数字用完，此时应停止遍历，并可以直接返回root
                if (i == nums.length)
                    return root;
                cur = nodeQueue.poll();
                if (nums[i] != null && cur != null) {
                    cur.left = new BSTreeNode(nums[i]);
                    nodeQueue.offer(cur.left);
                }
                // 同上，说明已经将nums中的数字用完，此时应停止遍历，并可以直接返回root
                if (i + 1 == nums.length)
                    return root;
                if (nums[i + 1] != null && cur != null) {
                    cur.right = new BSTreeNode(nums[i + 1]);
                    nodeQueue.offer(cur.right);
                }
            }
            startIndex += lineNodeNum;
            restLength -= lineNodeNum;
            lineNodeNum = nodeQueue.size() * 2;
        }
        return root;
    }


    //用于获得树的层数
    public static int getTreeDepth(BSTreeNode root) {
        return root == null ? 0 : (1 + Math.max(getTreeDepth(root.left), getTreeDepth(root.right)));
    }

    private static void writeArray(BSTreeNode currNode, int rowIndex, int columnIndex, String[][] res, int treeDepth) {
        if (currNode == null) return;
        res[rowIndex][columnIndex] = String.valueOf(currNode.val);
        int currLevel = ((rowIndex + 1) / 2);//计算当前位于树的第几层
        //若到了最后一层，则返回
        if (currLevel == treeDepth) return;
        //计算当前行到下一行，每个元素之间的间隔（下一行的列索引与当前元素的列索引之间的间隔）
        int gap = treeDepth - currLevel - 1;
        //对左儿子进行判断，若有左儿子，则记录相应的"/"与左儿子的值
        if (currNode.left != null) {
            res[rowIndex + 1][columnIndex - gap] = "/";
            writeArray(currNode.left, rowIndex + 2, columnIndex - gap * 2, res, treeDepth);
        }
        //对右儿子进行判断，若有右儿子，则记录相应的"\"与右儿子的值
        if (currNode.right != null) {
            res[rowIndex + 1][columnIndex + gap] = "\\";
            writeArray(currNode.right, rowIndex + 2, columnIndex + gap * 2, res, treeDepth);
        }
    }

    public static void show(BSTreeNode root) {
        if (root == null) System.out.println("EMPTY!");
        //得到树的深度
        int treeDepth = getTreeDepth(root);
        //最后一行的宽度为2的（n - 1）次方乘3，再加1
        //作为整个二维数组的宽度
        int arrayHeight = treeDepth * 2 - 1;
        int arrayWidth = (2 << (treeDepth - 2)) * 3 + 1;
        //用一个字符串数组来存储每个位置应显示的元素
        String[][] res = new String[arrayHeight][arrayWidth];
        //对数组进行初始化，默认为一个空格
        for (int i = 0; i < arrayHeight; i++) {
            for (int j = 0; j < arrayWidth; j++) {
                res[i][j] = " ";
            }
        }
        //从根节点开始，递归处理整个树
        writeArray(root, 0, arrayWidth / 2, res, treeDepth);
        //此时，已经将所有需要显示的元素储存到了二维数组中，将其拼接并打印即可
        for (String[] line : res) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < line.length; i++) {
                sb.append(line[i]);
                if (line[i].length() > 1 && i <= line.length - 1) {
                    i += line[i].length() > 4 ? 2 : line[i].length() - 1;
                }
            }
            System.out.println(sb.toString());
        }
    }
}
