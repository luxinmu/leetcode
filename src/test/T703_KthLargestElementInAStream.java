package test;

/**
 * 703. Kth Largest Element in a Stream
 * Difficult: Easy
 * <p>
 * Design a class to find the kth largest element in a stream.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * <p>
 * Your KthLargest class will have a constructor which accepts an integer k and an integer array nums,
 * which contains initial elements from the stream. For each call to the method KthLargest.add,
 * return the element representing the kth largest element in the stream.
 * <p>
 * Example:
 * int k = 3;
 * int[] arr = [4,5,8,2];
 * KthLargest kthLargest = new KthLargest(3, arr);
 * kthLargest.add(3);   // returns 4
 * kthLargest.add(5);   // returns 5
 * kthLargest.add(10);  // returns 5
 * kthLargest.add(9);   // returns 8
 * kthLargest.add(4);   // returns 8
 * <p>
 * Note:
 * You may assume that nums' length ≥ k-1 and k ≥ 1.
 */
public class T703_KthLargestElementInAStream {
    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(4, new int[]{4, 5, 8, 2});
        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(9));
        System.out.println(kthLargest.add(11));
        System.out.println(kthLargest.add(7));
        System.out.println(kthLargest.add(10));

        System.out.println(kthLargest.findK());
        System.out.println(kthLargest.findK(1));
        System.out.println(kthLargest.findK(2));
        System.out.println(kthLargest.findK(9));
        kthLargest.showDetail();
    }

    static class KthLargest {

        BSTreeNode tree;
        int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            for (int i : nums) {
                tree = BSTreeNode.insertBST(tree, i);
            }
        }

        public int add(int val) {
            BSTreeNode.insertBST(tree, val);
            return findK();
        }

        public int findK() {
            return findKNode().val;
        }

        public int findK(int k) {
            return findKNode(k).val;
        }

        public BSTreeNode findKNode() {
            return tree.findK(tree, this.k);
        }

        public BSTreeNode findKNode(int K) {
            return tree.findK(tree, K);
        }

        public void showDetail() {
            tree.showDetail(tree);
        }

        static class BSTreeNode {
            int val;
            int count;
            BSTreeNode left;
            BSTreeNode right;

            BSTreeNode(int x) {
                val = x;
                count = 1;
            }

            private BSTreeNode find(BSTreeNode root, int val) {
                if (root == null) return null;
                return root.val == val ? root : root.val > val ? find(root.left, val) : find(root.right, val);
            }

            private BSTreeNode findK(BSTreeNode root, int k) {
                if (root == null) return null;
                int rightNum = root.right == null ? 0 : root.right.count;
                int leftNum = root.left == null ? 0 : root.left.count;
                int curNum = root.count - rightNum - leftNum;
                // KEYPOINT
                if (rightNum >= k)
                    return findK(root.right, k);
                else if (rightNum + curNum < k)
                    return findK(root.left, k - rightNum - curNum);
                else
                    return root;
            }

            private static BSTreeNode insertBST(BSTreeNode root, int val) {
                if (root == null) {
                    return new BSTreeNode(val);
                }
                root.count++;
                if (root.val > val) {
                    if (root.left == null)
                        root.left = new BSTreeNode(val);
                    else
                        insertBST(root.left, val);
                } else if (root.val < val) {
                    if (root.right == null)
                        root.right = new BSTreeNode(val);
                    else
                        insertBST(root.right, val);
                }
                return root;
            }

            private void showDetail(BSTreeNode root) {
                if (root == null) return;
                showDetail(root.left);
                System.out.print(root.val + ":[" + root.count + "],");
                showDetail(root.right);
            }
        }
    }
}
