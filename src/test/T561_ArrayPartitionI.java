package test;

import java.util.Arrays;

/**
 * 561. Array Partition I
 * Difficult: Easy
 * <p>
 * Given an array of 2n integers, your task is to group these integers into n pairs of integer,
 * say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.
 * <p>
 * Example 1:
 * Input: [1,4,3,2]
 * Output: 4
 * Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).
 * <p>
 * Note:
 * <p>
 * n is a positive integer, which is in the range of [1, 10000].
 * All the integers in the array will be in the range of [-10000, 10000].
 */
public class T561_ArrayPartitionI {
    public static void main(String[] args) {
        T561_ArrayPartitionI t = new T561_ArrayPartitionI();
        System.out.println(t.arrayPairSum1(new int[]{1, 4, 3, 2}));
        System.out.println(t.arrayPairSum1(new int[]{0, 0, 1, 1}));
        System.out.println(t.arrayPairSum1(new int[]{0, 0, 0, 1, 1, 2}));
        System.out.println(t.arrayPairSum1(new int[]{4, 2, 5, 5, 6, 0}));
    }

    /**
     * 执行用时 :4 ms, 99.64%
     * 内存消耗 :40.4 MB, 26.48%
     */
    public int arrayPairSum1(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int sum = 0;
        final int OFFSET = 10000;
        int[] arrays = new int[20001];
        //使用元素作为下标，记录元素出现的次数
        for (int num : nums)
            arrays[num + OFFSET]++;
        //前一个元素出现次数是否屏蔽后一个，例如:
        //1, 1, 1, 2, 2, 2
        //记为 [1] = 3, [2] = 3
        //第三个1和第一个2组成数对，三个2中第一个2相当于被屏蔽。
        boolean mask = false;
        for (int i = 0; i < arrays.length; i++)
            if (arrays[i] > 0) {
                sum += (arrays[i] + (mask ? 0 : 1)) / 2 * (i - OFFSET);
                if (arrays[i] % 2 != 0)
                    mask = !mask;
            }
        return sum;
    }

    /**
     * 执行用时 :18 ms, 91.08%
     * 内存消耗 :40.1 MB, 31.19%
     */
    public int arrayPairSum(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int sum = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }
}
