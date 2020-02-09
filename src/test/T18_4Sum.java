package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 4Sum
 * Difficult: Medium
 * <p>
 * Given an array nums of n integers and an integer target, are there elements a, b, c,
 * and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 * Note:
 * The solution set must not contain duplicate quadruplets.
 * <p>
 * Example:
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 * A solution set is:
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 *
 * @see T1_TwoSum
 * @see T15_3Sum
 */
public class T18_4Sum {
    public static void main(String[] args) {
        T18_4Sum test = new T18_4Sum();
        System.out.println(test.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
        System.out.println(test.fourSum(new int[]{1, 0, -1, 0, -2, 2}, -2));
        System.out.println(test.fourSum(new int[]{0, 4, -5, 2, -2, 4, 2, -1, 4}, 12));
    }

    /**
     * 执行用时 :52 ms, 16.80%
     * 内存消耗 :39 MB, 24.83%
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 4) return ans;
        int len = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < len - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < len - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int left = j + 1, right = len - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum < target)
                        while (left < right && nums[left] == nums[++left]) ;
                    else if (sum > target)
                        while (left < right && nums[right] == nums[--right]) ;
                    else {
                        List<Integer> ans0 = new ArrayList<>();
                        ans0.add(nums[i]);
                        ans0.add(nums[j]);
                        ans0.add(nums[left]);
                        ans0.add(nums[right]);
                        ans.add(ans0);
                        while (left < right && nums[left] == nums[++left]) ;
                        while (left < right && nums[right] == nums[--right]) ;
                    }
                }
            }
        }
        return ans;
    }
}
