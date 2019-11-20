package test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class T1_TwoSum {

	public static void main(String[] args) {
		int nums[] = { 1, 3, 4, 9 };
		System.out.println(Arrays.toString(twoSum1(nums, 7)));
	}

	public static int[] twoSum(int[] nums, int target) {
		int i, j;
		for (i = 0; i < nums.length - 1; i++)
			for (j = i + 1; j < nums.length; j++)
				if (nums[i] + nums[j] == target)
					return new int[] { i, j };
		return null;
	}

	public static int[] twoSum1(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++)
			if (map.containsKey(target - nums[i]))
				return new int[] { map.get(target - nums[i]), i };
			else
				map.put(nums[i], i);
		return null;
	}
}
