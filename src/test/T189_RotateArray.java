package test;

/**
 * 189. Rotate Array
 * Difficult: Easy
 * <p>
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 * <p>
 * Example 1:
 * Input: [1,2,3,4,5,6,7] and k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * <p>
 * Example 2:
 * Input: [-1,-100,3,99] and k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 * <p>
 * Note:
 * <p>
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 * Could you do it in-place with O(1) extra space?
 */
public class T189_RotateArray {
    public static void main(String[] args) {
        T189_RotateArray t = new T189_RotateArray();
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        int[] nums2 = {-1, -100, 3, 99};
        t.rotate(nums1, 3);
        t.rotate(nums2, 2);
        Tools.printArray(nums1);
        Tools.printArray(nums2);
    }

    /**
     * 环状替换解法
     * 执行用时 :1 ms, 80.82%
     * 内存消耗 :37.6 MB, 21.91%
     */
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length <= 1 || k < 1)
            return;
        int len = nums.length;
        if (k % len == 0)
            return;
        k %= len; //因为如果k大于len，移动k次实际上相当于移动k%len次
        int count = 0;  //替换次数
        for (int i = 0; count < len; i++) {
            int cur = i;  //解决环状替换再len%k == 0时，有元素未遍历的问题
            int prev = nums[cur];
            do {
                int next = (cur + k) % len;
                int tmp = nums[next];
                nums[next] = prev;
                prev = tmp;
                cur = next;
                count++;
            } while (i != cur);
        }
    }
}
