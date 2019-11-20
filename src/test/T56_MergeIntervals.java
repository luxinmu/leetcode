package test;

import java.util.Arrays;

public class T56_MergeIntervals {

	public static void main(String[] args) {
		Tools.printArray(merge(new int[][] { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } }));
		Tools.printArray(merge(new int[][] { { 2, 6 }, { 1, 3 }, { 8, 10 }, { 15, 18 } }));
		Tools.printArray(merge(new int[][] { { 1, 3 }, { 2, 6 }, { 3, 5 }, { 15, 18 } }));
		Tools.printArray(merge(new int[][] { { 1, 3 }, { 3, 6 } }));
		Tools.printArray(merge(new int[][] { { 1, 4 }, { 0, 4 } }));
		Tools.printArray(merge(new int[][] {}));
	}

	public static int[][] merge(int[][] intervals) {
		if (intervals == null || intervals.length <= 1)
			return intervals;
		int len = intervals.length;
		int[][] ans = new int[len][2];
		int i, j, k = 0;
		for (i = 0; i < len; i++) {
			for (j = len - 1; j > i; j--) {
				if (intervals[j][0] < intervals[j - 1][0]) {
					int min[] = intervals[j];
					intervals[j] = intervals[j - 1];
					intervals[j - 1] = min;
				}
			}
			if (i == 0) {
				ans[0] = intervals[i];
			} else {
				if (ans[k][1] >= intervals[i][0])
					ans[k][1] = Math.max(ans[k][1], intervals[i][1]);
				else
					ans[++k] = intervals[i];
			}
		}
		return Arrays.copyOf(ans, k + 1);
	}

	/**
	 * intervals sort arrays, this is answer.
	 */
	public static int[][] sortmerge(int[][] intervals) {
		if (intervals == null || intervals.length == 0)
			return intervals;
		int[][] ans = new int[intervals.length][2];
		boolean first = true;
		int i = 0;
		Tools.printArray(intervals);
		for (int[] intervals0 : intervals) {
			if (first) {
				ans[0] = intervals0;
				first = !first;
			} else {
				if (ans[i][1] >= intervals0[0])
					ans[i][1] = Math.max(ans[i][1], intervals0[1]);
				else {
					ans[++i] = intervals0;
				}
			}
		}
		return Arrays.copyOf(ans, i + 1);
	}
}
