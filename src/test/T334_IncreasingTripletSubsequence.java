package test;

/**
 * 334. Increasing Triplet Subsequence
 * Difficult: Medium
 * <p>
 * Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.
 * Formally the function should:
 * Return true if there exists i, j, k
 * such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
 * Note: Your algorithm should run in O(n) time complexity and O(1) space complexity.
 * <p>
 * Example 1:
 * Input: [1,2,3,4,5]
 * Output: true
 * <p>
 * Example 2:
 * Input: [5,4,3,2,1]
 * Output: false
 *
 * @see T300_LongestIncreasingSubsequence
 */
public class T334_IncreasingTripletSubsequence {
    public static void main(String[] args) {
        T334_IncreasingTripletSubsequence test = new T334_IncreasingTripletSubsequence();
        System.out.println(test.increasingTriplet(new int[]{1, 2, 3, 4, 5}));  //true
        System.out.println(test.increasingTriplet(new int[]{7, 2, 6, 3, 5}));  //true
        System.out.println(test.increasingTriplet(new int[]{1, 1, -2, 6}));  //false
        System.out.println(test.increasingTriplet(new int[]{1, 1, 1, 1, 1, 1, 1}));  //false
        System.out.println(test.increasingTriplet(new int[]{5, 4, 3, 2, 1}));  //false
    }

    /**
     * 执行用时 :0 ms, 100.00%
     * 内存消耗 :39.4 MB, 5.11%
     */
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3)
            return false;
        int first = Integer.MAX_VALUE;  //最小值
        int second = Integer.MAX_VALUE;  //次小值
        for (int n : nums)
            if (n < first)  //小于最小值，更新最小值
                first = n;
            else if (n > first && n < second)  //大于最小值且小于次小值，更新次小值
                second = n;
            else if (n > second)  //大于次小值，找到了三个数组成的上升子序列
                return true;
        return false;
    }
}
