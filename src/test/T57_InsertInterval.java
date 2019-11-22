package test;

import java.util.Arrays;

public class T57_InsertInterval {

	public static void main(String[] args) {
		T57_InsertInterval t57 = new T57_InsertInterval();
		Tools.printArray(t57.insert(new int[][] { { 1, 3 }, { 4, 6 }, { 8, 10 }, { 15, 18 } }, new int[] { 2, 5 }));
		Tools.printArray(t57.insert(new int[][] { { 1, 3 }, { 4, 5 }, { 11, 18 } }, new int[] { 2, 12 }));
		Tools.printArray(t57.insert(new int[][] { { 2, 3 }, { 4, 5 }, { 11, 18 } }, new int[] { 1, 12 }));
		Tools.printArray(t57.insert(new int[][] { { 2, 3 }, { 4, 5 }, { 11, 18 } }, new int[] { 7, 8 }));
		Tools.printArray(t57.insert(new int[][] {}, new int[] { 1, 3 }));
		Tools.printArray(t57.insert(new int[][] { { 1, 5 } }, new int[] { 6, 8 }));
		Tools.printArray(t57.insert(new int[][] { { 1, 5 } }, new int[] { 0, 0 }));
		Tools.printArray(t57.insert(new int[][] { { 1, 3 }, { 4, 5 } }, new int[] { 6, 8 }));
	}

	public int[][] insert(int[][] intervals, int[] newInterval) {
		if (intervals == null || intervals.length == 0)
			return new int[][] { newInterval };

		if (newInterval == null || newInterval.length == 0)
			return intervals;
		int len = intervals.length;
		int[][] ans = new int[len + 1][2];
		int i = 0, k = 0;
		boolean insertLeft = false;
		for (i = 0; i < len; i++) {
			if (!insertLeft) {
				if (newInterval[0] > intervals[i][1])
					ans[k++] = intervals[i];
				else {
					insertLeft = !insertLeft;
					ans[k][0] = Math.min(newInterval[0], intervals[i][0]);
					if (newInterval[1] >= intervals[i][0])
						ans[k][1] = Math.max(newInterval[1], intervals[i][1]);
					else {
						ans[k++][1] = newInterval[1];
						System.arraycopy(intervals, i, ans, k, len - i);
						k += len - i - 1;
						break;
					}
				}
			} else {
				if (ans[k][1] < intervals[i][0])
					ans[++k] = intervals[i];
				else
					ans[k][1] = Math.max(ans[k][1], intervals[i][1]);
			}
		}
		if (!insertLeft)
			ans[k] = newInterval;
		return Arrays.copyOf(ans, k + 1);
	}
}
