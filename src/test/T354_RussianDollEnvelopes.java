package test;

import java.util.Arrays;

/**
 * 354. Russian Doll Envelopes
 * Difficult: Hard
 * <p>
 * You have a number of envelopes with widths and heights given as a pair of integers (w, h).
 * One envelope can fit into another if and only if both the width and height of one envelope is
 * greater than the width and height of the other envelope.
 * What is the maximum number of envelopes can you Russian doll? (put one inside other)
 * Note:
 * Rotation is not allowed.
 * <p>
 * Example:
 * Input: [[5,4],[6,4],[6,7],[2,3]]
 * Output: 3
 * Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
 *
 * @see T300_LongestIncreasingSubsequence
 */
public class T354_RussianDollEnvelopes {
    public static void main(String[] args) {

        T354_RussianDollEnvelopes test = new T354_RussianDollEnvelopes();
        System.out.println(test.maxEnvelopes(new int[][]{{5, 4}, {6, 4}, {6, 7}, {2, 3}}));
        System.out.println(test.maxEnvelopes(new int[][]{{4, 5}, {4, 6}, {6, 7}, {2, 3}, {1, 1}}));
        System.out.println(test.maxEnvelopes(new int[][]{{4, 6}, {4, 5}, {5, 6}, {2, 3}, {1, 1}}));
    }

    /**
     * 排序与最长上升子序列解法
     * 执行用时 :20 ms, 65.73%
     * 内存消耗 :54.4 MB, 49.39%
     */
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0)
            return 0;
        // KEYPOINT 对数组进行宽w升序，高h降序的排序
        // 排序前 [4,5],[4,6],[6,7],[2,3],[1,1]
        // 排序后 [1,1],[2,3],[4,6],[4,5],[6,7]
        Arrays.sort(envelopes, (o1, o2)
                -> o1[0] - o2[0] != 0 ? o1[0] - o2[0] : o2[1] - o1[1]);
        // 排序后，问题简化为求高h的最长上升子序列
        int[] pokers = new int[envelopes.length];  //数组中存放各个h
        int k = 0; //最大上升子序列的长度
        for (int[] ints : envelopes) {
            int low = 0, high = k - 1;
            while (low <= high) {  //二分查找过程
                int mid = (low + high) >>> 1;
                int cmp = pokers[mid] - ints[1];
                if (cmp < 0)
                    low = mid + 1;
                else if (cmp > 0)
                    high = mid - 1;
                else break; // key found
            }
            if (low <= high) continue;  //说明当前(w, h)的h在pokers中，跳过不处理
            pokers[low] = ints[1];
            if (k == low) // 写入位置为实际pokers长度尾端时，增加上升序列长度。
                k++;
        }
        return k;
    }
}
