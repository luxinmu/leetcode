package test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class T46_Permutations {

	public static void main(String[] args) {
		System.out.println(permute(new int[] { 1, 2, 3 }));
		System.out.println(permute(new int[] { 1, 2, 3, 4 }));
	}

	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		if (nums.length == 0)
			return ans;
		if (nums.length == 1) {
			List<Integer> list = new ArrayList<>();
			list.add(nums[0]);
			ans.add(list);
			return ans;
		}
		boolean visited[] = new boolean[nums.length]; // boolean default false
		permute0(ans, nums, new ArrayList<>(), visited);
		return ans;
	}

	private static void permute0(List<List<Integer>> ans, int[] nums, ArrayList<Integer> tmp, boolean[] visited) {

		if (tmp.size() == nums.length) { // KEYPOINT
			ans.add(new ArrayList<>(tmp));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				tmp.add(nums[i]);
				permute0(ans, nums, tmp, visited);
				tmp.remove(tmp.size() - 1);
				visited[i] = false;  // KEYPOINT
			}
		}
	}

	public static List<List<Integer>> permute1(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		if (nums.length == 0)
			return ans;
		if (nums.length == 1) {
			List<Integer> list = new ArrayList<>();
			list.add(nums[0]);
			ans.add(list);
			return ans;
		}
		boolean index[] = new boolean[nums.length]; // boolean default false
		int indexLen = 0;
		return permute00(nums, index, indexLen);
	}

	private static List<List<Integer>> permute00(int[] nums, boolean[] index, int indexLen) {
		List<List<Integer>> ans = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			if (!index[i]) {
				if (indexLen == nums.length - 1) {
					List<Integer> list = new ArrayList<>();
					list.add(nums[i]);
					ans.add(list);
					return ans;
				}
				index[i] = true;
				for (List<Integer> l : permute00(nums, index, indexLen + 1)) {
					l.add(nums[i]);
					ans.add(l);
				}
				index[i] = false;
			}
		}
		return ans;
	}

	public static List<List<Integer>> permute3(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		if (nums.length == 0)
			return ans;
		if (nums.length == 1) {
			List<Integer> list = new ArrayList<>();
			list.add(nums[0]);
			ans.add(list);
			return ans;
		}
		Set<Integer> set = new HashSet<>();
		return permute30(nums, set);
	}

	private static List<List<Integer>> permute30(int[] nums, Set<Integer> set) {
		List<List<Integer>> ans = new ArrayList<>();
		for (int i : nums) {
			if (!set.contains(i)) {
				if (set.size() == nums.length - 1) {
					List<Integer> list = new ArrayList<>();
					list.add(i);
					ans.add(list);
					return ans;
				}
				set.add(i);
				for (List<Integer> l : permute30(nums, set)) {
					l.add(i);
					ans.add(l);
				}
				set.remove(i);
			}
		}
		return ans;
	}

	public static List<List<Integer>> permute2(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		if (nums.length == 0)
			return ans;
		if (nums.length == 1) {
			List<Integer> list = new ArrayList<>();
			list.add(nums[0]);
			ans.add(list);
			return ans;
		}
//		if (nums.length == 2) {
//			List<Integer> list0 = new ArrayList<>();
//			List<Integer> list1 = new ArrayList<>();
//			list0.add(nums[0]);
//			list0.add(nums[1]);
//			ans.add(list0);
//			list1.add(nums[1]);
//			list1.add(nums[0]);
//			ans.add(list1);
//			return ans;
//		}

		int nums0[] = new int[nums.length - 1];
		for (int i : nums) {
			int k = 0;
			for (int j : nums) {
				if (j != i)
					nums0[k++] = j;
			}
			for (List<Integer> l : permute2(nums0)) {
				List<Integer> list = new ArrayList<>();
				list.add(i);
				list.addAll(l);
				ans.add(list);
			}
		}
		return ans;
	}

}
