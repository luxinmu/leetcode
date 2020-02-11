package test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 128. Longest Consecutive Sequence
 * Difficult: Hard
 * <p>
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * Your algorithm should run in O(n) complexity.
 * <p>
 * Example:
 * Input: [100, 4, 200, 1, 3, 2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 */
public class T128_LongestConsecutiveSequence {
    public static void main(String[] args) {
        T128_LongestConsecutiveSequence test = new T128_LongestConsecutiveSequence();
        System.out.println(test.longestConsecutive1(new int[]{0, 3, 2, 1, 5, 4}));
        System.out.println(test.longestConsecutive1(new int[]{100, 4, 200, 1, 3, 2}));
    }

    /**
     * HashMap解法
     * 执行用时 :11 ms, 38.00%
     * 内存消耗 :45.6 MB, 5.04%
     * 遍历数组，对于每一个节点，有如下规律：
     * 当前节点的最大连续数 = 前一节点连续数 + 后一节点连续数 + 1
     */
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int n : nums) {
            if (map.containsKey(n))
                continue;
            boolean beforeN = map.containsKey(n - 1);
            boolean afterN = map.containsKey(n + 1);
            int leftCnt = beforeN ? map.get(n - 1) : 0;
            int rightCnt = afterN ? map.get(n + 1) : 0;
            int cnt = leftCnt + rightCnt + 1;
            max = Math.max(max, cnt);
            map.put(n, cnt);
            // 若存在前后节点，则更新相应的节点的值为新的最大连续值
            // 更新时，对于前序节点，需要更新最左侧的节点的对应值
            // 对于后序节点，需要更新最右侧的节点的对应连续数
            if (beforeN) map.put(n - leftCnt, cnt);  // KEYPOINT
            if (afterN) map.put(n + rightCnt, cnt);
        }
        return max;
    }

    /**
     * HashSet解法
     * 执行用时 :11 ms, 38.00%
     * 内存消耗 :37.9 MB, 57.59%
     * 空间换时间的解法，将所有数据放入Set中，找到每一个连续序列的头，统计，求最大值。
     */
    public int longestConsecutive1(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        Set<Integer> set = new HashSet<>(nums.length);
        for (int n : nums)
            set.add(n);
        int max = 0;
        for (int n : set) {
            // 找到连续序列的头
            // 当不存在当前数字前面的数字时，当前数字为序列头
            if (!set.contains(n - 1)) {
                int cnt = 0;
                while (set.contains(n++))
                    cnt++;
                max = Math.max(max, cnt);
            }
        }
        return max;
    }
}
