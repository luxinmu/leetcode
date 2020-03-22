package test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 40. Combination Sum II
 * Difficult: Medium
 * <p>
 * Given a collection of candidate numbers (candidates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sums to target.
 * Each number in candidates may only be used once in the combination.
 * <p>
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * <p>
 * Example 1:
 * Input: candidates = [10,1,2,7,6,1,5], target = 8,
 * A solution set is:
 * [[1, 7],[1, 2, 5],[2, 6],[1, 1, 6]]
 * <p>
 * Example 2:
 * Input: candidates = [2,5,2,1,2], target = 5,
 * A solution set is:
 * [[1,2,2],[5]]
 */
public class T40_CombinationSumII {

    public static void main(String[] args) {
        T40_CombinationSumII test = new T40_CombinationSumII();
        System.out.println(test.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
        System.out.println(test.combinationSum2(new int[]{2, 5, 2, 1, 2}, 5));
    }

    /**
     * 执行用时 :3 ms, 在所有 Java 提交中击败了96.17% 的用户
     * 内存消耗 :39.6 MB, 在所有 Java 提交中击败了19.61%的用户
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new LinkedList<>();
        if (candidates == null || candidates.length == 0)
            return ans;
        Arrays.sort(candidates);  //一定要排序
        backtrace(candidates, target, ans, 0, new LinkedList<>());
        return ans;
    }

    private void backtrace(int[] candidates, int target, List<List<Integer>> ans, int start, LinkedList<Integer> tmp) {
        //start参数是为了限制从candidates中取数的范围，避免结果集重复
        for (int i = start; i < candidates.length; i++) {
            // 当前元素等于前一元素时，跳过，否则会出现重复结果集
            // 如集合[1, 1, 2]，目标值 3
            // 第一个数1与2之和为目标值3
            // 第二个数1，与第一个数相同，不能再次选择
            if (i > start && candidates[i] == candidates[i - 1])
                continue;
            int newTarget = target - candidates[i];
            if (newTarget >= 0) {
                tmp.add(candidates[i]);
                if (newTarget == 0)//满足条件，加入结果集
                    ans.add(new LinkedList<>(tmp));
                else
                    //当前目标值任不满足条件， 需要继续递归
                    //candidates中每个元素只能使用一次，故递归时start为i + 1，不取当前位置的元素。
                    backtrace(candidates, newTarget, ans, i + 1, tmp);
                tmp.removeLast();
            } // else if (newTarget < 0) {}  剪枝
        }
    }
}
