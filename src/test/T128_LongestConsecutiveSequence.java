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
     * HashMap�ⷨ
     * ִ����ʱ :11 ms, 38.00%
     * �ڴ����� :45.6 MB, 5.04%
     * �������飬����ÿһ���ڵ㣬�����¹��ɣ�
     * ��ǰ�ڵ����������� = ǰһ�ڵ������� + ��һ�ڵ������� + 1
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
            // ������ǰ��ڵ㣬�������Ӧ�Ľڵ��ֵΪ�µ��������ֵ
            // ����ʱ������ǰ��ڵ㣬��Ҫ���������Ľڵ�Ķ�Ӧֵ
            // ���ں���ڵ㣬��Ҫ�������Ҳ�Ľڵ�Ķ�Ӧ������
            if (beforeN) map.put(n - leftCnt, cnt);  // KEYPOINT
            if (afterN) map.put(n + rightCnt, cnt);
        }
        return max;
    }

    /**
     * HashSet�ⷨ
     * ִ����ʱ :11 ms, 38.00%
     * �ڴ����� :37.9 MB, 57.59%
     * �ռ任ʱ��Ľⷨ�����������ݷ���Set�У��ҵ�ÿһ���������е�ͷ��ͳ�ƣ������ֵ��
     */
    public int longestConsecutive1(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        Set<Integer> set = new HashSet<>(nums.length);
        for (int n : nums)
            set.add(n);
        int max = 0;
        for (int n : set) {
            // �ҵ��������е�ͷ
            // �������ڵ�ǰ����ǰ�������ʱ����ǰ����Ϊ����ͷ
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
