package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 90. Subsets II
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
 * Note: The solution set must not contain duplicate subsets.
 * Example:
 * Input: [1,2,2]
 * Output:
 * [ [2], [1], [1,2,2], [2,2], [1,2], [] ]
 */
public class T90_SubsetsII {

    public static void main(String[] args) {
        T90_SubsetsII t90 = new T90_SubsetsII();
        System.out.println(t90.subsetsWithDup(new int[]{1, 1, 2, 2}));
        // output: [[], [1], [1, 1], [1, 1, 2], [1, 1, 2, 2], [1, 2], [1, 2, 2], [2], [2, 2]]
    }

    /**
     * 执行用时 :1 ms, 100.00%
     * 内存消耗 :37.2 MB, 87.47%
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        List<List<Integer>> ans = new LinkedList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        backtrace(0, nums, visited, new LinkedList<>(), ans);
        return ans;
    }

    private void backtrace(int begin, int[] nums, boolean[] visited, LinkedList<Integer> tmp, List<List<Integer>> ans) {
        ans.add(new LinkedList<>(tmp));
        for (int i = begin; i < nums.length; i++)
            if (!visited[i]) {
                if (i > 0 && !visited[i - 1] && nums[i] == nums[i - 1])  //KEYPOINT
                    continue;
                tmp.add(nums[i]);
                visited[i] = true;
                backtrace(i + 1, nums, visited, tmp, ans);
                visited[i] = false;
                tmp.removeLast();
            }
    }
}
