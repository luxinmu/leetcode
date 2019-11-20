package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T47_PermutationsII {

	public static void main(String[] args) {

		System.out.println(permuteUnique(new int[] {}));
		System.out.println(permuteUnique(new int[] { 1, 1, 2 }));
		System.out.println(permuteUnique(new int[] { 1, 1, 2, 3 }));
		System.out.println(permuteUnique(new int[] { 1, 2, 3 }));
		System.out.println(permuteUnique(new int[] { 2, 2, 1, 1 }));
	}

	public static List<List<Integer>> permuteUnique(int[] nums) {
		if (nums.length == 0)
			return new ArrayList<List<Integer>>();

		List<List<Integer>> ans = new ArrayList<>();
		if (nums.length == 1) {
			ArrayList<Integer> list = new ArrayList<>(1);
			list.add(nums[0]);
			ans.add(list);
			return ans;
		}
		boolean visited[] = new boolean[nums.length];
		Arrays.sort(nums);  // KEYPOINT
		permuteUnique0(ans, nums, new ArrayList<Integer>(), visited);
		return ans;
	}

	private static void permuteUnique0(List<List<Integer>> ans, int[] nums, ArrayList<Integer> tmp, boolean[] visited) {
		if (tmp.size() == nums.length) {
			ans.add(new ArrayList<>(tmp));
			return;
		}
		int prev = 0;
		boolean first = true;
		for (int i = 0; i < nums.length; i++) {
			// KEYPOINT
			if (!visited[i]) {
				if (first)
					first = !first;
				else if (prev == nums[i])
					continue;
				prev = nums[i];
				visited[i] = true;
				tmp.add(nums[i]);
				permuteUnique0(ans, nums, tmp, visited);
				tmp.remove(tmp.size() - 1);
				visited[i] = false;
			}
		}
	}
}
