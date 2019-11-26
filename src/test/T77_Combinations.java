package test;

import java.util.LinkedList;
import java.util.List;

public class T77_Combinations {
    public static void main(String[] args) {
        T77_Combinations t77 = new T77_Combinations();
        System.out.println(t77.combine(4, 2));
        System.out.println(t77.combine(3, 3));
        System.out.println(t77.combine(13, 3));
    }

    /**
     * backtrace优化
     * 执行用时 :30 ms, 53.77%
     * 内存消耗 :40.9 MB, 87.82%
     */
    public List<List<Integer>> combine(int n, int k) {
        if (n <= 0 || k <= 0) return null;
        List<List<Integer>> ans = new LinkedList<>();
        backtrace(1, n, k, new LinkedList<>(), ans);
        return ans;
    }

    private void backtrace(int first, int n, int k, LinkedList<Integer> cur, List<List<Integer>> ans) {
        if (cur.size() == k) {
            ans.add(new LinkedList<>(cur));
            return;
        }
        for (int i = first; i < n + 1; i++) {
            cur.add(i);
            //first参数对参与组合的下一个数字进行了限制
            //当first为1, 下一个数字可以是2、3、4
            //当first为2, 下一个数字只能为3、4, 依此类推.
            backtrace(i + 1, n, k, cur, ans);
            cur.removeLast();
        }
    }

    /**
     * backtrace
     * 执行用时 :79 ms, 18.64%
     * 内存消耗 :40.2 MB, 91.03%
     */
    public List<List<Integer>> combine1(int n, int k) {
        if (n <= 0 || k <= 0) return null;
        List<List<Integer>> ans = new LinkedList<>();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = i + 1;
        boolean[] visited = new boolean[n];
        backtrace1(k, ans, nums, new LinkedList<>(), visited);
        return ans;
    }

    private void backtrace1(int k, List<List<Integer>> ans, int[] nums, LinkedList<Integer> list, boolean[] visited) {
        if (list.size() == k) {
            List<Integer> l = new LinkedList<>(list);
            ans.add(l);
            return;
        }

        for (int i = 0; i < nums.length; i++)
            if (!visited[i]) {
                if ((list.isEmpty() ? 0 : list.get(list.size() - 1)) > nums[i])
                    continue;
                list.add(nums[i]);
                visited[i] = true;
                backtrace1(k, ans, nums, list, visited);
                visited[i] = false;
                list.removeLast();
            }
    }
}
