package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 3Sum
 * Difficult: Medium
 * <p>
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 * Note:
 * The solution set must not contain duplicate triplets.
 * <p>
 * Example:
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 *
 * @see T1_TwoSum
 * @see T18_4Sum
 */
public class T15_3Sum {
    public static void main(String[] args) {
        T15_3Sum test = new T15_3Sum();
        System.out.println(test.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(test.threeSum(new int[]{-2, 0, 0, 2, 2}));
    }

    /**
     * 快慢指针逼近法
     * 执行用时 :40 ms, 56.54%
     * 内存消耗 :47 MB, 73.10%
     * 先排序，然后用快慢指针法
     * 目标值大于0， 减小快指针，小于0，增加慢指针，等于0，添加结果。
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length <= 2)
            return ans;
        int len = nums.length;
        Arrays.sort(nums);  // KEYPOINT
        for (int i = 0; i < len - 2; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1, right = len - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < 0)
                    // 用来去除结果集中重复值
                    while (left < right && nums[left] == nums[++left]) ;
                else if (sum > 0)
                    while (left < right && nums[right] == nums[--right]) ; //作用去重
                else {
                    List<Integer> ans0 = new ArrayList<>();
                    ans0.add(nums[i]);
                    ans0.add(nums[left]);
                    ans0.add(nums[right]);
                    ans.add(ans0);
                    while (left < right && nums[left] == nums[++left]) ; //作用去重
                    while (left < right && nums[right] == nums[--right]) ; //作用去重
                }
            }
        }
        return ans;
    }
}
