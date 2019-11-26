package test;

import java.util.LinkedList;
import java.util.List;

public class T78_Subsets {
    public static void main(String[] args) {
        T78_Subsets t78 = new T78_Subsets();
        System.out.println(t78.subsets(new int[]{1, 2, 3}));
    }

    /**
     * 执行用时 :1 ms, 99.54%
     * 内存消耗 :36.4 MB, 53.80%
     */
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) return new LinkedList<>();
        List<List<Integer>> ans = new LinkedList<>();
        boolean[] visited = new boolean[nums.length];
        backtrace(0, nums, new LinkedList<>(), visited, ans);
        return ans;
    }

    private void backtrace(int first, int[] nums, LinkedList<Integer> cur, boolean[] visited, List<List<Integer>> ans) {
        ans.add(new LinkedList<>(cur));
        for (int i = first; i < nums.length; i++) {
            if (!visited[i]) {
                cur.add(nums[i]);
                visited[i] = true;
                backtrace(i + 1, nums, cur, visited, ans);
                visited[i] = false;
                cur.removeLast();
            }
        }
    }


}
