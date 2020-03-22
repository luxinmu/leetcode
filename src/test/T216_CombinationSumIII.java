package test;

import java.util.LinkedList;
import java.util.List;

/**
 * 216. Combination Sum III
 * Difficult: Medium
 * <p>
 * Find all possible combinations of k numbers that add up to a number n,
 * given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
 * Note:
 * All numbers will be positive integers.
 * The solution set must not contain duplicate combinations.
 * <p>
 * Example 1:
 * Input: k = 3, n = 7
 * Output: [[1,2,4]]
 * <p>
 * Example 2:
 * Input: k = 3, n = 9
 * Output: [[1,2,6], [1,3,5], [2,3,4]]
 */
public class T216_CombinationSumIII {

    public static void main(String[] args) {
        T216_CombinationSumIII test = new T216_CombinationSumIII();
        System.out.println(test.combinationSum3(3, 7));
        System.out.println(test.combinationSum3(3, 10));
        System.out.println(test.combinationSum3(2, 10));
    }

    int K;
    int N;

    /**
     * ִ����ʱ :1 ms, ������ Java �ύ�л�����87.06% ���û�
     * �ڴ����� :37.6 MB, ������ Java �ύ�л�����5.16%���û�
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        if (k < 1 || n < 1 || n > 45)
            return null;
        this.K = k;
        this.N = n;
        List<List<Integer>> ans = new LinkedList<>();
        backtrace(0, 1, 0, ans, new LinkedList<>());
        return ans;
    }

    private void backtrace(int cnt, int startNum, int target, List<List<Integer>> ans, LinkedList<Integer> tmp) {
        if (target > N || cnt > K)
            return;
        else if (target == N) {
            if (cnt == K)
                ans.add(new LinkedList<>(tmp));
            return;
        }

        for (int n = startNum; n < 10; n++) {
            tmp.add(n);
            backtrace(cnt + 1, n + 1, target + n, ans, tmp);
            tmp.removeLast();
        }
    }
}
