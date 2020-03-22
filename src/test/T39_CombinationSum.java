package test;


import java.util.LinkedList;
import java.util.List;

/**
 * 39. Combination Sum
 * Difficult: Medium
 * <p>
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sums to target.
 * The same repeated number may be chosen from candidates unlimited number of times.
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * <p>
 * Example 1:
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [[7],[2,2,3]]
 * <p>
 * Example 2:
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [[2,2,2,2],[2,3,3],[3,5]]
 *
 * @see T40_CombinationSumII
 * @see T216_CombinationSumIII
 * @see T377_CombinationSumIV
 */
public class T39_CombinationSum {

    public static void main(String[] args) {
        T39_CombinationSum test = new T39_CombinationSum();
        System.out.println(test.combinationSum(new int[]{2, 3, 6, 7}, 7));
        System.out.println(test.combinationSum(new int[]{3, 2, 5}, 8));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new LinkedList<>();
        if (candidates == null || candidates.length == 0)
            return ans;
        backtrace(candidates, target, ans, 0, new LinkedList<>());
        return ans;
    }

    /**
     * 执行用时 :3 ms, 在所有 Java 提交中击败了95.58% 的用户
     * 内存消耗 :41.8 MB, 在所有 Java 提交中击败了5.06%的用户
     */
    private void backtrace(int[] candidates, int target, List<List<Integer>> ans, int start, LinkedList<Integer> tmp) {
        //start参数是为了限制从candidates中取数的范围，避免结果集重复
        for (int i = start; i < candidates.length; i++) {
            int newTarget = target - candidates[i];
            if (newTarget >= 0) {
                tmp.add(candidates[i]);
                if (newTarget == 0) //满足条件，加入结果集
                    ans.add(new LinkedList<>(tmp));
                else //大于0， 需要继续递归
                    backtrace(candidates, newTarget, ans, i, tmp);
                tmp.removeLast();
            } // else if (newTarget < 0) {}  剪枝
        }
    }

    /**
     * 未进行剪枝优化的回溯算法
     * 执行用时 :6 ms, 在所有 Java 提交中击败了42.13% 的用户
     * 内存消耗 :41.2 MB, 在所有 Java 提交中击败了6.08%的用户
     */
    private void backtrace1(int[] candidates, int target, List<List<Integer>> ans, int start, LinkedList<Integer> tmp) {
        if (target < 0 || start == candidates.length)
            return;
        else if (target == 0) {
            ans.add(new LinkedList<>(tmp));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            tmp.add(candidates[i]);
            backtrace(candidates, target - candidates[i], ans, i, tmp);
            tmp.removeLast();
        }
    }
}
